package espotify;

import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataParticular;
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
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IPublicarLista;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PublicarListaTest {
    static IPublicarLista iPublicarLista;
    
    public PublicarListaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iPublicarLista = Fabrica.getIPublicarLista();
        IAltaPerfil cu = Fabrica.getIAltaPerfil();
        try {
            cu.AltaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null,""));
            cu.AltaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null,""));
            DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica", null);
            IAltaLista instance = Fabrica.getIAltaLista();
            instance.AltaListaParticular(d);
        } catch (Exception ex) {
        }
    }

    @Test
    public void test2PublicarLista1() throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException, ListaRepetidaException {
        System.out.println("PublicarLista: ok");
        iPublicarLista.PublicarLista("Mi Lista Publica", "TesterLista");
    }
    
    @Test (expected=ClienteInexistenteException.class)
    public void test8PublicarLista2() throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException, ListaRepetidaException {
        System.out.println("PublicarLista: nombre de usuario incorrecto");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica que no va a poder", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);   
        iPublicarLista.PublicarLista("Mi Lista Publica", "TesterListakas.dbg");
    }
    
    @Test (expected=ListaInexistenteException.class)
    public void test9PublicarLista3() throws ClienteInexistenteException, ListaInexistenteException, ListaRepetidaException, YaPublicaException {
        System.out.println("PublicarLista: nombre de lista incorrecto");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica que no va a poder por el nombre", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d); 
        iPublicarLista.PublicarLista("Mi Lista Publicanbasdf", "TesterLista");
    }
    
    @Test
    public void test1ListarListasPrivadasDeCliente() throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException, ListaRepetidaException {
        System.out.println("ListarListasPrivadasDeCliente:");
        ArrayList<String> result = iPublicarLista.ListarListasPrivadasDeCliente("TesterLista");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("Mi Lista Publica");
        assertEquals(expResult,result);
    }
    
    @Test
    public void test3ListarListasPrivadasDeCliente() throws ClienteInexistenteException {
        System.out.println("ListarListasPrivadasDeCliente:no hay");
        ArrayList<String> result = iPublicarLista.ListarListasPrivadasDeCliente("TesterLista");
        ArrayList<String> expResult = new ArrayList<>();
        assertEquals(expResult,result);
    }
    
    @Test (expected=ClienteInexistenteException.class)
    public void testListarListasPrivadasDeCliente() throws ClienteInexistenteException {
        System.out.println("ListarListasPrivadasDeCliente:cliente inexistente");
        ArrayList<String> result = iPublicarLista.ListarListasPrivadasDeCliente("TesasdfterLista");
    }
    
    @Test (expected=YaPublicaException.class)
    public void tirameLaExcepcionPapa() throws YaPublicaException, ListaRepetidaException, ClienteInexistenteException, ListaInexistenteException {
        DataParticular d = new DataParticular("TesterLista", "Mi Lista Publica D", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);
        iPublicarLista.PublicarLista("Mi Lista Publica", "TesterLista");
        iPublicarLista.PublicarLista("Mi Lista Publica", "TesterLista");
    }
}
