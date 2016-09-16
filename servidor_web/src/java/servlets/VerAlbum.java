/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataClienteExt;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.interfaces.web.IVerAlbum;
import espotify.interfaces.web.IVerPerfil;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavierM42
 */
public class VerAlbum extends HttpServlet {

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
        
        String inputNick = request.getParameter("nick");
        String inputNom = request.getParameter("album");

        IVerAlbum interf = Fabrica.getIVerAlbum();
        try {
            DataAlbumExt data = interf.consultaAlbum(inputNom,inputNick);
            request.setAttribute("nomAlbum", data.getNombre());
            if(data.getImg() == null) {
            request.setAttribute("imagen", "./assets/img/default_cover.png");
            } else {
            request.setAttribute("imagen", data.getImg());
            }
            request.setAttribute("nomArtista", data.getNickArtista());
            request.setAttribute("anio", data.getAnio());
            request.setAttribute("generos", data.getGeneros());
            request.setAttribute("temas", data.getTemas());

            request.getRequestDispatcher("/WEB-INF/albums/Album.jsp").forward(request,response);
            
            
        } catch (ArtistaInexistenteException ex) {
            response.sendError(404);
            //el nick no es un artista
        } catch (AlbumInexistenteException ex) {
            response.sendError(404);
            //el album no existe del artista
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
