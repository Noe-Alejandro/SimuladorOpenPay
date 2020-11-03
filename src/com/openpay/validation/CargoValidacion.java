/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.validation;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.csv.CSV;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Noé
 */
public class CargoValidacion implements Validador {
    
    private String orderID;
    
    public CargoValidacion(String orderID) {
        this.orderID = orderID;
    }

    @Override
    public boolean validar() throws IOException, FileNotFoundException, CsvValidationException {
        CSV csv = new CSV();
        ArrayList<String[]> charges = csv.readInformation("cargos");
        for (int i = 0; i < charges.size(); i++) {
            if (charges.get(i)[0].equals(orderID)) {
                return true;
            }
        }
        return false;
    }

}
