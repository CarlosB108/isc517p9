package Beans;

import Entidades.carrito_de_venta;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;

/**
 * Created by AcMined on 9/29/2016.
 */
@ManagedBean(name = "carroBean")
@SessionScoped
public class carroBean {
    private ArrayList< carrito_de_venta > elementos = new ArrayList< >( );
    private ArrayList< carrito_de_venta > temp_for_clean = new ArrayList<>( );
    public void agregar_a_carro( int id, int cantidad ){
        //
    }


    private ArrayList< Contacto > contactos = new ArrayList<>( );

    public String eliminar( ){
        for( carrito_de_venta c : elementos ){
            if( c.isSelected( ) ){
                temp_for_clean.add( c );
            }
        }

        if( temp_for_clean.size() > 0 ) {
            elementos.removeAll(temp_for_clean);
            temp_for_clean.clear();
            FacesContext.getCurrentInstance().addMessage( null, new FacesMessage( "Producto/s eliminado/s" ) );
        }
        return "index";
    }


}
