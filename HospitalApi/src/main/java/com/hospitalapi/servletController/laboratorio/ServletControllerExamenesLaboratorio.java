/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospitalapi.servletController.laboratorio;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.hospitalapi.model.Laboratorio;
import com.hospitalapi.model.Usuario;
import com.hospitalapi.model.reports.EspecialidadesMedico;
import com.hospitalapi.model.reports.ExamenesLaboratorio;
import com.hospitalapi.objects.JsonConverter;
import com.hospitalapi.objects.LectorJson;
import com.hospitalapi.service.laboratorio.ServiceExamenes;
import com.hospitalapi.service.laboratorio.ServiceExamenesLaboratorio;
import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "ServletControllerExamenesLaboratorio", urlPatterns = {"/ServletControllerExamenesLaboratorio"})
public class ServletControllerExamenesLaboratorio extends HttpServlet {

    private ServiceExamenes serviceExamenes;
    private ServiceExamenesLaboratorio serviceExamenesLaboratorio;
    private LectorJson lectorJson;
    private JsonConverter converter;

    public ServletControllerExamenesLaboratorio() {
        this.serviceExamenes = new ServiceExamenes();
        this.lectorJson = new LectorJson();
        this.converter = new JsonConverter<>();
        this.serviceExamenesLaboratorio = new ServiceExamenesLaboratorio();
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
            case "examenesDisponibles":
                listarExamensDisponibles(request, response);
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
            case "examenesLab":
                listarExamensByLaboratory(request, response);
                break;
            case "insert":
                ingresarExamenesLaboratorio(request, response);
                break;
            default:
        }
    }

    private void listarExamensByLaboratory(HttpServletRequest request, HttpServletResponse response) throws IOException {
        Usuario userLaboratorio = (Usuario) this.converter.fromJson(this.lectorJson.read(request.getReader()), Usuario.class);
        response.getWriter().write(this.converter.toJson(this.serviceExamenesLaboratorio.getByLaboratorio(userLaboratorio)));
    }

    private void listarExamensDisponibles(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.getWriter().write(this.converter.toJson(this.serviceExamenes.getDisponibles()));
    }

    private void ingresarExamenesLaboratorio(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int idLab = Integer.parseInt(request.getParameter("idLaboratorio"));
        System.out.println("id laboratorio " + idLab);
        String json = lectorJson.read(request.getReader());
        System.out.println("jso examens: " + json);
        Type listType2 = new TypeToken<ArrayList<ExamenesLaboratorio>>() {
        }.getType();
        ArrayList<ExamenesLaboratorio> examens = new Gson().fromJson(json, listType2);
        System.out.println(Arrays.toString(examens.toArray()));
        for (ExamenesLaboratorio user : examens) {
            System.out.println("examen: " + user.toString());
        }
        this.serviceExamenes.ingresarExamenesLaboratorio(examens, idLab);
        response.setStatus(HttpServletResponse.SC_OK);
        response.getWriter().print("{\"message\": \"Se guardado la información correctamente.\"}");
    }

}
