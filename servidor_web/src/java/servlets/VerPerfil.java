package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import espotify.Fabrica;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.YaPublicaException;
import espotify.interfaces.IAgregarTemaLista;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IConsultaCliente;
import espotify.interfaces.IPublicarLista;
import espotify.interfaces.web.IVerPerfil;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavierM42
 */
public class VerPerfil extends HttpServlet {

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
        
        
        String inputNick = request.getParameter("nick");

        IVerPerfil iPerfil = Fabrica.getIVerPerfil();
        try {
            //obtener el tipo de usuario.
            boolean esCli = iPerfil.esCliente(inputNick);
            if (esCli) {
                try {
                    DataClienteExt d = iPerfil.consultaCliente(inputNick);
                    request.setAttribute("nick", d.getNick());
                    if(d.getImg() == null) {
                        request.setAttribute("imagen", "./assets/img/profile.png");
                    } else {
                        request.setAttribute("imagen", d.getImg());
                    }
                    List<String> listas = iPerfil.listarListasPublicasDeCliente(inputNick);
                    request.setAttribute("listas", listas);
                    
                    request.getRequestDispatcher("/PerfilCliente.jsp").forward(request,response);
                    
                } catch (ClienteInexistenteException e) {
                    request.getRequestDispatcher("/Error.jsp").forward(request,response);
                    //problemas consultando el cliente
                }
            } else { //es artista
                try {
                    DataArtistaExt d = iPerfil.consultaArtista(inputNick);
                    request.setAttribute("nick",d.getNick());
                    if(d.getImg() == null) {
                        request.setAttribute("imagen", "./assets/img/profile.png");
                    } else {
                        request.setAttribute("imagen", d.getImg());
                    }
                    List<String> albums = iPerfil.listarAlbumesDeArtista(inputNick);
                    request.setAttribute("albums", albums);
                    
                    request.getRequestDispatcher("/PerfilArtista.jsp").forward(request,response);
                } catch (ArtistaInexistenteException e) {
                    
                }
            }
            
            
            
            
            
            
            
            
            
            
            
        } catch (ClienteInexistenteException ex) {
            request.getRequestDispatcher("/Error.jsp").forward(request,response);
            //el nick no existe en el sistema
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
