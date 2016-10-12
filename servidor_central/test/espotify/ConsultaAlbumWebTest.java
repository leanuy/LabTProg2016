package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;
import espotify.datatypes.DataTemaWeb;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.interfaces.IAltaAlbum;
import espotify.interfaces.web.IVerAlbum;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author JavierM42
 */
public class ConsultaAlbumWebTest {

    IVerAlbum interf;
    
    public ConsultaAlbumWebTest() {
    }
    
    @Before
    public void setUpMethod() throws Exception {
        ManejadorColecciones.clear();
        new AltaPerfilTest().testAltaArtista1();
        Fabrica.getIAltaGenero().altaGenero(new DataGenero("Pop", ""));
        Fabrica.getIAltaGenero().altaGenero(new DataGenero("Jazz", ""));
        new AltaAlbumTest().testAltaAlbum();
        interf = Fabrica.getIVerAlbum();
    }
    
    @Test
    public void testConsultaTema() throws ArtistaInexistenteException, AlbumInexistenteException{
        System.out.println("test consulta tema: web");
        DataTema expResult = new DataTema("tema 1", 160, 1, "ElGordoAxl", "Album 1", true);
        DataTema result = interf.consultaTema("ElGordoAxl","Album 1", "tema 1");
        assertEquals(expResult,result);
    }
    
    @Test
    public void test2ConsultaTema() throws ArtistaInexistenteException, AlbumInexistenteException{
        System.out.println("test consulta tema: archivo");
        DataTema expResult = new DataTema("tema 5", 230, 5, "ElGordoAxl", "Album 1", false);
        DataTema result = interf.consultaTema("ElGordoAxl","Album 1", "tema 5");
        assertEquals(expResult,result);
    }
    
    @Test (expected=ArtistaInexistenteException.class)
    public void test3ConsultaTema() throws ArtistaInexistenteException, AlbumInexistenteException{
        System.out.println("test consulta tema: artista inexistente");
        DataTema result = interf.consultaTema("asdfasdf","Album 1", "tema 5");
    }
    
    @Test (expected=AlbumInexistenteException.class)
    public void test4ConsultaTema() throws ArtistaInexistenteException, AlbumInexistenteException{
        System.out.println("test consulta tema: artista inexistente");
        DataTema result = interf.consultaTema("ElGordoAxl","Alasdfbum 1", "tema 5");
    }
}
