package Beans;

import Comunes.General;
import Entidades.Producto;
import Entidades.producto_venta;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.event.RateEvent;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

/**
 * Created by AcMined on 9/22/2016.
 */

@ManagedBean
@SessionScoped
public class productoBean  extends AbstractBean implements Serializable {

    private ArrayList< String > imagenes = new ArrayList< >( );
    private ArrayList< Integer > ratings = new ArrayList< >( );

    private Producto producto_actual = null;
    private int cantidad_a_pedir = 0;

    public void handleFileUpload( FileUploadEvent event ) {
        try {
            String path = "C:\\Users\\AcMined\\Documents\\Pucmm\\Ciclo 10\\ISC\\517\\imagenes_p9\\";
            SimpleDateFormat fmt = new SimpleDateFormat("yyyyMMddHHmmss");
            String name = fmt.format(new Date())
                    + event.getFile().getFileName().substring(
                    event.getFile().getFileName().lastIndexOf('.'));
            File file = new File( path + event.getFile().getFileName());

            InputStream is = event.getFile().getInputstream();
            OutputStream out = new FileOutputStream(file);
            byte buf[] = new byte[1024];
            int len;
            while ((len = is.read(buf)) > 0)
                out.write(buf, 0, len);
            is.close();
            out.close();

            imagenes.add( file.getName() );
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void resetar( ) {
        producto_actual = new Producto( );
        producto_actual.setId( -1 );
        imagenes.clear( );
    }

    public String procesar( ) {
        for( String imagen : imagenes ){
            producto_actual.getImagenes( ).add( imagen );
        }

        if( producto_actual.getId( ) != -1 ) {
            General.actualizar_producto( producto_actual );
        }
        else {
            General.agregar_producto( producto_actual );
        }

        resetar( );
        return "productosDisponibles?faces-redirect=true";
    }

    public ArrayList< Producto > getProductos() {
        return General.Products;
    }
    public ArrayList<producto_venta> getVentas() {
        return General.Ventas;
    }

    public ArrayList< String > getImagenes( ){
        return imagenes;
    }

    public void setImagens( ArrayList< String > imagenes ) {
        this.imagenes = imagenes;
    }

    public String ver_producto( int id ) {
        producto_actual = General.obtener_producto_por_id( id );
        cantidad_a_pedir = 0;
        return "ver_producto?faces-redirect=true";
    }

    public String editar_producto( int id ){
        producto_actual = General.obtener_producto_por_id( id );
        return "editar_producto?faces-redirect=true";
    }

    public String crear_producto( ){
        producto_actual = new Producto( );
        return "crear_producto?faces-redirect=true";
    }

    public void setProducto_actual( Producto p ){
        producto_actual = p;
    }

    public Producto getProducto_actual( ){
        return producto_actual;
    }

    public void setCantidad_a_pedir( int cantidad_a_pedir ){
        this.cantidad_a_pedir = cantidad_a_pedir;
    }

    public int getCantidad_a_pedir( ){
        return this.cantidad_a_pedir;
    }

    public String obtener_nombre ( int id ){
        for( Producto producto: General.Products ) {
            if( producto.getId( ) == id ) return producto.getNombre( );
        }

        return null;
    }

    public void onrate(RateEvent rateEvent) {
        Integer rate = Integer.parseInt( rateEvent.getRating( ).toString() );

        ratings.add(rate);
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Producto calificado", "Usted ha calificado con:" + rate );
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public void oncancel() {
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Cancelado", "No se ha calificado!" );
        FacesContext.getCurrentInstance().addMessage(null, message);
    }

    public boolean isBought( ){
        for( producto_venta venta : getVentas( ) ){
            if( venta.getId_usuario() == General.usuario.getId() ) return true;
        }
        return false;
    }

    public ArrayList< Integer > getRatings( ){
        return ratings;
    }
}

