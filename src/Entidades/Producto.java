package Entidades;

import java.util.ArrayList;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class Producto {
    private Integer id;
    private String nombre;
    private Integer cantidad_disponible;
    private String descripcion;
    private Boolean selected;
    private double precio;
    private ArrayList< String > imagenes;

    public Producto( Integer id, String nombre, Integer cantidad_disponible,String descripcion, int precio ) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_disponible = cantidad_disponible;
        this.descripcion = descripcion;
        this.precio = precio;
        this.imagenes = new ArrayList< >( );

    }

    public Producto( ){
        this.id = -1;
        this.nombre = "";
        this.cantidad_disponible = 0;
        this.descripcion = "";
        this.precio = 0;
        this.imagenes = new ArrayList< >( );
        this.selected = false;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getCantidad_disponible() {
        return cantidad_disponible;
    }

    public void setCantidad_disponible(Integer cantidad_disponible) {
        this.cantidad_disponible = cantidad_disponible;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getSelected( ){
        return selected;
    }

    public void setSelected( Boolean sel ){
        selected = sel;
    }

    public void setPrecio( double precio ){
        this.precio = precio;
    }

    public double getPrecio( ){
        return precio;
    }

    public void setImagenes( ArrayList< String > imagenes ){
        this.imagenes = imagenes;
    }

    public ArrayList< String > getImagenes( ){
        return imagenes;
    }
}
