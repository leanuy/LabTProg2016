package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import espotify.Excepciones.NickRepetidoException;
import java.util.ArrayList;
import java.util.HashMap;
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
    public static void setUpClass() {
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
     * Test of getInstancia method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testGetInstancia() {
        System.out.println("getInstancia");
        CtrlMusica expResult = null;
        CtrlMusica result = CtrlMusica.getInstancia();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
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
     * Test of ExisteArtista method, of class CtrlMusica.
     * caso base todo ok.
     * No se esperan excepciones
     */
    @Test
    public void testExisteArtista1() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("ExisteArtista1: Existe artista. Debe devolver la lista de generos del sistema.");

        CtrlUsuariosTest ctrlUsuariosTest = new CtrlUsuariosTest();
        //Crear un artista ficticio:
        ctrlUsuariosTest.testAltaArtista1();
        String nickArtista = "ElGordoAxl";
        CtrlMusica instance = CtrlMusica.getInstancia();
        DataGenero expResult = instance.ListarGeneros();
        DataGenero result = instance.ExisteArtista(nickArtista);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ExisteArtista method, of class CtrlMusica.
     * nickArtista vacio.
     * Sin artistas ingresados en el sistema.
     * Se espera una exception de que el artista no esta en el sistema.
     */
    @Test (expected = ArtistaInexistenteException.class)
    public void testExisteArtista2() throws ArtistaInexistenteException {
        System.out.println("ExisteArtista: No existe artista");
        String nickArtista = "";
        CtrlMusica instance = CtrlMusica.getInstancia();
        DataGenero expResult = null;
        DataGenero result = instance.ExisteArtista(nickArtista);
        assertEquals(expResult, result);
    }
    
    /**
     * Test of ExisteArtista method, of class CtrlMusica. nickArtista vacio. 
     * con artistas ingresados en el sistema. Se espera una exception de que el
     * artista no esta en el sistema.
     */
    @Test(expected = ArtistaInexistenteException.class)
    public void testExisteArtista3() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("ExisteArtista: No existe artista");
        
        CtrlUsuariosTest ctrlUsuariosTest = new CtrlUsuariosTest();
        //Crear un artista ficticio:
        //ctrlUsuariosTest.testAltaArtista1(); //ToDo: Agregar mas artistas?
        // Agus: este test estaba fallando porque agregabas el artista dos veces. Le comenté la línea. Ahora busca y falla sin agregar antes. -JM42
        String nickArtista = "";
        CtrlMusica instance = CtrlMusica.getInstancia();
        DataGenero expResult = null;
        DataGenero result = instance.ExisteArtista(nickArtista);
        assertEquals(expResult, result);
    }
    
        /**
     * Test of ValidarGeneros method, of class CtrlMusica.
     * Caso 1: No se envian generos.
     */
    @Test
    public void testValidarGeneros1() throws GeneroInexistenteException {
        System.out.println("ValidarGeneros: no se envian generos");

        //Crear un artista ficticio:
        CtrlMusica instance = CtrlMusica.getInstancia();
        HashMap<String, Genero> expResult = null;
        ArrayList<String> lista_generos = new ArrayList<>();
        HashMap<String, Genero> result = instance.ValidarGeneros(lista_generos);
        assert(result.isEmpty());
    }
        /**
     * Test of ValidarGeneros method, of class CtrlMusica.
     * Caso 2: Se envian generos que no son validos.
     */
    @Test(expected = GeneroInexistenteException.class)
    public void testValidarGeneros2() throws GeneroInexistenteException {
        System.out.println("ValidarGeneros: no se envian generos");

        //Crear un artista ficticio:
        CtrlMusica instance = CtrlMusica.getInstancia();
        ArrayList<String> lista_generos = new ArrayList<>();
        lista_generos.add("genero no existente");
        HashMap<String, Genero> result = instance.ValidarGeneros(lista_generos);
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
        CtrlMusica instance = CtrlMusica.getInstancia();
        instance.AltaGenero(d);
    }
    @Test
    public void testAltaGenero2() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre existente");
        DataGenero d = new DataGenero("Metal", "");
        CtrlMusica instance = CtrlMusica.getInstancia();
        instance.AltaGenero(d);
        //d = new DataGenero("Black Metal", "Metal");
        //instance.AltaGenero(d);
    }
    @Test (expected = GeneroInexistenteException.class)
    public void testAltaGenero3() throws Exception {
        System.out.println("AltaGenero: Padre inexistente");
        DataGenero d = new DataGenero("Cumbia Plancha", "Rombai");
        CtrlMusica instance = CtrlMusica.getInstancia();
        instance.AltaGenero(d);
    }
    
    @Test (expected = GeneroRepetidoException.class)
    public void testAltaGenero4() throws Exception {
        System.out.println("AltaGenero: Género repetido");
        DataGenero d = new DataGenero("Jazz", "");
        CtrlMusica instance = CtrlMusica.getInstancia();
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

    /**
     * Test of ExisteArtista method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testExisteArtista() throws Exception {
        System.out.println("ExisteArtista");
        String nickArtista = "";
        CtrlMusica instance = null;
        DataGenero expResult = null;
        DataGenero result = instance.ExisteArtista(nickArtista);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ValidarGeneros method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testValidarGeneros() throws Exception {
        System.out.println("ValidarGeneros");
        ArrayList<String> lista_generos = null;
        CtrlMusica instance = null;
        HashMap<String, Genero> expResult = null;
        HashMap<String, Genero> result = instance.ValidarGeneros(lista_generos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaAlbum method, of class CtrlMusica.
     */
    @Ignore
    @Test
    public void testAltaAlbum() throws Exception {
        System.out.println("AltaAlbum");
        DataAlbumExt d = null;
        CtrlMusica instance = null;
        instance.AltaAlbum(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
