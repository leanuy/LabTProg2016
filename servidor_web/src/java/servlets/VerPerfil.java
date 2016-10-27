package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.ArtistaInexistenteException_Exception;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataArtistaExt;
import servidor.DataClienteExt;
import servidor.DataColeccionString;
import servidor.UsuarioInexistenteException_Exception;

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
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        HttpSession session = request.getSession();
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && 
                inputNick.equals((String)session.getAttribute("nick_sesion"))){
            request.getRequestDispatcher("/MiPerfil").forward(request,response);
        } else {
            try {
                //obtener el tipo de usuario.
                boolean esCli = port.esCliente(inputNick);
                if (esCli) {
                    try {
                        DataClienteExt d = port.consultaCliente(inputNick);
                        request.setAttribute("nick", d.getNick());
                        if (d.getImg() == null) {
                            request.setAttribute("imagen", "./assets/img/profile.png");
                        } else {
                            request.setAttribute("imagen", d.getImg());
                        }
                        DataColeccionString listas = port.listarListasPublicasDeCliente(inputNick);
                        request.setAttribute("listas", listas.getData());

                        if(session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && Boolean.valueOf(session.getAttribute("es_cliente").toString())  ) {
                            boolean siguiendo = port.siguiendo((String) session.getAttribute("nick_sesion"),inputNick);
                            request.setAttribute("siguiendo", siguiendo);
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/perfiles/PerfilCliente.jsp").forward(request,response);

                    } catch (ClienteInexistenteException_Exception ex) {
                        response.sendError(404);
                    }
                } else { //es artista
                    try {
                        DataArtistaExt d = port.consultaArtista(inputNick);
                        request.setAttribute("nick",d.getNick());
                        request.setAttribute("nombre", d.getNombre());
                        request.setAttribute("apellido", d.getApellido());
                        request.setAttribute("correo", d.getCorreo());
                        request.setAttribute("fechaNac", d.getFNacStr());
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
                        
                        DataColeccionString albums = port.listarAlbumesDeArtista(inputNick);
                        request.setAttribute("albums", albums.getData());

                        if(session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && Boolean.valueOf(session.getAttribute("es_cliente").toString())  ) {
                            boolean siguiendo = port.siguiendo((String) session.getAttribute("nick_sesion"),inputNick);
                            request.setAttribute("siguiendo", siguiendo);
                        }
                        
                        request.getRequestDispatcher("/WEB-INF/perfiles/PerfilArtista.jsp").forward(request,response);
                    } catch (ArtistaInexistenteException_Exception ex) {
                        response.sendError(404);
                    } catch (ClienteInexistenteException_Exception ex) {
                        response.sendError(404);
                    }
                }
            } catch (UsuarioInexistenteException_Exception ex) {
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

}
