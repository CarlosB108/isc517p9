package Entidades;

import java.util.Date;

/**
 * Created by carlosb108 on 9/21/16.
 */
public class Venta {

    private Integer id;
    private Integer id_cliente;
    private Integer monto;
    private Date fecha;

    public Venta(Integer id,Integer id_cliente,Integer monto,Date fecha ) {
        this.id = id;
        this.id_cliente = id_cliente;
        this.monto = monto;
        this.fecha = fecha;

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId_cliente() {
        return id_cliente;
    }

    public void setId_cliente(Integer id_cliente) {
        this.id_cliente = id_cliente;
    }

    public Integer getMonto() {
        return monto;
    }

    public void setMonto(Integer monto) {
        this.monto = monto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
