/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.api;

import com.itextpdf.text.DocumentException;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.openpay.csv.CSV;
import com.openpay.model.Recibo;
import com.openpay.model.data.Fecha;
import com.openpay.validation.CargoValidacion;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Noé
 */
public class API {

    public boolean cardNumberInStock(String cardNumber) throws CsvValidationException, IOException {
        CSV csv = new CSV();
        ArrayList<String[]> tarjetas = csv.readInformation("tarjetas");
        for (int i = 0; i < tarjetas.size(); i++) {
            if (tarjetas.get(i)[1].equals(cardNumber)) {
                return true;
            }
        }
        return false;
    }
    
    public void pagar(String cardNumber, boolean tarjetaValida, String orderID) throws IOException, CsvValidationException, FileNotFoundException, DocumentException{
        if(tarjetaValida && new CargoValidacion(orderID).validar()){
            CSV csv = new CSV();
            csv.registrarTransaccion(cardNumber, new Fecha(), orderID);
            JOptionPane.showMessageDialog(null, "Pago efectuado correctamente");
            String recibo = JOptionPane.showInputDialog("¿Desea guardar su recibo?\nEscriba 'Si' en caso de desearlo");
            if(recibo.equals("Si")){
                Recibo pdf = new Recibo();
                pdf.CrearPDF(orderID);
            }
            csv.eliminarCargo(orderID);
        }else{
            JOptionPane.showMessageDialog(null, "Tarjeta o cargo invalido");
        }
    }
}
