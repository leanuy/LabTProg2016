/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.ClienteInexistenteException_Exception;
import servidor.AlbumInexistenteException_Exception;
import servidor.ArtistaInexistenteException_Exception;
import servidor.FavoritoRepetidoException_Exception;
import servidor.ListaInexistenteException_Exception;

/**
 *
 * @author JavierM42
 */
public class Favoritear extends HttpServlet {

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
            String tipoFav = new String(request.getParameter("tipo").getBytes(
                "iso-8859-1"), "UTF-8");
            servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();
            try{
                if (port.tieneSuscripcionVigente(nick)) {
                    if(tipoFav.equals("album")) {
                        String nomAlbum = new String(request.getParameter("album").getBytes(
                        "iso-8859-1"), "UTF-8");
                        String nomArtista = new String(request.getParameter("artista").getBytes(
                        "iso-8859-1"), "UTF-8");
                        port.favoritearAlbum(nick, nomArtista, nomAlbum);

                        request.getRequestDispatcher("/VerAlbum?nick="+nomArtista+"&album="+nomAlbum).forward(request,response);
                    } else if(tipoFav.equals("particular")) {
                        String nomLista = new String(request.getParameter("lista").getBytes(
                        "iso-8859-1"), "UTF-8");
                        String nomCliente = new String(request.getParameter("nick").getBytes(
                        "iso-8859-1"), "UTF-8");
                        port.favoritearParticular(nick, nomCliente, nomLista);

                        request.getRequestDispatcher("/VerListaParticular?nick="+nomCliente+"&lista="+nomLista).forward(request,response);
                    } else if(tipoFav.equals("tema")) {
                        String nomTema = new String(request.getParameter("tema").getBytes(
                        "iso-8859-1"), "UTF-8");
                        String nomAlbum = new String(request.getParameter("album").getBytes(
                        "iso-8859-1"), "UTF-8");
                        String nomArtista = new String(request.getParameter("artista").getBytes(
                        "iso-8859-1"), "UTF-8");
                        port.favoritearTema(nick, nomArtista, nomAlbum, nomTema);
                        //esto no funciona exactamente como querríamos, si favoriteás desde una lista va al álbum.
                        request.getRequestDispatcher("/VerAlbum?nick="+nomArtista+"&album="+nomAlbum).forward(request,response);
                    } else if(tipoFav.equals("defecto")) {
                        String nomLista = new String(request.getParameter("lista").getBytes(
                        "iso-8859-1"), "UTF-8");
                        port.favoritearDefecto(nick, nomLista);

                        request.getRequestDispatcher("/VerListaDefecto?lista="+nomLista).forward(request,response);
                    }
                } else {
                    response.sendError(500);
                }
            } catch (ClienteInexistenteException_Exception ex) {
                response.sendError(500);
            } catch (AlbumInexistenteException_Exception ex) {
                response.sendError(500);
            } catch (ArtistaInexistenteException_Exception ex) {
                response.sendError(500);
            } catch (FavoritoRepetidoException_Exception ex) {
                response.sendError(500);
            } catch (ListaInexistenteException_Exception ex) {
                response.sendError(500);
            }
        } else {
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
