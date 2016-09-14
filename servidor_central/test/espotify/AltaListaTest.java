package espotify;


import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaListaTest {
    static IAltaLista iAltaLista;
    
    public AltaListaTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ManejadorColecciones.clear();
        iAltaLista = Fabrica.getIAltaLista();
        try {
            IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
            Calendar cal = Calendar.getInstance();
            cal.set(2001, 1, 1);
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", cal, null,""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", cal, null,""));
        } catch (Exception ex) {
        }
    }

    @Test
    public void test2ListarClientes() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("ListarClientes");
        List<String> expResult = new ArrayList<>();
        expResult.add("TesterLista2");
        expResult.add("TesterLista");
        List<String> result = iAltaLista.ListarClientes();
        assertEquals(expResult, result);
    }    
    
    
    @Test
    public void testAltaListaParticular1() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular: caso ok");
        DataParticular dLista = new DataParticular("TesterLista", "Mi Lista", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(dLista);
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void testAltaListaParticular2() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:usuario inexistente");
        DataParticular dLista = new DataParticular("no existo yey", "Mi Lista", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(dLista);
    }
    
    @Test
    public void testAltaListaParticular3() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:dos clientes con listas de igual nombre");
        DataParticular dLista = new DataParticular("TesterLista", "Lista que comparte nombre", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(dLista);
        dLista = new DataParticular("TesterLista2", "Lista que comparte nombre", null);
        instance.AltaListaParticular(dLista);
    }
    
    @Test (expected = ListaRepetidaException.class)
    public void testAltaListaParticular4() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:nombre de lista repetido");
        DataParticular dLista = new DataParticular("TesterLista", "Repetido", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(dLista);
        dLista = new DataParticular("TesterLista", "Repetido", null);
        instance.AltaListaParticular(dLista);
    }
    
    @Test (expected = ListaRepetidaException.class)
    public void testAltaListaParticular5() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:nombre de lista vacío");
        DataParticular dLista = new DataParticular("TesterLista", "", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(dLista);
    }
    
    @Test
    public void testAltaListaDefecto1() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: género=Genero");
        DataDefecto dLista = new DataDefecto("Genero", "Lista genérica", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(dLista);
    }
    
    @Test (expected = GeneroInexistenteException.class)
    public void testAltaListaDefecto2() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: género inexistente");
        DataDefecto dLista = new DataDefecto("aksdnlfaesufmx", "Lista que no va a andar", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(dLista);
    }
    
    @Test (expected = ListaRepetidaException.class)
    public void testAltaListaDefecto3() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: nombre repetido");
        DataDefecto dLista = new DataDefecto("Genero", "Soy una lista con un nombre comun", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(dLista);
        instance.AltaListaDefecto(dLista);
    }
    
    @Test (expected = ListaRepetidaException.class)
    public void testAltaListaDefecto4() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: nombre vacío");
        DataDefecto dLista = new DataDefecto("Genero", "", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(dLista);
    }
}
