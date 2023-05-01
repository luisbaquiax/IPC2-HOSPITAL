/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.model;

import java.io.Serializable;
import lombok.ToString;

/**
 *
 * @author luis
 */
@ToString
public class ExamenSolicitado implements Serializable {

    private int idExamen;
    private int idSolicitud;
    private double precio;

    /**
     *
     * @param idExamen
     * @param idSolicitud
     * @param precio
     */
    public ExamenSolicitado(int idExamen, int idSolicitud, double precio) {
        this.idExamen = idExamen;
        this.idSolicitud = idSolicitud;
        this.precio = precio;
    }

    /**
     * @return the idExamen
     */
    public int getIdExamen() {
        return idExamen;
    }

    /**
     * @param idExamen the idExamen to set
     */
    public void setIdExamen(int idExamen) {
        this.idExamen = idExamen;
    }

    /**
     * @return the idSolicitud
     */
    public int getIdSolicitud() {
        return idSolicitud;
    }

    /**
     * @param idSolicitud the idSolicitud to set
     */
    public void setIdSolicitud(int idSolicitud) {
        this.idSolicitud = idSolicitud;
    }

    /**
     * @return the precio
     */
    public double getPrecio() {
        return precio;
    }

    /**
     * @param precio the precio to set
     */
    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
