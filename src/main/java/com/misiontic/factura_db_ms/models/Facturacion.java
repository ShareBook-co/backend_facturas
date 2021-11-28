package com.misiontic.factura_db_ms.models;

import org.springframework.data.annotation.Id;

import java.util.Date;

public class Facturacion {
    @Id
    private String   id;
    private String   vendedor;
    private String   cliente;
    private String   direccion;
    private String   idBook;
    private Integer  cantidadLibro;
    private Integer  valorTotal;
    private Date     fecha;

    public Facturacion(){}

    public Facturacion(String id, String Vendedor, String Cliente, String direccion, String idBook, Integer cantidadLibro, Integer valorTotal, Date fecha){
        this.id             =   id;
        this.vendedor       =   Vendedor;
        this.cliente        =   Cliente;
        this.direccion      =   direccion;
        this.idBook         =   idBook;
        this.cantidadLibro  =   cantidadLibro;
        this.valorTotal     =   valorTotal;
        this.fecha          =   fecha;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getVendedor() {
        return vendedor;
    }

    public void setVendedor(String vendedor) {
        this.vendedor = vendedor;
    }

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getIdBook() {
        return idBook;
    }

    public void setIdBook(String idBook) {
        this.idBook = idBook;
    }

    public Integer getCantidadLibro() {
        return cantidadLibro;
    }

    public void setCantidadLibro(Integer cantidadLibro) {
        this.cantidadLibro = cantidadLibro;
    }

    public Integer getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(Integer valorTotal) {
        this.valorTotal = valorTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
