package espotify;

import espotify.Datatypes.DataGenero;
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
    public void testBuscarGenero() {
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
    public void testExisteArtista1() throws Exception {
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
    @Test (expected = Exception.class)
    public void testExisteArtista2() throws Exception {
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
    @Test(expected = Exception.class)
    public void testExisteArtista3() throws Exception {
        System.out.println("ExisteArtista: No existe artista");
        
        CtrlUsuariosTest ctrlUsuariosTest = new CtrlUsuariosTest();
        //Crear un artista ficticio:
        ctrlUsuariosTest.testAltaArtista1(); //ToDo: Agregar mas artistas?

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
    public void testValidarGeneros1() throws Exception {
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
    @Test(expected = Exception.class)
    public void testValidarGeneros2() throws Exception {
        System.out.println("ValidarGeneros: no se envian generos");

        //Crear un artista ficticio:
        CtrlMusica instance = CtrlMusica.getInstancia();
        ArrayList<String> lista_generos = new ArrayList<>();
        lista_generos.add("genero no existente");
        HashMap<String, Genero> result = instance.ValidarGeneros(lista_generos);
    }
    
}
