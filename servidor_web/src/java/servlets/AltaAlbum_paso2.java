/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import servidor.DataAlbumExt;
import servidor.DataTemaArchivo;
import servidor.DataTemaWeb;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import servidor.ArtistaInexistenteException_Exception;

/**
 *
 * @author agus
 */
@WebServlet
@MultipartConfig
public class AltaAlbum_paso2 extends HttpServlet {
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
        HttpSession session = request.getSession();
        
        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();

        String artista = (String) session.getAttribute("nick_sesion");
        if (port.esArtista(artista)) {
        request.setAttribute("album", request.getParameter("album"));
        request.getRequestDispatcher("/WEB-INF/albums/paso2.jsp").forward(request, response);
        } else {
            response.sendError(401, "Usted no tiene permitido el acceso a esta funcionalidad de la app.");
        }
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

        HttpSession session = request.getSession();

        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        String artista = (String) session.getAttribute("nick_sesion");
        if (!"".equals(artista)) {
            
        response.setContentType("text/html;charset=UTF-8");
        PrintWriter out = response.getWriter();
        
        boolean has_errors = false;
        try {
            Part part;
            Scanner s;
                        
            DataAlbumExt album = port.getAlbumTemp(artista);
            
            part = request.getPart("orden");
            s = new Scanner(part.getInputStream());
            int orden = Integer.parseInt(s.nextLine());
            
            part = request.getPart("nombre");
            s = new Scanner(part.getInputStream());
            String nombre = s.nextLine();
            
            part = request.getPart("duracion");
            s = new Scanner(part.getInputStream());
            int duracion = Integer.parseInt(s.nextLine());

            part = request.getPart("tipo");
            s = new Scanner(part.getInputStream());
            String tipo = s.nextLine();
            
            
            if (tipo.equals("web")) {
                part = request.getPart("url");
                s = new Scanner(part.getInputStream());
                String url = s.nextLine();

                DataTemaWeb temaWeb = new DataTemaWeb();
                temaWeb.setUrl(url);
                temaWeb.setNombre(nombre);
                temaWeb.setDuracion(duracion);
                temaWeb.setNum(orden);
                temaWeb.setNomArtista(artista);
                temaWeb.setAlbum(album.getNombre());
                port.addTemaWebAlbumTemp(artista, temaWeb);
                out.print("true");
            } else if(tipo.equals("archivo")){
                boolean isMultipart = ServletFileUpload.isMultipartContent(request);
                if (isMultipart) {
                    part = request.getPart("archivo");
                    InputStream input = part.getInputStream();
                    byte[] buffer = new byte[1024];
                    int bytesRead;
                    ByteArrayOutputStream output = new ByteArrayOutputStream();
                    while ((bytesRead = input.read(buffer)) != -1) {
                        output.write(buffer, 0, bytesRead);
                    }
                    DataTemaArchivo temaArchivo = new DataTemaArchivo();
                    temaArchivo.setNombre(nombre);
                    temaArchivo.setDuracion(duracion);
                    temaArchivo.setNum(orden);
                    temaArchivo.setNomArtista(artista);
                    temaArchivo.setAlbum(album.getNombre());
                    port.addTemaArchivoAlbumTemp(artista, temaArchivo, output.toByteArray());
                    out.print("true");
                }
            }
   
        } catch (ArtistaInexistenteException_Exception ex) {
            out.print("false");
        }
        }else{
            response.sendError(401, "Usted no tiene permitido el acceso a esta funcionalidad de la app.");
    }
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
