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
public class ListaEstadosConsulta {

    public static final String AGENDADA = "AGENDADA";
    public static final String EXAMEN_PENDIENTE = "EXAMEN_PENDIENTE";
    public static final String FINALIZADA = "FINALIZADA";
    public static final String PEDIENTE_REVISION = "PEDIENTE_REVISION";
    private final List<EstadoConsulta> lista;

    /**
     *
     */
    public ListaEstadosConsulta() {
        this.lista = new ArrayList<>();
        this.lista.add(EstadoConsulta.builder().estado(AGENDADA).build());
        this.lista.add(EstadoConsulta.builder().estado(EXAMEN_PENDIENTE).build());
        this.lista.add(EstadoConsulta.builder().estado(FINALIZADA).build());
        this.lista.add(EstadoConsulta.builder().estado(PEDIENTE_REVISION).build());

    }

    /**
     * @return the lista
     */
    public List<EstadoConsulta> getLista() {
        return lista;
    }

}
