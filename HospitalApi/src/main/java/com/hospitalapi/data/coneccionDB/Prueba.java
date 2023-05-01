/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.coneccionDB;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hospitalapi.data.modelDB.MedicoDB;
import com.hospitalapi.model.reports.EspecialidadesMedico;
import com.hospitalapi.model.reports.ExamenesLaboratorio;
import com.hospitalapi.objects.Encriptador;
import com.hospitalapi.objects.datos.ContenidoArchivoJSON;
import com.hospitalapi.objects.datos.ProcesadorEnradaJSON;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author luis
 */
public class Prueba {

    public static void main(String[] args) throws Exception {
        ConeccionDB.getConnection();
        String[] pass = new String[]{"contra1", "contra2", "contra3", "contra4", "contra5", "contra6", "contra7"};
        Encriptador encriptador = new Encriptador();
        System.out.println(encriptador.desencriptar("1Z1U4g19HcLKeL47jpIN9g=="));
        MedicoDB medicoDB = new MedicoDB();
        medicoDB.insert(1000);
        ProcesadorEnradaJSON p = new ProcesadorEnradaJSON();
        ContenidoArchivoJSON contenidoArchivoJSON = new ContenidoArchivoJSON();
        String json = "[{\"especialidad\":\"EspecialidadA\",\"precio\":33}]";
        Type listType = new TypeToken<ArrayList<EspecialidadesMedico>>() {
        }.getType();
        ArrayList<EspecialidadesMedico> users = new Gson().fromJson(json, listType);
        System.out.println(Arrays.toString(users.toArray()));
        
        String json2 = "[{\"nombre\":\"Nombre tipo examen A\",\"precio\":11}]";
        Type listType2 = new TypeToken<ArrayList<ExamenesLaboratorio>>() {
        }.getType();
        ArrayList<ExamenesLaboratorio> users2 = new Gson().fromJson(json2, listType2);
        System.out.println(Arrays.toString(users2.toArray()));
//        File file = new File("/home/luis/Escritorio/entrada_hospital.json");
//
//        p.procesarContendioJSON(contenidoArchivoJSON.getContenidioArchivoJSON(new BufferedReader(new FileReader(file))));
//        CargaDatos carga = new CargaDatos(p);
//        carga.subirDatos(p);
    }

}
