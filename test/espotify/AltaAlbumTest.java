package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaArchivo;
import espotify.Datatypes.DataTemaWeb;
import espotify.Excepciones.AlbumRepetidoException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.CampoVacioException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.DuracionInvalidaException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Excepciones.NumeroTemaInvalidoException;
import espotify.Excepciones.TemaRepetidoException;
import espotify.Excepciones.TemaTipoInvalidoException;
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IAltaGenero;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

public class AltaAlbumTest {

    static IAltaAlbum iAltaAlbum;
    public AltaAlbumTest() {
        iAltaAlbum = Fabrica.getIAltaAlbum();
    }

    @BeforeClass
    public static void setUpClass() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, GeneroInexistenteException, GeneroRepetidoException {
        new AltaPerfilTest().testAltaArtista1();
        IAltaGenero iAltaGenero = Fabrica.getIAltaGenero();
        iAltaGenero.AltaGenero(new DataGenero("Pop", ""));
        iAltaGenero.AltaGenero(new DataGenero("Jazz", ""));
    }

    @Test
    public void testAltaAlbum() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test 1");

        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3));
        temas.add(new DataTemaArchivo(null, "tema 4", 70, 4));
        temas.add(new DataTemaArchivo(null, "tema 5", 230, 5));

        String nombre = "Album 1";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        iAltaAlbum.AltaAlbum(data);
    }

    /**
     * Test AltaAlbum: Lista de generos vacia.
     */
    @Test(expected = CampoVacioException.class)
    public void testAltaAlbumSinGeneros() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test Sin generos");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3));
        temas.add(new DataTemaWeb("url4", "tema 4", 70, 4));
        temas.add(new DataTemaWeb("url5", "tema 5", 230, 5));

        String nombre = "Album 2";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    /**
     * Test AltaAlbum: Lista de generos vacia.
     */
    @Test(expected = GeneroInexistenteException.class)
    public void testAltaAlbumGeneroInexistente() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test con genero inexistente");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();

        //Agrego a la lista un genero inexistente
        generos.add("No es un genero");

        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = AlbumRepetidoException.class)
    public void testAltaAlbumRepetido() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test con album repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1));

        String nombre = "Album valido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = DuracionInvalidaException.class)
    public void testAltaAlbumTemaDuracionInvalida() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception, DuracionInvalidaException {
        System.out.println("Alta Album - Test tema duracion invalida");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", -20, 1));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbumNumeroTemaInvalido1() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por debajo");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 0));
        temas.add(new DataTemaWeb("url1", "tema 1", 123, -3));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbumNumeroTemaInvalido2() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por arriba");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 2));
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 345));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbumNumeroTemaInvalido3() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por estar repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 1));
        temas.add(new DataTemaWeb("url1", "tema 2", 123, 1));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = TemaRepetidoException.class)
    public void testAltaAlbumNombreTemaRepetido() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por estar repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 1));
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 2));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }

    @Test(expected = TemaTipoInvalidoException.class)
    public void testAltaAlbumDataTemaTipoInvalido() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por estar repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList< DataTema> temas = new ArrayList<>();
        temas.add(new DataTema("tema 1", 123, 1));
        temas.add(new DataTema("tema 1", 123, 2));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(data);
    }
}
