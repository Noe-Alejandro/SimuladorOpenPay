/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.model;

import com.openpay.model.data.Fecha;

/**
 *
 * @author Noé
 */
public class Cargo {
    private String descripcion;
    private String cantidad;
    private String orderID;
    private Fecha fechaDeCreacion;
    private String metodo;
    private String toClienteID;

    public Cargo(String descripcion, String cantidad, String orderID, Fecha fechaDeCreacion, String metodo, String toClienteID) {
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.orderID = orderID;
        this.fechaDeCreacion = fechaDeCreacion;
        this.metodo = metodo;
        this.toClienteID = toClienteID;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getCantidad() {
        return cantidad;
    }

    public String getOrderID() {
        return orderID;
    }

    public Fecha getFechaDeCreacion() {
        return fechaDeCreacion;
    }

    public String getMetodo() {
        return metodo;
    }

    public String getToClienteID() {
        return toClienteID;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public void setOrderID(String orderID) {
        this.orderID = orderID;
    }

    public void setFechaDeCreacion(Fecha fechaDeCreacion) {
        this.fechaDeCreacion = fechaDeCreacion;
    }

    public void setMetodo(String metodo) {
        this.metodo = metodo;
    }

    public void setToClienteID(String toClienteID) {
        this.toClienteID = toClienteID;
    }
}
