package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Excepciones.YaPublicaException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IDejarDeSeguir;
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
    static CtrlUsuarios ctrl;    

    public CtrlUsuariosTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        ctrl = new CtrlUsuarios();
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
     * Test of ConsultaCliente method, of class CtrlUsuarios.
     */
    @Test
    public void testConsultaCliente() throws ClienteInexistenteException {
        //tests de santiago que hice yo -JM42
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null);
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();

        try {
            ctrl.AltaCliente(d);
        } catch (Exception ex) {
            Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("ConsultaCliente");
        String s = "clienteconsultado";
        DataClienteExt expResult = new DataClienteExt("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null, new String[0], new String[0]);
        IConsultaCliente instance = Fabrica.getIConsultaCliente();

        DataClienteExt result = instance.ConsultaCliente(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of ListarArtistas method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testListarArtistas() {
        System.out.println("ListarArtistas: lista vacía");
        ManejadorColecciones.clear();
        //CtrlUsuarios ctrl = new CtrlUsuarios();
        ArrayList<String> expResult = new ArrayList<>();
        //ArrayList<String> result = ctrl.ListarArtistas();
        //assertEquals(expResult, result);
    }
    @Ignore
    @Test
    public void testListarArtistas2() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("ListarArtistas");
        ManejadorColecciones.clear();
        //CtrlUsuarios ctrl = new CtrlUsuarios();
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista d = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","ElGordoAxl", "Axl", "Rose", "axl@rose.com", cal, null);
        ctrl.AltaArtista(d);
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("ElGordoAxl");
        //ArrayList<String> result = ctrl.ListarArtistas();
        //assertEquals(expResult, result);
    }

    /**
     * Test of ConsultaArtista method, of class CtrlUsuarios.
     */
    @Test
    public void testConsultaArtista() {
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataArtista d = new DataArtista("Soy un artista y me consultan","", "ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null);
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            ctrl.AltaArtista(d);
        } catch (Exception ex) {
            Logger.getLogger(CtrlUsuariosTest.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.out.println("ConsultaArtista");
        String s = "ArtistaConsultado";
        DataArtistaExt expResult = new DataArtistaExt("ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null, "Soy un artista y me consultan", "", new HashMap<String,Album>());
        IConsultaArtista instance = Fabrica.getIConsultaArtista();
        DataArtistaExt result = instance.ConsultaArtista(s);
        assertEquals(expResult, result);
    }

    /**
     * Test of DejarDeSeguir method, of class CtrlUsuarios.
     */
    @Test
    public void testDejarDeSeguir() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();

        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        ctrl2.AltaSeguir("Seguidor", "Seguido");
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Normal");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguido";
        IDejarDeSeguir instance = Fabrica.getIDejarDeSeguir();
        instance.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected=SeguidorInexistenteException.class)
    public void testDejarDeSeguir2() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();
        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        ctrl2.AltaSeguir("Seguidor", "Seguido");
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Seguidor Inexistente");
        String nomSeguidor = "Seguidorasdf";
        String nomSeguido = "Seguido";
        IDejarDeSeguir instance = Fabrica.getIDejarDeSeguir();
        instance.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected=SeguidoInexistenteException.class)
    public void testDejarDeSeguir3() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();
        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        ctrl2.AltaSeguir("Seguidor", "Seguido");
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Seguido Inexistente");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguidoasdf";
        IDejarDeSeguir instance = Fabrica.getIDejarDeSeguir();
        instance.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected=SeguidoInexistenteException.class)
    public void testDejarDeSeguir4() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor2", "Javier", "Morales", "seguidor2@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido2", "Javier", "Morales", "seguido2@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Seguido al que no seguían");
        String nomSeguidor = "Seguidor2";
        String nomSeguido = "Seguido2";
        IDejarDeSeguir instance = Fabrica.getIDejarDeSeguir();
        instance.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    

    /**
     * Test of BuscarCliente method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testBuscarCliente() throws ClienteInexistenteException{
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
    public void testBuscarArtista() throws ArtistaInexistenteException {
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
     * Test of ListarListasDeCliente method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testListarListasDeCliente() throws ClienteInexistenteException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ListaRepetidaException {
        System.out.println("ListarListasDeCliente");
        ArrayList<String> expResult = new ArrayList<>();

        //CtrlUsuarios ctrl = new CtrlUsuarios();
        System.out.println("ListarListasDeCliente");
        ManejadorColecciones.clear();
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("JavierM42", "Javier", "Morales", "javiermorales42@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        CtrlListas ctrlListas = new CtrlListas();
        ctrlListas.AltaListaParticular(new DataParticular("JavierM42","Lista1",null));
        
        expResult.add("Lista1");
        //ArrayList<String> result = ctrl.ListarListasDeCliente("JavierM42");
        //assertEquals(expResult, result);
    }



    /**
     * Test of getSeguidos method, of class CtrlUsuarios.
     */
    @Ignore
    @Test
    public void testGetSeguidos() throws ClienteInexistenteException {
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
    public void testAltaLista() throws ClienteInexistenteException, ListaRepetidaException {
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
    public void testQuitarTemaDeLista() throws ListaInexistenteException, ClienteInexistenteException {
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
