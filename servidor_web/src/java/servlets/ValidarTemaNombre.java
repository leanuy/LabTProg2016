/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servidor.ArtistaInexistenteException_Exception;

/**
 *
 * @author agustina
 */
@WebServlet(name = "ValidarTemaNombre", urlPatterns = {"/ValidarTemaNombre"})
public class ValidarTemaNombre extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws espotify.excepciones.ArtistaInexistenteException
     * @throws servidor.ArtistaInexistenteException_Exception
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ArtistaInexistenteException_Exception {
        HttpSession session = request.getSession();
        
        response.setContentType("text/html;charset=UTF-8");
        String tema = new String(request.getParameter("tema").getBytes(
                "iso-8859-1"), "UTF-8");
        
        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        boolean tieneTema = port.albumTempTieneTema((String) session.getAttribute("nick_sesion"), tema);

        
        
        PrintWriter out = response.getWriter();

        if (tieneTema) {
            out.print("false");
        } else {
            out.print("true");
        }
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
        try {
            processRequest(request, response);
        } catch (ArtistaInexistenteException_Exception ex) {
            response.sendError(500, "el artista no existe");
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
            processRequest(request, response);
        } catch (ArtistaInexistenteException_Exception ex) {
            response.sendError(500, "el artista no existe");
        }
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
