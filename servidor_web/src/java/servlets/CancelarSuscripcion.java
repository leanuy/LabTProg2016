package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servidor.ClienteInexistenteException_Exception;
import servidor.NoHaySuscripcionException_Exception;
import servidor.TransicionSuscripcionInvalidaException_Exception;

public class CancelarSuscripcion extends HttpServlet {

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
        String inputNick = new String(request.getParameter("cancelar").getBytes(
                "iso-8859-1"), "UTF-8");
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        try {
            port.cancelarSuscripcion(inputNick);
        } catch (ClienteInexistenteException_Exception ex) {  
            response.sendError(500);
        } catch (NoHaySuscripcionException_Exception ex) {
            response.sendError(500);
        } catch (TransicionSuscripcionInvalidaException_Exception ex) {
            response.sendError(500);
        }
        response.sendRedirect("/Suscripcion");
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
