/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.model.reports.EspecialidadesMedico;
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
public class EspecialidadesMedicoDB {

    private static final String SELECT = "SELECT nombre, descripcion, precio\n"
            + "FROM especialidad e\n"
            + "INNER JOIN medico_especialidad p\n"
            + "ON p.id_especialidad = e.id\n"
            + "INNER JOIN medico m\n"
            + "ON m.id = p.medico\n"
            + "WHERE p.medico = ?";

    private ResultSet resultSet;

    public EspecialidadesMedicoDB() {
    }

    /**
     * LISTA DE ESPECIALIDADES POR MEDICO
     *
     * @param medico
     * @return
     */
    public List<EspecialidadesMedico> getEspecialidadsByMedico(Usuario medico) {
        List<EspecialidadesMedico> lista = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            statement.setInt(1, medico.getId());
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(EspecialidadesMedico.builder().
                        especialidad(resultSet.getString("nombre")).
                        descripcion(resultSet.getString("descripcion")).
                        precio(resultSet.getDouble("precio")).build());
            }
        } catch (SQLException ex) {
            Logger.getLogger(EspecialidadesMedicoDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }
}
