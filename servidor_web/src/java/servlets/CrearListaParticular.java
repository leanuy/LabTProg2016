/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataParticular;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.web.ISuscripcionWeb;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
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
@MultipartConfig
public class CrearListaParticular extends HttpServlet {

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
        HttpSession session = request.getSession();
        ISuscripcionWeb isusc = Fabrica.getISuscripcionWeb();
        String usuario = (String) session.getAttribute("nick_sesion");
        try {
            if (isusc.tieneSuscripcionVigente(usuario)) {
                request.getRequestDispatcher("/WEB-INF/listas/CrearListaParticular.jsp").forward(request, response);
            } else {
                response.sendError(500);
            }
        } catch (ClienteInexistenteException ex) {
            Logger.getLogger(CrearListaParticular.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        ISuscripcionWeb isusc = Fabrica.getISuscripcionWeb();
        String usuario = (String) session.getAttribute("nick_sesion");

        String nombre = new String(request.getParameter("nombre").getBytes(
                "iso-8859-1"), "UTF-8");
        try {
            if (isusc.tieneSuscripcionVigente(usuario)) {
                try {
                    if (!nombre.equals("")) {
                        IAltaLista ial = Fabrica.getIAltaLista();
                        DataParticular dataParticular;

                        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                        if (isMultipart) {
                            Part part = request.getPart("imagen");
                            InputStream is = part.getInputStream();
                            BufferedImage img = ImageIO.read(is);
                            dataParticular = new DataParticular((String) session.getAttribute("nick_sesion"), nombre, img);
                        } else {
                            dataParticular = new DataParticular((String) session.getAttribute("nick_sesion"), nombre, null);
                        }

                        ial.altaListaParticular(dataParticular);
                        request.getRequestDispatcher("/VerListaParticular?nick=" + session.getAttribute("nick_sesion") + "&lista=" + nombre).forward(request, response);
                    } else {
                        request.setAttribute("has_errors", true);
                        request.setAttribute("error_nombre", "El nombre de la lista es requerido");
                        request.getRequestDispatcher("/WEB-INF/listas/CrearListaParticular.jsp").forward(request, response);
                    }
                } catch (ListaRepetidaException e) {
                    request.setAttribute("has_errors", true);
                    request.setAttribute("error_nombre", "Usted ya tiene una lista con ese nombre");
                    request.getRequestDispatcher("/WEB-INF/listas/CrearListaParticular.jsp").forward(request, response);
                } catch (ClienteInexistenteException e) {
                    response.sendError(404);
                } catch (CampoVacioException ex) {
                    Logger.getLogger(CrearListaParticular.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                response.sendError(500);
            }
        } catch (ClienteInexistenteException ex) {
            Logger.getLogger(CrearListaParticular.class.getName()).log(Level.SEVERE, null, ex);
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
