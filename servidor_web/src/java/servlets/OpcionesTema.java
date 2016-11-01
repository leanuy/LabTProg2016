package servlets;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.AlbumInexistenteException_Exception;
import servidor.ArtistaInexistenteException_Exception;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataTema;
/**
 *
 * @author JavierM42
 */
public class OpcionesTema extends HttpServlet {
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
        String nickArtista = new String(request.getParameter("artista").getBytes(
                "iso-8859-1"), "UTF-8");
        String nombreAlbum = new String(request.getParameter("album").getBytes(
                "iso-8859-1"), "UTF-8");
        String nombreTema = new String(request.getParameter("tema").getBytes(
                "iso-8859-1"), "UTF-8");
        PrintWriter out = response.getWriter();
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        HttpSession session = request.getSession();
        boolean tieneVigente = false;
        String nick = (String) session.getAttribute("nick_sesion");
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
            try {
                tieneVigente = port.tieneSuscripcionVigente(nick);
            } catch (ClienteInexistenteException_Exception ex) {
                tieneVigente = false;
            }
        }
        try {
            DataTema data = port.consultaTema(nickArtista, nombreAlbum, nombreTema);
            boolean esWeb = data.isEsWeb();
            request.setAttribute("esWeb",esWeb);
            if(esWeb) {
                request.setAttribute("link",port.consultaURLTema(nickArtista,nombreAlbum,nombreTema));
            }
            request.setAttribute("tieneVigente",tieneVigente);
            request.setAttribute("nickArtista",nickArtista);
            request.setAttribute("nombreAlbum",nombreAlbum);
            request.setAttribute("nombreTema",nombreTema);
            List<String> list = new ArrayList();
            if (tieneVigente) {
                list = port.listarListasDeCliente(nick).getData();
            }
            request.setAttribute("listas",list);
            request.getRequestDispatcher("/WEB-INF/listas/OpcionesTema.jsp").forward(request,response);
        } catch (ArtistaInexistenteException_Exception ex) {
            out.write("Error");
        } catch (AlbumInexistenteException_Exception ex) {
            out.write("Error");
        } catch (ClienteInexistenteException_Exception ex) {
            out.write("Error");
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