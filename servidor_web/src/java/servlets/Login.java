/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package servlets;

import exceptions.UsuarioNoEncontrado;
import model.EstadoSesion;
import espotify.Fabrica;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataClienteExt;
import espotify.interfaces.IIniciarSesion;
import espotify.datatypes.DataUsuario;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.interfaces.IAltaPerfil;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author Igui
 */
public class Login extends HttpServlet {
   
    /** 
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code> methods.
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException, UsuarioInexistenteException {
        HttpSession objSesion = request.getSession();
        String login = request.getParameter("login");
        String password = request.getParameter("password");
        EstadoSesion nuevoEstado;
		// chequea contraseña
		try {
                        IIniciarSesion iIniciarSesion = Fabrica.getIIniciarSesion();
                        DataUsuario dataUsr = iIniciarSesion.BuscarUsuario(login);
                        String psw = dataUsr.getPassword();
			if(iIniciarSesion.checkPassword(login, password)) {
                            nuevoEstado = EstadoSesion.LOGIN_CORRECTO;
                            // setea el usuario logueado
                            objSesion.setAttribute("usuario_logueado", dataUsr.getCorreo());
                            objSesion.setAttribute("nick_sesion", login);
                            boolean esCliente = dataUsr instanceof DataClienteExt;
                            objSesion.setAttribute("es_cliente",esCliente);
                        } else nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		} catch(UsuarioInexistenteException ex){
			nuevoEstado = EstadoSesion.LOGIN_INCORRECTO;
		}
		
        objSesion.setAttribute("estado_sesion", nuevoEstado);
		
        // redirige a la página principal para que luego rediriga a la página
        // que corresponde
        request.getRequestDispatcher("/inicio").forward(request, response);
    } 
	
	/**
	 * Devuelve el usuario logueado
	 * @param request
	 * @return
	 * @throws UsuarioNoEncontrado 
	 */
	static public DataUsuario getUsuarioLogueado(HttpServletRequest request)
			throws UsuarioNoEncontrado, UsuarioInexistenteException
	{
            IIniciarSesion iIniciarSesion = Fabrica.getIIniciarSesion();
            DataUsuario dataUsr = iIniciarSesion.BuscarUsuario((String) request.getSession().getAttribute("usuario_logueado"));
		return dataUsr;
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
        try {
            processRequest(request, response);
        } catch (UsuarioInexistenteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (UsuarioInexistenteException ex) {
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
