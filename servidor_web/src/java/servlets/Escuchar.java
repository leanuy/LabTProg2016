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
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
            int length = 0;
            stream = response.getOutputStream();
            buf = Fabrica.getIObtenerAudio().getAudio(artista,album,tema);
            int readBytes;
            while ((readBytes = buf.read()) != -1) {
                length++;
                stream.write(readBytes);
            }
            response.setContentLength(length);
            response.addHeader("Content-Range", "bytes 0-1"); 
          } catch (IOException ioe) {
            throw new ServletException(ioe.getMessage());
          } catch (ArtistaInexistenteException ex) {
              response.sendError(500);
          } catch (AlbumInexistenteException ex) {
              response.sendError(500);
          } catch (TemaTipoInvalidoException ex) {
              response.sendError(500);
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
