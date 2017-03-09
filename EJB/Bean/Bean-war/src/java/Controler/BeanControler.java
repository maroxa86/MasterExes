/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controler;

import java.io.IOException;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Nombres;
import session.NombresServiceLocal;

/**
 *
 * @author Xavi
 */
@WebServlet(name = "BeanControler", urlPatterns = {"*.do"})
public class BeanControler extends HttpServlet {

    @EJB
    private NombresServiceLocal nombresService;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rq;
        switch(request.getServletPath()){
            case "/index.do":
                List<Nombres> listadoNombres = nombresService.listadoNombres();
                request.setAttribute("listadoNombres", listadoNombres);
                rq = request.getRequestDispatcher("index.jsp");  
                break;
            case "/addNombre.do": 
                rq = request.getRequestDispatcher("addNombre.jsp");
                break;
            case "/insertNombre.do":
                Nombres nombreInsertar = new Nombres();
                nombreInsertar.setNombre(request.getParameter("nombre"));
                nombresService.saveNombre(nombreInsertar);
                rq = request.getRequestDispatcher("index.do");
                break;
            case "/editNombre.do":
                Nombres nombreEditar = nombresService.getNombre(Long.parseLong(request.getParameter("idNombre")));
                request.setAttribute("nombre", nombreEditar);
                rq = request.getRequestDispatcher("editNombre.jsp");
                break;
            case "/saveNombre.do":
                Nombres nombreSalvar = nombresService.getNombre(Long.parseLong(request.getParameter("idNombre")));
                nombreSalvar.setNombre(request.getParameter("nombre"));
                nombresService.saveNombre(nombreSalvar);
                rq = request.getRequestDispatcher("index.do");
                break;
            case "/deleteNombre.do":
                nombresService.deleteNombre(Long.parseLong(request.getParameter("idNombre")));
                rq = request.getRequestDispatcher("index.do");
                break;
            default:
                rq = request.getRequestDispatcher("index.do");
                break;
        }
        
        rq.forward(request, response);
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
