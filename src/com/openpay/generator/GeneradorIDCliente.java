/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.generator;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.csv.CSV;
import com.openpay.model.Cliente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author Noé
 */
public class GeneradorIDCliente implements Generator {
    private String cantidad;

    public GeneradorIDCliente() throws IOException, FileNotFoundException, CsvValidationException {
        this.cantidadDeClientes();
    }
    
    @Override
    public String generar(){
        String digitos = cantidad;
        int bucle = 12-digitos.length();
        String ID = "";
        for (int i = 0; i < bucle; i++) {
            ID+="0";
        }
        ID+=digitos;
        System.out.println(ID);
        return ID;
    }
    
    public void cantidadDeClientes() throws FileNotFoundException, IOException, CsvValidationException{
        CSV csv = new CSV();
        ArrayList<String[]> customers = csv.readInformation("clientes");
        int codigo = customers.size()+1;
        this.cantidad = String.valueOf(codigo);
    }
    
}
