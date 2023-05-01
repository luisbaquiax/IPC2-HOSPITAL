/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospitalapi.servletController.medico;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.model.reports.EspecialidadesMedico;
import com.hospitalapi.objects.JsonConverter;
import com.hospitalapi.objects.LectorJson;
import com.hospitalapi.service.medico.ServiceEspecialidad;
import com.hospitalapi.service.medico.ServiceMedicoEspecialidad;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luis
 */
@WebServlet(name = "servletControllerMedicoEspecialidad", urlPatterns = {"/servletControllerMedicoEspecialidad"})
public class servletControllerMedicoEspecialidad extends HttpServlet {

    private JsonConverter converter;
    private LectorJson lectorJson;
    private ServiceMedicoEspecialidad serviceEspecialidadesMedico;
    private ServiceEspecialidad serviceEspecialidad;

    public servletControllerMedicoEspecialidad() {
        this.converter = new JsonConverter();
        this.lectorJson = new LectorJson();
        this.serviceEspecialidadesMedico = new ServiceMedicoEspecialidad();
        this.serviceEspecialidad = new ServiceEspecialidad();
    }

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
            case "especialidadesDisponibles":
                listarEspecialidadesDisponbles(request, response);
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
            case "especialidades":
                listarEspecialidades(request, response);
                break;
            case "insert":
                ingresarEspecialidad(request, response);
                break;
            default:
        }

    }

    @Override
    protected void doPut(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

    private void listarEspecialidades(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario medico = (Usuario) this.converter.fromJson(lectorJson.read(request.getReader()), Usuario.class);
        String json = this.converter.toJson(this.serviceEspecialidadesMedico.getEspecialidadsByMedico(medico));

        response.getWriter().print(json);
    }

    private void listarEspecialidadesDisponbles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        System.out.println("Especialidades: " + Arrays.toString(this.serviceEspecialidad.getEspecialidades().toArray()));
        response.getWriter().write(this.converter.toJson(this.serviceEspecialidad.getEspecialidades()));
    }

    private void ingresarEspecialidad(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idMedico = Integer.parseInt(request.getParameter("idMedico"));
        System.out.println("id medico " + idMedico);
        String json = lectorJson.read(request.getReader());

        Type listType = new TypeToken<ArrayList<EspecialidadesMedico>>() {
        }.getType();
        ArrayList<EspecialidadesMedico> users = new Gson().fromJson(json, listType);
        System.out.println(Arrays.toString(users.toArray()));
        for (EspecialidadesMedico user : users) {
            System.out.println("espe: "+user.toString());
        }
        this.serviceEspecialidad.ingresarEspecialidades(users, idMedico);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("{\"message\": \"Se guardado la información correctamente.\"}");
    }

}
