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
import espotify.interfaces.web.IListarArtistas;
import espotify.interfaces.web.IListarGeneros;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
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
        try {
            processRequest(request, response);
        } catch (ArtistaInexistenteException ex) {
            response.sendError(500);
        }
        IAltaAlbumWeb inter = Fabrica.getIAltaAlbumWeb();
        boolean has_errors = false;
        HttpSession session = request.getSession();
        try {
            DataAlbumExt album = inter.getAlbumTemp((String) session.getAttribute("nick_sesion"), new String(request.getParameter("album").getBytes("iso-8859-1"), "UTF-8"));

            String orden_str = request.getParameter("orden");
            int orden;
            String nombre = new String(request.getParameter("nombre").getBytes("iso-8859-1"), "UTF-8");
            String duracion_str = request.getParameter("duracion");
            String duracion_str_aux = request.getParameter("duracion_str");
            String tipo = request.getParameter("tipo");
            String url;
            BufferedInputStream archivo;
            if (tipo.equals("web")) {
                url = request.getParameter("url");
                if (url.equals("")) {
                    request.setAttribute("error_url", "La url es requerida para temas web.");
                    has_errors = true;
                }               
            } else if(tipo.equals("archivo")){
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if (isMultipart) {
                    Part part = request.getPart("imagen");
                    InputStream is = part.getInputStream();
                    archivo = new BufferedInputStream(is);
                }else{
                    request.setAttribute("error_archivo", "El archivo es requerido para temas de archivo.");
                    has_errors = true;
                }
            }else{
                request.setAttribute("error_tipo", "No has ingresado una fuente para el tema, seleciona un tipo y completa el dato.");
                has_errors = true;
            }
            if (nombre.equals("")) {
                request.setAttribute("error_nombre", "El nombre del tema es requerido.");
                has_errors = true;
            } else if (album.tieneTema(nombre)) {
                request.setAttribute("error_nombre", "No puedes ingresar dos temas con el mismo nombre.");
                has_errors = true;
            }
            if (orden_str.equals("")) {
                request.setAttribute("error_orden", "El orden del tema es requerido.");
                has_errors = true;
            }else{
                orden = Integer.parseInt(orden_str);
                if (orden < 0) {
                    request.setAttribute("error_orden", "El orden del tema debe ser positivo");
                    has_errors = true;
                }
            }
            if (duracion_str.equals("")) {
                request.setAttribute("error_duracion", "La duración del tema es requerida.");
                has_errors = true;
            }else{
                orden = Integer.parseInt(orden_str);
                if (orden < 0) {
                    request.setAttribute("error_duracion", "La duración del tema debe ser positivo");
                    has_errors = true;
                }
            }

            if (has_errors) {
                request.setAttribute("has_errors", true);
            }else{
                String json = "{"
                        + "'orden':'"+orden_str+"'"
                        + "'nombre':'"+nombre+"'"
                        + "'duracion':'"+duracion_str_aux+"'"
                        + "'tipo':'"+tipo+"'"
                        + "}"; 
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().print("{success: true}");
                response.getWriter().write(json);
            }
        } catch (ArtistaInexistenteException ex) {
            Logger.getLogger(AltaAlbum_paso2.class.getName()).log(Level.SEVERE, null, ex);
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
