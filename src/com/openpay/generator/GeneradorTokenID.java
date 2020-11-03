/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.generator;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.model.Card;
import java.io.FileNotFoundException;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Noé
 */
public class GeneradorTokenID implements Generator{
    private String tokenID;

    public GeneradorTokenID(String tokenID) {
        this.tokenID = tokenID;
    }
    
    @Override
    public String generar(){
        if(tokenID!=null && tokenIDValidation(tokenID)){
            return tokenID;
        }
        return null;
    }

    public boolean tokenIDValidation(String tokenID) {
        int i=0;
        if(tokenID.length()==4){
            for(i=0; i<4; i++){
                char letra = tokenID.charAt(i);
                int valor = letra;
                if(valor<48 || valor>57){
                    return false;
                }
            }
        }
        
        if(i==4){
            return true;
        }else{
            return false;
        }
    } 
}
