package Entidades;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class carrito_de_venta {
    private Integer id;
    private Integer id_producto;
    private Integer id_cliente;
    private Integer cantidad;


    public carrito_de_venta( Integer id, Integer id_producto, Integer id_cliente,Integer cantidad) {
        this.id = id;
        this.id_producto = id_producto;
        this.id_cliente = id_cliente;
        this.cantidad = cantidad;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_producto() {
        return id_producto;
    }

    public void setId_producto(Integer id_producto) {
        this.id_producto = id_producto;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
