/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.Horario;
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
public class HorarioDB {

    private static final String INSERT = "INSERT INTO horario(hora_inicio,hora_final,idMedico) VALUES(?,?,?)";
    private static final String UPDATE = "UPDATE horario SET hora_inicio = ? hora_final = ? WHERE id = ?";
    /**
     * Horario por médico
     */
    private static final String SELECT_BY_MEDICO = "SELECT * FROM horario WHERE idMedico = ?";
    private ResultSet resultSet;

    public HorarioDB() {
    }

    /**
     *
     * @param horario
     * @return
     */
    public boolean insert(Horario horario) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, horario.getHoraInicio());
            statement.setString(2, horario.getHoraFinal());
            statement.setInt(3, horario.getIdMedico());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * @param horario
     * @return
     */
    public boolean update(Horario horario) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, horario.getHoraInicio());
            statement.setString(2, horario.getHoraFinal());
            statement.setInt(3, horario.getId());
            statement.executeUpdate();
            statement.close();
            return true;
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDB.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    /**
     *
     * Schedule of a doctor
     *
     * @param idMedico
     * @return
     */
    public List<Horario> getHorarioByMedico(int idMedico) {
        List<Horario> lista = new ArrayList<>();
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT_BY_MEDICO)) {
            statement.setInt(1, idMedico);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                lista.add(get(resultSet));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(HorarioDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lista;
    }

    private Horario get(ResultSet resultSet) throws SQLException {
        return new Horario(
                resultSet.getInt("id"),
                resultSet.getString("hora_inicio"),
                resultSet.getString("hora_final"),
                resultSet.getInt("idMedico"));
    }
}
