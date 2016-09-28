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
import espotify.interfaces.IObtenerImagen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import javax.imageio.ImageIO;
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
public class TraerImagenes extends HttpServlet {

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
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
            String tipo = (String) session.getAttribute("tipo");
            String nomUsuario = (String) session.getAttribute("nombreUsuario");
            String extra = (String) session.getAttribute("extra");
            IObtenerImagen interfaz = Fabrica.getIImagen();
            File file = null;
            try {
                if (tipo.equals("ImagenUsuario")) {
                    file = interfaz.getImageUsuario(nomUsuario);
                    if (file == null) {
                        file = new File("./assets/img/profile.png");
                    }
                }
                if (tipo.equals("ImagenAlbum")) {
                    file = interfaz.getImageAlbum(nomUsuario, extra);
                    if (file == null) {
                        file = new File("./assets/img/default_cover.png");
                    }
                }
                if (tipo.equals("ImagenListaDefecto")) {
                    file = interfaz.getImageListaDefecto(extra);
                    if (file == null) {
                        file = new File("./assets/img/default_cover.png");
                    }
                }
                if (tipo.equals("ImagenListaParticular")) {
                    file = interfaz.getImageListaParticular(nomUsuario, extra);
                    if (file == null) {
                        file = new File("./assets/img/default_cover.png");
                    }
                }
                BufferedImage bi = ImageIO.read(file);
                String ext = getExtension(file);
		OutputStream out = response.getOutputStream();
                if (ext.equals("jpg")) {
                    ImageIO.write(bi, "jpg", out);
                } else {
                    ImageIO.write(bi, "png", out);
                }
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