package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class CtrlUsuariosTest {
    
    public CtrlUsuariosTest() {
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
     * Test of ListarClientes method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testListarClientes() {
        System.out.println("ListarClientes");
        CtrlUsuarios instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultaCliente method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testConsultaCliente() {
        //tests de santiago que hice yo -JM42
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        try {
            instance.AltaCliente(d);
        } catch (Exception ex) {
            Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("ConsultaCliente");
        String s = "clienteconsultado";
        DataClienteExt expResult = new DataClienteExt("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null, new HashMap<String,Usuario>(), new HashMap<String,Particular>());
        DataClienteExt result = instance.ConsultaCliente(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of ListarArtistas method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testListarArtistas() {
        System.out.println("ListarArtistas");
        CtrlUsuarios instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarArtistas();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ConsultaArtista method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testConsultaArtista() {
        System.out.println("ConsultaArtista");
        String s = null;
        CtrlUsuarios instance = null;
        DataArtistaExt expResult = null;
        DataArtistaExt result = instance.ConsultaArtista(s);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaSeguir method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testAltaSeguir() throws Exception {
        System.out.println("AltaSeguir");
        String nomSeguidor = "";
        String nomSeguido = "";
        CtrlUsuarios instance = null;
        instance.AltaSeguir(nomSeguidor, nomSeguido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DejarDeSeguir method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testDejarDeSeguir() throws Exception {
        System.out.println("DejarDeSeguir");
        String nomSeguidor = "";
        String nomSeguido = "";
        CtrlUsuarios instance = null;
        instance.DejarDeSeguir(nomSeguidor, nomSeguido);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaCliente method, of class CtrlUsuarios.
     */
    @Test
    public void testAltaCliente1() throws Exception {
        System.out.println("AltaCliente: ingreso normal");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("JavierM42", "Javier", "Morales", "javiermorales42@hotmail.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaCliente(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaCliente2() throws Exception {
        System.out.println("AltaCliente: campo vacío");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("", "Javier", "Morales", "javiermorales42@hotmail.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaCliente(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaCliente3() throws Exception {
        System.out.println("AltaCliente: nick repetido.");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("b", "Javier", "Morales", "javiermorales422@hotmail.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaCliente(d);
        d = new DataCliente("b", "Javier", "Morales", "javiermorales4222@hotmail.com", cal, null);
        instance.AltaCliente(d);
    }

    @Test (expected=Exception.class)
    public void testAltaCliente4() throws Exception {
        System.out.println("AltaCliente: correo repetido.");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("d", "Javier", "Morales", "a@hotmail.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaCliente(d);
        d = new DataCliente("e", "Javier", "Morales", "a@hotmail.com", cal, null);
        instance.AltaCliente(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaCliente5() throws Exception {
        System.out.println("AltaCliente: correo sin formato de correo.");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("e", "Javier", "Morales", "hola", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaCliente(d);
    }
    
    /**
     * Test of AltaArtista method, of class CtrlUsuarios.
     * @return 
     */
    @Test
    public void testAltaArtista1() throws Exception {
        System.out.println("AltaArtista: ingreso normal");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","ElGordoAxl", "Axl", "Rose", "axl@rose.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaArtista(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaArtista2() throws Exception {
        System.out.println("AltaArtista: campo vacío");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","", "Axl", "Rose", "axl2@rose.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaArtista(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaArtista3() throws Exception {
        System.out.println("AltaArtista: nick repetido");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl3", "Axl", "Rose", "axl3@rose.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaArtista(d);
        d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl3", "Axl", "Rose", "axl33@rose.com", cal, null);
        instance.AltaArtista(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaArtista4() throws Exception {
        System.out.println("AltaArtista: correo repetido");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl4", "Axl", "Rose", "axl4@rose.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaArtista(d);
        d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl4", "Axl", "Rose", "axl4@rose.com", cal, null);
        instance.AltaArtista(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaArtista5() throws Exception {
        System.out.println("AltaArtista: correo sin formato de correo");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl4", "Axl", "Rose", "axl4rose.com", cal, null);
        CtrlUsuarios instance = CtrlUsuarios.getInstancia();
        instance.AltaArtista(d);
    }

    /**
     * Test of BuscarCliente method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testBuscarCliente() throws Exception{
        System.out.println("BuscarCliente");
        String nick = "";
        CtrlUsuarios instance = null;
        Cliente expResult = null;
        Cliente result = instance.BuscarCliente(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of BuscarArtista method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testBuscarArtista() throws Exception {
        System.out.println("BuscarArtista");
        String nick = "";
        CtrlUsuarios instance = null;
        Artista expResult = null;
        Artista result = instance.BuscarArtista(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of PublicarLista method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testPublicarLista() throws Exception {
        System.out.println("PublicarLista");
        String nomLista = "";
        String nick = "";
        CtrlUsuarios instance = null;
        instance.PublicarLista(nomLista, nick);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarListasDeCliente method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testListarListasDeCliente() throws Exception {
        System.out.println("ListarListasDeCliente");
        String nick = "";
        CtrlUsuarios instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarListasDeCliente(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarTemasDeLista method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testListarTemasDeLista() throws Exception {
        System.out.println("ListarTemasDeLista");
        String nick = "";
        String nombre = "";
        CtrlUsuarios instance = null;
        ArrayList<DataTema> expResult = null;
        ArrayList<DataTema> result = instance.ListarTemasDeLista(nick, nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DevolverClientes method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testDevolverClientes() {
        System.out.println("DevolverClientes");
        CtrlUsuarios instance = null;
        String[] expResult = null;
        String[] result = instance.DevolverClientes();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of DevolverArtistas method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testDevolverArtistas() {
        System.out.println("DevolverArtistas");
        CtrlUsuarios instance = null;
        String[] expResult = null;
        String[] result = instance.DevolverArtistas();
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getSeguidos method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testGetSeguidos() {
        System.out.println("getSeguidos");
        String usr = "";
        CtrlUsuarios instance = null;
        String[] expResult = null;
        String[] result = instance.getSeguidos(usr);
        assertArrayEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaLista method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testAltaLista() throws Exception {
        System.out.println("AltaLista");
        DataParticular d = null;
        CtrlUsuarios instance = null;
        instance.AltaLista(d);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of QuitarTemaDeLista method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testQuitarTemaDeLista() throws Exception {
        System.out.println("QuitarTemaDeLista");
        String nick = "";
        String nomLista = "";
        String nomTema = "";
        String nomAlbum = "";
        CtrlUsuarios instance = null;
        instance.QuitarTemaDeLista(nick, nomLista, nomTema, nomAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
