/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.HistorialPorcentaje;
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
public class HistorialPorcentajDB {

    private static final String INSERT = "INSERT INTO historial_porcentajes(porcentaje,fecha_inicial,fecha_final,estado) VALUES(?,?,?,?)";
    private static final String UPDATE = "UPDATE historial_porcentajes SET estado = ? WHERE id = ?";
    private static final String SELECT = "SELECT * FROM historial_porcentajes";

    private ResultSet resultSet;

    /**
     *
     * @param historialPorcentaje
     * @return
     */
    public boolean insert(HistorialPorcentaje historialPorcentaje) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setDouble(1, historialPorcentaje.getPorcentaje());
            statement.setString(2, historialPorcentaje.getFechaInicial());
            statement.setString(3, historialPorcentaje.getFechaFinal());
            statement.setString(4, historialPorcentaje.getEstado());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialPorcentajDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Update a historial de porcentajes
     *
     * @param historialPorcentaje
     * @return
     */
    public boolean update(HistorialPorcentaje historialPorcentaje) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, historialPorcentaje.getEstado());
            statement.setInt(2, historialPorcentaje.getId());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HistorialPorcentajDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * List of historialPorcentaje
     *
     * @return
     */
    public List<HistorialPorcentaje> getListaHistorialPorcentaje() {
        List<HistorialPorcentaje> lista = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(getHistorial(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HistorialPorcentajDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private HistorialPorcentaje getHistorial(ResultSet resultSet) throws SQLException {
        return new HistorialPorcentaje(
                resultSet.getInt("id"),
                resultSet.getDouble("porcentaje"),
                resultSet.getString("fecha_inicial"),
                resultSet.getString("fecha_final"),
                resultSet.getString("estado"));
    }

}
