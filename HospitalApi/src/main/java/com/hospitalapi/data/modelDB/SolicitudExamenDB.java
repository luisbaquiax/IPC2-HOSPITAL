/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.SolicitudExamen;
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
public class SolicitudExamenDB {

    private static final String INSERT_FROM_FILE
            = "INSERT INTO solicitud_examen(id,paciente,laboratorio,porcentaje,fecha_solicitado,fecha_finalizada,estado,ganancia_lab,ganancia_admin,costo_total) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT
            = "INSERT INTO solicitud_examen(paciente,laboratorio,porcentaje,fecha_solicitado,fecha_finalizada,estado,ganancia_lab,ganancia_admin,costo_total) "
            + "VALUES(?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE solicitud_examen SET estado = ? WHERE id = ?";
    /**
     * Lista de solicitudes de examen
     */
    private static final String SELECT = "SELECT * FROM solicitud_examen";
    /**
     * Lista de solicitudes de examen en un intervalo de fecha
     */
    private static final String SELECT_BETWEEN_FECHA = "SELECT * FROM solicitud_examen WHERE fecha_solicitado BETWEEN ? AND ?";

    private ResultSet resultSet;

    public SolicitudExamenDB() {
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean insertFromFile(SolicitudExamen solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT_FROM_FILE)) {
            statement.setInt(1, solicitud.getId());
            statement.setInt(2, solicitud.getIdPaciente());
            statement.setInt(3, solicitud.getIdLaboratorio());
            statement.setDouble(4, solicitud.getPorcentaje());
            statement.setString(5, solicitud.getFechaSolicitado());
            statement.setString(6, solicitud.getFechaRealizada());
            statement.setString(7, solicitud.getEstado());
            statement.setDouble(8, solicitud.getGananciaLab());
            statement.setDouble(9, solicitud.getGananciaAdmin());
            statement.setDouble(10, solicitud.getCostoTotal());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean insert(SolicitudExamen solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setInt(1, solicitud.getIdPaciente());
            statement.setInt(2, solicitud.getIdLaboratorio());
            statement.setDouble(3, solicitud.getPorcentaje());
            statement.setString(4, solicitud.getFechaSolicitado());
            statement.setString(5, solicitud.getFechaRealizada());
            statement.setString(6, solicitud.getEstado());
            statement.setDouble(7, solicitud.getGananciaLab());
            statement.setDouble(8, solicitud.getGananciaAdmin());
            statement.setDouble(9, solicitud.getCostoTotal());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param solicitud
     * @return
     */
    public boolean update(SolicitudExamen solicitud) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setString(6, solicitud.getEstado());
            statement.setInt(2, solicitud.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudExamenDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * List of SolicitudExamen
     *
     * @return
     */
    public List<SolicitudExamen> getListSolicitdExamen() {
        List<SolicitudExamen> lista = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudExamenDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    /**
     * List of SolicitudExamen in time interval
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<SolicitudExamen> getListSolicitdExamen(String fecha1, String fecha2) {
        List<SolicitudExamen> lista = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT_BETWEEN_FECHA)) {
            statement.setString(1, fecha1);
            statement.setString(2, fecha2);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(SolicitudExamenDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private SolicitudExamen get(ResultSet resultSet) throws SQLException {
        return new SolicitudExamen(
                resultSet.getInt("id"),
                resultSet.getInt("paciente"),
                resultSet.getInt("laboratorio"),
                resultSet.getDouble("porcentaje"),
                resultSet.getString("fecha_solicitado"),
                resultSet.getString("fecha_finalizada"),
                resultSet.getString("estado"),
                resultSet.getDouble("ganancia_lab"),
                resultSet.getDouble("ganancia_admin"),
                resultSet.getDouble("costo_total"));
    }
}
