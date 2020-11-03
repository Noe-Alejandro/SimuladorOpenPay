/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.demo;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.csv.CSV;
import com.openpay.model.Cargo;
import com.openpay.model.data.Fecha;
import java.io.IOException;

/**
 *
 * @author Noé
 */
public class Demo {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, CsvValidationException {
        // TODO code application logic here
        CSV csv = new CSV();
        /*Address direccion = new Address("49","126A","126B","Cancun","Quintana Roo","77527");
        Cliente cliente = new Cliente("Juan","Gonzalez", direccion);
        Card tarjeta = new Card("Santander","Noe Alejandro",cliente.getDireccion(),"752");
        csv.registrarCliente(cliente);
        csv.registrarTarjeta(tarjeta, cliente.getID());
        csv.registrarTokenID("5412", tarjeta.getCardNumber());
        csv.registrarCreacionesTarjetas(tarjeta.getCardNumber(), tarjeta.getCreacion());*/
        
        Cargo cargo = new Cargo("Mi primer pago","100.00","215-251",new Fecha(),"Tarjeta","000000000001");
        csv.registrarCargo(cargo);
        
        //TarjetaValidar validadorTarjeta = new TarjetaValidar("7073461240722722","Santander","Noe Alejandro","09/25","752","5412");
        //CargoValidacion validadorCargo = new CargoValidacion("215-251");
        
        /*API api = new API();
        api.pagar(new TarjetaValidar("7073461240722722","Santander","Noe Alejandro","09/25","752","5412").validar(), "215-251");
        */
    }

}
