/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.model;

import com.itextpdf.text.BadElementException;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfWriter;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.openpay.api.API;
import com.openpay.csv.CSV;
import com.openpay.model.data.Fecha;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author Shannon
 */
public class Recibo {

    public void CrearPDF(String orderID) throws FileNotFoundException, DocumentException, BadElementException, IOException, CsvValidationException {

        Document documento = new Document();

        FileOutputStream ficheroPDF = new FileOutputStream("Recibo.pdf");

        PdfWriter.getInstance(documento, ficheroPDF);

        documento.open();
        
        CSV csv = new CSV();
        ArrayList<String[]> cargos = csv.readInformation("cargos");
        String[] cargo = new String[6];
        for(int i=0; i<cargos.size(); i++){
            if(cargos.get(i)[0].equals(orderID)){
                cargo = cargos.get(i);
                break;
            }
        }
        
        Font f = new Font();
        f.setStyle(Font.NORMAL);
        f.setSize(10);

        Paragraph titulo = new Paragraph("Recibo", FontFactory.getFont(FontFactory.TIMES_ROMAN, 20, Font.BOLD, BaseColor.GREEN.darker()));
        titulo.setAlignment(1);

        Paragraph importe = new Paragraph();
        importe.setFont(f);
        importe.add("Importe de servicio depositado: $" + cargo[3] + " MXN");

        Paragraph id = new Paragraph();
        id.setFont(f);
        id.add("ID del evento: " + cargo[0]);

        Paragraph bien = new Paragraph();
        bien.setFont(f);
        bien.add("Tipo de bien empleado: Indefinido");

        Paragraph metodo = new Paragraph();
        metodo.setFont(f);
        metodo.add("Método de Pago: " + cargo[2]);

        Paragraph concepto = new Paragraph();
        concepto.setFont(f);
        concepto.add("Concepto de pago: " + cargo[4]);

        //-----------------Fecha,Hora y Huso-Horario-------------------
        Paragraph fecha = new Paragraph();
        fecha.setFont(f);
        Calendar calendario = new GregorianCalendar();
        String fechaE = fecha();
        fecha.add("Fecha de adjudicación : " + fechaE);

        Paragraph hora = new Paragraph();
        hora.setFont(f);
        String horaE = hora();
        hora.add("Hora de adjucición: " + horaE);

        Paragraph Huso = new Paragraph();
        Huso.setFont(f);
        Huso.add("Huso-Horario deseado: México");

        // Mensaje Final
        Paragraph transaccion = new Paragraph("¡Muchas Gracias por su pago! Transacción Exitosa.", FontFactory.getFont(FontFactory.TIMES_ROMAN, 15, Font.UNDEFINED, BaseColor.DARK_GRAY));
        transaccion.setAlignment(1);

        documento.add(titulo);
        documento.add(importe);
        documento.add(id);
        documento.add(bien);
        documento.add(metodo);
        documento.add(concepto);
        documento.add(fecha);
        documento.add(hora);
        documento.add(Huso);
        documento.add(transaccion);

        documento.close();

    }

    public String fecha() {
        Date fecha = new Date();
        SimpleDateFormat formatofecha = new SimpleDateFormat("dd,MM,YYYY");
        return formatofecha.format(fecha);
    }

    public String hora() {
        String hora, minuto, segundo;
        String hactual;
        Calendar calendario = new GregorianCalendar();
        Date horaactual = new Date();
        calendario.setTime(horaactual);
        hora = calendario.get(Calendar.HOUR_OF_DAY) > 9 ? "" + calendario.get(Calendar.HOUR_OF_DAY) : "0" + calendario.get(Calendar.HOUR_OF_DAY);
        minuto = calendario.get(Calendar.MINUTE) > 9 ? "" + calendario.get(Calendar.MINUTE) : "0" + calendario.get(Calendar.MINUTE);
        segundo = calendario.get(Calendar.SECOND) > 9 ? "" + calendario.get(Calendar.SECOND) : "0" + calendario.get(Calendar.SECOND);

        hactual = hora + ":" + minuto + ":" + segundo;

        return hactual;
    }
}
