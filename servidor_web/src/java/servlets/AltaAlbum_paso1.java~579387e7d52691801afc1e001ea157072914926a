/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataAlbumExt;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.web.IAltaAlbumWeb;
import espotify.interfaces.web.IListarGeneros;
import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author agus
 */
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
        IListarGeneros interf = Fabrica.getIListarGeneros();
        Map<String, String> data = interf.stringifyDataGeneros();
                
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

        IAltaAlbumWeb inter = Fabrica.getIAltaAlbumWeb();
        boolean has_errors = false;
        int anio = 0;
        HttpSession session = request.getSession();
        String nombre = new String(request.getParameter("nombre").getBytes("iso-8859-1"), "UTF-8");
        String anio_str = request.getParameter("anio");
        String[] generos_arr = request.getParameterValues("generos");

        
        List<String> generos = new ArrayList<String>();
        
        
        if(nombre.equals("")){
            request.setAttribute("error_nombre", "El nombre del álbum es requerido");
            has_errors = true;
        }else{
            boolean ya_existe = false;
            try {
                ya_existe = inter.esAlbumDeArtista((String) session.getAttribute("nick_sesion"), nombre);
            } catch (Exception ex) {
                response.sendError(500);
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
            request.setAttribute("error_generos", "Debes elegir al menos un año para el álbum");
            has_errors = true;
        }else{
            for (String genero : generos_arr) {
                generos.add(new String(genero.getBytes("iso-8859-1"), "UTF-8"));
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
            if (isMultipart) {
                Part part = request.getPart("imagen");
                InputStream is = part.getInputStream();
                BufferedImage img = ImageIO.read(is);
                data = new DataAlbumExt(nombre, anio, generos, img, (String) session.getAttribute("nick_sesion"));
            } else {
                data = new DataAlbumExt(nombre, anio, generos, null, (String) session.getAttribute("nick_sesion"));
            }
            
            try {
                inter.addAlbumTemp(data);
            } catch (ArtistaInexistenteException ex) {
                Logger.getLogger(AltaAlbum_paso1.class.getName()).log(Level.SEVERE, null, ex);
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
