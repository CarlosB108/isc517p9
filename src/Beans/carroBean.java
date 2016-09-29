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
    public void agregar_a_carro( int id, int cantidad ){
        //
    }
}
