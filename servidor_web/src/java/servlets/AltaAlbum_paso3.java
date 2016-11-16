/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import servidor.AlbumRepetidoException_Exception;
import servidor.ArtistaInexistenteException_Exception;
import servidor.CampoVacioException_Exception;
import servidor.DuracionInvalidaException_Exception;
import servidor.GeneroInexistenteException_Exception;
import servidor.NumeroTemaInvalidoException_Exception;
import servidor.TemaRepetidoException_Exception;
import servidor.TemaTipoInvalidoException_Exception;

/**
 *
 * @author agustina
 */
public class AltaAlbum_paso3 extends HttpServlet {

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
        
        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        String artista = (String) session.getAttribute("nick_sesion");
        if(!"".equals(artista)){
        
        try {
            port.aceptarAltaAlbum(artista);
        } catch (ArtistaInexistenteException_Exception ex) {
            response.sendError(500, "artista inexistente.");
        } catch (AlbumRepetidoException_Exception ex) {
            response.sendError(500, "album repetido.");
        } catch (GeneroInexistenteException_Exception ex) {
            response.sendError(500, "genero inexistente.");
        } catch (DuracionInvalidaException_Exception ex) {
            response.sendError(500, "duracion invalida.");
        } catch (NumeroTemaInvalidoException_Exception ex) {
            response.sendError(500, "numero tema invalido.");
        } catch (TemaRepetidoException_Exception ex) {
            response.sendError(500, "tema repetido.");
        } catch (CampoVacioException_Exception ex) {
            response.sendError(500, "campo vacio.");
        } catch (TemaTipoInvalidoException_Exception ex) {
            response.sendError(500, "tema tipo invalido.");
        }
        PrintWriter out = response.getWriter();
        out.print(artista);
        }else{
            response.sendError(401, "Usted no tiene permitido el acceso a esta funcionalidad de la app.");
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
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
