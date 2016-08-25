package espotify;

import espotify.Datatypes.DataGenero;
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
    
}
