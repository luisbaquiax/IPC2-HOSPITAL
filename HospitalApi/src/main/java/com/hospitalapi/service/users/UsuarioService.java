/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.hospitalapi.service.users;

import com.hospitalapi.data.modelDB.LaboratorioDB;
import com.hospitalapi.data.modelDB.MedicoDB;
import com.hospitalapi.data.modelDB.PacienteDB;
import com.hospitalapi.data.modelDB.UserDB;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.objects.ListaTiposUsuario;
import java.util.List;

/**
 *
 * @author luis
 */
public class UsuarioService {

    private UserDB userDB;
    private MedicoDB medicoDB;
    private LaboratorioDB laboratorioDB;
    private PacienteDB pacienteDB;

    public UsuarioService() {
        this.userDB = new UserDB();
        this.medicoDB = new MedicoDB();
        this.laboratorioDB = new LaboratorioDB();
        this.pacienteDB = new PacienteDB();
    }

    public boolean insert(Usuario usuario) {
        if (userDB.insert(usuario)) {
            usuario.setId(userDB.getUltimoId(UserDB.ULTIMO));
            switch (usuario.getTipo()) {
                case ListaTiposUsuario.MEDICO:
                    this.medicoDB.insert(usuario.getId());
                    break;
                case ListaTiposUsuario.PACIENTE:
                    this.pacienteDB.insert(usuario.getId());
                    break;
                case ListaTiposUsuario.LABORATORIO:
                    this.laboratorioDB.insert(usuario.getId());
                    break;
            }
            return true;
        } else {
            return false;
        }
    }

    public boolean insertFromFile(Usuario usuario) {
        return this.userDB.insertFromFile(usuario);
    }

    public boolean update(Usuario usuario) {
        return this.userDB.update(usuario);
    }

    public Usuario getUserByUsernamePassword(String username, String password) {
        return this.userDB.getUserByUsernamePassword(username, password);
    }

    public Usuario getUserByUsername(String username) {
        return this.userDB.getUserByUsername(username);
    }

    public List<Usuario> getAll() {
        return this.userDB.getAllUsers();
    }
}
