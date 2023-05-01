/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.model.reports.ExamenesLaboratorio;
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
public class ExamanesLaboratorioDB {

    public static final String SELECT
            = "SELECT nombre, descripcion, precio\n"
            + "FROM tipo_examen e\n"
            + "INNER JOIN precio_examen p\n"
            + "ON p.examen = e.id\n"
            + "INNER JOIN laboratorio l\n"
            + "ON l.id = p.laboratorio\n"
            + "WHERE p.laboratorio = ?";

    private ResultSet resultSet;

    public ExamanesLaboratorioDB() {
    }

    /**
     * List of examenes of laboratorio
     *
     * @param laboratorio
     * @return
     */
    public List<ExamenesLaboratorio> getList(Usuario laboratorio) {
        List<ExamenesLaboratorio> lista = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            statement.setInt(1, laboratorio.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(ExamenesLaboratorio.builder().
                        nombre(resultSet.getString("nombre")).
                        descripcion(resultSet.getString("descripcion")).
                        precio(resultSet.getDouble("precio")).build());
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(ExamanesLaboratorioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
