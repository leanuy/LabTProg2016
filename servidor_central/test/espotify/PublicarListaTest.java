package espotify;

import static org.junit.Assert.assertEquals;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.YaPublicaException;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IPublicarLista;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class PublicarListaTest {
    static IPublicarLista iPublicarLista;
    
    public PublicarListaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iPublicarLista = Fabrica.getIPublicarLista();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null,""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null,""));
            DataParticular dLista = new DataParticular("TesterLista", "Mi Lista Publica", null);
            IAltaLista instance = Fabrica.getIAltaLista();
            instance.altaListaParticular(dLista);
        } catch (Exception ex) {
        }
    }

    @Test
    public void test2PublicarLista1() throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException, ListaRepetidaException {
        System.out.println("PublicarLista: ok");
        iPublicarLista.publicarLista("Mi Lista Publica", "TesterLista");
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void test8PublicarLista2() throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException, ListaRepetidaException {
        System.out.println("PublicarLista: nombre de usuario incorrecto");
        DataParticular dLista = new DataParticular("TesterLista", "Mi Lista Publica que no va a poder", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.altaListaParticular(dLista);   
        iPublicarLista.publicarLista("Mi Lista Publica", "TesterListakas.dbg");
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void test9PublicarLista3() throws ClienteInexistenteException, ListaInexistenteException, ListaRepetidaException, YaPublicaException {
        System.out.println("PublicarLista: nombre de lista incorrecto");
        DataParticular dLista = new DataParticular("TesterLista", "Mi Lista Publica que no va a poder por el nombre", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.altaListaParticular(dLista); 
        iPublicarLista.publicarLista("Mi Lista Publicanbasdf", "TesterLista");
    }
    
    @Test
    public void test1ListarListasPrivadasDeCliente() throws ClienteInexistenteException, ListaInexistenteException, YaPublicaException, ListaRepetidaException {
        System.out.println("ListarListasPrivadasDeCliente:");
        List<String> result = iPublicarLista.listarListasPrivadasDeCliente("TesterLista");
        List<String> expResult = new ArrayList<>();
        expResult.add("Mi Lista Publica");
        assertEquals(expResult,result);
    }
    
    @Test
    public void test3ListarListasPrivadasDeCliente() throws ClienteInexistenteException {
        System.out.println("ListarListasPrivadasDeCliente:no hay");
        List<String> result = iPublicarLista.listarListasPrivadasDeCliente("TesterLista");
        List<String> expResult = new ArrayList<>();
        assertEquals(expResult,result);
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void testListarListasPrivadasDeCliente() throws ClienteInexistenteException {
        System.out.println("ListarListasPrivadasDeCliente:cliente inexistente");
        List<String> result = iPublicarLista.listarListasPrivadasDeCliente("TesasdfterLista");
    }
    
    @Test (expected = YaPublicaException.class)
    public void tirameLaExcepcionPapa() throws YaPublicaException, ListaRepetidaException, ClienteInexistenteException, ListaInexistenteException {
        DataParticular dLista = new DataParticular("TesterLista", "Mi Lista Publica D", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.altaListaParticular(dLista);
        iPublicarLista.publicarLista("Mi Lista Publica", "TesterLista");
        iPublicarLista.publicarLista("Mi Lista Publica", "TesterLista");
    }
}
