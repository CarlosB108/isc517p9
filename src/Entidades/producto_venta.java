package Entidades;


/**
 * Created by carlosb108 on 9/21/16.
 */
public class producto_venta {
    private Integer id_venta;
    private Integer id_producto;
    private Integer monto;
    private Integer cantidad_vendida;


    public producto_venta(Integer id_venta,Integer id_producto,Integer monto,Integer cantidad_vendidaa ) {
        this.id_venta = id_venta;
        this.id_producto = id_producto;
        this.monto = monto;
        this.cantidad_vendida = cantidad_vendidaa;

    }

    public Integer getId_venta() {
        return id_venta;
    }

    public void setId_venta(Integer id_venta) {
        this.id_venta = id_venta;
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
}
