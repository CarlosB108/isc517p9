package Beans;

import Comunes.General;
import Entidades.Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;

/**
 * Created by AcMined on 9/22/2016.
 */

@ManagedBean
@SessionScoped
public class productoBean  extends AbstractBean {

    public ArrayList<Producto> getProductos() {
        return General.Products;
    }
}