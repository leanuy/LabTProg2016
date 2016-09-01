package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaGenero;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class CtrlMusicaTest {
    
    public CtrlMusicaTest() {
    }
    
    @BeforeClass
    public static void setUpClass() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of BuscarGenero method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testBuscarGenero() throws GeneroInexistenteException {
        System.out.println("BuscarGenero");
        String genero = "";
        CtrlMusica instance = null;
        Genero expResult = null;
        Genero result = instance.BuscarGenero(genero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
    
    
    /**
     * Test of ConsultaAlbum method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testConsultaAlbum() throws Exception {
        System.out.println("ConsultaAlbum");
        String nomAlbum = "";
        String nomArtista = "";
        CtrlMusica instance = null;
        DataAlbumExt expResult = null;
        DataAlbumExt result = instance.ConsultaAlbum(nomAlbum, nomArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarGeneros method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testListarGeneros() {
        System.out.println("ListarGeneros");
        CtrlMusica instance = null;
        DataGenero expResult = null;
        DataGenero result = instance.ListarGeneros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaGenero method, of class CtrlMusica.
     */
    @Test
    public void testAltaGenero() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre nulo");
        DataGenero d = new DataGenero("Rock", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
    }
    @Test
    public void testAltaGenero2() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre existente");
        DataGenero d = new DataGenero("Metal", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
        //d = new DataGenero("Black Metal", "Metal");
        //instance.AltaGenero(d);
    }
    @Test (expected = GeneroInexistenteException.class)
    public void testAltaGenero3() throws Exception {
        System.out.println("AltaGenero: Padre inexistente");
        DataGenero d = new DataGenero("Cumbia Plancha", "Rombai");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
    }
    
    @Test (expected = GeneroRepetidoException.class)
    public void testAltaGenero4() throws Exception {
        System.out.println("AltaGenero: Género repetido");
        DataGenero d = new DataGenero("Jazz", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
        instance.AltaGenero(d);
    }

    /**
     * Test of ListarAlbumesDeGenero method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testListarAlbumesDeGenero() throws Exception {
        System.out.println("ListarAlbumesDeGenero");
        String nomGenero = "";
        CtrlMusica instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.ListarAlbumesDeGenero(nomGenero);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarArtistas method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testListarArtistas() {
        System.out.println("ListarArtistas");
        CtrlMusica instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarArtistas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarAlbumesDeArtista method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testListarAlbumesDeArtista() throws Exception {
        System.out.println("ListarAlbumesDeArtista");
        String nomArtista = "";
        CtrlMusica instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarAlbumesDeArtista(nomArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

}
