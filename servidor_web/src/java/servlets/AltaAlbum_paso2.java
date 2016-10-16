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
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
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
@WebServlet
@MultipartConfig
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
        request.setAttribute("album", request.getParameter("album"));
        request.getRequestDispatcher("/WEB-INF/albums/paso2.jsp").forward(request, response);
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
        PrintWriter out = response.getWriter();
        
        IAltaAlbumWeb inter = Fabrica.getIAltaAlbumWeb();
        boolean has_errors = false;
        HttpSession session = request.getSession();
        try {
            String artista = (String) session.getAttribute("nick_sesion");
            Part part;
            Scanner s;
                        
            DataAlbumExt album = inter.getAlbumTemp(artista);
            
            part = request.getPart("orden");
            s = new Scanner(part.getInputStream());
            int orden = Integer.parseInt(s.nextLine());
            
            part = request.getPart("nombre");
            s = new Scanner(part.getInputStream());
            String nombre = s.nextLine();
            
            part = request.getPart("duracion");
            s = new Scanner(part.getInputStream());
            int duracion = Integer.parseInt(s.nextLine());

            part = request.getPart("tipo");
            s = new Scanner(part.getInputStream());
            String tipo = s.nextLine();
            if (tipo.equals("web")) {
                part = request.getPart("url");
                s = new Scanner(part.getInputStream());
                String url = s.nextLine();

                DataTemaWeb temaWeb = new DataTemaWeb(url, nombre, duracion, orden, artista, album.getNombre());
                inter.addTemaAlbumTemp(artista, temaWeb);
                out.print("true");
            } else if(tipo.equals("archivo")){
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if (isMultipart) {
                    part = request.getPart("archivo");
                    InputStream is = part.getInputStream();
                    BufferedInputStream archivo = new BufferedInputStream(is);
                    DataTemaArchivo temaArchivo = new DataTemaArchivo(archivo, nombre, duracion, orden, artista, album.getNombre());
                    inter.addTemaAlbumTemp(artista, temaArchivo);
                    out.print("true");
                }
            }
   
        }catch(ArtistaInexistenteException ex){
            out.print("false");
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
