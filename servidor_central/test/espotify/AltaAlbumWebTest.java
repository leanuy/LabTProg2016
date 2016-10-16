/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import static espotify.AltaAlbumTest.iAltaAlbum;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;
import espotify.datatypes.DataTemaWeb;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.GeneroRepetidoException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.web.IAltaAlbumWeb;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author JavierM42
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaAlbumWebTest {
    
    private static IAltaAlbumWeb interf;
    
    @BeforeClass
    public static void setUpClass() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, GeneroInexistenteException, GeneroRepetidoException {
        interf = Fabrica.getIAltaAlbumWeb();
        new AltaPerfilTest().testAltaArtista1();
        IAltaGenero interf = Fabrica.getIAltaGenero();
        interf.altaGenero(new DataGenero("Pop", ""));
        interf.altaGenero(new DataGenero("Jazz", ""));
    }
        
    @Test
    public void testAAGetAlbumTemp() throws ArtistaInexistenteException {
        System.out.println("obtener album temporal: ningun album temporal");
        assertEquals(interf.getAlbumTemp("ElGordoAxl"),null);
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void testGetAlbumTemp2() throws ArtistaInexistenteException {
        System.out.println("obtener album temporal: artista inexistente");
        interf.getAlbumTemp("ElGordasdfoAxl");
    }
    
    @Test
    public void testAltaAlbum() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 1");

        String nombre = "Apetite for Destruction";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "Apetite for Destruction");
        
        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        
        interf.aceptarAltaAlbum("ElGordoAxl");
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void testAltaAlbum2() throws ArtistaInexistenteException {
        System.out.println("Alta Album - Test 2: artista inexistente");

        String nombre = "Apetite for Destruction";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGasdfordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);  
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void testAltaAlbum3() throws ArtistaInexistenteException {
        System.out.println("Alta Album - Test 3: artista inexistente al agregar el tema");

        String nombre = "Apetite for Destruction";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "Apetite for Destruction");
        
        interf.addTemaAlbumTemp("ElGorasdfdoAxl", tema);
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void testAltaAlbum4() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 4: artista inexistente al confirmar");

        String nombre = "Apetite for Destruction";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "Apetite for Destruction");
        
        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        
        interf.aceptarAltaAlbum("ElGoasdfrdoAxl");
    }
    
    @Test (expected = AlbumRepetidoException.class)
    public void testAltaAlbum5() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 5: album repetido.");

        String nombre = "Apetite for Destruction";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "Apetite for Destruction");
        
        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        
        interf.aceptarAltaAlbum("ElGordoAxl");
    }  
    
    @Test (expected = GeneroInexistenteException.class)
    public void testAltaAlbum6() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 6: género inexistente.");

        String nombre = "GNR Lies";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop Salado");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "GNR Lies");
        
        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        
        interf.aceptarAltaAlbum("ElGordoAxl");
    }
    
    @Test (expected = DuracionInvalidaException.class)
    public void testAltaAlbum7() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 7: duración inválida.");

        String nombre = "GNR Lies";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 0, 1, "ElGordoAxl", "GNR Lies");
        
        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        
        interf.aceptarAltaAlbum("ElGordoAxl");
    }
    
    @Test (expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbum8() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 8: duración inválida.");

        String nombre = "GNR Lies";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 42, "ElGordoAxl", "GNR Lies");
        
        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        
        interf.aceptarAltaAlbum("ElGordoAxl");
    }
    
    @Test (expected = TemaRepetidoException.class)
    public void testAltaAlbum9() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 9: duración inválida.");

        String nombre = "GNR Lies";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "GNR Lies");
        DataTema tema2 = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 2, "ElGordoAxl", "GNR Lies");

        interf.addTemaAlbumTemp("ElGordoAxl", tema);
        interf.addTemaAlbumTemp("ElGordoAxl", tema2);

        interf.aceptarAltaAlbum("ElGordoAxl");
    }
    
    @Test (expected = CampoVacioException.class)
    public void testAltaAlbum10() throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        System.out.println("Alta Album - Test 10: campo vacío.");

        String nombre = "";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(nombre, anio, generos, img, nickArtista);
        interf.addAlbumTemp(data);
        
        DataTema tema = new DataTemaWeb("url1", "Sweet Child O' Mine", 160, 1, "ElGordoAxl", "");

        interf.addTemaAlbumTemp("ElGordoAxl", tema);

        interf.aceptarAltaAlbum("ElGordoAxl");
    }
    
}
