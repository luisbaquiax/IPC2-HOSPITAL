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
public class SolicitudTipoExamen implements Serializable {

    private String nombre;
    /**
     * Estado de la solicitud = aceptado / rechazado
     */
    private String estado;

    /**
     *
     * @param nombre
     * @param estado
     */
    public SolicitudTipoExamen(String nombre, String estado) {
        this.nombre = nombre;
        this.estado = estado;
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
        return estado;
    }

    /**
     * @param estado the aceptado to set
     */
    public void setAceptado(String estado) {
        this.estado = estado;
    }
}
