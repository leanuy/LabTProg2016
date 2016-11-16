/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servidor.ClienteInexistenteException_Exception;
import servidor.ListaInexistenteException_Exception;
import servidor.YaPublicaException_Exception;

/**
 *
 * @author agus
 */
public class PublicarLista extends HttpServlet {

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
        HttpSession session = request.getSession();
        String lista = new String(request.getParameter("lista").getBytes(
                "iso-8859-1"), "UTF-8");
        String nick = (String) session.getAttribute("nick_sesion");
        try {
            servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();
            if (port.tieneSuscripcionVigente(nick)) {
                port.publicarLista(lista, nick);
                response.sendRedirect("/VerListaParticular?nick="+nick+"&lista=" + request.getParameter("lista"));
            } else {
                response.sendError(500);
            }
        } catch (IOException e) {
            response.sendError(500);
        } catch (ClienteInexistenteException_Exception ex) {
            response.sendError(500, "cliente inexistente");
        } catch (ListaInexistenteException_Exception ex) {
            response.sendError(500, "lista inexistente ");
        } catch (YaPublicaException_Exception ex) {
            response.sendError(500, "lista ya publicada");
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
        processRequest(request,response);
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
