package servlets;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import espotify.Fabrica;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataParticular;
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
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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

        //DOY DE ALTA UN CLIENTE PARA PROBAR.
        IAltaPerfil ctrlAltaPerfil = Fabrica.getIAltaPerfil();
        Calendar cal = Calendar.getInstance();
        cal.set(1972, 3, 8);
        DataCliente dataCliente = new DataCliente("el_padrino", "Vito", "Corleone", "el_padrino@tuta.io", cal, null,"");
        try {
            ctrlAltaPerfil.altaCliente(dataCliente);
        } catch (NickRepetidoException ex) {
        } catch (CorreoRepetidoException ex) {
        } catch (FormatoIncorrectoException ex) {
        }
        IAltaLista ctrlAltaListas = Fabrica.getIAltaLista();
        DataParticular dataParticular = new DataParticular("el_padrino", "Música Inspiradora", null);
        try {
            ctrlAltaListas.altaListaParticular(dataParticular);
        } catch (ListaRepetidaException ex) {
        } catch (ClienteInexistenteException ex) {
        }
        dataParticular = new DataParticular("el_padrino", "Música Inspiradora vol. II", null);
        try {
            ctrlAltaListas.altaListaParticular(dataParticular);
        } catch (ListaRepetidaException ex) {
        } catch (ClienteInexistenteException ex) {
        }
        IPublicarLista ctrlPublicar = Fabrica.getIPublicarLista();
        try {
            ctrlPublicar.publicarLista("Música Inspiradora","el_padrino");
            ctrlPublicar.publicarLista("Música Inspiradora vol. II","el_padrino");
        } catch (ClienteInexistenteException ex) {
        } catch (ListaInexistenteException ex) {
        } catch (YaPublicaException ex) {
        }
        
        
        //FIN ALTA
        
        
        
        String inputNick = "el_padrino"; //esto lo obtendría de algun lado, se supone que por donde llegué a la página esta.
        
        try {
            IConsultaCliente iConsulta = Fabrica.getIConsultaCliente();
            DataClienteExt d = iConsulta.consultaCliente(inputNick);
            request.setAttribute("nick", d.getNick());
            if(d.getImg() == null) {
                request.setAttribute("imagen", "./assets/img/profile.png");
            } else {
                request.setAttribute("imagen", d.getImg());
            }
            IAgregarTemaLista iListas = Fabrica.getIAgregarTemaLista();
            List<String> listas = iListas.listarListasPublicasDeCliente(inputNick);
            request.setAttribute("listas", listas);
            
            
            request.getRequestDispatcher("/PerfilCliente.jsp").forward(request,response);
        
        
        } catch (ClienteInexistenteException ex) {
            request.getRequestDispatcher("/Error.jsp").forward(request,response);
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
