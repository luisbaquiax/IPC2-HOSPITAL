/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.hospitalapi.servletController.data;

import com.hospitalapi.service.users.DataService;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.json.simple.parser.ParseException;

/**
 *
 * @author luis
 */
@WebServlet(name = "servletControllerData", urlPatterns = {"/servletControllerData"})
@MultipartConfig
public class servletControllerData extends HttpServlet {

    private DataService dataService;

    public servletControllerData() {
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
        //validar si no hay errores
        if (dataService != null) {
            this.dataService.subirDatos();
            response.setStatus(HttpServletResponse.SC_CONTINUE);
            response.setContentType("application/json");

            //mensaje
            response.getWriter().print("{\"message\": \"Se ha subido la información correctamente\"}");
        } else {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            response.setContentType("application/json");
            response.getWriter().print("{\"message\": \"No se pudo cargar la información.\"}");
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
        try {
            this.dataService = new DataService();
            System.out.println("hola entro");
            Part partes = request.getPart("archivo");
            InputStream inputStream = partes.getInputStream();
            BufferedReader buffer = new BufferedReader(new InputStreamReader(inputStream));
            //procesar datos
            this.dataService.procesarDatos(buffer);
            response.setStatus(HttpServletResponse.SC_CREATED);
            response.setContentType("application/json");

            //mensaje
            response.getWriter().print("{\"message\": \"Se ha leido el contendio del archivo\"}");
        } catch (ParseException ex) {
            response.setStatus(HttpServletResponse.SC_EXPECTATION_FAILED);
            response.getWriter().print("{\"message\": \"No se pudo leer el archivo\"}");
            ex.printStackTrace();
            Logger.getLogger(servletControllerData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
