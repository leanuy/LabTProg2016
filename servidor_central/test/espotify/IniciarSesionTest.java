package espotify;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IIniciarSesion;
import espotify.interfaces.web.IValidar;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class IniciarSesionTest {
        
    private static IIniciarSesion interf;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        interf = Fabrica.getIIniciarSesion();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, "pass"));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null, ""));
            new AltaPerfilTest().testAltaArtista1();
            IAltaGenero interfazGenero = Fabrica.getIAltaGenero();
            interfazGenero.altaGenero(new DataGenero("Pop", ""));
            interfazGenero.altaGenero(new DataGenero("Jazz", ""));
            new AltaAlbumTest().testAltaAlbum();
        } catch (Exception ex) {
             Logger.getLogger("Algo salió mal").log(Level.SEVERE, null, ex);
        }
    }
    
    @Test (expected=UsuarioInexistenteException.class)
    public void testBuscar() throws UsuarioInexistenteException {
        System.out.println("Buscar usuario, no existe");
        interf.buscarUsuario("asdf");
    }
    
    @Test
    public void testBuscar2() throws UsuarioInexistenteException {
        System.out.println("Buscar artista");
        assert(interf.buscarUsuario("ElGordoAxl")!=null);
    }
    
    @Test (expected=UsuarioInexistenteException.class)
    public void testPassword1() throws UsuarioInexistenteException {
        System.out.println("check password, no existe usuario");
        interf.checkPassword("asdf", "no");
    }
    
    @Test
    public void testPassword2() throws UsuarioInexistenteException {
        System.out.println("check password, sí");
        assert(interf.checkPassword("TesterLista", "pass"));
    }
    
    @Test
    public void testPassword3() throws UsuarioInexistenteException {
        System.out.println("check password, no");
        assert(!interf.checkPassword("TesterLista", "noPass"));
    }
    
    @Test
    public void testPassword4() throws UsuarioInexistenteException {
        System.out.println("check password artista, no");
        assert(!interf.checkPassword("ElGordoAxl", "noPass"));
    }

}
