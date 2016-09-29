import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by carlosb108 on 26/09/16.
 */
@Stateless
public class servivioproducto {

    public static int IdCounter = 0;

    private List<Producto> producto;

    public servivioproducto() { }

    //    @Override
    public Boolean agregar(Producto producto) {
        Boolean agregado = Producto.agregar(producto);
        if (agregado) {
            setProducto(producto);
        }

        return agregado;
    }



    //    @Override
    public Boolean borrar(Producto producto) {
        Boolean borrar = producto.remove(producto);
        if(borrar) {
            setProducto(producto);
        }

        return borrar;
    }


    public List<Producto> getProducto() {
        producto = (ArrayList<Producto>)FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("producto");
        if(producto == null) {
            producto = new ArrayList<>();
        }
        return products;
    }



    public void setProducto(List<Producto> producto) {
        this.producto = producto;
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("producto", this.producto);
    }

}
