/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataSuscripcion;
import servidor.EstadoSuscripcion;
import servidor.NoHaySuscripcionException_Exception;
import servidor.TipoSuscripcion;

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
            request.setAttribute("nick_sesion", nick);
            servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();        
            try {
                List<DataSuscripcion> historial = port.listarSuscripcionesCliente(nick).getData();
                request.setAttribute("historial", historial);
            } catch (ClienteInexistenteException_Exception ex) {
                response.sendError(500);
            }
            DataSuscripcion actual = null;
            String fVencimiento = "";
            try {
                actual = port.obtenerSuscripcionActual(nick);
            } catch (ClienteInexistenteException_Exception ex) {
                response.sendError(500);
            } catch (NoHaySuscripcionException_Exception ex) {
                actual = null;
            }
            if ( request.getAttribute("suscvigente") != null ) {
                request.setAttribute("suscvigente", null);
            }
            if ( request.getAttribute("vencida") != null ) {
                request.setAttribute("vencida", null);
            }
            if ( request.getAttribute("pendiente") != null ) {
                request.setAttribute("pendiente", null);
            }
            if ( request.getAttribute("vigente") != null ) {
                request.setAttribute("vigente", null);
            }
            if ( request.getAttribute("cancelada") != null ) {
                request.setAttribute("cancelada", null);
            }
            if (actual == null) {
                request.setAttribute("suscvigente", null);
            } else {
                if ( actual.getEstado() == EstadoSuscripcion.VENCIDA ) {
                    request.setAttribute("vencida", true);
                }
                if ( actual.getEstado() == EstadoSuscripcion.PENDIENTE ) {
                    request.setAttribute("pendiente", true);
                }
                if ( actual.getEstado() == EstadoSuscripcion.VIGENTE ) {
                    request.setAttribute("vigente", true);
                    try {
                        fVencimiento = port.consultaFechaVencimientoSuscripcionVigente(nick);
                    } catch (ClienteInexistenteException_Exception ex) {
                        // nada, si llego hasta aca el pibe existe...
                    }
                    request.setAttribute("fVencimiento", fVencimiento);
                    
                }
                if ( actual.getEstado() == EstadoSuscripcion.CANCELADA ) {
                    request.setAttribute("cancelada", true);
                }
                request.setAttribute("suscvigente", actual);
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
        String tipo = (String)request.getParameter("tipo");
        servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();        
            boolean contratacionExitosa = false;
        try {
            contratacionExitosa = port.contratarSuscripcion(devolverTipoSuscripcion(tipo), nick);
            response.sendRedirect("/Suscripcion");
        } catch (ClienteInexistenteException_Exception ex) {
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
