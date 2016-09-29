package Beans;

import Comunes.General;
import Entidades.Producto;
import Entidades.carrito_de_venta;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by AcMined on 9/29/2016.
 */
@ManagedBean(name = "carroBean")
@SessionScoped
public class carroBean {
    private ArrayList< carrito_de_venta > elementos = new ArrayList< >( );
    int contador = 0;

    public String agregar_a_carro( int id, int cantidad ){
        boolean flag = false;

        if( cantidad == 0 ) return "";

        for( carrito_de_venta elemento : elementos ){
            if( elemento.getId_producto( ) == id ){
                elemento.setCantidad( elemento.getCantidad( ) );
                flag = true;

                return "CarritodeCompra?faces-redirect=true";
            }
        }

        elementos.add( new carrito_de_venta( contador, id, General.usuario.getId( ), cantidad ) );

        return "CarritodeCompra?faces-redirect=true";
    }

    public String procesar( ){
        boolean flag = false;

        for ( carrito_de_venta elemento : elementos ){
            Producto p = General.get_producto( elemento.getId_producto( ) );
            if( p.getCantidad_disponible() < elemento.getCantidad( ) ) {
                flag = true;
                break;
            }
        }

        if( !flag ) {
            for ( carrito_de_venta elemento : elementos ) {
                Producto p = General.get_producto( elemento.getId_producto( ) );
                p.setCantidad_disponible( p.getCantidad_disponible( ) - elemento.getCantidad( ) );
                General.add_venta( p.getId( ), (int)p.getPrecio( )*elemento.getCantidad( ), elemento.getCantidad( ) );
            }
            elementos.clear();
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "Compra realizada", "");
            FacesContext.getCurrentInstance().addMessage("", msg);
        }
        else {
            FacesMessage msg = new FacesMessage(FacesMessage.SEVERITY_INFO, "No hay stock para algunos elementos!", "");
            FacesContext.getCurrentInstance().addMessage("", msg);
        }

        return "";
    }


    public void setElementos( ArrayList< carrito_de_venta > e ){
        elementos = e;
    }

    public ArrayList< carrito_de_venta > getElementos( ){
        return elementos;
    }
}
