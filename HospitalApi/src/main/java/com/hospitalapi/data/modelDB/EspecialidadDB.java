/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.Especialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class EspecialidadDB {

    private static final String INSERT = "INSERT INTO especialidad(nombre,descripcion) VALUES(?,?)";
    private static final String SELECT = "SELECT * FROM especialidad";

    private ResultSet resultSet;

    public EspecialidadDB() {
    }

    /**
     * Insert Tipo_examen
     *
     * @param solicitud
     * @return
     */
    public boolean insert(Especialidad solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, solicitud.getName());
            statement.setString(2, solicitud.getDescription());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * List fo Tipo_examen
     *
     * @return
     */
    public List<Especialidad> getEspecialidades() {
        List<Especialidad> solicitudes = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitudes;
    }

    private Especialidad get(ResultSet resultSet) throws SQLException {
        return new Especialidad(
                resultSet.getInt("id"),
                resultSet.getString("nombre"),
                resultSet.getString("descripcion"));
    }
}
