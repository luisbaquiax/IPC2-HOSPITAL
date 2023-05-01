/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.SolicitudEspecialidad;
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
public class SolicitudEspecialidadDB {

    private static final String INSERT = "INSERT INTO solicitud_especialidad(nombre,estado) VALUES(?,?)";
    private static final String UPDATE = "UPDATE solicitud_especialidad SET estado = ? WHERE nombre = ?";
    private static final String SELECT = "SELECT * FROM solicitud_especialidad";

    private ResultSet resultSet;

    public SolicitudEspecialidadDB() {
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean insert(SolicitudEspecialidad solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, solicitud.getNombre());
            statement.setString(2, solicitud.getEstado());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudEspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean update(SolicitudEspecialidad solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, solicitud.getEstado());
            statement.setString(2, solicitud.getNombre());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudEspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @return
     */
    public List<SolicitudEspecialidad> getListSolicitudes() {
        List<SolicitudEspecialidad> solicitudes = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudEspecialidadDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitudes;
    }

    private SolicitudEspecialidad get(ResultSet resultSet) throws SQLException {
        return new SolicitudEspecialidad(resultSet.getString("nombre"), resultSet.getString("estado"));
    }

}
