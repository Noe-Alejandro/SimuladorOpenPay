/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.model;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.api.API;
import com.openpay.csv.CSV;
import com.openpay.model.data.Fecha;
import com.openpay.model.data.Expiracion;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Noé
 */
public class Card {

    private String cardNumber;
    private Fecha creacion;
    private String bankName;
    private String titular;
    private Expiracion expiracion;
    private Address direccion;
    private String cvv2;
    private String tokenId;

    public Card(String bankName, String titular, Address direccion, String cvv2) throws CsvValidationException, IOException {
        this.cardNumber = this.asignarCardNumber();
        this.creacion = new Fecha();
        this.bankName = bankName;
        this.titular = titular;
        this.expiracion = new Expiracion();
        this.direccion = direccion;
        this.cvv2 = cvv2;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public Fecha getCreacion() {
        return creacion;
    }

    public String getBankName() {
        return bankName;
    }

    public String getTitular() {
        return titular;
    }

    public Expiracion getExpiracion() {
        return expiracion;
    }

    public Address getDireccion() {
        return direccion;
    }

    public String getCvv2() {
        return cvv2;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setCreacion(Fecha creacion) {
        this.creacion = creacion;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setExpiracion(Expiracion expiracion) {
        this.expiracion = expiracion;
    }

    public void setDireccion(Address direccion) {
        this.direccion = direccion;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }
    
    public String asignarCardNumber() throws IOException, CsvValidationException {
        String number = "";
        for (int i = 0; i < 16; i++) {
            int numero = ((int) (Math.random() * 10));
            String letra = String.valueOf(numero);
            number += letra;
        }
        if(new API().cardNumberInStock(number)){
            return this.asignarCardNumber();
        }else{
            return number;
        }
    }
}
