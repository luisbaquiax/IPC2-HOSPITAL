/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.model;

import java.io.Serializable;

/**
 *
 * @author luis
 */
public class SolicitudEspecialidad implements Serializable {

    private String nombre;
    /**
     * Estado de la solicitud = aceptado / rechazado /  solicitado
     */
    private String aceptado;

    /**
     *
     * @param nombre
     * @param aceptado
     */
    public SolicitudEspecialidad(String nombre, String aceptado) {
        this.nombre = nombre;
        this.aceptado = aceptado;
    }

    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the aceptado
     */
    public String getEstado() {
        return aceptado;
    }

    /**
     * @param aceptado the aceptado to set
     */
    public void setEstado(String aceptado) {
        this.aceptado = aceptado;
    }
}
