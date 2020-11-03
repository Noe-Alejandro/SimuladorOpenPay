/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.csv;

import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import com.opencsv.exceptions.CsvValidationException;
import com.openpay.generator.GeneradorDeviceSessionID;
import com.openpay.generator.GeneradorIDCliente;
import com.openpay.model.Address;
import com.openpay.model.Card;
import com.openpay.model.Cargo;
import com.openpay.model.Cliente;
import com.openpay.model.data.Fecha;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class CSV implements DB {

    public ArrayList<String[]> readInformation(String target) throws FileNotFoundException, IOException, CsvValidationException {
        ArrayList<String[]> customer = new ArrayList<>();
        String destino = opcionesLeer(target);
        if (destino != null) {
            String archCSV = "OpenPayDB\\" + destino;
            CSVReader csvReader = new CSVReader(new FileReader(archCSV));
            String[] fila = null;
            while ((fila = csvReader.readNext()) != null) {
                customer.add(fila);
            }
            csvReader.close();
        }
        return customer;
    }

    private String opcionesLeer(String opcion) {
        switch (opcion) {
            case "clientes":
                return "customer.csv";
            case "tarjetas":
                return "cards.csv";
            case "cargos":
                return "charges.csv";
            case "transacciones":
                return "transactions.csv";
            case "direcciones":
                return "address.csv";
            case "creaciones de tarjetas":
                return "cardsCreations.csv";
            default:
                return null;
        }
    }

    @Override
    public void registrarCliente(Cliente cliente) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\customer.csv";
        ArrayList<String[]> customers = this.readInformation("clientes");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        //En caso de haber informacion en el archivo el for la sobreescribe
        for (int i = 0; i < customers.size(); i++) {
            String[] content = {customers.get(i)[0], customers.get(i)[1], customers.get(i)[2], customers.get(i)[3]};
            writer.writeNext(content);
        }
        //Registra aquí la nueva información 
        String[] content = {cliente.getNombre(), cliente.getApellido(), cliente.getID(), cliente.getDeviceSessionID()};
        writer.writeNext(content);
        writer.close();
        //Hay que guardar la direccion tenga o no
        this.registrarDireccion(cliente.getID(), cliente.getDireccion());
    }

    @Override
    public void registrarTarjeta(Card tarjeta, String clienteID) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\cards.csv";
        ArrayList<String[]> cards = this.readInformation("tarjetas");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < cards.size(); i++) {
            String[] content = {cards.get(i)[0], cards.get(i)[1], cards.get(i)[2], cards.get(i)[3], cards.get(i)[4], cards.get(i)[5], cards.get(i)[6]};
            writer.writeNext(content);
        }
        //Registra la nueva tarjeta
        String[] content = {clienteID, tarjeta.getCardNumber(), tarjeta.getBankName(), tarjeta.getTitular(), tarjeta.getExpiracion().toString(), tarjeta.getCvv2(), tarjeta.getTokenId()};
        writer.writeNext(content);
        writer.close();
    }

    @Override
    public void registrarTokenID(String tokenID, String cardNumber) throws IOException, CsvValidationException {
        String path = "OpenPayDB\\cards.csv";
        ArrayList<String[]> cards = this.readInformation("tarjetas");

        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < cards.size(); i++) {
            if (cards.get(i)[1].equals(cardNumber)) {
                String[] content = {cards.get(i)[0], cards.get(i)[1], cards.get(i)[2], cards.get(i)[3], cards.get(i)[4], cards.get(i)[5], tokenID};
                writer.writeNext(content);
            } else {
                String[] content = {cards.get(i)[0], cards.get(i)[1], cards.get(i)[2], cards.get(i)[3], cards.get(i)[4], cards.get(i)[5], cards.get(i)[6]};
                writer.writeNext(content);
            }
        }
        writer.close();
    }

    @Override
    public void registrarDeviceSessionID(String deviceSessionID, String clienteID) throws CsvValidationException, IOException {
        String path = "OpenPayDB\\customer.csv";
        ArrayList<String[]> customers = this.readInformation("clientes");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        //Se pasa por todo el archivo hasta encontrar el ID del cliente y asignar el device
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i)[2].equals(clienteID)) {
                String[] content = {customers.get(i)[0], customers.get(i)[1], customers.get(i)[2], deviceSessionID};
                writer.writeNext(content);
            } else {
                String[] content = {customers.get(i)[0], customers.get(i)[1], customers.get(i)[2], customers.get(i)[3]};
                writer.writeNext(content);
            }
        }
        writer.close();
    }

    @Override
    public void registrarCargo(Cargo cargo) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\charges.csv";
        ArrayList<String[]> charges = this.readInformation("cargos");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < charges.size(); i++) {
            String[] content = {charges.get(i)[0], charges.get(i)[1], charges.get(i)[2], charges.get(i)[3], charges.get(i)[4], charges.get(i)[5]};
            writer.writeNext(content);
        }
        String[] content = {cargo.getOrderID(), cargo.getToClienteID(), cargo.getMetodo(), cargo.getCantidad(), cargo.getDescripcion(), cargo.getFechaDeCreacion().toString()};
        writer.writeNext(content);
        writer.close();
    }

    @Override
    public void eliminarCliente(String clienteID) throws IOException, CsvValidationException {
        String path = "OpenPayDB\\customer.csv";
        ArrayList<String[]> customers = this.readInformation("clientes");

        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < customers.size(); i++) {
            if (!customers.get(i)[2].equals(clienteID)) {
                String[] content = {customers.get(i)[0], customers.get(i)[1], customers.get(i)[2], customers.get(i)[3]};
                writer.writeNext(content);
            }
        }
        writer.close();
    }

    @Override
    public void eliminarTarjeta(String cardNumber) throws IOException, CsvValidationException {
        String path = "OpenPayDB\\cards.csv";
        ArrayList<String[]> cards = this.readInformation("tarjetas");

        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < cards.size(); i++) {
            if (!cards.get(i)[1].equals(cardNumber)) {
                String[] content = {cards.get(i)[0], cards.get(i)[1], cards.get(i)[2], cards.get(i)[3], cards.get(i)[4], cards.get(i)[5], cards.get(i)[6]};
                writer.writeNext(content);
            }
        }
        writer.close();
    }

    @Override
    public void eliminarDeviceSessionID(String clienteID) throws IOException, CsvValidationException {
        this.registrarDeviceSessionID(null, clienteID);
    }

    @Override
    public void eliminarCargo(String orderID) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\charges.csv";
        ArrayList<String[]> charges = this.readInformation("cargos");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < charges.size(); i++) {
            if (!charges.get(i)[0].equals(orderID)) {
                String[] content = {charges.get(i)[0], charges.get(i)[1], charges.get(i)[2], charges.get(i)[3], charges.get(i)[4], charges.get(i)[5]};
                writer.writeNext(content);
            }
        }
        writer.close();
    }

    @Override
    public void registrarDireccion(String clienteID, Address direccion) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\address.csv";
        ArrayList<String[]> address = this.readInformation("direcciones");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < address.size(); i++) {
            String[] content = {address.get(i)[0],address.get(i)[1],address.get(i)[2],address.get(i)[3],address.get(i)[4],address.get(i)[5],address.get(i)[6]};
            writer.writeNext(content);
        }
        String[] content = {clienteID,direccion.getLine1(),direccion.getLine2(),direccion.getLine3(),direccion.getCity(),direccion.getState(),direccion.getPostalCode()};
        writer.writeNext(content);
        writer.close();
    }

    @Override
    public void registrarCreacionesTarjetas(String cardNumber, Fecha fecha) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\cardsCreations.csv";
        ArrayList<String[]> CC = this.readInformation("creaciones de tarjetas");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < CC.size(); i++) {
            String[] content = {CC.get(i)[0],CC.get(i)[1],CC.get(i)[2],CC.get(i)[3],CC.get(i)[4],CC.get(i)[5]};
            writer.writeNext(content);
        }
        String[] content = {cardNumber,fecha.getDia(),fecha.getMes(),fecha.getAnio(),fecha.getHora(),fecha.getMinutos()};
        writer.writeNext(content);
        writer.close();
    }

    @Override
    public void registrarTransaccion(String cardNumber, Fecha fechaPagada, String orderID) throws FileNotFoundException, IOException, CsvValidationException {
        String path = "OpenPayDB\\transactions.csv";
        ArrayList<String[]> transacciones = this.readInformation("transacciones");
        CSVWriter writer = new CSVWriter(new FileWriter(path));
        for (int i = 0; i < transacciones.size(); i++) {
            String[] content = {transacciones.get(i)[0],transacciones.get(i)[1],transacciones.get(i)[2],transacciones.get(i)[3],transacciones.get(i)[4]};
            writer.writeNext(content);
        }
        ArrayList<String[]> cargos = this.readInformation("cargos");
        String[] cargo = new String[6];
        for(int i=0; i<cargos.size(); i++){
            if(cargos.get(i)[0].equals(orderID)){
                cargo = cargos.get(i);
            }
        }
        String[] content = {cardNumber,cargo[3],cargo[4],cargo[2],new Fecha().toString()};
        writer.writeNext(content);
        writer.close();
    }
}
