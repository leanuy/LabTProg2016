package espotify;

import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataDefecto;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IFavoritear;
import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class FavoritearTest {
    
    static IFavoritear ifav;
    public FavoritearTest() {
        
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        ifav = Fabrica.getIFavoritear();
        try {
            IAltaPerfil cu = Fabrica.getIAltaPerfil();
            Calendar cal = Calendar.getInstance();
            cal.set(2001, 1, 1);
            cu.AltaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", cal, null));
            cu.AltaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", cal, null));
        } catch (Exception ex) {
        }
        new AltaListaTest().testAltaListaDefecto1();
        new AltaListaTest().testAltaListaParticular1();
        Fabrica.getIPublicarLista().PublicarLista("Mi Lista", "TesterLista");
    }
   
    @Test
    public void FavoritearTest() throws Exception
    {
        System.out.println("Favoritear: lista defecto");
        DataDefecto d = new DataDefecto("", "Lista genérica", null);
        ifav.Favoritear("TesterLista",d);
    }
    
    @Test (expected=ListaInexistenteException.class)
    public void FavoritearTest2() throws Exception
    {
        System.out.println("Favoritear: lista defecto no existe");
        DataDefecto d = new DataDefecto("", "Lista asdfgenérica", null);
        ifav.Favoritear("TesterLista",d);
    }

    @Test (expected=FavoritoRepetidoException.class)
    public void FavoritearTest3() throws Exception
    {
        System.out.println("Favoritear: lista defecto repetida");
        DataDefecto d = new DataDefecto("", "Lista genérica", null);
        ifav.Favoritear("TesterLista",d);
    }
    
    @Test
    public void FavoritearTest4() throws Exception
    {
        System.out.println("Favoritear: lista pública");
        DataParticular d = new DataParticular("TesterLista", "Mi Lista", null);
        ifav.Favoritear("TesterLista",d);
    }
    
    @Test (expected=ListaInexistenteException.class)
    public void FavoritearTest5() throws Exception
    {
        System.out.println("Favoritear: lista pública inexistente");
        DataParticular d = new DataParticular("TesterLista", "Mi Liasdsta", null);
        ifav.Favoritear("TesterLista",d);
    }
    @Test (expected=ClienteInexistenteException.class)
    public void FavoritearTest6() throws Exception
    {
        System.out.println("Favoritear: cliente inexistente");
        DataParticular d = new DataParticular("TesasdfterLista", "Mi Liasdsta", null);
        ifav.Favoritear("TesterLista",d);
    }
}
