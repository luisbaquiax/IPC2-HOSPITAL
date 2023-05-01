/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.ExamenConsulta;
import com.hospitalapi.model.SolicitudEspecialidad;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luis
 */
public class ExamenConsultaDB {

    private static final String INSERT = "INSERT INTO examenes_consulta(examen,consulta) VALUES(?,?)";
    private static final String SELECT = "SELECT * FROM examenes_consulta";

    private ResultSet resultSet;

    public ExamenConsultaDB() {
    }

    /**
     *
     * @param examenConsulta
     * @return
     */
    public boolean insert(ExamenConsulta examenConsulta) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setInt(1, examenConsulta.getIdExamen());
            statement.setInt(2, examenConsulta.getIndConsulta());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(ExamenConsultaDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
}
