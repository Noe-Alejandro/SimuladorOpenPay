/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.model.data;

/**
 *
 * @author Noé
 */
public class Expiracion {
    private String mesExpiracion;
    private String annioExpiracion;

    public Expiracion() {
        this.asignarFecha();
    }

    public String getMesExpiracion() {
        return mesExpiracion;
    }

    public String getAnnioExpiracion() {
        return annioExpiracion;
    }

    public void setMesExpiracion(String mesExpiracion) {
        this.mesExpiracion = mesExpiracion;
    }

    public void setAnnioExpiracion(String annioExpiracion) {
        this.annioExpiracion = annioExpiracion;
    }
    
    public void asignarFecha(){
        Fecha fecha = new Fecha();
        int fechaExp = Integer.parseInt(fecha.getAnio())+5;
        String annio = String.valueOf(fechaExp);
        
        this.annioExpiracion = annio.substring(2, 4);
        this.mesExpiracion = String.valueOf(fecha.getMes());
        if(this.mesExpiracion.length()!=2){
            String aux = "0" + this.mesExpiracion;
            this.setMesExpiracion(aux);
        }
    }

    @Override
    public String toString() {
        return getMesExpiracion() + "/" + this.getAnnioExpiracion();
    }
    
}
