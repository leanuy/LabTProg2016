package espotify;

import espotify.datatypes.DataAlbum;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class BuscarTest {
     
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
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
            new AltaListaTest().testAltaListaParticular1();
            Fabrica.getIPublicarLista().publicarLista("Mi Lista", "TesterLista");
            new AltaListaTest().testAltaListaDefecto1();
        } catch (Exception ex) {
             Logger.getLogger("Algo salió mal").log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void buscarListasTest() {
        System.out.println("Buscar listas: ");
        List<String[]> result = Fabrica.getIBuscar().buscarListas("asdf");
        assert(result.isEmpty());
    }
    
    @Test
    public void buscarListasTest2() {
        System.out.println("Buscar listas: ");
        List<String[]> result = Fabrica.getIBuscar().buscarListas("i");
        assert(!result.isEmpty());
    }
    
    @Test
    public void buscarAlbumsTest() {
        System.out.println("Buscar albums: ");
        List<DataAlbum> result = Fabrica.getIBuscar().buscarAlbums("asdf");
        assert(result.isEmpty());
    }
    
    @Test
    public void buscarAlbumsTest2() {
        System.out.println("Buscar albums: ");
        List<DataAlbum> result = Fabrica.getIBuscar().buscarAlbums("1");
        assert(!result.isEmpty());
    }
    
    @Test
    public void buscarTemasTest() {
        System.out.println("Buscar temas: ");
        List<String[]> result = Fabrica.getIBuscar().buscarTemas("asdf");
        assert(result.isEmpty());
    }
    
    @Test
    public void buscarTemasTest2() {
        System.out.println("Buscar temas: ");
        List<String[]> result = Fabrica.getIBuscar().buscarTemas("Pop");
        assert(!result.isEmpty());
    }
}
