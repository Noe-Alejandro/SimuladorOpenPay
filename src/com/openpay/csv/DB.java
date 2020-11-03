/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.csv;

import com.opencsv.exceptions.CsvValidationException;
import com.openpay.model.Address;
import com.openpay.model.Card;
import com.openpay.model.Cargo;
import com.openpay.model.Cliente;
import com.openpay.model.data.Fecha;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Noé
 */
public interface DB {
    public void registrarCliente(Cliente cliente) throws FileNotFoundException, IOException, CsvValidationException;
    public void registrarDireccion(String clienteID, Address direccion)throws FileNotFoundException, IOException, CsvValidationException;;
    public void registrarTarjeta(Card tarjeta, String clienteID)throws FileNotFoundException, IOException, CsvValidationException;
    public void registrarCargo(Cargo cargo)throws FileNotFoundException, IOException, CsvValidationException;
    public void registrarCreacionesTarjetas(String tarjetaID, Fecha fecha)throws FileNotFoundException, IOException, CsvValidationException;;
    public void registrarTransaccion(String cardNumber, Fecha fechaPagada, String orderID)throws FileNotFoundException, IOException, CsvValidationException;;
    public void registrarTokenID(String tokenID, String tarjetaID)throws FileNotFoundException, IOException, CsvValidationException;
    public void registrarDeviceSessionID(String deviceSessionID, String clienteID)throws FileNotFoundException, IOException, CsvValidationException;
    public void eliminarCliente(String clienteID)throws FileNotFoundException, IOException, CsvValidationException;
    public void eliminarTarjeta(String tarjetaID)throws FileNotFoundException, IOException, CsvValidationException;
    public void eliminarDeviceSessionID(String clienteID)throws FileNotFoundException, IOException, CsvValidationException;
    public void eliminarCargo(String orderID) throws FileNotFoundException, IOException, CsvValidationException;
}
