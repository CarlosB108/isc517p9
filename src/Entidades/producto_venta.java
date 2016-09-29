package Entidades;


import java.util.Date;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class producto_venta {
    private Integer id_usuario;
    private Integer id_producto;
    private Integer monto;
    private Integer cantidad_vendida;
    private Date fecha;


    public producto_venta(Integer id_usuario,Integer id_producto,Integer monto,Integer cantidad_vendida  ) {
        this.id_usuario = id_usuario;
        this.id_producto = id_producto;
        this.monto = monto;
        this.cantidad_vendida = cantidad_vendida;
        fecha = new Date( );
    }

    public Integer getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(Integer id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Integer getCantidad_vendida() {
        return cantidad_vendida;
    }

    public void setCantidad_vendida(Integer cantidad_vendida) {
        this.cantidad_vendida = cantidad_vendida;
    }

    public String getFecha( ){
        return fecha.toString();
    }
}
