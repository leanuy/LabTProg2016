/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.excepciones.AlbumInexistenteException;
import espotify.interfaces.web.IAltaTemaListaWeb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Santiago
 */
@WebServlet(name = "AgregarTemaListaWeb", urlPatterns = {"/AgregarTemaListaWeb"})
public class AgregarTemaListaWeb extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String nick = (String) request.getAttribute("nickUsr");
        String tema = (String) request.getAttribute("tema");
        String artista = (String) request.getAttribute("artista");
        String listaSacar = (String) request.getAttribute("listaSacar");
        String usrSacar = (String) request.getAttribute("usrSacar");
        String albumSacar = (String) request.getAttribute("album");
        String listaAgregar = (String) request.getAttribute("listaAgregar");
        IAltaTemaListaWeb ialtw = Fabrica.getIAltaTemaListaWeb();
        try {
            ialtw.agregarTemaListaWeb(nick, listaAgregar, tema, albumSacar, listaSacar, usrSacar, artista);
        } catch (AlbumInexistenteException ex) {
            response.sendError(404);
        } catch (Exception ex) {
            response.sendError(404);
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
