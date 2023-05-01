/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospitalapi.servletController.users;

import com.hospitalapi.model.Usuario;
import com.hospitalapi.objects.Encriptador;
import com.hospitalapi.objects.JsonConverter;
import com.hospitalapi.objects.LectorJson;
import com.hospitalapi.service.users.UsuarioService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
@WebServlet(name = "UserController", urlPatterns = {"/UserController"})
public class UserController extends HttpServlet {

    private LectorJson lectorJson;
    private JsonConverter jsonConverter;
    private Encriptador encriptador;

    private UsuarioService usuarioService;

    public UserController() {
        this.lectorJson = new LectorJson();
        this.jsonConverter = new JsonConverter();
        this.usuarioService = new UsuarioService();
        this.encriptador = new Encriptador();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tarea = request.getParameter("tarea");
        switch (tarea) {
            case "allUsers":
                System.out.println("Usuarios");
                System.out.println(this.jsonConverter.toJson(this.usuarioService.getAll()));
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                response.getWriter().print(this.jsonConverter.toJson(this.usuarioService.getAll()));
                break;
            case "userUsername":
                System.out.println("Usuarios");
                String username = request.getParameter("username");
                System.out.println(this.jsonConverter.toJson(this.usuarioService.getUserByUsername(username)));
                response.setStatus(HttpServletResponse.SC_OK);
                response.setContentType("application/json");
                response.getWriter().print(this.jsonConverter.toJson(this.usuarioService.getUserByUsername(username)));
                break;
            default:
        }
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String tarea = request.getParameter("tarea");
        switch (tarea) {
            case "ingresarNuevo":
                String json = this.lectorJson.read(request.getReader());
                System.out.println(json);
                Usuario usuario = (Usuario) this.jsonConverter.fromJson(json, Usuario.class);
                usuario.setPassword(encriptador.encriptar(usuario.getPassword()));
                if (usuarioService.insert(usuario)) {
                    System.out.println("bien");
                    response.setStatus(HttpServletResponse.SC_OK);
                    response.setContentType("application/json");
                    response.getWriter().print(json);
                } else {
                    System.out.println("falló");
                    response.setContentType("application/json");
                    response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
                    response.getWriter().print("{\"message\": \"No se pudo crear la cuenta. Lo sentimos.\"}");
                }
                break;
            case "search":
                buscarUsuario(request, response);
                break;
            default:
        }
    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String tarea = request.getParameter("tarea");
        switch (tarea) {
            case "editarUsuario":
                String json = this.lectorJson.read(request.getReader());
                System.out.println(json);
                Usuario usuario = (Usuario) this.jsonConverter.fromJson(json, Usuario.class);
                usuario.setPassword(encriptador.encriptar(usuario.getPassword()));
                if (usuarioService.update(usuario)) {
                    System.out.println("bien");
                } else {
                    System.out.println("falló");
                }
                response.getWriter().print(json);
                break;

            default:
        }
    }

    @Override
    protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws IOException {
    }

    private void buscarUsuario(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario userJSON = (Usuario) this.jsonConverter.fromJson(lectorJson.read(request.getReader()), Usuario.class);
//        String password = request.getParameter("password");
//        String username = request.getParameter("username");
        Usuario user = this.usuarioService.getUserByUsernamePassword(userJSON.getUserName(), encriptador.encriptar(userJSON.getPassword()));
        //Usuario user = this.usuarioService.getUserByUsernamePassword(username, encriptador.encriptar(password));
        System.out.println("buscando al usuario" + userJSON.toString());
        if (user != null) {
            System.out.println(user.toString());
            user.setPassword(encriptador.desencriptar(user.getPassword()));
            System.out.println(user.toString());
            String json = this.jsonConverter.toJson(user);
            response.setStatus(HttpServletResponse.SC_OK);
            response.setContentType("application/json");
            response.getWriter().print(json);
        } else {
            response.setStatus(HttpServletResponse.SC_NOT_FOUND);
            response.setContentType("application/json");
            response.getWriter().print("{\"message\": \"Credendiales incorrectas.\"}");
        }

    }

}
