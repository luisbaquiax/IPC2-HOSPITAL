/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.service.users;

import com.hospitalapi.objects.datos.CargaDatos;
import com.hospitalapi.objects.datos.ContenidoArchivoJSON;
import com.hospitalapi.objects.datos.ProcesadorEnradaJSON;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import lombok.Getter;
import lombok.ToString;
import org.json.simple.parser.ParseException;

/**
 *
 * @author luis
 */
@Getter
@ToString
public class DataService {

    private ProcesadorEnradaJSON procesadorJSON;
    private CargaDatos cargaDatos;
    private ContenidoArchivoJSON contenidoArchivoJSON;

    public DataService() {
        this.contenidoArchivoJSON = new ContenidoArchivoJSON();
        this.procesadorJSON = new ProcesadorEnradaJSON();
        this.cargaDatos = new CargaDatos(procesadorJSON);
    }

    public void procesarDatos(BufferedReader buffer) throws ParseException, IOException {
        this.procesadorJSON.procesarContendioJSON(contenidoArchivoJSON.getContenidioArchivoJSON(buffer));
    }

    public void subirDatos() {
        this.cargaDatos.subirDatos(procesadorJSON);
    }
}
