/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.datatypes.DataAlbum;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.web.IFavoritos;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author JavierM42
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FavoritosTest {
    
    private static IFavoritos interf;
   
    public FavoritosTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        interf = Fabrica.getIFavoritos();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, ""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null, ""));
            DataParticular dLista = new DataParticular("TesterLista", "Mi Lista Publica", null);
            IAltaLista instance = Fabrica.getIAltaLista();
            instance.altaListaParticular(dLista);
            new AltaPerfilTest().testAltaArtista1();
            IAltaGenero interf = Fabrica.getIAltaGenero();
            interf.altaGenero(new DataGenero("Pop", ""));
            interf.altaGenero(new DataGenero("Jazz", ""));
            new AltaAlbumTest().testAltaAlbum();
        } catch (Exception ex) {
             Logger.getLogger("Algo salió mal").log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void testListarFavoritos() throws ClienteInexistenteException {
        System.out.println("Lista de favoritos: vacía");
        List<DataFavoriteable> lista = interf.listarFavoritos("TesterLista");
        assert (lista.isEmpty());
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void test2ListarFavoritos() throws ClienteInexistenteException {
        System.out.println("Lista de favoritos: cliente inexistente");
        List<DataFavoriteable> lista = interf.listarFavoritos("asdf");
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void testEsFavorito() throws ClienteInexistenteException,
            ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        System.out.println("es favorito?: cliente inexistente");
        interf.esFavorito("asdf",null);
    }
    
    @Test (expected = ArtistaInexistenteException.class)
    public void testEsFavorito2() throws ClienteInexistenteException,
            ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        DataAlbum dataFav = new DataAlbum("asdf", 0, null, null, "asdf");
        System.out.println("es favorito?: artista inexistente");
        interf.esFavorito("TesterLista",dataFav);
    }
    
    @Test (expected = AlbumInexistenteException.class)
    public void testEsFavorito3() throws ClienteInexistenteException,
            ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        DataAlbum dataFav = new DataAlbum("asdf", 0, null, null, "ElGordoAxl");
        System.out.println("es favorito?: álbum inexistente");
        interf.esFavorito("TesterLista",dataFav);
    }
    
    @Test
    public void testEsFavorito4() throws ClienteInexistenteException,
            ListaInexistenteException, ArtistaInexistenteException, AlbumInexistenteException {
        DataAlbum dataFav = new DataAlbum("Album 1", 0, null, null, "ElGordoAxl");
        System.out.println("es favorito?: álbum, no");
        assert (!interf.esFavorito("TesterLista",dataFav));
    }
}
