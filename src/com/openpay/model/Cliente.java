/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.model;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.generator.GeneradorDeviceSessionID;
import com.openpay.generator.GeneradorIDCliente;
import java.io.IOException;

/**
 *
 * @author Noé
 */
public class Cliente {
    private String nombre=null;
    private String apellido=null;
    private Address direccion=null;
    private String deviceSessionID=null;
    private String ID=null;

    public Cliente(String nombre, String apellido, Address direccion) throws CsvValidationException, IOException{
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        GeneradorIDCliente generador = new GeneradorIDCliente();
        this.ID = generador.generar();
        this.deviceSessionID = new GeneradorDeviceSessionID().generar();
    }

    public Cliente(String nombre, String apellido)throws CsvValidationException, IOException {
        this.nombre = nombre;
        this.apellido = apellido;
        this.ID = new GeneradorIDCliente().generar();
        this.deviceSessionID = new GeneradorDeviceSessionID().generar();
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public Address getDireccion() {
        return direccion;
    }

    public String getDeviceSessionID() {
        return deviceSessionID;
    }
    
    public String getID(){
        return ID;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setDireccion(Address direccion) {
        this.direccion = direccion;
    }

    public void setDeviceSessionID(String deviceSessionID) {
        this.deviceSessionID = deviceSessionID;
    }
    
    public void setID(String ID){
        this.ID = ID;
    }
}
