package espotify;

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
        dataCliente = new DataCliente("Eleven11", "Eleven", " ", "Eleven11@gmail.com", cal, null);
        ctrlAltaPerfil.AltaCliente(dataCliente);
        
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
        
        
        
    }
    
    
}
