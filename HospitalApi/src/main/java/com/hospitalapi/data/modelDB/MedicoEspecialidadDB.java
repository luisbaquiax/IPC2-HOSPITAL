/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.MedicoEspecialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class MedicoEspecialidadDB {

    private static final String INSERT = "INSERT INTO medico_especialidad(id_especialidad,medico,precio) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE medico_especialidad SET precio = ? WHERE id_especialidad = ? AND medico = ?";

    public MedicoEspecialidadDB() {
    }

    /**
     * Insert a new PrecioExamen
     *
     * @param precioExamen
     * @return
     */
    public boolean insert(MedicoEspecialidad precioExamen) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setInt(1, precioExamen.getIdEspecialidad());
            statement.setInt(2, precioExamen.getIdMedico());
            statement.setDouble(3, precioExamen.getPrecio());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoEspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Update a PrecioExamen
     *
     * @param precioExamen
     * @return
     */
    public boolean update(MedicoEspecialidad precioExamen) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setDouble(1, precioExamen.getPrecio());
            statement.setInt(2, precioExamen.getIdEspecialidad());
            statement.setInt(3, precioExamen.getIdMedico());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(MedicoEspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
