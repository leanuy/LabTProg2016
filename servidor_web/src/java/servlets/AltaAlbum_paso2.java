/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataTemaArchivo;
import espotify.datatypes.DataTemaWeb;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.interfaces.web.IAltaAlbumWeb;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import static java.lang.System.out;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author agus
 */
public class AltaAlbum_paso2 extends HttpServlet {
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
        
        IAltaAlbumWeb inter = Fabrica.getIAltaAlbumWeb();
        boolean has_errors = false;
        HttpSession session = request.getSession();
        try {
            String artista = (String) session.getAttribute("nick_sesion");
            DataAlbumExt album = inter.getAlbumTemp( artista, new String(request.getParameter("album").getBytes("iso-8859-1"), "UTF-8"));

            int orden = Integer.parseInt(request.getParameter("orden"));
            String nombre = new String(request.getParameter("nombre").getBytes("iso-8859-1"), "UTF-8");
            int duracion = Integer.parseInt(request.getParameter("duracion"));
            String tipo = request.getParameter("tipo");
            String url;
            BufferedInputStream archivo;
            if (tipo.equals("web")) {
                url = request.getParameter("url");
                DataTemaWeb temaWeb = new DataTemaWeb(url, nombre, duracion, orden, artista, album.getNombre());
                album.addTema(temaWeb);
            } else if(tipo.equals("archivo")){
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if (isMultipart) {
                    Part part = request.getPart("imagen");
                    InputStream is = part.getInputStream();
                    archivo = new BufferedInputStream(is);
                    DataTemaArchivo temaArchivo = new DataTemaArchivo(archivo, nombre, duracion, orden, artista, album.getNombre());
                    album.addTema(temaArchivo);
                }
            }
            //Check si quedo agregado
            if (album.tieneTema(nombre)) {
                out.print("false");
            } else {
                out.print("true");
            }
        }catch(ArtistaInexistenteException ex){
            response.sendError(500);
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
