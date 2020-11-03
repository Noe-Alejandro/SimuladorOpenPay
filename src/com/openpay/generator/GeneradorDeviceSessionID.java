/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.generator;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.model.Cliente;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Noé
 */
public class GeneradorDeviceSessionID implements Generator {

    public GeneradorDeviceSessionID() {
    }
    
    @Override
    public String generar(){
        String Sessionid = "";
        for (int i = 0; i < 24; i++) {
            if ((i + 1) % 6 == 0) {
                int numero = ((int) (Math.random() * 100) % 25) + 65;
                char letra = (char) numero;
                Sessionid += letra;
            } else {
                Sessionid += String.valueOf((int) (Math.random() * 10));
            }
        }
        return Sessionid;
    }

}
