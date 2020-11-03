/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.validation;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.csv.CSV;
import com.openpay.model.Address;
import com.openpay.model.Card;
import com.openpay.model.data.Expiracion;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Noé
 */
public class TarjetaValidar implements Validador{
    private String cardNumber;
    private String bankName;
    private String titular;
    private String expiracion;
    private String cvv2;
    private String tokenID;

    public TarjetaValidar(String cardNumber, String bankName, String titular, String expiracion, String cvv2, String tokenID) {
        this.cardNumber = cardNumber;
        this.bankName = bankName;
        this.titular = titular;
        this.expiracion = expiracion;
        this.cvv2 = cvv2;
        this.tokenID = tokenID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public String getBankName() {
        return bankName;
    }

    public String getTitular() {
        return titular;
    }

    public String getExpiracion() {
        return expiracion;
    }

    public String getCvv2() {
        return cvv2;
    }

    public String getTokenID() {
        return tokenID;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public void setExpiracion(String expiracion) {
        this.expiracion = expiracion;
    }

    public void setCvv2(String cvv2) {
        this.cvv2 = cvv2;
    }

    public void setTokenID(String tokenID) {
        this.tokenID = tokenID;
    }

    @Override
    public boolean validar() throws IOException, FileNotFoundException, CsvValidationException {
        CSV csv = new CSV();
        ArrayList<String[]> tarjetas = csv.readInformation("tarjetas");
        for(int i=0; i<tarjetas.size(); i++){
            String[] aux = tarjetas.get(i);
            if(aux[1].equals(cardNumber) && aux[2].equals(bankName) && aux[3].equals(titular) && 
                    aux[4].equals(expiracion) && aux[5].equals(cvv2) && aux[6].equals(tokenID)){
                return true;
            }
        }
        return false;
    }
    
}
