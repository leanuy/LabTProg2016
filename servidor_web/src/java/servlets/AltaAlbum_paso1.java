/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import servidor.DataCollectionGenerosStrfyItems;
import servidor.DataAlbumExt;
import espotify.interfaces.web.IListarGeneros;
import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Map;
import javax.imageio.ImageIO;
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
import servidor.DataColeccionGenerosStrfy;

/**
 *
 * @author agus
 */
@WebServlet
@MultipartConfig
public class AltaAlbum_paso1 extends HttpServlet {
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
        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();

        DataColeccionGenerosStrfy generos = port.getGenerosStringified();
        List<DataCollectionGenerosStrfyItems> data = generos.getData();
                
        request.setAttribute("generos", data);
        request.getRequestDispatcher("/WEB-INF/albums/paso1.jsp").forward(request, response);
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
        
        servidor.PublicadorService service = new servidor.PublicadorService();
        servidor.Publicador port = service.getPublicadorPort();
        
        
        boolean has_errors = false;
        String generos_str = "";
        int anio = 0;
        HttpSession session = request.getSession();
        String nombre = new String(request.getParameter("nombre").getBytes("iso-8859-1"), "UTF-8");
        String anio_str = request.getParameter("anio");
        String[] generos_arr = request.getParameterValues("generos");
        
        if(nombre.equals("")){
            request.setAttribute("error_nombre", "El nombre del álbum es requerido");
            has_errors = true;
        }else{
            boolean ya_existe = false;
            try {
                ya_existe = port.esAlbumDeArtista((String) session.getAttribute("nick_sesion"), nombre);
            } catch (ArtistaInexistenteException_Exception ex) {
                response.sendError(500, "no existe el artista.");
            }
            if(ya_existe){
                request.setAttribute("error_nombre", "Ya tienes un álbum con este nombre");
                has_errors = true;
            }
        }
        
        if(anio_str.equals("")){
            request.setAttribute("error_anio", "El año del álbum es requerido");
            has_errors = true;
        }else{
            anio = Integer.parseInt(anio_str);
            if(anio < 0){
                request.setAttribute("error_anio", "El año del álbum no es correcto");
                has_errors = true;
            }
        }
        if(generos_arr == null || generos_arr.length == 0){
            request.setAttribute("error_generos", "Debes elegir al menos un género para el álbum");
            has_errors = true;
        }else{
            for (String genero : generos_arr) {
                generos_str = generos_str.concat(new String(genero.getBytes("iso-8859-1"), "UTF-8"));
                generos_str = generos_str.concat(", ");
            }
            if(!generos_str.isEmpty()){
                generos_str = generos_str.substring(0, generos_str.length()-3);
            }
        }
        
        if(has_errors){
            IListarGeneros interf = Fabrica.getIListarGeneros();
            Map<String, String> data = interf.stringifyDataGeneros();
            
            request.setAttribute("has_errors", true);

            request.setAttribute("generos", data);
            
            request.setAttribute("nombre", nombre);
            request.setAttribute("anio", anio_str);
            request.setAttribute("generos_arr", generos_arr);
            request.getRequestDispatcher("/WEB-INF/albums/paso1.jsp").forward(request, response);
        }else{
            
            DataAlbumExt data;
            
            
            boolean isMultipart = ServletFileUpload.isMultipartContent(request);
            byte[] img = null;
            if (isMultipart) {
                Part part = request.getPart("imagen");
                InputStream is = part.getInputStream();
                BufferedImage bufImg = ImageIO.read(is);
                if(bufImg != null){
                    ByteArrayOutputStream baos = new ByteArrayOutputStream();
                    ImageIO.write(bufImg, "jpg", baos);
                    baos.flush();
                    img = baos.toByteArray();
                    baos.close();
                }
                data = new DataAlbumExt();
                data.setNombre(nombre);
                data.setAnio(anio);
                data.setNickArtista((String) session.getAttribute("nick_sesion"));
                
            } else {
                data = new DataAlbumExt();
                data.setNombre(nombre);
                data.setAnio(anio);
                data.setImg(null);
                data.setNickArtista((String) session.getAttribute("nick_sesion"));
            }
            
            try {
                
                if (img != null) {
                    port.addAlbumTempConImagen(data, generos_str, img);
                } else {
                    port.addAlbumTemp(data, generos_str);
                }
                port.addAlbumTemp(data, generos_str);
            } catch (ArtistaInexistenteException_Exception ex) {
            }
        response.sendRedirect("/AltaAlbum/paso2?album="+nombre);
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
