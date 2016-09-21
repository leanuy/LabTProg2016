package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataAlbum;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.interfaces.web.IVerPerfil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;

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
            
            IVerPerfil iPerfil = Fabrica.getIVerPerfil();
            try {
                //obtener el tipo de usuario.
                boolean esCli = iPerfil.esCliente(nick);
                if (esCli) {
                    try {
                        DataClienteExt d = iPerfil.consultaCliente(nick);
                        request.setAttribute("nick", d.getNick());
                        request.setAttribute("nombre", d.getNombre());
                        request.setAttribute("apellido", d.getApellido());
                        request.setAttribute("correo", d.getCorreo());
                        request.setAttribute("fechaNac", d.getfNacStr());
                        if (d.getImg() == null) {
                            request.setAttribute("imagen", "./assets/img/profile.png");
                        } else {
                            request.setAttribute("imagen", d.getImg());
                        }
                        request.setAttribute("seguidos", d.getSeguidos());
                        request.setAttribute("seguidores", d.getSeguidores());
                        
                        List<String> listasPub = iPerfil.listarListasPublicasDeCliente(nick);
                        request.setAttribute("listasPub", listasPub);
                        List<String> listasPriv = iPerfil.listarListasPrivadasDeCliente(nick);
                        request.setAttribute("listasPriv", listasPriv);
                        
                        List<DataFavoriteable> favoritos = Fabrica.getIFavoritos().listarFavoritos(d.getNick());
                        List<DataAlbum> albumsFavoritos = new ArrayList();
                        List<DataParticular> particularesFavoritas = new ArrayList();
                        for (DataFavoriteable fav : favoritos) {
                            if(fav instanceof DataAlbum) {
                                albumsFavoritos.add((DataAlbum)fav);
                            } else if (fav instanceof DataParticular) {
                                particularesFavoritas.add((DataParticular)fav);
                            }
                        }
                        request.setAttribute("albumsFavoritos", albumsFavoritos);
                        request.setAttribute("particularesFavoritas", particularesFavoritas);
                        
                        request.getRequestDispatcher("/WEB-INF/perfiles/MiPerfilCliente.jsp").forward(request,response);

                    } catch (ClienteInexistenteException e) {
                        response.sendError(404);
                        //problemas consultando el cliente
                    }
                } else { //es artista
                    try {
                        DataArtistaExt d = iPerfil.consultaArtista(nick);
                        request.setAttribute("nick", d.getNick());
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
                        
                        List<String> albums = iPerfil.listarAlbumesDeArtista(nick);
                        request.setAttribute("albums", albums);

                        request.getRequestDispatcher("/WEB-INF/perfiles/MiPerfilArtista.jsp").forward(request,response);
                    } catch (ArtistaInexistenteException e) {

                    }
                }
            } catch (ClienteInexistenteException ex) {
                response.sendError(404);
                //el nick no existe en el sistema
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
