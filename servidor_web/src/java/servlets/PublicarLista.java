/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.YaPublicaException;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IPublicarLista;
import espotify.interfaces.web.ISuscripcionWeb;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
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
public class PublicarLista extends HttpServlet {

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
        HttpSession session = request.getSession();
        String lista = new String(request.getParameter("lista").getBytes(
                "iso-8859-1"), "UTF-8");
        String nick = (String) session.getAttribute("nick_sesion");
        try {
            ISuscripcionWeb isusc = Fabrica.getISuscripcionWeb();
            if (isusc.tieneSuscripcionVigente(nick)) {
                IPublicarLista ipl = Fabrica.getIPublicarLista();
                ipl.publicarLista(lista, nick);
                response.sendRedirect("/VerListaParticular?nick="+nick+"&lista=" + request.getParameter("lista"));
            } else {
                response.sendError(500);
            }
        } catch (ClienteInexistenteException e) {
            response.sendError(500, "cliente inexistente");
        } catch (ListaInexistenteException e) {
            response.sendError(500, "lista inexistente ");
        } catch (YaPublicaException e) {
            response.sendError(500, "lista ya publicada");
        } catch (IOException e) {
            response.sendError(500);
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

        HttpSession session = request.getSession();


        String nombre = new String(request.getParameter("nombre").getBytes(
                "iso-8859-1"), "UTF-8");

        try {
            if (!nombre.equals("")) {
                IAltaLista ial = Fabrica.getIAltaLista();
                DataParticular dataParticular;
                
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if (isMultipart){
                    Part part = request.getPart("imagen");
                    InputStream is = part.getInputStream();
                    BufferedImage img = ImageIO.read(is);
                    dataParticular = new DataParticular((String) session.getAttribute("nick_sesion"), nombre, img);
                }else{
                    dataParticular = new DataParticular((String) session.getAttribute("nick_sesion"), nombre, null);
                }
                
                ial.altaListaParticular(dataParticular);
                request.getRequestDispatcher("/VerListaParticular?nick="+session.getAttribute("nick_sesion")+"&lista="+nombre).forward(request, response);
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
