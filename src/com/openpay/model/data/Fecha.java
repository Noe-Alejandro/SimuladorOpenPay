/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.model.data;

import java.util.Calendar;

/**
 *
 * @author Noé
 */
public class Fecha {
    private String dia;
    private String mes;
    private String anio;
    private String minutos;
    private String hora;

    public Fecha() {
        this.currentDate();
    }

    public String getDia() {
        return dia;
    }

    public String getMes() {
        return mes;
    }

    public String getAnio() {
        return anio;
    }

    public String getMinutos() {
        return minutos;
    }

    public String getHora() {
        return hora;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public void setAnio(String anio) {
        this.anio = anio;
    }

    public void setMinutos(String minutos) {
        this.minutos = minutos;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }
    
    public void currentDate(){
        Calendar c1 = Calendar.getInstance();
        this.dia = String.valueOf(c1.get(Calendar.DATE));
        int mesNumero = c1.get(Calendar.MONTH)+1;
        this.mes = String.valueOf(mesNumero);
        this.anio = String.valueOf(c1.get(Calendar.YEAR));
        this.hora = String.valueOf(c1.get(Calendar.HOUR_OF_DAY));
        this.minutos = String.valueOf(c1.get(Calendar.MINUTE));
    }

    @Override
    public String toString() {
        return getDia()+"/"+getMes()+"/"+getAnio()+" "+getHora()+":"+getMinutos();
    }
    
    
}
