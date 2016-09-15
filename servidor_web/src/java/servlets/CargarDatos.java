/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import espotify.Fabrica;
import espotify.datatypes.DataAlbum;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtista;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;
import espotify.datatypes.DataTemaWeb;
import espotify.interfaces.IAgregarTemaLista;
import espotify.interfaces.IAltaAlbum;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IAltaSeguir;
import espotify.interfaces.IFavoritear;
import espotify.interfaces.IPublicarLista;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Calendar;
import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author JavierM42
 */
public class CargarDatos extends HttpServlet {

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
        
        try {
            DatosDePrueba();
            request.getRequestDispatcher("/index.jsp").forward(request,response);
        } catch (Exception e) {
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
    
     private void DatosDePrueba() throws Exception {
        //ALTA DE CLIENTES:
        Fabrica.clear(); //ESTO NO DEBERIA ESTAR.
        
        IAltaPerfil ctrlAltaPerfil = Fabrica.getIAltaPerfil();
        File file;
        BufferedImage img;
        
        img = null;
        
        //file = new File("./src/Presentacion/img/clientes/ElPadrino.png");
        //img = ImageIO.read(file);
        Calendar cal = Calendar.getInstance();
        cal.set(1972, 3, 8);
        DataCliente dataCliente = new DataCliente("el_padrino", "Vito", "Corleone", "el_padrino@tuta.io", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        //file = new File("./src/Presentacion/img/clientes/ScarlettOHara.jpg");
        //img = ImageIO.read(file);
        cal.set(1984, 11, 27);
        dataCliente = new DataCliente("scarlettO", "Scarlett", "O'Hara", "scarlettO@tuta.io", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        //file = new File("./src/Presentacion/img/clientes/PepeArgento.png");
        //img = ImageIO.read(file);
        cal.set(1955, 2, 14);
        dataCliente = new DataCliente("ppArgento", "Pepe", "Argento", "ppArgento@hotmail.com", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        cal.set(1056, 3, 7);
        dataCliente = new DataCliente("Heisenberg", "Walter", "White", "Heisenberg@tuta.io", cal, null,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        //file = new File("./src/Presentacion/img/clientes/BenKenobi.png");
        //img = ImageIO.read(file);
        cal.set(1914, 4, 2);
        dataCliente = new DataCliente("benKenobi", "Obi-Wan", "Kenobi", "benKenobi@gmail.com", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        //file = new File("./src/Presentacion/img/clientes/lachiqui.jpg");
        //img = ImageIO.read(file);
        cal.set(1927, 2, 23);
        dataCliente = new DataCliente("lachiqui", "Mirtha", "Legrand", "lachiqui@hotmail.com.ar", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        //file = new File("./src/Presentacion/img/clientes/CachoBochinche.jpg");
        //img = ImageIO.read(file);
        cal.set(1937, 5, 8);
        dataCliente = new DataCliente("cbochinche", "Cacho", "Bochinche", "cbochinche@vera.com.uy", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        //file = new File("./src/Presentacion/img/clientes/eleven.jpg");
        //img = ImageIO.read(file);
        cal.set(1971, 12, 31);
        dataCliente = new DataCliente("Eleven11", "Eleven", "o'clock", "Eleven11@gmail.com", cal, img,"");
        ctrlAltaPerfil.altaCliente(dataCliente);
        
        DataArtista dataArtista;      
        String bio;
        
        //file = new File("./src/Presentacion/img/artistas/VillagePeople.jpg");
        //img = ImageIO.read(file);
        cal.set(1977, 1, 1);
        bio = "Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.";
        dataArtista = new DataArtista(bio, "www.officialvillagepeople.com", "vpeople", "Village", "People", "vpeople@tuta.io", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        //file = new File("./src/Presentacion/img/artistas/DepecheMode.jpg");
        //img = ImageIO.read(file);
        cal.set(1980, 6, 14);
        bio = "";
        dataArtista = new DataArtista(bio, "www.depechemode.com", "dmode", "Depeche", "Mode", "dmode@tuta.io", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        //file = new File("./src/Presentacion/img/artistas/CyndiLauper.jpg");
        //img = ImageIO.read(file);
        cal.set(1953, 6, 22);
        bio = "Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participar en el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debut She's So Unusual a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.";
        dataArtista = new DataArtista(bio, "cyndilauper.com", "clauper", "Cyndi", "Lauper", "clauper@hotmail.com", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        //file = new File("./src/Presentacion/img/artistas/BruceTheBoss.jpg");
        //img = ImageIO.read(file);
        cal.set(1949, 9, 23);
        bio = "";
        dataArtista = new DataArtista(bio, "brucespringsteen.net", "bruceTheBoss", "Bruce", "Springsteen", "bruceTheBoss@gmail.com", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        //file = new File("./src/Presentacion/img/artistas/LaTripleNelson.jpg");
        //img = ImageIO.read(file);
        cal.set(1998, 1, 1);
        bio = "La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando Paco"
            +" Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).";
        dataArtista = new DataArtista(bio, "", "tripleNelson", "La Triple", "Nelson", "tripleNelson@tuta.io", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        cal.set(1987, 2, 14);
        bio = "";
        dataArtista = new DataArtista(bio, "", "la_ley", "La", "Ley", "la_ley@tuta.io", cal, null,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        cal.set(1940, 6, 7);
        bio = "Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.";
        dataArtista = new DataArtista(bio, "", "tigerOfWales", "Tom", "Jones", "tigerOfWales@tuta.io", cal, null,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        cal.set(1840, 4, 25);
        bio = "Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo";
        dataArtista = new DataArtista(bio, "", "chaiko", "Piotr", "Tchaikovsky", "chaiko@tuta.io", cal, null,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        //file = new File("./src/Presentacion/img/artistas/NicoleNeumann.jpg");
        //img = ImageIO.read(file);
        cal.set(1980, 10, 31);
        bio = "";
        dataArtista = new DataArtista(bio, "", "nicoleneu", "Nicole", "Neumann", "nicoleneu@hotmail.com", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        //file = new File("./src/Presentacion/img/artistas/Pimpinela.jpg");
        //img = ImageIO.read(file);
        cal.set(1981, 8, 13);
        bio = "";
        dataArtista = new DataArtista(bio, "www.pimpinela.net", "lospimpi", "Pimpinela", "pega la vuelta", "lospimpi@gmail.com", cal, img,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        cal.set(1940, 3, 5);
        bio = "José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.";
        dataArtista = new DataArtista(bio, "", "dyangounchained", "Dyango", "Unchained", "dyangounchained@gmail.com", cal, null,"");
        ctrlAltaPerfil.altaArtista(dataArtista);

        cal.set(1952, 7, 17);
        bio = "Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito Violeta"
            + ", originalmente compuesta e nterpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote».";
        dataArtista = new DataArtista(bio, "", "alcides", "Alcides", "Palacio", "alcides@tuta.io", cal, null,"");
        ctrlAltaPerfil.altaArtista(dataArtista);
            
        
        
        //ALTA DE SEGUIDORES
        IAltaSeguir ctrlSeguir = Fabrica.getIAltaSeguir();
        ctrlSeguir.altaSeguir("el_padrino", "vpeople");
        ctrlSeguir.altaSeguir("el_padrino", "dmode");
        ctrlSeguir.altaSeguir("el_padrino", "clauper");
        ctrlSeguir.altaSeguir("el_padrino", "benKenobi");
        ctrlSeguir.altaSeguir("el_padrino", "lachiqui");
        ctrlSeguir.altaSeguir("el_padrino", "cbochinche");
        ctrlSeguir.altaSeguir("el_padrino", "Eleven11");
        ctrlSeguir.altaSeguir("scarlettO", "dmode");
        ctrlSeguir.altaSeguir("scarlettO", "bruceTheBoss");
        ctrlSeguir.altaSeguir("scarlettO", "tripleNelson");
        ctrlSeguir.altaSeguir("scarlettO", "tigerOfWales");
        ctrlSeguir.altaSeguir("scarlettO", "Heisenberg");
        ctrlSeguir.altaSeguir("scarlettO", "lachiqui");
        ctrlSeguir.altaSeguir("scarlettO", "benKenobi");
        ctrlSeguir.altaSeguir("ppArgento", "dmode");
        ctrlSeguir.altaSeguir("ppArgento", "bruceTheBoss");
        ctrlSeguir.altaSeguir("ppArgento", "tripleNelson");
        ctrlSeguir.altaSeguir("ppArgento", "benKenobi");
        ctrlSeguir.altaSeguir("ppArgento", "lachiqui");
        ctrlSeguir.altaSeguir("ppArgento", "cbochinche");
        ctrlSeguir.altaSeguir("ppArgento", "Eleven11");
        ctrlSeguir.altaSeguir("Heisenberg", "dmode");
        ctrlSeguir.altaSeguir("Heisenberg", "bruceTheBoss");
        ctrlSeguir.altaSeguir("Heisenberg", "tigerOfWales");
        ctrlSeguir.altaSeguir("Heisenberg", "tripleNelson");
        ctrlSeguir.altaSeguir("Heisenberg", "lospimpi");
        ctrlSeguir.altaSeguir("Heisenberg", "dyangounchained");
        ctrlSeguir.altaSeguir("Heisenberg", "alcides");
        ctrlSeguir.altaSeguir("Heisenberg", "el_padrino");
        ctrlSeguir.altaSeguir("Heisenberg", "scarlettO");
        ctrlSeguir.altaSeguir("Heisenberg", "ppArgento");
        ctrlSeguir.altaSeguir("Heisenberg", "benKenobi");
        ctrlSeguir.altaSeguir("Heisenberg", "lachiqui");
        ctrlSeguir.altaSeguir("Heisenberg", "Eleven11");
        ctrlSeguir.altaSeguir("benKenobi", "dmode");
        ctrlSeguir.altaSeguir("benKenobi", "bruceTheBoss");
        ctrlSeguir.altaSeguir("benKenobi", "la_ley");
        ctrlSeguir.altaSeguir("benKenobi", "chaiko");
        ctrlSeguir.altaSeguir("benKenobi", "nicoleneu");
        ctrlSeguir.altaSeguir("benKenobi", "lospimpi");
        ctrlSeguir.altaSeguir("benKenobi", "alcides");
        ctrlSeguir.altaSeguir("benKenobi", "el_padrino");
        ctrlSeguir.altaSeguir("benKenobi", "ppArgento");
        ctrlSeguir.altaSeguir("benKenobi", "lachiqui");
        ctrlSeguir.altaSeguir("benKenobi", "cbochinche");
        ctrlSeguir.altaSeguir("benKenobi", "Eleven11");
        ctrlSeguir.altaSeguir("lachiqui", "bruceTheBoss");
        ctrlSeguir.altaSeguir("lachiqui", "la_ley");
        ctrlSeguir.altaSeguir("lachiqui", "lospimpi");
        ctrlSeguir.altaSeguir("lachiqui", "alcides");
        ctrlSeguir.altaSeguir("lachiqui", "el_padrino");
        ctrlSeguir.altaSeguir("lachiqui", "scarlettO");
        ctrlSeguir.altaSeguir("lachiqui", "ppArgento");
        ctrlSeguir.altaSeguir("cbochinche", "la_ley");
        ctrlSeguir.altaSeguir("cbochinche", "lospimpi");
        ctrlSeguir.altaSeguir("cbochinche", "alcides");
        ctrlSeguir.altaSeguir("cbochinche", "dyangounchained");
        ctrlSeguir.altaSeguir("cbochinche", "ppArgento");
        ctrlSeguir.altaSeguir("Eleven11", "la_ley");
        ctrlSeguir.altaSeguir("Eleven11", "el_padrino");
        ctrlSeguir.altaSeguir("Eleven11", "scarlettO");
        ctrlSeguir.altaSeguir("Eleven11", "ppArgento");
        
        
        //ALTA DE GENEROS
        IAltaGenero ctrlAltaGenero = Fabrica.getIAltaGenero();
        DataGenero dataGenero = new DataGenero("Rock", "");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Rock Clásico", "Rock");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Rock Latino", "Rock");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Rock & Roll", "Rock");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Clásica", "");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Disco", "");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Pop", "");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Electropop", "Pop");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Dance-pop", "Pop");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Pop Clásico", "Pop");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Balada", "");
        ctrlAltaGenero.altaGenero(dataGenero);
        dataGenero = new DataGenero("Cumbia", "");
        ctrlAltaGenero.altaGenero(dataGenero);
        
        String nickArtista;
        String nombreAlbum;
        ArrayList<DataTema> temas;
        ArrayList<String> generos;
        DataAlbumExt dataAlbumExt;
        IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        File tema = null;

        nickArtista = "vpeople";
        nombreAlbum = "Village People Live and Sleazy";
        generos = new ArrayList<String>();
        generos.add("Disco");
        generos.add("Dance-pop");
        generos.add("Pop Clásico");

        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCvpymca", "YMCA", 268, 1, nickArtista, nombreAlbum));
        //tema = new File("./src/Presentacion/mp3/MachoMan.mp3");
        temas.add(new DataTemaArchivo(tema, "Macho Man", 208, 2, nickArtista, nombreAlbum));
        temas.add(new DataTemaWeb("bit.ly/SCvpinthenavy", "In the Navy", 193, 3, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Village People Live and Sleazy", 1980, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "dmode";
        nombreAlbum = "Enjoy The Silence";
        generos = new ArrayList<String>();
        generos.add("Electropop");
        temas = new ArrayList<DataTema>();
        //tema = new File("./src/Presentacion/mp3/PersonalJesus.mp3");
        temas.add(new DataTemaArchivo(tema, "Personal Jesus", 296, 1, nickArtista, nombreAlbum));
        tema = new File("./src/Presentacion/mp3/EnjoyTheSilence.mp3");
        temas.add(new DataTemaArchivo(tema, "Enjoy The Silence", 261, 2, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Violator", 1990, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "clauper";
        nombreAlbum = "She's So Unusual";
        generos = new ArrayList<String>();
        generos.add("Pop Clásico");
        generos.add("Dance-pop");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCclgirlsjustwant", "Girls Just Want To Have Fun", 195, 1, nickArtista, nombreAlbum));
        //tema = new File("./src/Presentacion/mp3/TimeAfterTime.mp3");
        temas.add(new DataTemaArchivo(tema, "Time After Time", 312, 2, nickArtista, nombreAlbum));
        //file = new File("./src/Presentacion/img/albums/ShesSoUnusual.PNG");
        //img = ImageIO.read(file);

        dataAlbumExt = new DataAlbumExt(temas, "She's So Unusual", 1983, generos, img, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "bruceTheBoss";
        nombreAlbum = "Born In The U.S.A.";
        generos = new ArrayList<String>();
        generos.add("Rock Clásico");
        generos.add("Rock & Roll");
        generos.add("Pop Clásico");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCbsborninusa", "Born In The U.S.A.", 298, 1, nickArtista, nombreAlbum));
        temas.add(new DataTemaWeb("bit.ly/SCbsglorydays", "Glory Days", 323, 2, nickArtista, nombreAlbum));
        //tema = new File("./src/Presentacion/mp3/DancingInTheDark.mp3");
        temas.add(new DataTemaArchivo(tema, "Dancing In The Park", 238, 3, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Born In The U.S.A.", 1984, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "tigerOfWales";
        nombreAlbum = "It's Not Unusual";
        generos = new ArrayList<String>();
        generos.add("Rock Clásico");
        generos.add("Pop Clásico");
        temas = new ArrayList<DataTema>();
        tema = new File("./src/Presentacion/mp3/ItSNotUnusual.mp3");
        temas.add(new DataTemaArchivo(tema, "It’s Not Unusual", 120, 1, nickArtista, nombreAlbum));
        //file = new File("./src/Presentacion/img/albums/ItsNotUnusual.jpeg");
        //img = ImageIO.read(file);

        dataAlbumExt = new DataAlbumExt(temas, "It's Not Unusual", 1965, generos, img, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "tripleNelson";
        nombreAlbum = "Agua Y Sal";
        generos = new ArrayList<String>();
        generos.add("Rock Latino");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCtnadagiopais", "Adagio De Mi País", 290, 1, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Agua Y Sal", 2012, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "la_ley";
        nombreAlbum = "MTV Unplugged";
        generos = new ArrayList<String>();
        generos.add("Rock Latino");
        generos.add("Pop Clásico");
        temas = new ArrayList<DataTema>();
        //tema = new File("./src/Presentacion/mp3/ElDuelo.mp3");
        temas.add(new DataTemaArchivo(tema, "El Duelo", 323, 1, nickArtista, nombreAlbum));
        tema = new File("./src/Presentacion/mp3/Mentira.mp3");
        temas.add(new DataTemaArchivo(tema, "Mentira", 288, 2, nickArtista, nombreAlbum));
        //file = new File("./src/Presentacion/img/albums/mtvUnplugged.jpg");
        //img = ImageIO.read(file);

        dataAlbumExt = new DataAlbumExt(temas, "MTV Unplugged", 2001, generos, img, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "chaiko";
        nombreAlbum = "El Lago De Los Cisnes";
        generos = new ArrayList<String>();
        generos.add("Clásica");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCptswanlake", "Acto 2, Número 10, Escena (Moderato)", 160, 1, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "El Lago De Los Cisnes", 1875, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "chaiko";
        nombreAlbum = "Concierto Para Piano No. 1 En Si Menor, Opus 23";
        generos = new ArrayList<String>();
        generos.add("Clásica");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCptpiano", "Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", 1318, 1, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Concierto Para Piano No. 1 En Si Menor, Opus 23", 1875, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "nicoleneu";
        nombreAlbum = "Primer Amor";
        generos = new ArrayList<String>();
        generos.add("Electropop");
        temas = new ArrayList<DataTema>();
        //tema = new File("./src/Presentacion/mp3/NoQuieroEstudiar.mp3");
        temas.add(new DataTemaArchivo(tema, "No Quiero Estudiar", 132, 1, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Primer Amor", 1994, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "lospimpi";
        nombreAlbum = "Hay Amores Que Matan";
        generos = new ArrayList<String>();
        generos.add("Pop Clásico");
        generos.add("Balada");
        temas = new ArrayList<DataTema>();
        //tema = new File("./src/Presentacion/mp3/PorEseHombre.mp3");
        temas.add(new DataTemaArchivo(tema, "Por Ese Hombre", 285, 1, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Hay Amores Que Matan", 1993, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "dyangounchained";
        nombreAlbum = "Un Loco Como Yo";
        generos = new ArrayList<String>();
        generos.add("Pop Clásico");
        generos.add("Balada");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCdyporesehombre", "Por Ese Hombre", 313, 1, nickArtista, nombreAlbum));

        dataAlbumExt = new DataAlbumExt(temas, "Un Loco Como Yo", 1993, generos, null, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);

        nickArtista = "alcides";
        nombreAlbum = "20 Grandes Éxitos";
        generos = new ArrayList<String>();
        generos.add("Cumbia");
        temas = new ArrayList<DataTema>();
        temas.add(new DataTemaWeb("bit.ly/SCvioleta", "Violeta", 116, 1, nickArtista, nombreAlbum));
        //file = new File("./src/Presentacion/img/albums/alcides20.jpg");
        //img = ImageIO.read(file);

        dataAlbumExt = new DataAlbumExt(temas, "20 Grandes Éxitos", 1989, generos, img, nickArtista);
        iAltaAlbum.altaAlbum(dataAlbumExt);
        
        //ALTA DE LISTAS
        //DEFECTO
        IAltaLista ctrlAltaListas = Fabrica.getIAltaLista();

        DataDefecto dataDefecto = new DataDefecto("Pop Clásico", "Noche De La Nostalgia", null);
        ctrlAltaListas.altaListaDefecto(dataDefecto);
        dataDefecto = new DataDefecto("Rock Latino", "Rock En Español", null);
        ctrlAltaListas.altaListaDefecto(dataDefecto);
        dataDefecto = new DataDefecto("Clásica", "Música Clásica", null);
        ctrlAltaListas.altaListaDefecto(dataDefecto);
        
        //PARTICULARES
        
        DataParticular dataParticular = new DataParticular("el_padrino", "Música Inspiradora", null);
        ctrlAltaListas.altaListaParticular(dataParticular);
        dataParticular = new DataParticular("scarlettO", "De Todo Un Poco", null);
        ctrlAltaListas.altaListaParticular(dataParticular);
        dataParticular = new DataParticular("Heisenberg", "Para Cocinar", null);
        ctrlAltaListas.altaListaParticular(dataParticular);
        dataParticular = new DataParticular("lachiqui", "Para Las Chicas", null);
        ctrlAltaListas.altaListaParticular(dataParticular);
        dataParticular = new DataParticular("cbochinche", "Fiesteras", null);
        ctrlAltaListas.altaListaParticular(dataParticular);
        dataParticular = new DataParticular("cbochinche", "Mis Favoritas", null);
        ctrlAltaListas.altaListaParticular(dataParticular);
        
        //PUBLICAR LISTAS
        IPublicarLista ctrlPublicar = Fabrica.getIPublicarLista();
        ctrlPublicar.publicarLista("Música Inspiradora","el_padrino");
        ctrlPublicar.publicarLista("De Todo Un Poco", "scarlettO");
        ctrlPublicar.publicarLista("Para Las Chicas", "lachiqui");
        ctrlPublicar.publicarLista("Fiesteras", "cbochinche");
        
        IFavoritear ifav = Fabrica.getIFavoritear();
        ifav.favoritear("el_padrino", new DataDefecto("","Noche De La Nostalgia", null));
        ifav.favoritear("el_padrino", new DataDefecto("","Música Clásica", null));
        ifav.favoritear("scarlettO", new DataDefecto("","Música Clásica", null));
        ifav.favoritear("ppArgento", new DataDefecto("","Noche De La Nostalgia", null));
        ifav.favoritear("ppArgento", new DataDefecto("","Rock En Español", null));
        ifav.favoritear("Heisenberg", new DataParticular("el_padrino","Música Inspiradora",null));
        ifav.favoritear("cbochinche", new DataDefecto("","Noche De La Nostalgia", null));
        ifav.favoritear("cbochinche", new DataDefecto("","Rock En Español", null));
        ifav.favoritear("el_padrino", new DataAlbum("Violator", 0, null, null, "dmode"));
        ifav.favoritear("el_padrino", new DataAlbum("El Lago De Los Cisnes", 0, null, null, "chaiko"));
        ifav.favoritear("el_padrino", new DataAlbum("Concierto Para Piano No. 1 En Si Menor, Opus 23", 0, null, null, "chaiko"));
        ifav.favoritear("benKenobi", new DataAlbum("El Lago De Los Cisnes", 0, null, null, "chaiko"));
        ifav.favoritear("benKenobi", new DataAlbum("Concierto Para Piano No. 1 En Si Menor, Opus 23", 0, null, null, "chaiko"));
        ifav.favoritear("cbochinche", new DataAlbum("Hay Amores Que Matan", 0, null, null, "lospimpi"));
        ifav.favoritear("el_padrino", new DataTema("El Duelo", 0, 0, "la_ley","MTV Unplugged"));
        ifav.favoritear("ppArgento", new DataTema("Adagio De Mi País", 0, 0, "tripleNelson","Agua Y Sal"));
        ifav.favoritear("cbochinche", new DataTema("Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", 0, 0, "chaiko","Concierto Para Piano No. 1 En Si Menor, Opus 23"));
        ifav.favoritear("Eleven11", new DataTema("No Quiero Estudiar", 0, 0, "nicoleneu","Primer Amor"));

        IAgregarTemaLista iadd = Fabrica.getIAgregarTemaLista();
        iadd.agregarTemaLista(new DataTema("YMCA", 0, 0, "vpeople","Village People Live and Sleazy"), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Macho Man", 0, 0, "vpeople","Village People Live and Sleazy"), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("In the Navy", 0, 0, "vpeople","Village People Live and Sleazy"), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Girls Just Want To Have Fun", 0, 0, "clauper","She's So Unusual"), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Time After Time", 0, 0, "clauper","She\'s So Unusual"), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Born In The U.S.A.", 0, 0, "bruceTheBoss","Born In The U.S.A."), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Dancing In The Park", 0, 0, "bruceTheBoss","Born In The U.S.A."), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Glory Days", 0, 0, "bruceTheBoss","Born In The U.S.A."), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("It’s Not Unusual", 0, 0, "tigerOfWales","It's Not Unusual"), "Noche De La Nostalgia");
        iadd.agregarTemaLista(new DataTema("Adagio De Mi País", 0, 0, "tripleNelson","Agua Y Sal"), "Rock En Español");
        iadd.agregarTemaLista(new DataTema("El Duelo", 0, 0, "la_ley","MTV Unplugged"), "Rock En Español");
        iadd.agregarTemaLista(new DataTema("Mentira", 0, 0, "la_ley","MTV Unplugged"), "Rock En Español");
        iadd.agregarTemaLista(new DataTema("Acto 2, Número 10, Escena (Moderato)", 0, 0, "chaiko","El Lago De Los Cisnes"), "Música Clásica");
        iadd.agregarTemaLista(new DataTema("Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", 0, 0, "chaiko","Concierto Para Piano No. 1 En Si Menor, Opus 23"), "Música Clásica");
        iadd.listarListasDeCliente("el_padrino");
        iadd.agregarTemaLista(new DataTema("Acto 2, Número 10, Escena (Moderato)", 0, 0, "chaiko","El Lago De Los Cisnes"), "Música Inspiradora");
        iadd.agregarTemaLista(new DataTema("Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", 0, 0, "chaiko","Concierto Para Piano No. 1 En Si Menor, Opus 23"), "Música Inspiradora");
        iadd.agregarTemaLista(new DataTema("Personal Jesus", 0, 0, "dmode","Violator"), "Música Inspiradora");
        iadd.listarListasDeCliente("scarlettO");
        iadd.agregarTemaLista(new DataTema("Girls Just Want To Have Fun", 0, 0, "clauper","She's So Unusual"), "De Todo Un Poco");
        iadd.agregarTemaLista(new DataTema("Time After Time", 0, 0, "clauper","She\'s So Unusual"), "De Todo Un Poco");
        iadd.listarListasDeCliente("Heisenberg");
        iadd.agregarTemaLista(new DataTema("Personal Jesus", 0, 0, "dmode","Violator"), "Para Cocinar");
        iadd.listarListasDeCliente("lachiqui");
        iadd.agregarTemaLista(new DataTema("Girls Just Want To Have Fun", 0, 0, "clauper","She's So Unusual"), "Para Las Chicas");
        iadd.agregarTemaLista(new DataTema("It’s Not Unusual", 0, 0, "tigerOfWales","It's Not Unusual"), "Para Las Chicas");
        iadd.agregarTemaLista(new DataTema("Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", 0, 0, "chaiko","Concierto Para Piano No. 1 En Si Menor, Opus 23"), "Para Las Chicas");
        iadd.agregarTemaLista(new DataTema("No Quiero Estudiar", 0, 0, "nicoleneu","Primer Amor"), "Para Las Chicas");
        iadd.agregarTemaLista(new DataTema("Por Ese Hombre", 0, 0, "dyangounchained","Un Loco Como Yo"), "Para Las Chicas");
        iadd.listarListasDeCliente("cbochinche");
        iadd.agregarTemaLista(new DataTema("YMCA", 0, 0, "vpeople","Village People Live and Sleazy"), "Fiesteras");
        iadd.agregarTemaLista(new DataTema("Macho Man", 0, 0, "vpeople","Village People Live and Sleazy"), "Fiesteras");
        iadd.agregarTemaLista(new DataTema("In the Navy", 0, 0, "vpeople","Village People Live and Sleazy"), "Fiesteras");
        iadd.agregarTemaLista(new DataTema("Glory Days", 0, 0, "bruceTheBoss","Born In The U.S.A."), "Fiesteras");
        iadd.agregarTemaLista(new DataTema("Violeta", 0, 0, "alcides","20 Grandes Éxitos"), "Fiesteras");
        iadd.agregarTemaLista(new DataTema("Adagio De Mi País", 0, 0, "tripleNelson","Agua Y Sal"), "Mis Favoritas");
        iadd.agregarTemaLista(new DataTema("Primer Movimiento (Allegro non troppo e molto maestoso – Allegro con spirito)", 0, 0, "chaiko","Concierto Para Piano No. 1 En Si Menor, Opus 23"), "Mis Favoritas");
        iadd.agregarTemaLista(new DataTema("Por Ese Hombre", 0, 0, "lospimpi","Hay Amores Que Matan"), "Mis Favoritas");
        iadd.listarListasDefecto();

    }

}
