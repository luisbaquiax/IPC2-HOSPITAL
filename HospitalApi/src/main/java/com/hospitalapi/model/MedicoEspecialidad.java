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
public class MedicoEspecialidad implements Serializable {

    private int idEspecialidad;
    private int idMedico;
    private double precio;

    /**
     *
     * @param idEspecialidad
     * @param idMedico
     * @param precio
     */
    public MedicoEspecialidad(int idEspecialidad, int idMedico, double precio) {
        this.idEspecialidad = idEspecialidad;
        this.idMedico = idMedico;
        this.precio = precio;
    }

    /**
     * @return the idEspecialidad
     */
    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    /**
     * @param idEspecialidad the idEspecialidad to set
     */
    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    /**
     * @return the idMedico
     */
    public int getIdMedico() {
        return idMedico;
    }

    /**
     * @param idMedico the idMedico to set
     */
    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
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
