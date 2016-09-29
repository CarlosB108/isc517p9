package Beans;

import Comunes.General;
import Entidades.Producto;
import org.primefaces.event.FileUploadEvent;
import org.primefaces.model.UploadedFile;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
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

    public void removeImage( UploadedFile image ) {
        imagenes.remove( image );
    }

    public ArrayList< String > getImagenes( ){
        return imagenes;
    }

    public void setImagens( ArrayList< String > imagenes ) {
        this.imagenes = imagenes;
    }

    public String ver_producto( int id ) {
        producto_actual = General.obtener_producto_por_id( id );
        return "ver_producto?faces-redirect=true";
    }

    public String editar_producto( int id ){
        producto_actual = General.obtener_producto_por_id( id );
        return "editar_producto?faces-redirect=true";

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

    }


    ///Chequear
    public void obtener_nombre (id){
        for(Producto productos: Productos) {
            Productos.getNombres;
        }
        return obtener_nombre();
    }

}

