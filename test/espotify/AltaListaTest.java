/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;


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
            IAltaPerfil cu = Fabrica.getIAltaPerfil();
            Calendar cal = Calendar.getInstance();
            cal.set(2001, 1, 1);
            cu.AltaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", cal, null,""));
            cu.AltaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", cal, null,""));
        } catch (Exception ex) {
        }
    }

    @Test
    public void test2ListarClientes() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("ListarClientes");
        ArrayList<String> expResult = new ArrayList<>();
        expResult.add("TesterLista2");
        expResult.add("TesterLista");
        ArrayList<String> result = iAltaLista.ListarClientes();
        assertEquals(expResult, result);
    }    
    
    
    @Test
    public void testAltaListaParticular1() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular: caso ok");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);
    }
    
    @Test (expected=ClienteInexistenteException.class)
    public void testAltaListaParticular2() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:usuario inexistente");
        DataParticular d = new DataParticular("no existo yey", "Mi Lista", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);
    }
    
    @Test
    public void testAltaListaParticular3() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:dos clientes con listas de igual nombre");
        DataParticular d = new DataParticular("TesterLista", "Lista que comparte nombre", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);
        d = new DataParticular("TesterLista2", "Lista que comparte nombre", null);
        instance.AltaListaParticular(d);
    }
    
    @Test (expected=ListaRepetidaException.class)
    public void testAltaListaParticular4() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:nombre de lista repetido");
        DataParticular d = new DataParticular("TesterLista", "Repetido", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);
        d = new DataParticular("TesterLista", "Repetido", null);
        instance.AltaListaParticular(d);
    }
    
    @Test (expected=ListaRepetidaException.class)
    public void testAltaListaParticular5() throws ListaRepetidaException, ClienteInexistenteException {
        System.out.println("AltaListaParticular:nombre de lista vacío");
        DataParticular d = new DataParticular("TesterLista", "", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(d);
    }
    
    @Test
    public void testAltaListaDefecto1() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: género=Genero");
        DataDefecto d = new DataDefecto("Genero", "Lista genérica", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(d);
    }
    
    @Test (expected=GeneroInexistenteException.class)
    public void testAltaListaDefecto2() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: género inexistente");
        DataDefecto d = new DataDefecto("aksdnlfaesufmx", "Lista que no va a andar", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(d);
    }
    
    @Test (expected=ListaRepetidaException.class)
    public void testAltaListaDefecto3() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: nombre repetido");
        DataDefecto d = new DataDefecto("Genero", "Soy una lista con un nombre comun", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(d);
        instance.AltaListaDefecto(d);
    }
    
    @Test (expected=ListaRepetidaException.class)
    public void testAltaListaDefecto4() throws ListaRepetidaException, GeneroInexistenteException {
        System.out.println("AltaListaDefecto: nombre vacío");
        DataDefecto d = new DataDefecto("Genero", "", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaDefecto(d);
    }
}
