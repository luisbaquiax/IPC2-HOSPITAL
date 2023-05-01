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
public class SolicitudExamen implements Serializable {

    private int id;
    private int idPaciente;
    private int idLaboratorio;
    private double porcentaje;
    private String fechaSolicitado;
    private String fechaRealizada;
    private String estado;
    private double gananciaLab;
    private double gananciaAdmin;
    private double costoTotal;

    /**
     *
     * @param id
     * @param idPaciente
     * @param idLaboratorio
     * @param porcentaje
     * @param fechaSolicitado
     * @param fechaRealizada
     * @param estado
     * @param gananciaLab
     * @param gananciaAdmin
     * @param costoTotal
     */
    public SolicitudExamen(int id, int idPaciente, int idLaboratorio, double porcentaje, String fechaSolicitado, String fechaRealizada, String estado, double gananciaLab, double gananciaAdmin, double costoTotal) {
        this.id = id;
        this.idPaciente = idPaciente;
        this.idLaboratorio = idLaboratorio;
        this.porcentaje = porcentaje;
        this.fechaSolicitado = fechaSolicitado;
        this.fechaRealizada = fechaRealizada;
        this.estado = estado;
        this.gananciaLab = gananciaLab;
        this.gananciaAdmin = gananciaAdmin;
        this.costoTotal = costoTotal;
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
     * @return the fechaSolicitado
     */
    public String getFechaSolicitado() {
        return fechaSolicitado;
    }

    /**
     * @param fechaSolicitado the fechaSolicitado to set
     */
    public void setFechaSolicitado(String fechaSolicitado) {
        this.fechaSolicitado = fechaSolicitado;
    }

    /**
     * @return the fechaRealizada
     */
    public String getFechaRealizada() {
        return fechaRealizada;
    }

    /**
     * @param fechaRealizada the fechaRealizada to set
     */
    public void setFechaRealizada(String fechaRealizada) {
        this.fechaRealizada = fechaRealizada;
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
     * @return the gananciaLab
     */
    public double getGananciaLab() {
        return gananciaLab;
    }

    /**
     * @param gananciaLab the gananciaLab to set
     */
    public void setGananciaLab(double gananciaLab) {
        this.gananciaLab = gananciaLab;
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

    /**
     * @return the costoTotal
     */
    public double getCostoTotal() {
        return costoTotal;
    }

    /**
     * @param costoTotal the costoTotal to set
     */
    public void setCostoTotal(double costoTotal) {
        this.costoTotal = costoTotal;
    }
}
