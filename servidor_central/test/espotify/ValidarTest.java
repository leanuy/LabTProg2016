/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.web.IValidar;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.Test;

public class ValidarTest {
    
    private static IValidar interf;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        interf = Fabrica.getIValidar();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, ""));
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
        
    @Test
    public void testValidar() {
        System.out.println("Validar nick, sí");
        assert interf.existeUsuarioNick("TesterLista");
    }
    
    @Test
    public void testValidar2() {
        System.out.println("Validar nick, no");
        assert !interf.existeUsuarioNick("TeasfdsterLista");
    }
    
    @Test
    public void testValidar3() {
        System.out.println("Validar nick, artista sí");
        assert interf.existeUsuarioNick("ElGordoAxl");
    }
    
    @Test
    public void testValidar4() {
        System.out.println("Validar correo, sí");
        assert interf.existeUsuarioCorreo("test@lista.com");
    }
    
    @Test
    public void testValidar5() {
        System.out.println("Validar correo, no");
        assert !interf.existeUsuarioCorreo("TeasfdsterLista");
    }
    
    @Test
    public void testValidar6() {
        System.out.println("Validar correo, artista sí");
        assert interf.existeUsuarioCorreo("axl@rose.com");
    }
    

}
