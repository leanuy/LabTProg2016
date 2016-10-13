/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataArtista;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataParticular;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.NickRepetidoException;
import espotify.interfaces.IAltaPerfil;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;

/**
 *
 * @author JavierM42
 */
@MultipartConfig
public class Registrarme extends HttpServlet {



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
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/perfiles/AltaPerfil.jsp").forward(request,response);
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
        
        String login = request.getParameter("login");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Calendar fechaNac = Calendar.getInstance(); //TODO
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        
        BufferedImage img = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            Part part = request.getPart("imagen");
            InputStream is = part.getInputStream();
            img = ImageIO.read(is);
        }
        
        String tipo = request.getParameter("tipo");
        if(tipo.equals("cliente")) {
            IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
            
            try {
                fechaNac.setTime(sdf.parse(request.getParameter("fechaNac")));
                DataCliente dataCli = new DataCliente(login,nombre,apellido,correo,fechaNac,img,password);
                iPerfil.altaCliente(dataCli);
                request.getRequestDispatcher("/iniciar-sesion").forward(request,response);
            } catch (NickRepetidoException ex) {
                response.sendError(500);
            } catch (CorreoRepetidoException ex) {
                response.sendError(500);
            } catch (FormatoIncorrectoException ex) {
                response.sendError(500);
            } catch (ParseException ex) {
                    response.sendError(500);
            }
        } else if (tipo.equals("artista")) {
            String url = request.getParameter("url");
            String bio = request.getParameter("bio");
            IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
            
            try {
                fechaNac.setTime(sdf.parse(request.getParameter("fechaNac")));
                DataArtista dataArt = new DataArtista(bio,url,login,nombre,apellido,correo,fechaNac,img,password);
                iPerfil.altaArtista(dataArt);
                request.getRequestDispatcher("/iniciar-sesion").forward(request,response);
            } catch (NickRepetidoException ex) {
                response.sendError(500);
            } catch (CorreoRepetidoException ex) {
                response.sendError(500);
            } catch (FormatoIncorrectoException ex) {
                response.sendError(500);
            } catch (ParseException ex) {
                response.sendError(500);
            }
        } else {
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
