package espotify;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.UsuarioInexistenteException;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.web.IObtenerImagen;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Calendar;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import static junit.framework.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.Test;

public class ObtenerImagenTest {
    
    private static IObtenerImagen interf;
    private static BufferedImage img;
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        interf = Fabrica.getIImagen();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, ""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null, ""));
            File file = new File("./src/presentacion/img/clientes/ElPadrino.png");
            img = ImageIO.read(file);
            iPerfil.altaCliente(new DataCliente("TengoImagen", "Test", "asdf", "test2@imagen.com", Calendar.getInstance(), img, ""));
            new AltaPerfilTest().testAltaArtista1();
            DataParticular dLista = new DataParticular("TesterLista", "Mi Lista Publica", null);
            IAltaLista instance = Fabrica.getIAltaLista();
            instance.altaListaParticular(dLista);
            new AltaListaTest().testAltaListaDefecto1();
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
    public void testImagenUsuario() throws UsuarioInexistenteException {
        System.out.println("Obtener imagen de usuario: vacía");
        BufferedImage imagen = interf.getImageUsuario("TesterLista");
        assert(imagen == null);
    }
    
    @Test
    public void testImagenUsuario2() throws UsuarioInexistenteException {
        System.out.println("Obtener imagen de usuario: existente");
        BufferedImage imagen = interf.getImageUsuario("TengoImagen");
        assertEquals(imagen,img);
    }
    
    @Test (expected = UsuarioInexistenteException.class)
    public void testImagenUsuario3() throws UsuarioInexistenteException {
        System.out.println("Obtener imagen de usuario: no existe");
        BufferedImage imagen = interf.getImageUsuario("asdfasdfasdf");
    }
    
    @Test
    public void testEsArtista() throws UsuarioInexistenteException {
        System.out.println("es artista: sí");
        boolean result = interf.esArtista("ElGordoAxl");
        assert(result);
    }
    
    @Test
    public void testEsArtista2() throws UsuarioInexistenteException {
        System.out.println("es artista: no");
        boolean result = interf.esArtista("TesterLista");
        assert(!result);
    }
    
    @Test
    public void testImagenParticular() throws ListaInexistenteException, ClienteInexistenteException {
        System.out.println("Obtener imagen de lista: sin imagen");
        BufferedImage imagen = interf.getImageLista("TesterLista","Mi Lista Publica");
        assertEquals(imagen,null);
    }
    
    @Test
    public void testImagenParticular2() throws ListaInexistenteException, ClienteInexistenteException {
        System.out.println("Obtener imagen de lista: lista inexistente");
        BufferedImage imagen = interf.getImageLista("TesterLista","Mi Listasdfa Publica");
        assertEquals(imagen,null);
    }
    
    @Test
    public void testImagenParticular3() throws ListaInexistenteException, ClienteInexistenteException {
        System.out.println("Obtener imagen de lista: cliente inexistente");
        BufferedImage imagen = interf.getImageLista("TesterLasdfista","Publiasdfca");
        assertEquals(imagen,null);
    }
    
    @Test
    public void testImagenDefecto() throws ListaInexistenteException, ClienteInexistenteException {
        System.out.println("Obtener imagen de lista defecto: sin imagen");
        BufferedImage imagen = interf.getImageLista("","Lista Genérica");
        assertEquals(imagen,null);
    }
    
    @Test 
    public void testImagenDefecto2() {
        System.out.println("Obtener imagen de lista defecto: inexistente");
        BufferedImage imagen = interf.getImageLista("","Lista Genasdférica");
        assertEquals(imagen,null);
    }
    
    @Test
    public void testImagenAlbum() {
        System.out.println("Obtener imagen de álbum: artista inexistente");
        BufferedImage imagen = interf.getImageAlbum("asdf","asdf");
        assertEquals(imagen,null);
    }
    
    @Test
    public void testImagenAlbum2() {
        System.out.println("Obtener imagen de álbum: album inexistente");
        BufferedImage imagen = interf.getImageAlbum("ElGordoAxl", "asdf");
        assertEquals(imagen,null);
    }

    @Test
    public void testImagenAlbum3() {
        System.out.println("Obtener imagen de álbum: sin imagen");
        BufferedImage imagen = interf.getImageAlbum("ElGordoAxl", "Album 1");
        assertEquals(imagen,null);
    }
    
}
