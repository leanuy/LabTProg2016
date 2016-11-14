/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;

/**
 *
 * @author DJA
 */
@WebServlet(name = "HomeMobile", urlPatterns = {"/HomeMobile"})
public class HomeMobile extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    public static void initSession(HttpServletRequest request) {
        HttpSession session = request.getSession();
        if (session.getAttribute("paginas_navegadas") == null) {
                session.setAttribute("paginas_navegadas", 0);
        }
        if (session.getAttribute("estado_sesion") == null) {
                session.setAttribute("estado_sesion", EstadoSesion.NO_LOGIN);
                session.setAttribute("nick_sesion", null);
        }
    }

    /**
     * Devuelve el estado de la sesión
     * @param request
     * @return 
     */
    public static EstadoSesion getEstado(HttpServletRequest request)
    {
            return (EstadoSesion) request.getSession().getAttribute("estado_sesion");
    }

    private void processRequest(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {
        initSession(req);

        switch(getEstado(req)) {
          case NO_LOGIN:
                // hace que se ejecute el jsp sin cambiar la url
              req.getRequestDispatcher("/WEB-INF/auth/loginMobile.jsp").
                                forward(req, resp);
                break;
          case LOGIN_INCORRECTO:
                // hace que se ejecute el jsp sin cambiar la url
                req.getRequestDispatcher("/WEB-INF/auth/loginErroneoMobile.jsp").
                                forward(req, resp);
                break;
            case LOGIN_CORRECTO:
                // manda una redirección a otra URL (cambia la URL)
                resp.sendRedirect("/VerPerfil?nick="+req.getSession().getAttribute("nick_sesion"));
                break;
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
                            throws ServletException, IOException {
            processRequest(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
                    throws ServletException, IOException {
            processRequest(req, resp);
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
