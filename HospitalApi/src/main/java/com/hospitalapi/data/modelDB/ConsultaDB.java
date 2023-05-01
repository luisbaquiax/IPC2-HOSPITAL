/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.Consulta;
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
public class ConsultaDB {

    private static final String INSERT_FROM_FILE
            = "INSERT INTO consulta(id,paciente,medico,especialidad,porcentaje,fecha_creacion,fecha_agendada,precio,informe,estado,ganancia_medico,ganancia_admin) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT
            = "INSERT INTO consulta(paciente,medico,especialidad,porcentaje,fecha_creacion,fecha_agendada,precio,informe,estado,ganancia_medico,ganancia_admin) "
            + "VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE
            = "UPDATE consulta SET paciente = ?, medico = ?, especialidad = ?, porcentaje = ?, "
            + "fecha_creacion = ?, fecha_agendada = ?, precio = ?, informe = ?, estado = ?, ganancia_medico = ?, ganancia_admin = ? WHERE id = ?";
    /**
     * Lista de consultas
     */
    private static final String SELECT = "SELECT * FROM consulta";

    /**
     * Lisa de consultas en un intervalo de fecha
     */
    private static final String SELECT_BY_FECHA = "SELECT * FROM consulta WHERE fecha_creacion BETWEEN ? AND ?";
    private ResultSet resusSet;

    public ConsultaDB() {
    }

    /**
     * Insert Consulta to data base
     *
     * @param consulta
     * @return
     */
    public boolean insert(Consulta consulta) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setInt(1, consulta.getIdPaciente());
            statement.setInt(2, consulta.getIdMedico());
            statement.setInt(3, consulta.getIdEspecialidad());
            statement.setDouble(4, consulta.getPorcentaje());
            statement.setString(5, consulta.getFechaCreacion());
            statement.setString(6, consulta.getFechaAgenda());
            statement.setDouble(7, consulta.getPrecio());
            statement.setString(8, consulta.getInforme());
            statement.setString(9, consulta.getEstado());
            statement.setDouble(10, consulta.getGananciaMedico());
            statement.setDouble(11, consulta.getGananciaAdmin());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Insert consulta from file to data base
     *
     * @param consulta
     * @return
     */
    public boolean insertFromFile(Consulta consulta) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT_FROM_FILE)) {
            statement.setInt(1, consulta.getId());
            statement.setInt(2, consulta.getIdPaciente());
            statement.setInt(3, consulta.getIdMedico());
            statement.setInt(4, consulta.getIdEspecialidad());
            statement.setDouble(5, consulta.getPorcentaje());
            statement.setString(6, consulta.getFechaCreacion());
            statement.setString(7, consulta.getFechaAgenda());
            statement.setDouble(8, consulta.getPrecio());
            statement.setString(9, consulta.getInforme());
            statement.setString(10, consulta.getEstado());
            statement.setDouble(11, consulta.getGananciaMedico());
            statement.setDouble(12, consulta.getGananciaAdmin());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * Upudate a consulta
     *
     * @param consulta
     * @return
     */
    public boolean update(Consulta consulta) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, consulta.getIdPaciente());
            statement.setInt(2, consulta.getIdMedico());
            statement.setInt(3, consulta.getIdEspecialidad());
            statement.setDouble(4, consulta.getPorcentaje());
            statement.setString(5, consulta.getFechaCreacion());
            statement.setString(6, consulta.getFechaAgenda());
            statement.setDouble(7, consulta.getPrecio());
            statement.setString(8, consulta.getInforme());
            statement.setString(9, consulta.getEstado());
            statement.setDouble(10, consulta.getGananciaMedico());
            statement.setDouble(11, consulta.getGananciaAdmin());
            statement.setInt(12, consulta.getId());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     * List of consultas
     *
     * @return
     */
    public List<Consulta> getListConsulta() {
        List<Consulta> consutas = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT);) {
            resusSet = statement.executeQuery();
            while (resusSet.next()) {
                consutas.add(get(resusSet));
            }
            resusSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consutas;
    }

    /**
     * List of consultas in a interval time
     *
     * @param fecha1
     * @param fecha2
     * @return
     */
    public List<Consulta> getListConsulta(String fecha1, String fecha2) {
        List<Consulta> consutas = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT_BY_FECHA)) {
            resusSet = statement.executeQuery();
            while (resusSet.next()) {
                consutas.add(get(resusSet));
            }
            resusSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ConsultaDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return consutas;
    }

    private Consulta get(ResultSet resultSet) throws SQLException {
        return new Consulta(
                resultSet.getInt("id"),
                resultSet.getInt("paciente"),
                resultSet.getInt("medico"),
                resultSet.getInt("especialidad"),
                resultSet.getDouble("porcentaje"),
                resultSet.getString("fecha_creacion"),
                resultSet.getString("fecha_agendada"),
                resultSet.getDouble("precio"),
                resultSet.getString("informe"),
                resultSet.getString("estado"),
                resultSet.getDouble("ganancia_medico"),
                resultSet.getDouble("ganancia_admin"));
    }
}
