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
public class ExamenConsulta implements Serializable {

    private int idExamen;
    private int indConsulta;

    /**
     *
     * @param idExamen
     * @param indConsulta
     */
    public ExamenConsulta(int idExamen, int indConsulta) {
        this.idExamen = idExamen;
        this.indConsulta = indConsulta;
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
     * @return the indConsulta
     */
    public int getIndConsulta() {
        return indConsulta;
    }

    /**
     * @param indConsulta the indConsulta to set
     */
    public void setIndConsulta(int indConsulta) {
        this.indConsulta = indConsulta;
    }

}
