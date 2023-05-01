/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.objects;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luis
 */
public class ListaEstadosSolicitudExamen {

    public static final String PENDIENTE = "PENDIENTE";
    public static final String FINALIZADA = "FINALIZADA";

    private List<EstadoSolicitudExamen> lista;

    public ListaEstadosSolicitudExamen() {
        this.lista = new ArrayList<>();
        this.lista.add(EstadoSolicitudExamen.builder().estado(PENDIENTE).build());
        this.lista.add(EstadoSolicitudExamen.builder().estado(FINALIZADA).build());
    }

    /**
     * @return the lista
     */
    public List<EstadoSolicitudExamen> getLista() {
        return lista;
    }

}
