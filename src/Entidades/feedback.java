package Entidades;

import java.util.Date;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class feedback {
    private Integer id;
    private Integer id_venta;
    private Integer id_cliente;
    private String valoracion;
    private String comentario;
    private Date fecha;

    public feedback(Integer id,Integer id_venta,Integer id_cliente,String valoracion,String comentario,Date fecha ) {
        this.id = id;
        this.id_venta = id_venta;
        this.id_cliente = id_cliente;
        this.valoracion = valoracion;
        this.comentario = comentario;
        this.fecha = fecha;


    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public String getValoracion() {
        return valoracion;
    }

    public void setValoracion(String valoracion) {
        this.valoracion = valoracion;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
