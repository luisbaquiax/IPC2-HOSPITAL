/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.data.modelDB;

import com.hospitalapi.data.coneccionDB.ConeccionDB;
import com.hospitalapi.model.Usuario;
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
public class UserDB {

    private static final String INSERT_FROM_FILE = "INSERT INTO usuario(id,nombre,username,password,email,fecha_nacimiento,saldo,tipo,direccion,cui,telefono) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
    private static final String INSERT = "INSERT INTO usuario(nombre,username,password,email,fecha_nacimiento,saldo,tipo,direccion,cui,telefono) VALUES(?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE = "UPDATE usuario SET nombre = ?, username = ?, password = ?, email = ?, fecha_nacimiento = ?, saldo = ?, direccion = ?, cui = ?, telefono = ? WHERE id = ?";
    private static final String SELECT_BY_USERNAME_PASSWORD = "SELECT * FROM usuario WHERE username = ? AND password = ?";
    private static final String SELECT_BY_USERNAME = "SELECT * FROM usuario WHERE username = ?";

    private static final String SELECT = "SELECT * FROM usuario";
    
    public static final String ULTIMO = "SELECT id AS ultimo FROM usuario ORDER BY id DESC LIMIT 1";

    private ResultSet resultSet;

    public UserDB() {
    }

    /**
     * Insert a new user in the schema
     *
     * @param usuario
     * @return
     */
    public boolean insert(Usuario usuario) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getUserName());
            statement.setString(3, usuario.getPassword());
            statement.setString(4, usuario.getEmail());
            statement.setString(5, usuario.getFechaNacimiento());
            statement.setDouble(6, usuario.getSaldo());
            statement.setString(7, usuario.getTipo());
            statement.setString(8, usuario.getDireccion());
            statement.setString(9, usuario.getCui());
            statement.setString(10, usuario.getTelefono());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    /**
     * Insert a new user in the schema from file
     *
     * @param usuario
     * @return
     */
    public boolean insertFromFile(Usuario usuario) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(INSERT_FROM_FILE)) {
            statement.setInt(1, usuario.getId());
            statement.setString(2, usuario.getNombre());
            statement.setString(3, usuario.getUserName());
            statement.setString(4, usuario.getPassword());
            statement.setString(5, usuario.getEmail());
            statement.setString(6, usuario.getFechaNacimiento());
            statement.setDouble(7, usuario.getSaldo());
            statement.setString(8, usuario.getTipo());
            statement.setString(9, usuario.getDireccion());
            statement.setString(10, usuario.getCui());
            statement.setString(11, usuario.getTelefono());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;

        }
    }

    /**
     * Update a user
     *
     * @param usuario
     * @return
     */
    public boolean update(Usuario usuario) {
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, usuario.getNombre());
            statement.setString(2, usuario.getUserName());
            statement.setString(3, usuario.getPassword());
            statement.setString(4, usuario.getEmail());
            statement.setString(5, usuario.getFechaNacimiento());
            statement.setDouble(6, usuario.getSaldo());
            statement.setString(7, usuario.getDireccion());
            statement.setString(8, usuario.getCui());
            statement.setString(9, usuario.getTelefono());
            statement.setInt(10, usuario.getId());

            statement.executeUpdate();
            statement.close();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    /**
     * Validate if exists user in the data base
     *
     * @param username
     * @param password
     * @return
     */
    public Usuario getUserByUsernamePassword(String username, String password) {
        Usuario user = null;
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT_BY_USERNAME_PASSWORD)) {
            statement.setString(1, username);
            statement.setString(2, password);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
        }
        return user;
    }

    /**
     *
     * @param username
     * @return
     */
    public Usuario getUserByUsername(String username) {
        Usuario user = null;
        try (PreparedStatement statement = ConeccionDB.getConnection().prepareStatement(SELECT_BY_USERNAME)) {
            statement.setString(1, username);
            resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = getUser(resultSet);
            }
            resultSet.close();
            statement.close();
        } catch (Exception e) {
        }
        return user;
    }

    /**
     *
     * @return
     */
    public List<Usuario> getAllUsers() {
        List<Usuario> list = new ArrayList<>();
        try (PreparedStatement statemente = ConeccionDB.getConnection().prepareStatement(SELECT)) {
            resultSet = statemente.executeQuery();
            while (resultSet.next()) {
                list.add(getUser(resultSet));
            }
            resultSet.close();
            statemente.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return list;
    }

    public int getUltimoId(String sql) {
        int ultimo = 0;
        try (PreparedStatement statemente = ConeccionDB.getConnection().prepareStatement(sql)) {
            resultSet = statemente.executeQuery();
            while (resultSet.next()) {
                ultimo = resultSet.getInt("ultimo");
            }
            resultSet.close();
            statemente.close();
        } catch (SQLException ex) {
            Logger.getLogger(UserDB.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ultimo;
    }

    private Usuario getUser(ResultSet resultSet) throws SQLException {
        return new Usuario(
                resultSet.getInt("id"),
                resultSet.getString("nombre"),
                resultSet.getString("username"),
                resultSet.getString("password"),
                resultSet.getString("email"),
                resultSet.getString("fecha_nacimiento"),
                resultSet.getDouble("saldo"),
                resultSet.getString("tipo"),
                resultSet.getString("direccion"),
                resultSet.getString("telefono"),
                resultSet.getString("cui"));
    }

}
