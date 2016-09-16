package espotify;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataDefecto;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.FavoritoRepetidoException;
import espotify.excepciones.ListaInexistenteException;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IFavoritear;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FavoritearTest {
    
    private static IFavoritear ifav;

    public FavoritearTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        ifav = Fabrica.getIFavoritear();
        try {
            IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
            Calendar cal = Calendar.getInstance();
            cal.set(2001, 1, 1);
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", cal, null, ""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", cal, null, ""));
        } catch (Exception ex) {
            System.out.println("You are doomed to fail");
        }
        new AltaListaTest().testAltaListaDefecto1();
        new AltaListaTest().testAltaListaParticular1();
        Fabrica.getIPublicarLista().publicarLista("Mi Lista", "TesterLista");
    }
   
    @Test
    public void favoritearTest() throws Exception {
        System.out.println("Favoritear: lista defecto");
        ifav.favoritear("TesterLista", new DataDefecto("", "Lista genérica", null));
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void favoritearTest2() throws Exception {
        System.out.println("Favoritear: lista defecto no existe");
        ifav.favoritear("TesterLista", new DataDefecto("", "Lista asdfgenérica", null));
    }

    @Test (expected = FavoritoRepetidoException.class)
    public void favoritearTest3() throws Exception {
        System.out.println("Favoritear: lista defecto repetida");
        ifav.favoritear("TesterLista", new DataDefecto("", "Lista genérica", null));
    }
    
    @Test
    public void favoritearTest4() throws Exception {
        System.out.println("Favoritear: lista pública");
        ifav.favoritear("TesterLista", new DataParticular("TesterLista", "Mi Lista", null));
    }
    
    @Test (expected = ListaInexistenteException.class)
    public void favoritearTest5() throws Exception {
        System.out.println("Favoritear: lista pública inexistente");
        ifav.favoritear("TesterLista", new DataParticular("TesterLista", "Mi Liasdsta", null));
    }

    @Test (expected = ClienteInexistenteException.class)
    public void favoritearTest6() throws Exception {
        System.out.println("Favoritear: cliente inexistente");
        ifav.favoritear("TesterLista", new DataParticular("TesasdfterLista", "Mi Liasdsta", null));
    }
}
