/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.openpay.validation;

import com.opencsv.exceptions.CsvValidationException;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 *
 * @author Noé
 */
public interface Validador {
    public boolean validar() throws IOException, FileNotFoundException, CsvValidationException;
}
