/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataCliente;
import servidor.DataUsuario;
import servidor.UsuarioInexistenteException_Exception;

/**
 *
 * @author DJA
 */
@WebServlet(name = "LoginMobile", urlPatterns = {"/login_mobile"})
public class LoginMobile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
   protected void processRequest(HttpServletRequest request,
        HttpServletResponse response) throws ServletException, IOException {
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;
		// chequea contraseña
		try {
                        servidor.PublicadorService service =  new servidor.PublicadorService();
                        servidor.Publicador port = service.getPublicadorPort();
                        DataUsuario dataUsr = port.buscarUsuario(login);
                        boolean password_correcto = port.checkPassword(dataUsr.getNick(), password);
                        boolean esCliente = dataUsr instanceof DataCliente;
			if(password_correcto && esCliente) {
                            nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
                            // setea el usuario logueado
                            objSesion.setAttribute("usuario_logueado", dataUsr.getCorreo());
                            objSesion.setAttribute("nick_sesion", dataUsr.getNick());
                            objSesion.setAttribute("es_cliente",esCliente);
                            try {
                                objSesion.setAttribute("tiene_suscripcion",port.tieneSuscripcionVigente(dataUsr.getNick()));
                            } catch (ClienteInexistenteException_Exception ex) {
                                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
                            }
                        } else
                            nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		} catch(UsuarioInexistenteException_Exception ex){
                    nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		}
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
        // redirige a la página principal para que luego redirija a la página
        // que corresponde
        request.getRequestDispatcher("/ArtistasMobile").forward(request, response);
    }

     /** 
     * Handles the HTTP <code>GET</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
        processRequest(request, response);
    }

    /** 
     * Handles the HTTP <code>POST</code> method.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
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
