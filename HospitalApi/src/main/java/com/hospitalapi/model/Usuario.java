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
public class Usuario implements Serializable {

    private int id;
    private String nombre;
    private String username;
    private String password;
    private String email;
    /**
     * fecha_nacimiento-usuarios, fecha_fundacion-laboratorio
     */
    private String fechaNacimiento;
    private double saldo;
    private String tipo;
    private String direccion;
    private String telefono;
    private String cui;

    public Usuario() {
    }

    /**
     *
     * @param id
     * @param nombre
     * @param userName
     * @param password
     * @param email
     * @param fechaNacimiento
     * @param saldo
     * @param tipo
     * @param direccion
     * @param telefono
     * @param cui
     */
    public Usuario(int id, String nombre, String userName, String password, String email, String fechaNacimiento, double saldo, String tipo, String direccion, String telefono, String cui) {
        this.id = id;
        this.nombre = nombre;
        this.username = userName;
        this.password = password;
        this.email = email;
        this.fechaNacimiento = fechaNacimiento;
        this.saldo = saldo;
        this.tipo = tipo;
        this.direccion = direccion;
        this.telefono = telefono;
        this.cui = cui;
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
     * @return the userName
     */
    public String getUserName() {
        return username;
    }

    /**
     * @param userName the userName to set
     */
    public void setUserName(String userName) {
        this.username = userName;
    }

    /**
     * @return the password
     */
    public String getPassword() {
        return password;
    }

    /**
     * @param password the password to set
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the fechaNacimiento
     */
    public String getFechaNacimiento() {
        return fechaNacimiento;
    }

    /**
     * @param fechaNacimiento the fechaNacimiento to set
     */
    public void setFechaNacimiento(String fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    /**
     * @return the saldo
     */
    public double getSaldo() {
        return saldo;
    }

    /**
     * @param saldo the saldo to set
     */
    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    /**
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the direccion
     */
    public String getDireccion() {
        return direccion;
    }

    /**
     * @param direccion the direccion to set
     */
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    /**
     * @return the cui
     */
    public String getCui() {
        return cui;
    }

    /**
     * @param cui the cui to set
     */
    public void setCui(String cui) {
        this.cui = cui;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
