/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.web.IAltaAlbumWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author agustina
 */
public class AltaAlbum_paso3 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws espotify.excepciones.ArtistaInexistenteException
     * @throws espotify.excepciones.AlbumRepetidoException
     * @throws espotify.excepciones.GeneroInexistenteException
     * @throws espotify.excepciones.DuracionInvalidaException
     * @throws espotify.excepciones.NumeroTemaInvalidoException
     * @throws espotify.excepciones.TemaRepetidoException
     * @throws espotify.excepciones.CampoVacioException
     * @throws espotify.excepciones.TemaTipoInvalidoException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();

        IAltaAlbumWeb inter = Fabrica.getIAltaAlbumWeb();
        String artista = (String) session.getAttribute("nick_sesion");
        inter.aceptarAltaAlbum(artista);
        PrintWriter out = response.getWriter();
        out.print(artista);
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
        } catch (ArtistaInexistenteException ex) {
            response.sendError(500, "artista inexistente.");
        } catch (AlbumRepetidoException ex) {
            response.sendError(500, "album repetido.");
        } catch (GeneroInexistenteException ex) {
            response.sendError(500, "genero inexistente.");
        } catch (DuracionInvalidaException ex) {
            response.sendError(500, "duracion invalida.");
        } catch (NumeroTemaInvalidoException ex) {
            response.sendError(500, "numero tema invalido.");
        } catch (TemaRepetidoException ex) {
            response.sendError(500, "tema repetido.");
        } catch (CampoVacioException ex) {
            response.sendError(500, "campo vacio.");
        } catch (TemaTipoInvalidoException ex) {
            response.sendError(500, "tema tipo invalido.");
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
        } catch (ArtistaInexistenteException ex) {
            response.sendError(500, "artista inexistente.");
        } catch (AlbumRepetidoException ex) {
            response.sendError(500, "album repetido.");
        } catch (GeneroInexistenteException ex) {
            response.sendError(500, "genero inexistente.");
        } catch (DuracionInvalidaException ex) {
            response.sendError(500, "duracion invalida.");
        } catch (NumeroTemaInvalidoException ex) {
            response.sendError(500, "numero tema invalido.");
        } catch (TemaRepetidoException ex) {
            response.sendError(500, "tema repetido.");
        } catch (CampoVacioException ex) {
            response.sendError(500, "campo vacio.");
        } catch (TemaTipoInvalidoException ex) {
            response.sendError(500, "tema tipo invalido.");
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
