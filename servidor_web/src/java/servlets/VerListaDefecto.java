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
import servidor.AlbumInexistenteException_Exception;
import servidor.ArtistaInexistenteException_Exception;
import servidor.ClienteInexistenteException_Exception;
import servidor.DataLista;
import servidor.DataTema;
import servidor.ListaInexistenteException_Exception;

/**
 *
 * @author JavierM42
 */
public class VerListaDefecto extends HttpServlet {

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
        String inputNom = new String(request.getParameter("lista").getBytes(
                "iso-8859-1"), "UTF-8");

        servidor.PublicadorService service =  new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        try {
            DataLista data = port.darInfoDefecto(inputNom);
            request.setAttribute("nomLista", data.getNombre());
            request.setAttribute("temas", data.getTemas());

            boolean[] es_favorito_temas = new boolean[data.getTemas().size()];
            boolean soyCli;
            try {
                soyCli = Boolean.valueOf(session.getAttribute("es_cliente").toString());
            }
            catch (NullPointerException e) {
                soyCli = false;
            }
            if(session.getAttribute("estado_sesion") == EstadoSesion.LOGIN_CORRECTO && soyCli) {
                boolean es_favorito;
                String nickSesion = session.getAttribute("nick_sesion").toString();
                es_favorito = port.esFavoritoDefecto(nickSesion, data.getNombre());
                request.setAttribute("es_favorito", es_favorito);

                int idx = 0;
                for (DataTema t : data.getTemas()) {
                    es_favorito_temas[idx] = port.esFavoritoTema(nickSesion, t.getNomArtista(), t.getAlbum(), t.getNombre());
                    idx++;
                }
                request.setAttribute("es_favorito_temas",es_favorito_temas);
            }

            request.getRequestDispatcher("/WEB-INF/listas/ListaDefecto.jsp").forward(request,response);
            
        } catch (AlbumInexistenteException_Exception ex) {
            response.sendError(500);
        } catch (ClienteInexistenteException_Exception ex) {
            response.sendError(500);
        } catch (ListaInexistenteException_Exception ex) {
            response.sendError(404);
        } catch (ArtistaInexistenteException_Exception ex) {
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
