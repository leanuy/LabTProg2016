package espotify;

import static org.junit.Assert.assertEquals;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataLista;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IConsultaLista;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ConsultaListaTest {
    static IConsultaLista iConsultaLista;

    public ConsultaListaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iConsultaLista = Fabrica.getIConsultaLista();
        new AltaListaTest().testAltaListaDefecto1();
        try {
            IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
            Calendar cal = Calendar.getInstance();
            cal.set(2001, 1, 1);
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", cal, null,""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", cal, null,""));
        } catch (Exception ex) {
        }
        new AltaListaTest().testAltaListaParticular1();
    }
    
    @Test
    public void testListarGeneros() {
        System.out.println("Listar Generos (llama al otro controlador, en donde ya está testeado)");
        DataGenero result = iConsultaLista.listarGeneros();
        DataGenero expResult = new DataGenero("Genero","",new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testListarListasDeGenero() {
        System.out.println("Listar Listas de Genero");
        List<String> result = iConsultaLista.listarListasDeGenero("Genero");
        List<String> expResult = new ArrayList<String>();
        expResult.add("Lista genérica");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDarInfoDefecto() throws Exception {
        System.out.println("Dar Info Defecto");
        DataLista result = iConsultaLista.darInfoDefecto("Lista genérica");
        DataLista expResult = new DataLista("Lista genérica", null, new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void testDarInfoDefecto2() throws Exception {
        System.out.println("Dar Info Defecto 2: lista inexistente");
        DataLista result = iConsultaLista.darInfoDefecto("Lista gadfenérica");
    }
    
    
    @Test
    public void testListarListasDeCliente() throws Exception {
        System.out.println("Listar Listas de Cliente 1");
        List<String> result = iConsultaLista.listarListasDeCliente("TesterLista");
        List<String> expResult = new ArrayList<String>();
        expResult.add("Mi Lista");
        assertEquals(expResult, result);
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void testListarListasDeCliente2() throws Exception {
        System.out.println("Listar Listas de Cliente 2");
        List<String> result = iConsultaLista.listarListasDeCliente("TestasdferLista");
    }
    
    @Test
    public void testDarInfoParticular() throws Exception {
        System.out.println("Dar Info Particular");
        DataLista result = iConsultaLista.darInfoParticular("Mi Lista", "TesterLista");
        DataLista expResult = new DataLista("Mi Lista", null, new ArrayList<>());
        assertEquals(expResult, result);
    }
        
    @Test (expected = ClienteInexistenteException.class)
    public void testDarInfoParticular2() throws Exception {
        System.out.println("Dar Info Particular 2: cliente inexistente");
        DataLista result = iConsultaLista.darInfoParticular("Mi Lista", "TestasdferLista");
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void testDarInfoParticular3() throws Exception {
        System.out.println("Dar Info Particular 3: lista inexistente");
        DataLista result = iConsultaLista.darInfoParticular("Mi Liasfsta", "TesterLista");
    }
    

    
    
    
    
}
