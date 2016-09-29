package Entidades;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class Producto {
    private Integer id;
    private String nombre;
    private Integer cantidad_disponible;
    private String descripcion;
    private Boolean selected;

    public Producto( Integer id, String nombre, Integer cantidad_disponible,String descripcion) {
        this.id = id;
        this.nombre = nombre;
        this.cantidad_disponible = cantidad_disponible;
        this.descripcion = descripcion;

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


//Nuevo!!!
    public void crear() {
        FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage("Bienvenido " + id + " " + nombre + " " + cantidad_disponible + "" + descripcion));
    }
}
