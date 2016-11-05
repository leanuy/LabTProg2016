/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.awt.image.BufferedImage;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.apache.tomcat.util.http.fileupload.servlet.ServletFileUpload;
import servidor.CorreoRepetidoException_Exception;
import servidor.DataArtista;
import servidor.DataCliente;
import servidor.FormatoIncorrectoException_Exception;
import servidor.NickRepetidoException_Exception;

/**
 *
 * @author JavierM42
 */
@MultipartConfig
public class Registrarme extends HttpServlet {



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
        response.setContentType("text/html;charset=UTF-8");
        request.getRequestDispatcher("/WEB-INF/perfiles/AltaPerfil.jsp").forward(request,response);
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
        
        String login = request.getParameter("login");
        String correo = request.getParameter("correo");
        String password = request.getParameter("password");
        String nombre = request.getParameter("nombre");
        String apellido = request.getParameter("apellido");
        Calendar fechaNac = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("d/M/y");
        
        byte[] img = null;
        boolean isMultipart = ServletFileUpload.isMultipartContent(request);
        if (isMultipart) {
            Part part = request.getPart("imagen");
            InputStream is = part.getInputStream();
            BufferedImage bufImg = ImageIO.read(is);
            
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bufImg, "jpg", baos );
            baos.flush();
            img = baos.toByteArray();
            baos.close();
        }
        
        String tipo = request.getParameter("tipo");
        if(tipo.equals("cliente")) {
            
            try {
                fechaNac.setTime(sdf.parse(request.getParameter("fechaNac")));
                DataCliente dataCli = new DataCliente();
                dataCli.setNick(login);
                dataCli.setNombre(nombre);
                dataCli.setApellido(apellido);
                dataCli.setCorreo(correo);
                //http://ravindrap07.blogspot.com.uy/2009/08/convert-calendar-to-xmlgregoriancalenda.html
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTimeInMillis(fechaNac.getTimeInMillis());
                XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                dataCli.setFechaNac(xc);
                    
                dataCli.setPassword(password);
                
                servidor.PublicadorService service =  new servidor.PublicadorService();
                servidor.Publicador port = service.getPublicadorPort();
                if(img!=null) {
                    port.altaClienteConImagen(dataCli,img);
                } else {
                    port.altaCliente(dataCli);
                }
                request.getRequestDispatcher("/iniciar-sesion").forward(request,response);
            } catch (ParseException ex) {
                    response.sendError(500);
            } catch (CorreoRepetidoException_Exception ex) {
                response.sendError(500);
            } catch (FormatoIncorrectoException_Exception ex) {
                response.sendError(500);
            } catch (NickRepetidoException_Exception ex) {
                response.sendError(500);
            } catch (DatatypeConfigurationException ex) {
                response.sendError(500);
            }
        } else if (tipo.equals("artista")) {
            String url = request.getParameter("url");
            String bio = request.getParameter("bio");
            
            try {
                fechaNac.setTime(sdf.parse(request.getParameter("fechaNac")));
                DataArtista dataArt = new DataArtista();
                dataArt.setBio(bio);
                dataArt.setUrl(url);
                dataArt.setNick(login);
                dataArt.setNombre(nombre);
                dataArt.setApellido(apellido);
                dataArt.setCorreo(correo);
                GregorianCalendar gc = new GregorianCalendar();
                gc.setTimeInMillis(fechaNac.getTimeInMillis());
                XMLGregorianCalendar xc = DatatypeFactory.newInstance().newXMLGregorianCalendar(gc);
                dataArt.setFechaNac(xc);
                dataArt.setPassword(password);
                
                servidor.PublicadorService service =  new servidor.PublicadorService();
                servidor.Publicador port = service.getPublicadorPort();
                if(img!=null) {
                    port.altaArtistaConImagen(dataArt,img);
                } else {
                    port.altaArtista(dataArt);
                }
                request.getRequestDispatcher("/iniciar-sesion").forward(request,response);
            } catch (ParseException ex) {
                response.sendError(500);
            } catch (CorreoRepetidoException_Exception ex) {
                response.sendError(500);
            } catch (FormatoIncorrectoException_Exception ex) {
                response.sendError(500);
            } catch (NickRepetidoException_Exception ex) {
                response.sendError(500);
            } catch (DatatypeConfigurationException ex) {
                response.sendError(500);
            }
        } else {
            response.sendError(500);
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
