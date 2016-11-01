/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataParticular;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.interfaces.web.IFavoritos;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.EstadoSesion;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataLista;
import servidor.DataTema;
import servidor.ListaInexistenteException_Exception;

/**
 *
 * @author JavierM42
 */
public class VerListaParticular extends HttpServlet {

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
        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        HttpSession session = request.getSession();
        String inputNick = new String(request.getParameter("nick").getBytes(
                "iso-8859-1"), "UTF-8");
        String inputNom = new String(request.getParameter("lista").getBytes(
                "iso-8859-1"), "UTF-8");

        try {
            DataLista data = port.darInfoParticular(inputNom, inputNick);
            boolean esPrivada = port.listaEsPrivada(inputNom,inputNick);
            if(esPrivada && !inputNick.equals(session.getAttribute("nick_sesion"))) {
                response.sendError(500);
            } else {
                request.setAttribute("nomLista", data.getNombre());
                request.setAttribute("nomCliente", inputNick);

                request.setAttribute("temas", data.getTemas());
                request.setAttribute("esPrivada",esPrivada);

                boolean[] es_favorito_temas = new boolean[data.getTemas().size()];
                if(!esPrivada && session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && Boolean.valueOf(session.getAttribute("es_cliente").toString())) {
                    /*IFavoritos ifav = Fabrica.getIFavoritos();
                    boolean es_favorito;
                    String nickSesion = session.getAttribute("nick_sesion").toString();
                    DataParticular dataFav = new DataParticular(inputNick,data.getNombre(),null);
                    es_favorito = ifav.esFavorito(nickSesion, dataFav);
                    request.setAttribute("es_favorito", es_favorito);
                    
                    int idx = 0;
                    for (DataTema t : data.getTemas()) {
                        es_favorito_temas[idx] = ifav.esFavorito(nickSesion, (DataFavoriteable) t);
                        idx++;
                    }
                    request.setAttribute("es_favorito_temas",es_favorito_temas);*/
                }
                request.getRequestDispatcher("/WEB-INF/listas/ListaParticular.jsp").forward(request,response);
            }
        }/* catch (ClienteInexistenteException ex) {
            response.sendError(404);
        } catch (ListaInexistenteException ex) {
            response.sendError(404);
        } catch (ArtistaInexistenteException ex) {
            response.sendError(404);
        } catch (AlbumInexistenteException ex) {
            response.sendError(404);
        }*/ catch (ClienteInexistenteException_Exception ex) {
            response.sendError(404);
        } catch (ListaInexistenteException_Exception ex) {
            response.sendError(404);
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
