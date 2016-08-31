package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IPublicarLista;
import java.util.Calendar;

public abstract class CtrlDatosIniciales {
    public static void CargarDatosIniciales() throws Exception
    {
        //ALTA DE CLIENTES:
        IAltaPerfil ctrlAltaPerfil = Fabrica.getIAltaPerfil();
        
        Calendar cal = Calendar.getInstance();
        cal.set(1972, 3, 8);
        DataCliente dataCliente = new DataCliente("el_padrino", "Vito", "Corleone", "el_padrino@tuta.io", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1984, 11, 27);
        dataCliente = new DataCliente("scarlettO", "Scarlett", "O'Hara", "scarlettO@tuta.io", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1955, 2, 14);
        dataCliente = new DataCliente("ppArgento", "Pepe", "Argento", "ppArgento@hotmail.com", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1056, 3, 7);
        dataCliente = new DataCliente("Heisenberg", "Walter", "White", "Heisenberg@tuta.io", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1914, 4, 2);
        dataCliente = new DataCliente("benKenobi", "Obi-Wan", "Kenobi", "benKenobi@gmail.com", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1927, 2, 23);
        dataCliente = new DataCliente("lachiqui", "Mirtha", "Legrand", "lachiqui@hotmail.com.ar", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1937, 5, 8);
        dataCliente = new DataCliente("cbochinche", "Cacho", "Bochinche", "cbochinche@vera.com.uy", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        cal.set(1971, 12, 31);
        dataCliente = new DataCliente("Eleven11", "Eleven", " ", "Eleven11@gmail.com", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        
        DataArtista dataArtista;      
        String bio;
        
        cal.set(1, 1, 1977);
        bio = "Village People es una innovadora formación musical de estilo disco de finales de los años 70. Fue famosa tanto por sus peculiares disfraces, como por sus canciones pegadizas, con letras sugerentes y llenas de dobles sentidos.";
        dataArtista = new DataArtista(bio, "www.officialvillagepeople.com", "vpeople", "Village", "People", "vpeople@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(14, 6, 1980);
        bio = "";
        dataArtista = new DataArtista(bio, "www.depechemode.com", "dmode", "Depeche", "Mode", "dmode@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(22, 6, 1953);
        bio = "Cynthia Ann Stephanie Lauper, conocida simplemente como Cyndi Lauper, es una cantautora, actriz y empresaria estadounidense. Después de participar en el grupo musical, Blue Angel, en 1983 firmó con Portrait Records (filial de Epic Records) y lanzó su exitoso álbum debut She's So Unusual a finales de ese mismo año. Siguió lanzando una serie de álbumes en los que encontró una inmensa popularidad, superando los límites de contenido de las letras de sus canciones.";
        dataArtista = new DataArtista(bio, "cyndilauper.com", "clauper", "Cyndi", "Lauper", "clauper@hotmail.com", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(23, 9, 1949);
        bio = "";
        dataArtista = new DataArtista(bio, "brucespringsteen.net", "bruceTheBoss", "Bruce", "Springsteen", "bruceTheBoss@gmail.com", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(1, 1, 1998);
        bio = "La Triple Nelson es un grupo de rock uruguayo formado en enero de 1998 e integrado inicialmente por Christian Cary (guitarra y voz), Fernando Paco"
        +" Pintos (bajo y coros) y Rubén Otonello (actualmente su nuevo baterista es Rafael Ugo).";
        dataArtista = new DataArtista(bio, "", "tripleNelson", "La Triple", "Nelson", "tripleNelson@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(14, 2, 1987);
        bio = "";
        dataArtista = new DataArtista(bio, "", "la_ley", "La", "Ley", "la_ley@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(7, 6, 1940);
        bio = "Sir Thomas John, conocido por su nombre artístico de Tom Jones, es un cantante británico. Ha vendido más de 100 millones de discos en todo el mundo.";
        dataArtista = new DataArtista(bio, "", "tigerOfWales", "Tom", "Jones", "tigerOfWales@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(25, 4, 1840);
        bio = "Piotr Ilich Chaikovski fue un compositor ruso del período del Romanticismo";
        dataArtista = new DataArtista(bio, "", "chaiko", "Piotr", "Tchaikovsky", "chaiko@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(31, 10, 1980);
        bio = "";
        dataArtista = new DataArtista(bio, "", "nicoleneu", "Nicole", "Neumann", "nicoleneu@hotmail.com", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(13, 8, 1981);
        bio = "";
        dataArtista = new DataArtista(bio, "www.pimpinela.net", "lospimpi", "Pimpinela", " ", "lospimpi@gmail.com", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(5, 3, 1940);
        bio = "José Gómez Romero, conocido artísticamente como Dyango es un cantante español de música romántica.";
        dataArtista = new DataArtista(bio, "", "dyangounchained", "Dyango", " ", "dyangounchained@gmail.com", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);

        cal.set(17, 7, 1952);
        bio = "Su carrera comienza en 1976 cuando forma la banda Los Playeros junto a su hermano Víctor. Al poco tiempo se mudan a San Luis donde comienzan a hacerse conocidos en la escena musical. Su éxito a nivel nacional llega a comienzos de los años 1990 cuando desembarca en Buenos Aires y graba el éxito Violeta"
        + ", originalmente compuesta e nterpretada en 1985 por el músico brasileño Luiz Caldas bajo el título «Fricote».";
        dataArtista = new DataArtista(bio, "", "alcides", "Alcides", " ", "alcides@tuta.io", cal, null);
        ctrlAltaPerfil.AltaArtista(dataArtista);
        
        
        
        
        
        //ALTA DE SEGUIDORES
        IAltaSeguir ctrlSeguir = Fabrica.getIAltaSeguir();
        ctrlSeguir.AltaSeguir("el_padrino", "vpeople");
        ctrlSeguir.AltaSeguir("el_padrino", "dmode");
        ctrlSeguir.AltaSeguir("el_padrino", "clauper");
        ctrlSeguir.AltaSeguir("el_padrino", "benKenobi");
        ctrlSeguir.AltaSeguir("el_padrino", "lachiqui");
        ctrlSeguir.AltaSeguir("el_padrino", "cbochinche");
        ctrlSeguir.AltaSeguir("el_padrino", "Eleven11");
        ctrlSeguir.AltaSeguir("scarlettO", "dmode");
        ctrlSeguir.AltaSeguir("scarlettO", "bruceTheBoss");
        ctrlSeguir.AltaSeguir("scarlettO", "tripleNelson");
        ctrlSeguir.AltaSeguir("scarlettO", "tigerOfWales");
        ctrlSeguir.AltaSeguir("scarlettO", "Heisenberg");
        ctrlSeguir.AltaSeguir("scarlettO", "lachiqui");
        ctrlSeguir.AltaSeguir("scarlettO", "benKenobi");
        ctrlSeguir.AltaSeguir("ppArgento", "dmode");
        ctrlSeguir.AltaSeguir("ppArgento", "bruceTheBoss");
        ctrlSeguir.AltaSeguir("ppArgento", "tripleNelson");
        ctrlSeguir.AltaSeguir("ppArgento", "benKenobi");
        ctrlSeguir.AltaSeguir("ppArgento", "lachiqui");
        ctrlSeguir.AltaSeguir("ppArgento", "cbochinche");
        ctrlSeguir.AltaSeguir("ppArgento", "Eleven11");
        ctrlSeguir.AltaSeguir("Heisenberg", "dmode");
        ctrlSeguir.AltaSeguir("Heisenberg", "bruceTheBoss");
        ctrlSeguir.AltaSeguir("Heisenberg", "tigerOfWales");
        ctrlSeguir.AltaSeguir("Heisenberg", "tripleNelson");
        ctrlSeguir.AltaSeguir("Heisenberg", "lospimpi");
        ctrlSeguir.AltaSeguir("Heisenberg", "dyangounchained");
        ctrlSeguir.AltaSeguir("Heisenberg", "alcides");
        ctrlSeguir.AltaSeguir("Heisenberg", "el_padrino");
        ctrlSeguir.AltaSeguir("Heisenberg", "scarlettO");
        ctrlSeguir.AltaSeguir("Heisenberg", "ppArgento");
        ctrlSeguir.AltaSeguir("Heisenberg", "benKenobi");
        ctrlSeguir.AltaSeguir("Heisenberg", "lachiqui");
        ctrlSeguir.AltaSeguir("Heisenberg", "Eleven11");
        ctrlSeguir.AltaSeguir("benKenobi", "dmode");
        ctrlSeguir.AltaSeguir("benKenobi", "bruceTheBoss");
        ctrlSeguir.AltaSeguir("benKenobi", "la_ley");
        ctrlSeguir.AltaSeguir("benKenobi", "chaiko");
        ctrlSeguir.AltaSeguir("benKenobi", "nicoleneu");
        ctrlSeguir.AltaSeguir("benKenobi", "lospimpi");
        ctrlSeguir.AltaSeguir("benKenobi", "alcides");
        ctrlSeguir.AltaSeguir("benKenobi", "el_padrino");
        ctrlSeguir.AltaSeguir("benKenobi", "ppArgento");
        ctrlSeguir.AltaSeguir("benKenobi", "lachiqui");
        ctrlSeguir.AltaSeguir("benKenobi", "cbochinche");
        ctrlSeguir.AltaSeguir("benKenobi", "Eleven11");
        ctrlSeguir.AltaSeguir("lachiqui", "bruceTheBoss");
        ctrlSeguir.AltaSeguir("lachiqui", "la_ley");
        ctrlSeguir.AltaSeguir("lachiqui", "lospimpi");
        ctrlSeguir.AltaSeguir("lachiqui", "alcides");
        ctrlSeguir.AltaSeguir("lachiqui", "el_padrino");
        ctrlSeguir.AltaSeguir("lachiqui", "scarlettO");
        ctrlSeguir.AltaSeguir("lachiqui", "ppArgento");
        ctrlSeguir.AltaSeguir("cbochinche", "la_ley");
        ctrlSeguir.AltaSeguir("cbochinche", "lospimpi");
        ctrlSeguir.AltaSeguir("cbochinche", "alcides");
        ctrlSeguir.AltaSeguir("cbochinche", "dyangounchained");
        ctrlSeguir.AltaSeguir("cbochinche", "ppArgento");
        ctrlSeguir.AltaSeguir("Eleven11", "la_ley");
        ctrlSeguir.AltaSeguir("Eleven11", "el_padrino");
        ctrlSeguir.AltaSeguir("Eleven11", "scarlettO");
        ctrlSeguir.AltaSeguir("Eleven11", "ppArgento");
        
        
        //ALTA DE GENEROS
        IAltaGenero ctrlAltaGenero = Fabrica.getIAltaGenero();
        DataGenero dataGenero = new DataGenero("Rock", "");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Rock Clásico", "Rock");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Rock Latino", "Rock");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Rock & Roll", "Rock");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Clásica", "");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Disco", "");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Pop", "");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Electropop", "Pop");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Dance-pop", "Pop");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Pop Clásico", "Pop");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Balada", "");
        ctrlAltaGenero.AltaGenero(dataGenero);
        dataGenero = new DataGenero("Cumbia", "");
        ctrlAltaGenero.AltaGenero(dataGenero);
        
        
        //ALTA DE LISTAS
        //DEFECTO
        IAltaLista ctrlAltaListas = Fabrica.getIAltaLista();

        DataDefecto dataDefecto = new DataDefecto("Pop Clásico", "Noche De La Nostalgia", null);
        ctrlAltaListas.AltaListaDefecto(dataDefecto);
        dataDefecto = new DataDefecto("Rock Latino", "Rock En Español", null);
        ctrlAltaListas.AltaListaDefecto(dataDefecto);
        dataDefecto = new DataDefecto("Clásica", "Música Clásica", null);
        ctrlAltaListas.AltaListaDefecto(dataDefecto);
        
        //PARTICULARES
        
        DataParticular dataParticular = new DataParticular("el_padrino", "Música Inspiradora", null);
        ctrlAltaListas.AltaListaParticular(dataParticular);
        dataParticular = new DataParticular("scarlettO", "De Todo Un Poco", null);
        ctrlAltaListas.AltaListaParticular(dataParticular);
        dataParticular = new DataParticular("Heisenberg", "Para Cocinar", null);
        ctrlAltaListas.AltaListaParticular(dataParticular);
        dataParticular = new DataParticular("lachiqui", "Para Las Chicas", null);
        ctrlAltaListas.AltaListaParticular(dataParticular);
        dataParticular = new DataParticular("cbochinche", "Fiesteras", null);
        ctrlAltaListas.AltaListaParticular(dataParticular);
        dataParticular = new DataParticular("cbochinche", "Mis Favoritas", null);
        ctrlAltaListas.AltaListaParticular(dataParticular);
        
        //PUBLICAR LISTAS
        IPublicarLista ctrlPublicar = Fabrica.getIPublicarLista();
        ctrlPublicar.PublicarLista("Música Inspiradora","el_padrino");
        ctrlPublicar.PublicarLista("De Todo Un Poco", "scarlettO");
        ctrlPublicar.PublicarLista("Para Las Chicas", "lachiqui");
        ctrlPublicar.PublicarLista("Fiesteras", "cbochinche");

        
        
 
        
        
       
        
        
        
 
    }
    
    
}
