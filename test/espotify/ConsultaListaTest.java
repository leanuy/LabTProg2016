package espotify;

import static espotify.AltaGeneroTest.iAltaGenero;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataTema;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaLista;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

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
            IAltaPerfil cu = Fabrica.getIAltaPerfil();
            Calendar cal = Calendar.getInstance();
            cal.set(2001, 1, 1);
            cu.AltaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", cal, null));
            cu.AltaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", cal, null));
        } catch (Exception ex) {
        }
        new AltaListaTest().testAltaListaParticular1();
    }
    
    @Test
    public void testListarGeneros()
    {
        System.out.println("Listar Generos (llama al otro controlador, en donde ya está testeado)");
        DataGenero result = iConsultaLista.ListarGeneros();
        DataGenero expResult = new DataGenero("Genero","",new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    @Test
    public void testListarListasDeGenero()
    {
        System.out.println("Listar Listas de Genero");
        ArrayList<String> result = iConsultaLista.ListarListasDeGenero("Genero");
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Lista genérica");
        assertEquals(expResult, result);
    }
    
    @Test
    public void testDarInfoDefecto() throws Exception
    {
        System.out.println("Dar Info Defecto");
        DataLista result = iConsultaLista.DarInfoDefecto("Lista genérica");
        DataLista expResult = new DataLista("Lista genérica", null, new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    @Test (expected=ListaInexistenteException.class)
    public void testDarInfoDefecto2() throws Exception
    {
        System.out.println("Dar Info Defecto 2: lista inexistente");
        DataLista result = iConsultaLista.DarInfoDefecto("Lista gadfenérica");
    }
    
    
    @Test
    public void testListarListasDeCliente() throws Exception
    {
        System.out.println("Listar Listas de Cliente 1");
        ArrayList<String> result = iConsultaLista.ListarListasDeCliente("TesterLista");
        ArrayList<String> expResult = new ArrayList<String>();
        expResult.add("Mi Lista");
        assertEquals(expResult, result);
    }
    
    @Test (expected=ClienteInexistenteException.class)
    public void testListarListasDeCliente2() throws Exception
    {
        System.out.println("Listar Listas de Cliente 2");
        ArrayList<String> result = iConsultaLista.ListarListasDeCliente("TestasdferLista");
    }
    
    @Test
    public void testDarInfoParticular() throws Exception
    {
        System.out.println("Dar Info Particular");
        DataLista result = iConsultaLista.DarInfoParticular("Mi Lista", "TesterLista");
        DataLista expResult = new DataLista("Mi Lista", null, new ArrayList<>());
        assertEquals(expResult, result);
    }
        
    @Test (expected=ClienteInexistenteException.class)
    public void testDarInfoParticular2() throws Exception
    {
        System.out.println("Dar Info Particular 2: cliente inexistente");
        DataLista result = iConsultaLista.DarInfoParticular("Mi Lista", "TestasdferLista");
    }
    
    @Test (expected=ListaInexistenteException.class)
    public void testDarInfoParticular3() throws Exception
    {
        System.out.println("Dar Info Particular 3: lista inexistente");
        DataLista result = iConsultaLista.DarInfoParticular("Mi Liasfsta", "TesterLista");
    }
    

    
    
    
    
}
