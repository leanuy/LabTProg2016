package servlets;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.ArtistaInexistenteException_Exception;
import servidor.BeanListarFavoritos;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataAlbum;
import servidor.DataArtistaExt;
import servidor.DataClienteExt;
import servidor.DataColeccionString;
import servidor.DataDefecto;
import servidor.DataParticular;
import servidor.DataTema;
import servidor.UsuarioInexistenteException_Exception;

public class MiPerfil extends HttpServlet {

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
        HttpSession session = request.getSession();
        if (session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO) {
            String nick = (String) session.getAttribute("nick_sesion");
            
            servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();
            try {
                //obtener el tipo de usuario.
                boolean esCli = port.esCliente(nick);
                if (esCli) {
                    try {
                        DataClienteExt d = port.consultaCliente(nick);
                        request.setAttribute("nick", d.getNick());
                        request.setAttribute("nombre", d.getNombre());
                        request.setAttribute("apellido", d.getApellido());
                        request.setAttribute("correo", d.getCorreo());
                        request.setAttribute("fechaNac", d.getFNacStr());
                        if (d.getImg() == null) {
                            request.setAttribute("imagen", "./assets/img/profile.png");
                        } else {
                            request.setAttribute("imagen", d.getImg());
                        }
                        request.setAttribute("seguidos", d.getSeg());
                        request.setAttribute("seguidores", d.getSeguidores());
                        
                        DataColeccionString listasPub = port.listarListasPublicasDeCliente(nick);
                        request.setAttribute("listasPub", listasPub.getData());
                        DataColeccionString listasPriv = port.listarListasPrivadasDeCliente(nick);
                        request.setAttribute("listasPriv", listasPriv.getData());
                        
                        BeanListarFavoritos coleccionFavs = port.listarFavoritos(d.getNick());
                        List<DataAlbum> albumsFavoritos = coleccionFavs.getAlbumsFavoritos();
                        List<DataParticular> particularesFavoritas = coleccionFavs.getParticularesFavoritas();
                        List<DataTema> temasFavoritos = coleccionFavs.getTemasFavoritos();
                        List<DataDefecto> defectoFavoritas = coleccionFavs.getDefectoFavoritas();
                        request.setAttribute("albumsFavoritos", albumsFavoritos);
                        request.setAttribute("particularesFavoritas", particularesFavoritas);
                        request.setAttribute("temasFavoritos", temasFavoritos);
                        request.setAttribute("defectoFavoritas", defectoFavoritas);
                        
                        request.getRequestDispatcher("/WEB-INF/perfiles/MiPerfilCliente.jsp").forward(request,response);
                    } catch (ClienteInexistenteException_Exception ex) {
                        response.sendError(404);
                    }
                } else { //es artista
                    try {
                        DataArtistaExt d = port.consultaArtista(nick);
                        request.setAttribute("nick", d.getNick());
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
                        
                        DataColeccionString albums = port.listarAlbumesDeArtista(nick);
                        request.setAttribute("albums", albums.getData());

                        request.getRequestDispatcher("/WEB-INF/perfiles/MiPerfilArtista.jsp").forward(request,response);
                    } catch (ArtistaInexistenteException_Exception ex) {
                        response.sendError(404);
                    }
                }
            } catch (UsuarioInexistenteException_Exception ex) {
                response.sendError(404);
            }
        } else {
            request.getRequestDispatcher("/inicio").forward(request, response);
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
