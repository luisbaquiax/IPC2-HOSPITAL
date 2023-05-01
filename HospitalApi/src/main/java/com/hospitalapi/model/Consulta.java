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
public class Consulta implements Serializable {

    private int id;
    private int idPaciente;
    private int idMedico;
    private int idEspecialidad;
    private double porcentaje;
    private String fechaCreacion;
    private String fechaAgenda;
    private double precio;
    private String informe;
    private String estado;
    private double gananciaMedico;
    private double gananciaAdmin;

    /**
     *
     * @param id
     * @param idPaciente
     * @param idMedico
     * @param idEspecialidad
     * @param porcentaje
     * @param fechaCreacion
     * @param fechaAgenda
     * @param precio
     * @param informe
     * @param estado
     * @param gananciaMedico
     * @param gananciaAdmin
     */
    public Consulta(int id, int idPaciente, int idMedico, int idEspecialidad, double porcentaje, String fechaCreacion, String fechaAgenda, double precio, String informe, String estado, double gananciaMedico, double gananciaAdmin) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idMedico = idMedico;
        this.idEspecialidad = idEspecialidad;
        this.porcentaje = porcentaje;
        this.fechaCreacion = fechaCreacion;
        this.fechaAgenda = fechaAgenda;
        this.precio = precio;
        this.informe = informe;
        this.estado = estado;
        this.gananciaMedico = gananciaMedico;
        this.gananciaAdmin = gananciaAdmin;
    }

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the idPaciente
     */
    public int getIdPaciente() {
        return idPaciente;
    }

    /**
     * @param idPaciente the idPaciente to set
     */
    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
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
     * @return the porcentaje
     */
    public double getPorcentaje() {
        return porcentaje;
    }

    /**
     * @param porcentaje the porcentaje to set
     */
    public void setPorcentaje(double porcentaje) {
        this.porcentaje = porcentaje;
    }

    /**
     * @return the fechaCreacion
     */
    public String getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * @param fechaCreacion the fechaCreacion to set
     */
    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    /**
     * @return the fechaAgenda
     */
    public String getFechaAgenda() {
        return fechaAgenda;
    }

    /**
     * @param fechaAgenda the fechaAgenda to set
     */
    public void setFechaAgenda(String fechaAgenda) {
        this.fechaAgenda = fechaAgenda;
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

    /**
     * @return the informe
     */
    public String getInforme() {
        return informe;
    }

    /**
     * @param informe the informe to set
     */
    public void setInforme(String informe) {
        this.informe = informe;
    }

    /**
     * @return the estado
     */
    public String getEstado() {
        return estado;
    }

    /**
     * @param estado the estado to set
     */
    public void setEstado(String estado) {
        this.estado = estado;
    }

    /**
     * @return the gananciaMedico
     */
    public double getGananciaMedico() {
        return gananciaMedico;
    }

    /**
     * @param gananciaMedico the gananciaMedico to set
     */
    public void setGananciaMedico(double gananciaMedico) {
        this.gananciaMedico = gananciaMedico;
    }

    /**
     * @return the gananciaAdmin
     */
    public double getGananciaAdmin() {
        return gananciaAdmin;
    }

    /**
     * @param gananciaAdmin the gananciaAdmin to set
     */
    public void setGananciaAdmin(double gananciaAdmin) {
        this.gananciaAdmin = gananciaAdmin;
    }
}
