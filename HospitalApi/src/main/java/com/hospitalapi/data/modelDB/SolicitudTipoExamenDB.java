/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.SolicitudTipoExamen;
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
public class SolicitudTipoExamenDB {

    private static final String INSERT = "INSERT INTO solicitud_tipo_examen(nombre,estado) VALUES(?,?)";
    private static final String UPDATE = "UPDATE solicitud_tipo_examen SET estado = ? WHERE nombre = ?";
    private static final String SELECT = "SELECT * FROM solicitud_tipo_examen";

    private ResultSet resultSet;

    public SolicitudTipoExamenDB() {
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean insert(SolicitudTipoExamen solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, solicitud.getNombre());
            statement.setString(2, solicitud.getEstado());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudTipoExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean update(SolicitudTipoExamen solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, solicitud.getEstado());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudTipoExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @return
     */
    public List<SolicitudTipoExamen> getListSolicitudes() {
        List<SolicitudTipoExamen> solicitudes = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                solicitudes.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudTipoExamenDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return solicitudes;
    }

    private SolicitudTipoExamen get(ResultSet resultSet) throws SQLException {
        return new SolicitudTipoExamen(resultSet.getString("nombre"), resultSet.getString("estado"));
    }

}
