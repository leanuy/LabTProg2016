package espotify;

import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class CtrlListasTest {
    
    public CtrlListasTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        CtrlUsuarios cu = CtrlUsuarios.getInstancia();
        try {
            cu.AltaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), "unaimg.jpg"));
            cu.AltaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), "unaimg.jpg"));
        } catch (Exception ex) {
            Logger.getLogger(CtrlListasTest.class.getName()).log(Level.SEVERE, null, ex);
        }
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
     * Test of PublicarLista method, of class CtrlListas.
     */
    @Test
    public void testPublicarLista1() throws Exception {
        System.out.println("PublicarLista: ok");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);      
        instance.PublicarLista("Mi Lista Publica", "TesterLista");
    }
    
    @Test (expected=Exception.class)
    public void testPublicarLista2() throws Exception {
        System.out.println("PublicarLista: nombre de usuario incorrecto");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica que no va a poder", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);      
        instance.PublicarLista("Mi Lista Publica", "TesterListakas.dbg");
    }
    
    @Test (expected=Exception.class)
    public void testPublicarLista3() throws Exception {
        System.out.println("PublicarLista: nombre de lista incorrecto");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica que no va a poder por el nombre", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);      
        instance.PublicarLista("Mi Lista Publicanbasdf", "TesterLista");
    }

    /**
     * Test of ListarClientes method, of class CtrlListas.
     */
    @Ignore
    @Test
    public void testListarClientes() {
        System.out.println("ListarClientes");
        CtrlListas instance = CtrlListas.getInstancia();
        ArrayList<String> expResult = new ArrayList<>();
        ArrayList<String> result = instance.ListarClientes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarListasDeCliente method, of class CtrlListas.
     */
    @Ignore
    @Test
    public void testListarListasDeCliente() throws Exception {
        System.out.println("ListarListasDeCliente");
        String nick = "";
        CtrlListas instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarListasDeCliente(nick);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarListasDefecto method, of class CtrlListas.
     */
    @Ignore
    @Test
    public void testListarListasDefecto() {
        System.out.println("ListarListasDefecto");
        CtrlListas instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarListasDefecto();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarTemasLista method, of class CtrlListas.
     */
    @Ignore
    @Test
    public void testListarTemasLista() throws Exception {
        System.out.println("ListarTemasLista");
        String nombre = "";
        CtrlListas instance = null;
        ArrayList<DataTema> expResult = null;
        ArrayList<DataTema> result = instance.ListarTemasLista(nombre);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of RemoverTemaLista method, of class CtrlListas.
     */
    @Ignore
    @Test
    public void testRemoverTemaLista() throws Exception {
        System.out.println("RemoverTemaLista");
        String nomTema = "";
        String nomAlbum = "";
        CtrlListas instance = null;
        instance.RemoverTemaLista(nomTema, nomAlbum);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of ListarGeneros method, of class CtrlListas.
     */
    @Ignore
    @Test
    public void testListarGeneros() {
        System.out.println("ListarGeneros");
        CtrlListas instance = null;
        ArrayList<String> expResult = null;
        ArrayList<String> result = instance.ListarGeneros();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of AltaListaParticular method, of class CtrlListas.
     */
    @Test
    public void testAltaListaParticular1() throws Exception {
        System.out.println("AltaListaParticular: caso ok");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaListaParticular2() throws Exception {
        System.out.println("AltaListaParticular:usuario inexistente");
        DataParticular d = new DataParticular("no existo yey", "Mi Lista", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);
    }
    
    @Test
    public void testAltaListaParticular3() throws Exception {
        System.out.println("AltaListaParticular:dos clientes con listas de igual nombre");
        DataParticular d = new DataParticular("TesterLista", "Lista que comparte nombre", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);
        d = new DataParticular("TesterLista2", "Lista que comparte nombre", "");
        instance.AltaListaParticular(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaListaParticular4() throws Exception {
        System.out.println("AltaListaParticular:nombre de lista repetido");
        DataParticular d = new DataParticular("TesterLista", "Repetido", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaParticular(d);
        d = new DataParticular("TesterLista", "Repetido", "");
        instance.AltaListaParticular(d);
    }

    /**
     * Test of AltaListaDefecto method, of class CtrlListas.
     */
    @Test
    public void testAltaListaDefecto1() throws Exception {
        System.out.println("AltaListaDefecto: género=Genero");
        DataDefecto d = new DataDefecto("Genero", "Lista genérica", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaDefecto(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaListaDefecto2() throws Exception {
        System.out.println("AltaListaDefecto: género inexistente");
        DataDefecto d = new DataDefecto("aksdnlfaesufmx", "Lista que no va a andar", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaDefecto(d);
    }
    
    @Test (expected=Exception.class)
    public void testAltaListaDefecto3() throws Exception {
        System.out.println("AltaListaDefecto: nombre repetido");
        DataDefecto d = new DataDefecto("Genero", "Soy una lista con un nombre comun", "");
        CtrlListas instance = CtrlListas.getInstancia();
        instance.AltaListaDefecto(d);
        instance.AltaListaDefecto(d);
    }
    
}
