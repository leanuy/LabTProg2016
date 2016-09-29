package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import espotify.Fabrica;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataClienteExt;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.interfaces.web.IVerPerfil;
import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;

/**
 *
 * @author JavierM42
 */
public class VerPerfil extends HttpServlet {

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
        response.setContentType("text/html;charset=UTF-8");
        String inputNick = new String(request.getParameter("nick").getBytes(
                "iso-8859-1"), "UTF-8");
        
        HttpSession session = request.getSession();
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && 
                inputNick.equals((String)session.getAttribute("nick_sesion"))){
            request.getRequestDispatcher("/MiPerfil").forward(request,response);
        } else {
            IVerPerfil iPerfil = Fabrica.getIVerPerfil();
            try {
                //obtener el tipo de usuario.
                boolean esCli = iPerfil.esCliente(inputNick);
                if (esCli) {
                    try {
                        DataClienteExt d = iPerfil.consultaCliente(inputNick);
                        request.setAttribute("nick", d.getNick());
/*                        if (d.getImg() == null) {
                            request.setAttribute("imagen", "./assets/img/profile.png");
                        } else {
                            request.setAttribute("imagen", d.getImg());
                        }*/
                        List<String> listas = iPerfil.listarListasPublicasDeCliente(inputNick);
                        request.setAttribute("listas", listas);

                        boolean soyCli = Boolean.valueOf(session.getAttribute("es_cliente").toString());
                        if(session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && soyCli  ) {
                            boolean siguiendo = iPerfil.siguiendo((String) session.getAttribute("nick_sesion"),inputNick);
                            request.setAttribute("siguiendo", siguiendo);
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/perfiles/PerfilCliente.jsp").forward(request,response);

                    } catch (ClienteInexistenteException e) {
                        response.sendError(404);
                        //problemas consultando el cliente
                    }
                } else { //es artista
                    try {
                        DataArtistaExt d = iPerfil.consultaArtista(inputNick);
                        request.setAttribute("nick",d.getNick());
                        request.setAttribute("nombre", d.getNombre());
                        request.setAttribute("apellido", d.getApellido());
                        request.setAttribute("correo", d.getCorreo());
                        request.setAttribute("fechaNac", d.getfNacStr());
                        if(d.getUrl().equals("")) {
                            request.setAttribute("url", "-");
                        } else {
                            request.setAttribute("url", d.getUrl());
                        }
                        if(d.getBio().equals("")) {
                            request.setAttribute("bio", "-");
                        } else {
                            request.setAttribute("bio", d.getBio());
                        }
                        if (d.getImg() == null) {
                            request.setAttribute("imagen", "./assets/img/artista.png");
                        } else {
                            request.setAttribute("imagen", d.getImg());
                        }
                        request.setAttribute("seguidores", d.getSeguidores());
                        
                        List<String> albums = iPerfil.listarAlbumesDeArtista(inputNick);
                        request.setAttribute("albums", albums);

                        boolean soyCli = Boolean.valueOf(session.getAttribute("es_cliente").toString());
                        if(session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && soyCli  ) {
                            boolean siguiendo = iPerfil.siguiendo((String) session.getAttribute("nick_sesion"),inputNick);
                            request.setAttribute("siguiendo", siguiendo);
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/perfiles/PerfilArtista.jsp").forward(request,response);
                    } catch (ArtistaInexistenteException e) {
                        response.sendError(404);
                    }
                }
            } catch (ClienteInexistenteException ex) {
                response.sendError(404);
                //el nick no existe en el sistema
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

}
