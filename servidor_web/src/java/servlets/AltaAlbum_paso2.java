/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataAlbumExt;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.interfaces.web.IAltaAlbumWeb;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 *
 * @author agus
 */
public class AltaAlbum_paso2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     * @throws espotify.excepciones.ArtistaInexistenteException
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException, ArtistaInexistenteException {
        response.setContentType("text/html;charset=UTF-8");
        HttpSession session = request.getSession();
        String album = new String(request.getParameter("album").getBytes("iso-8859-1"), "UTF-8");

        IAltaAlbumWeb interf = Fabrica.getIAltaAlbumWeb();
        DataAlbumExt data = interf.getAlbumTemp((String) session.getAttribute("nick_sesion"), album);
        if (data != null) {
            request.setAttribute("album", data);
            request.getRequestDispatcher("/WEB-INF/albums/paso2.jsp").forward(request, response);
        }

    }

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
            response.sendError(500);
        }

        
        
        request.setAttribute("album", new String(request.getParameter("album").getBytes("iso-8859-1"), "UTF-8"));
        request.getRequestDispatcher("/WEB-INF/albums/AltaAlbum/paso2.jsp").forward(request, response);
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
