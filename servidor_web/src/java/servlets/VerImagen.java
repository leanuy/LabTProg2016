/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.interfaces.web.IObtenerImagen;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URL;
import javax.imageio.ImageIO;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;

/**
 *
 * @author Santiago
 */
@WebServlet(name = "TraerImagenes", urlPatterns = {"/TraerImagenes"})
public class VerImagen extends HttpServlet {

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
        response.setContentType("image/jpeg");
        HttpSession session = request.getSession();
        String tipo = new String(request.getParameter("tipo").getBytes(
            "iso-8859-1"), "UTF-8");
        String nomUsuario = new String(request.getParameter("nombreUsuario").getBytes(
            "iso-8859-1"), "UTF-8");
        String extra = new String(request.getParameter("extra").getBytes(
            "iso-8859-1"), "UTF-8");
        IObtenerImagen interfaz = Fabrica.getIImagen();
        BufferedImage img = null;
        URL url = null;
        ServletContext sc = session.getServletContext();
        try {
            if (tipo.equals("ImagenUsuario")) {
                img = interfaz.getImageUsuario(nomUsuario);
                if (img == null) {
                    boolean artista = interfaz.esArtista(nomUsuario);
                    if (artista){
                        url = sc.getResource("/assets/img/artista.png");
                    } else {
                        url = sc.getResource("/assets/img/profile.png");
                    }
                }
            }
            if (tipo.equals("ImagenAlbum")) {
                img = interfaz.getImageAlbum(nomUsuario, extra);
                if (img == null) {
                    url = new URL("/assets/img/default_cover.png");
                }
            }
            if (tipo.equals("ImagenListaDefecto")) {
                img = interfaz.getImageListaDefecto(extra);
                if (img == null) {
                    url = sc.getResource("/assets/img/default_cover.png");
                }
            }
            if (tipo.equals("ImagenListaParticular")) {
                img = interfaz.getImageListaParticular(nomUsuario, extra);
                if (img == null) {
                    url = sc.getResource("/assets/img/default_cover.png");
                }
            }
            if (img == null) {
                Image imag;
                imag = ImageIO.read(url);
                img = (BufferedImage) imag;
            }
            OutputStream out = response.getOutputStream();
            ImageIO.write(img, "png", out);
            out.close();

        } catch (UsuarioInexistenteException ex) {
            response.sendError(404);
        } catch (ArtistaInexistenteException ex) {
            response.sendError(404);
        } catch (AlbumInexistenteException ex) {
            response.sendError(404);
        } catch (ListaInexistenteException ex) {
            response.sendError(404);
        } catch (ClienteInexistenteException ex) {
            response.sendError(404);
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

    private String getExtension(File file) {
        String ext = null;
        String nomArchivo = file.getName();
        int idx = nomArchivo.lastIndexOf('.');
        if (idx > 0 &&  idx < nomArchivo.length() - 1) {
            ext = nomArchivo.substring(idx + 1).toLowerCase();
        }
        return ext;
    }
}