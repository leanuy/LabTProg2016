/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import net.java.dev.jaxb.array.StringArray;
import servidor.BeanBusqueda;
import servidor.DataAlbum;

/**
 *
 * @author JavierM42
 */
public class Buscar extends HttpServlet {

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
        String sort;
        try {
            sort = new String(request.getParameter("sort").getBytes(
                    "iso-8859-1"), "UTF-8");
        }
        catch(NullPointerException e) {
            sort = "alf";
        }
        String busqueda;
        try {
            busqueda = new String(request.getParameter("busqueda").getBytes(
                "iso-8859-1"), "UTF-8");
        }
        catch(NullPointerException e) {
            busqueda = "";
        }
        request.setAttribute("busqueda", busqueda);
        if (!busqueda.equals("") && busqueda != null) {
            servidor.PublicadorService service =  new servidor.PublicadorService();
            servidor.Publicador port = service.getPublicadorPort();
            Comparator tem_comp;
            Comparator alb_comp;
            Comparator list_comp = alf_list_comp();;
            if (sort.equals("alf")) {
                tem_comp = alf_tema_comp();
                alb_comp = alf_alb_comp();
                list_comp = alf_list_comp();
            }
            else {
                tem_comp = ano_tema_comp();
                alb_comp = ano_alb_comp();
                list_comp = ano_list_comp();
            }
            BeanBusqueda resultado = port.buscar(busqueda);
            List<StringArray> temas = resultado.getTemas();
            Collections.sort(temas, tem_comp);
            List<DataAlbum> albums = resultado.getAlbums();
            Collections.sort(albums, alb_comp);
            List<StringArray> listas = resultado.getListas();
            request.setAttribute("temas", temas);
            request.setAttribute("albums", albums);
            request.setAttribute("listas", listas);
        } 
        request.getRequestDispatcher("/WEB-INF/generos/Buscar.jsp").forward(request,response);
    }
    
    private Comparator alf_tema_comp() {
        return new Comparator<StringArray>() {
                @Override
                public int compare(StringArray o1, StringArray o2) {
                    return o1.getItem().get(0).compareToIgnoreCase(o2.getItem().get(0));
                }
            };   
    }
    
    private Comparator ano_tema_comp() {
        return new Comparator<StringArray>() {
            @Override
            public int compare(StringArray o1, StringArray o2) {
                int result;
                int o1Int = Integer.parseInt(o1.getItem().get(3));
                int o2Int = Integer.parseInt(o2.getItem().get(3));
                if (o1Int > o2Int) {
                    result = -1;
                }
                else if (o1Int == o2Int) {
                    result = 0;
                }
                else {
                    result = 1;
                }
                return result;
            }
        };   
    }
    
    private Comparator alf_alb_comp() {
        return new Comparator<DataAlbum>() {
            @Override
            public int compare(DataAlbum o1, DataAlbum o2) {
                return o1.getNombre().compareToIgnoreCase(o2.getNombre());
            }
        };
    }
    
    private Comparator ano_alb_comp() {
        return new Comparator<DataAlbum>() {
            @Override
            public int compare(DataAlbum o1, DataAlbum o2) {
                int result;
                int o1Int = o1.getAnio();
                int o2Int = o2.getAnio();
                if (o1Int > o2Int) {
                    result = -1;
                }
                else if (o1Int == o2Int) {
                    result = 0;
                }
                else {
                    result = 1;
                }
                return result;
            }
        };   
    }
    
    private Comparator alf_list_comp() {
        return new Comparator<StringArray>() {
            @Override
            public int compare(StringArray o1, StringArray o2) {
                return o1.getItem().get(0).compareToIgnoreCase(o2.getItem().get(0));
            }
        };
    }
    
    private Comparator ano_list_comp() {
        return new Comparator<StringArray>() {
            @Override
            public int compare(StringArray o1, StringArray o2) {
                int result;
                int o1Int = Integer.parseInt(o1.getItem().get(2));
                int o2Int = Integer.parseInt(o2.getItem().get(2));
                if (o1Int > o2Int) {
                    result = -1;
                }
                else if (o1Int == o2Int) {
                    result = 0;
                }
                else {
                    result = 1;
                }
                return result;
            }
        };   
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
