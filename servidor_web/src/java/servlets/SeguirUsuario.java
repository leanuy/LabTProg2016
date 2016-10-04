/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.SeguidorInexistenteException;
import espotify.interfaces.web.ISuscripcionWeb;
import espotify.interfaces.web.IWebSeguir;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;

/**
 *
 * @author Santiago
 */
@WebServlet(name = "SeguirUsuario", urlPatterns = {"/SeguirUsuario"})
public class SeguirUsuario extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
            String Seguidor = (String) session.getAttribute("nick_sesion");
            String aSeguir = new String(request.getParameter("nick").getBytes(
                "iso-8859-1"), "UTF-8");
            ISuscripcionWeb isusc = Fabrica.getISuscripcionWeb();
            try {
                if (isusc.tieneSuscripcionVigente(Seguidor)) {
                    IWebSeguir iws = Fabrica.getIWebSeguir();
                    iws.altaSeguir(Seguidor, aSeguir);
                    request.getRequestDispatcher("/VerPerfil?nick="+aSeguir).forward(request, response);
                } else {
                    response.sendError(500);
                }
            } catch (SeguidorInexistenteException ex) {
                response.sendError(404);
            } catch (SeguidoInexistenteException ex) {
                response.sendError(404);
            } catch (SeguidoRepetidoException ex) {
                response.sendError(500);
            } catch (AutoSeguirseException ex) {
                response.sendError(500);
            } catch (ClienteInexistenteException ex) {
                response.sendError(500);
            }
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
