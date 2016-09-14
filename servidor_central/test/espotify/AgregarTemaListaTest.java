package espotify;

import static org.junit.Assert.assertEquals;

import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaWeb;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Interfaces.IAgregarTemaLista;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IPublicarLista;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

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
        iAltaGenero.AltaGenero(new DataGenero("Pop", ""));
        iAltaGenero.AltaGenero(new DataGenero("Jazz", ""));
        new AltaAlbumTest().testAltaAlbum();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        iPerfil.AltaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null,""));
        iPerfil.AltaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null,""));
        DataParticular data = new DataParticular("TesterLista", "Mi Lista Publica", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.AltaListaParticular(data);
        IPublicarLista iPublicar = Fabrica.getIPublicarLista();
        iPublicar.PublicarLista("Mi Lista Publica", "TesterLista");
    }
    
    @Test
    public void ListarArtistasTest() {
        System.out.println("Listar Artistas, testeado en otro lado, testeando mensajes intercontroladores nomás acá");
        List<String> result = iAdd.ListarArtistas();
        List<String> expResult = new ArrayList<>();
    }
    
    @Test
    public void ListarListasDefectoTest() {
        System.out.println("Listar Listas por Defecto");
        List<String> result = iAdd.ListarListasDefecto();
        List<String> expResult = new ArrayList<>();
        expResult.add("Lista genérica");
        assertEquals(expResult, result);
    }
    
    @Test
    public void ListarAlbumesArtista() throws ArtistaInexistenteException {
        System.out.println("Listar Albumes de Artista");
        List<String> result = iAdd.ListarAlbumesDeArtista("ElGordoAxl");
        List<String> expResult = new ArrayList<>();
        expResult.add("Album 1");
        assertEquals(expResult, result);
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void ListarAlbumesArtista2() throws ArtistaInexistenteException {
        System.out.println("Listar Albumes de Artista 2: no existe");
        List<String> result = iAdd.ListarAlbumesDeArtista("ElGordasdfoAxl");
    }
    
    @Test
    public void ListarListasPublicasDeCLienteTest() throws ArtistaInexistenteException, ClienteInexistenteException {
        System.out.println("Listar Listas Publicas de Cliente");
        List<String> result = iAdd.ListarListasPublicasDeCliente("TesterLista");
        List<String> expResult = new ArrayList<>();
        expResult.add("Mi Lista Publica");
        assertEquals(expResult, result);
    }
    
    @Test
    public void ListarTemasLista() throws Exception {
        System.out.println("Listar Temas de Lista");
        List<DataTema> result = iAdd.ListarTemasLista("Lista genérica");
        List<DataTema> expResult = new ArrayList<>();
        assertEquals(expResult, result);
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void ListarTemasLista2() throws Exception {
        System.out.println("Listar Temas de Lista");
        List<DataTema> result = iAdd.ListarTemasLista("Mi Lista Pasdfublica");
    }
    
    @Test
    public void ListarTemasLista2_1() throws Exception {
        System.out.println("Listar Temas de Lista_2");
        List<DataTema> result = iAdd.ListarTemasLista2("TesterLista","Mi Lista Publica");
        List<DataTema> expResult = new ArrayList<>();
        assertEquals(expResult, result);
    }
    
    @Test
    public void TestAgregarTemaLista_1() throws Exception {
        System.out.println("Agregar Tema a Lista Generica");
        DataTemaWeb web = new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album 1");
        iAdd.AgregarTemaLista(web, "Lista genérica");
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void tirameExcepcion() throws Exception {
        DataTemaWeb web = new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album 1");
        iAdd.AgregarTemaLista(web, null);
    }
}
