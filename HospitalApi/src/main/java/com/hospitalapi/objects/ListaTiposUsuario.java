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
public class ListaTiposUsuario {

    public static final String ADMIN = "ADMIN";
    public static final String MEDICO = "MEDICO";
    public static final String PACIENTE = "PACIENTE";
    public static final String LABORATORIO = "LABORATORIO";

    private final List<TipoUsuario> lista;

    /**
     *
     */
    public ListaTiposUsuario() {
        this.lista = new ArrayList<>();
        this.lista.add(TipoUsuario.builder().tipo(ADMIN).build());
        this.lista.add(TipoUsuario.builder().tipo(MEDICO).build());
        this.lista.add(TipoUsuario.builder().tipo(PACIENTE).build());
        this.lista.add(TipoUsuario.builder().tipo(LABORATORIO).build());
    }

    /**
     * @return the lista
     */
    public List<TipoUsuario> getLista() {
        return lista;
    }

}
