/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicios;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Xavi
 */
@WebServlet(name = "Datos", urlPatterns = {"/Datos"})
public class Datos extends HttpServlet {
    String[] listadoProvincias = {"", "Tarragona", "Madrid", "Barcelona", "Valencia"};
    String[] listadoCiudades = {"", "Reus", "Alcala de Henares", "Badalona", "Xativa"};
    String[] listadoDirecciones = {"", "C/Madrid", "C/Escocia", "C/Merida", "C/Toledo"};
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
//        response.setContentType("application/xml");
//        response.setHeader("Cache-Control", "no-cache");
        String persona = request.getParameter("persona");
//        StringBuilder texto = new StringBuilder("<provincia>" + listadoProvincias[Integer.parseInt(persona)] + "</provincia> ");
//        texto.append("<ciudad>" + listadoCiudades[Integer.parseInt(persona)] + "</ciudad> ");
//        texto.append("<direccion>" + listadoDirecciones[Integer.parseInt(persona)] + "</direccion> ");
        response.setContentType("text/xml;charset=UTF-8");
        PrintWriter writer = response.getWriter();
        writer.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
        writer.append("<persona>");
        writer.append("<provincia> La provincia es: " + listadoProvincias[Integer.parseInt(persona)] + "</provincia>");
        writer.append("<ciudad> La ciudad es: " + listadoCiudades[Integer.parseInt(persona)] + "</ciudad> ");
        writer.append("<direccion> La direccion es: " + listadoDirecciones[Integer.parseInt(persona)] + "</direccion> ");
        writer.append("</persona>");


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
        processRequest(request, response);
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
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
