/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataGenero;
import espotify.excepciones.GeneroInexistenteException;
import espotify.interfaces.web.IVerGenero;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavierM42
 */
public class VerGenero extends HttpServlet {

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
        String inputNom = new String(request.getParameter("genero").getBytes(
                "iso-8859-1"), "UTF-8");

        IVerGenero interf = Fabrica.getIVerGenero();
        try {
            DataGenero data = interf.consultaGenero(inputNom);
            request.setAttribute("nombre", data.getNombre());

            List<String> listas = interf.listarListasDeGenero(inputNom);
            request.setAttribute("listas", listas);
            
            List<String[]> albums = interf.listarAlbumesDeGenero(inputNom);
            request.setAttribute("albums", albums);
            
            List<String> subgeneros = new ArrayList<String>();
            for(DataGenero dgen : data.getHijos()) {
                subgeneros.add(dgen.getNombre());
            }
            request.setAttribute("subgeneros", subgeneros);
            
            request.getRequestDispatcher("/WEB-INF/generos/VerGenero.jsp").forward(request,response);
            
            
        } catch (GeneroInexistenteException ex) {
            response.sendError(404);
            //el nick no es un artista
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
