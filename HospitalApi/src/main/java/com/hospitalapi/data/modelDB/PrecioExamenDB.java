/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.PrecioExamen;
import com.hospitalapi.model.TipoExamen;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class PrecioExamenDB {

    private static final String INSERT = "INSERT INTO precio_examen(examen,laboratorio,precio) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE precio_examen SET precio = ? WHERE examen = ? AND laboratorio = ?";
    private static final String SELECT = "SELECT * FROM precio_examen";

    private ResultSet resultSet;

    public PrecioExamenDB() {
    }

    /**
     * Insert a new PrecioExamen
     *
     * @param precioExamen
     * @return
     */
    public boolean insert(PrecioExamen precioExamen) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setInt(1, precioExamen.getIdExamen());
            statement.setInt(2, precioExamen.getIdLaboratorio());
            statement.setDouble(3, precioExamen.getPrecio());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PrecioExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Update a PrecioExamen
     *
     * @param precioExamen
     * @return
     */
    public boolean update(PrecioExamen precioExamen) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setDouble(1, precioExamen.getPrecio());
            statement.setInt(2, precioExamen.getIdExamen());
            statement.setInt(3, precioExamen.getIdLaboratorio());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(PrecioExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

}
