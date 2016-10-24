/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.web.IObtenerAudio;
import java.io.IOException;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author JavierM42
 */
public class ObtenerAudioTest {
    
    private static IObtenerAudio interf;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        interf = Fabrica.getIObtenerAudio();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, ""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null, ""));
            new AltaPerfilTest().testAltaArtista1();
            IAltaGenero interfazGenero = Fabrica.getIAltaGenero();
            interfazGenero.altaGenero(new DataGenero("Pop", ""));
            interfazGenero.altaGenero(new DataGenero("Jazz", ""));
            new AltaAlbumTest().testAltaAlbum();
        } catch (Exception ex) {
             Logger.getLogger("Algo salió mal").log(Level.SEVERE, null, ex);
        }
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void testAudio() throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException {
        System.out.println("Obtener audio: artista inexistente");
        interf.getAudio("asdf", "asdf", "asdf",false);
    }
    
    @Test (expected = AlbumInexistenteException.class)
    public void testAudio2() throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException {
        System.out.println("Obtener audio: album inexistente");
        interf.getAudio("ElGordoAxl", "asdf", "asdf",false);
    }
    
    @Test (expected = TemaTipoInvalidoException.class)
    public void testAudio3() throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException {
        System.out.println("Obtener audio: el tema es web");
        interf.getAudio("ElGordoAxl", "Album 1", "tema 1",false);
    }
    
    @Test (expected = TemaTipoInvalidoException.class)
    public void testAudio5() throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException {
        System.out.println("Obtener audio: el tema no existe");
        interf.getAudio("ElGordoAxl", "Album 1", "tema asdf1",false);
    }
    
    @Test
    public void testAudio4() throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException, IOException {
        System.out.println("Obtener audio: ok");
        assert interf.getAudio("ElGordoAxl", "Album 1", "tema 5",false) != null;
    }
    
    
}
