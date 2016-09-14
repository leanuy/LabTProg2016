package espotify;

import static org.junit.Assert.assertEquals;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaWeb;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.interfaces.IAgregarTemaLista;
import espotify.interfaces.IAltaGenero;
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
public class AgregarTemaListaTest {
  
    static IAgregarTemaLista iAdd;

    public AgregarTemaListaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iAdd = Fabrica.getIAgregarTemaLista();
        
        new AltaListaTest().testAltaListaDefecto1();
        new AltaPerfilTest().testAltaArtista1();
        IAltaGenero iAltaGenero = Fabrica.getIAltaGenero();
        iAltaGenero.altaGenero(new DataGenero("Pop", ""));
        iAltaGenero.altaGenero(new DataGenero("Jazz", ""));
        new AltaAlbumTest().testAltaAlbum();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null,""));
        iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null,""));
        DataParticular data = new DataParticular("TesterLista", "Mi Lista Publica", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.altaListaParticular(data);
        IPublicarLista iPublicar = Fabrica.getIPublicarLista();
        iPublicar.publicarLista("Mi Lista Publica", "TesterLista");
    }
    
    @Test
    public void listarArtistasTest() {
        System.out.println("Listar Artistas, testeado en otro lado, testeando mensajes intercontroladores nomás acá");
        List<String> result = iAdd.listarArtistas();
        List<String> expResult = new ArrayList<>();
    }
    
    @Test
    public void listarListasDefectoTest() {
        System.out.println("Listar Listas por Defecto");
        List<String> result = iAdd.listarListasDefecto();
        List<String> expResult = new ArrayList<>();
        expResult.add("Lista genérica");
        assertEquals(expResult, result);
    }
    
    @Test
    public void listarAlbumesArtista() throws ArtistaInexistenteException {
        System.out.println("Listar Albumes de Artista");
        List<String> result = iAdd.listarAlbumesDeArtista("ElGordoAxl");
        List<String> expResult = new ArrayList<>();
        expResult.add("Album 1");
        assertEquals(expResult, result);
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void listarAlbumesArtista2() throws ArtistaInexistenteException {
        System.out.println("Listar Albumes de Artista 2: no existe");
        List<String> result = iAdd.listarAlbumesDeArtista("ElGordasdfoAxl");
    }
    
    @Test
    public void listarListasPublicasDeCLienteTest() throws ArtistaInexistenteException, ClienteInexistenteException {
        System.out.println("Listar Listas Publicas de Cliente");
        List<String> result = iAdd.listarListasPublicasDeCliente("TesterLista");
        List<String> expResult = new ArrayList<>();
        expResult.add("Mi Lista Publica");
        assertEquals(expResult, result);
    }
    
    @Test
    public void listarTemasLista() throws Exception {
        System.out.println("Listar Temas de Lista");
        List<DataTema> result = iAdd.listarTemasLista("Lista genérica");
        List<DataTema> expResult = new ArrayList<>();
        assertEquals(expResult, result);
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void listarTemasLista2() throws Exception {
        System.out.println("Listar Temas de Lista");
        List<DataTema> result = iAdd.listarTemasLista("Mi Lista Pasdfublica");
    }
    
    @Test
    public void listarTemasLista2_1() throws Exception {
        System.out.println("Listar Temas de Lista_2");
        List<DataTema> result = iAdd.listarTemasLista2("TesterLista","Mi Lista Publica");
        List<DataTema> expResult = new ArrayList<>();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testAgregarTemaLista_1() throws Exception {
        System.out.println("Agregar Tema a Lista Generica");
        DataTemaWeb web = new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album 1");
        iAdd.agregarTemaLista(web, "Lista genérica");
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void tirameExcepcion() throws Exception {
        DataTemaWeb web = new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album 1");
        iAdd.agregarTemaLista(web, null);
    }
}
