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
import espotify.interfaces.web.IListarGeneros;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
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
public class AltaAlbum_paso1 extends HttpServlet {
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
        IListarGeneros interf = Fabrica.getIListarGeneros();
        Map<String, String> data = interf.stringifyDataGeneros();
                
        request.setAttribute("generos", data);
        request.getRequestDispatcher("/WEB-INF/albums/paso1.jsp").forward(request, response);
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
        HttpSession session = request.getSession();
        String nombre = new String(request.getParameter("nombre").getBytes("iso-8859-1"), "UTF-8");
        int anio = Integer.parseInt(request.getParameter("anio"));
        String[] generos_arr = request.getParameterValues("generos");
        
        List<String> generos = new ArrayList<String>();
        
        for (String genero : generos_arr) {
            generos.add(new String(genero.getBytes("iso-8859-1"), "UTF-8"));
        }
        if(nombre.equals("")){
            request.setAttribute("has_errors", true);
            request.setAttribute("error_nombre", "El nombre del álbum es requerido");
            request.getRequestDispatcher("/AltaAlbum/paso1").forward(request, response);
//            request.getRequestDispatcher("/WEB-INF/albums/AltaAlbum/paso1.jsp").forward(request, response);
        }
        
            IAltaAlbumWeb inter = Fabrica.getIAltaAlbumWeb();
            DataAlbumExt data;
            
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            if (isMultipart) {
                Part part = request.getPart("imagen");
                InputStream is = part.getInputStream();
                BufferedImage img = ImageIO.read(is);
                data = new DataAlbumExt(nombre, anio, generos, img, (String) session.getAttribute("nick_sesion"));
            } else {
                data = new DataAlbumExt(nombre, anio, generos, null, (String) session.getAttribute("nick_sesion"));
            }
            
            try {
                inter.addAlbumTemp(data);
            } catch (ArtistaInexistenteException ex) {
                Logger.getLogger(AltaAlbum_paso1.class.getName()).log(Level.SEVERE, null, ex);
            }
        response.sendRedirect("/AltaAlbum/paso2?album="+nombre);
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
