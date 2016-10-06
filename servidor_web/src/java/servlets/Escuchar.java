/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;
import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author JavierM42
 */
public class Escuchar extends HttpServlet {

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
        String tema = new String(request.getParameter("tema").getBytes(
            "iso-8859-1"), "UTF-8");
        String album = new String(request.getParameter("album").getBytes(
            "iso-8859-1"), "UTF-8");
        String artista = new String(request.getParameter("artista").getBytes(
            "iso-8859-1"), "UTF-8");
        
        ServletOutputStream stream = null;
        BufferedInputStream buf = null;
        try {
            stream = response.getOutputStream();
            HttpSession session = request.getSession();
            ServletContext sc = session.getServletContext();

            URL mp3 = sc.getResource("/assets/audio/RoundtableRival.mp3");
            Fabrica.getIObtenerAudio().getAudio(artista,album,tema);

            //set response headers
            response.setContentType("audio/mpeg");

            response.addHeader("Content-Disposition", "attachment; filename=" + artista+" - "+album+" - "+tema);

            InputStream input = mp3.openStream();
            buf = new BufferedInputStream(input);
            int readBytes;
            int length = 0;
            //read from the file; write to the ServletOutputStream
            while ((readBytes = buf.read()) != -1) {
                length++;
                stream.write(readBytes);
            }
            response.setContentLength(length);
          } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
          } catch (ArtistaInexistenteException ex) {
              Logger.getLogger(Escuchar.class.getName()).log(Level.SEVERE, null, ex);
          } catch (AlbumInexistenteException ex) {
              Logger.getLogger(Escuchar.class.getName()).log(Level.SEVERE, null, ex);
          } catch (TemaTipoInvalidoException ex) {
              Logger.getLogger(Escuchar.class.getName()).log(Level.SEVERE, null, ex);
          } finally {
          if (stream != null)
            stream.close();
          if (buf != null)
            buf.close();
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
