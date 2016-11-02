/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.AlbumInexistenteException_Exception;
import servidor.ArtistaInexistenteException_Exception;
import servidor.ClienteInexistenteException_Exception;
import servidor.ListaInexistenteException_Exception;
import servidor.TemaRepetidoException_Exception;

/**
 *
 * @author santiagoserantes
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
        HttpSession session = request.getSession();
        String nick_sesion = new String(request.getParameter("nick").getBytes(
                "iso-8859-1"), "UTF-8");
        String lista_poner = new String(request.getParameter("lista").getBytes(
                "iso-8859-1"), "UTF-8");
        String nom_tema = new String(request.getParameter("nom_tema").getBytes(
                "iso-8859-1"), "UTF-8");
        String album = new String(request.getParameter("album").getBytes(
            "iso-8859-1"), "UTF-8");
        String artista = new String(request.getParameter("artista").getBytes(
            "iso-8859-1"), "UTF-8");
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        try {
            if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
                port.agregarTemaWebxAlbum(nick_sesion, lista_poner, nom_tema, album, artista);
            }
        } catch (AlbumInexistenteException_Exception ex) {
            response.sendError(404);
        } catch (ArtistaInexistenteException_Exception ex) {
            response.sendError(404);
        } catch (ClienteInexistenteException_Exception ex) {
            response.sendError(404);
        } catch (ListaInexistenteException_Exception ex) {
            response.sendError(404);
        } catch (TemaRepetidoException_Exception ex) {
            response.sendError(500);
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