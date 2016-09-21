package Entidades;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class Cliente {


    private Integer id;
    private String nombre;
    private String clave;
    private String Correo;

    public Cliente(Integer id, String nombre,String clave,String Correo) {
        this.id = id;
        this.nombre = nombre;
        this.clave = clave;
        this.Correo = Correo;

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

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String correo) {
        Correo = correo;
    }
}
