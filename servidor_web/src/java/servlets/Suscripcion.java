/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.DataSuscripcionVigente;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.ClienteInexistenteException;
import espotify.interfaces.web.ISuscripcionWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import espotify.interfaces.web.ISuscripcionWeb;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;

/**
 *
 * @author leandro
 */
public class Suscripcion extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequestGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
            
            
            String nick = (String) session.getAttribute("nick_sesion");
            ISuscripcionWeb inter = Fabrica.getSuscripcionWeb();
            List<DataSuscripcion> historial = null;
            try {
                historial = inter.listarSuscripcionesCliente(nick);
            } catch (ClienteInexistenteException ex) {
                response.sendError(500);
            }
            if (historial == null) {
                request.setAttribute("historial", null);
            } else {
                request.setAttribute("historial", historial);
            }
            DataSuscripcionVigente vigente = null;
            try {
                vigente = inter.obtenerSuscripcionVigente(nick);
            } catch (ClienteInexistenteException ex) {
                response.sendError(500);
            }
            if (vigente == null) {
                request.setAttribute("vigente", null);
            } else {
                request.setAttribute("vigente", vigente);
            }
        } else {
            request.getRequestDispatcher("/inicio").forward(request, response);
        }
        request.getRequestDispatcher("/WEB-INF/suscripciones/Suscripciones.jsp").forward(request,response);
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
        processRequestGet(request, response);
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
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String nick = (String) session.getAttribute("nick_sesion");
        String tipo = request.getParameter("tipo");
        ISuscripcionWeb inter = Fabrica.getSuscripcionWeb();
        boolean contratacionExitosa = false;
        try {
            contratacionExitosa = inter.contratarSuscripcion(devolverTipoSuscripcion(tipo), nick);
        } catch (ClienteInexistenteException ex) {
            response.sendError(500);
        }        
    }
    private TipoSuscripcion devolverTipoSuscripcion(String tip) {
        TipoSuscripcion tipo;
        if ( tip.equals("semanal") ){
            tipo = TipoSuscripcion.SEMANAL;
        } else {
            if ( tip.equals("mensual") ){
                tipo = TipoSuscripcion.MENSUAL;
            } else {
                if ( tip.equals("anual") ){
                    tipo = TipoSuscripcion.ANUAL;
                } else {
                    tipo = null;
                }
            }
        }
        return tipo;
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
