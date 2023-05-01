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
public class PrecioExamen implements Serializable {

    /**
     * id del tipo de examen
     */
    private int idExamen;
    private int idLaboratorio;
    private double precio;

    /**
     *
     * @param idExamen
     * @param idLaboratorio
     * @param precio
     */
    public PrecioExamen(int idExamen, int idLaboratorio, double precio) {
        this.idExamen = idExamen;
        this.idLaboratorio = idLaboratorio;
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
     * @return the idLaboratorio
     */
    public int getIdLaboratorio() {
        return idLaboratorio;
    }

    /**
     * @param idLaboratorio the idLaboratorio to set
     */
    public void setIdLaboratorio(int idLaboratorio) {
        this.idLaboratorio = idLaboratorio;
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
