/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.TipoExamen;
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
public class TipoExamenDB {

    private static final String INSERT = "INSERT INTO tipo_examen(nombre,descripcion) VALUES(?,?)";
    private static final String SELECT = "SELECT * FROM tipo_examen";
    
    public static final String ULTIMO = "SELECT id AS ultimo FROM tipo_examen ORDER BY id DESC LIMIT 1";

    private ResultSet resultSet;

    public TipoExamenDB() {
    }

    /**
     * Insert Tipo_examen
     *
     * @param solicitud
     * @return
     */
    public boolean insertTipoExamen(TipoExamen solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, solicitud.getName());
            statement.setString(2, solicitud.getDescription());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(TipoExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * List fo Tipo_examen
     *
     * @return
     */
    public List<TipoExamen> getTipoExamenes() {
        List<TipoExamen> solicitudes = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(TipoExamenDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitudes;
    }

    private TipoExamen get(ResultSet resultSet) throws SQLException {
        return new TipoExamen(
                resultSet.getInt("id"),
                resultSet.getString("nombre"),
                resultSet.getString("descripcion"));
    }
}
