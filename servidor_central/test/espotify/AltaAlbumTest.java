package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;
import espotify.datatypes.DataTemaWeb;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.GeneroRepetidoException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.IAltaAlbum;
import espotify.interfaces.IAltaGenero;

import org.junit.BeforeClass;
import org.junit.Test;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class AltaAlbumTest {

    static IAltaAlbum iAltaAlbum;

    public AltaAlbumTest() {
        iAltaAlbum = Fabrica.getIAltaAlbum();
    }

    @BeforeClass
    public static void setUpClass() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, GeneroInexistenteException, GeneroRepetidoException {
        new AltaPerfilTest().testAltaArtista1();
        IAltaGenero iAltaGenero = Fabrica.getIAltaGenero();
        iAltaGenero.altaGenero(new DataGenero("Pop", ""));
        iAltaGenero.altaGenero(new DataGenero("Jazz", ""));
    }

    @Test
    public void testAltaAlbum() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test 1");

        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album 1"));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2, "ElGordoAxl", "Album 1"));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3, "ElGordoAxl", "Album 1"));
        temas.add(new DataTemaArchivo(null, "tema 4", 70, 4, "ElGordoAxl", "Album 1"));
        temas.add(new DataTemaArchivo(null, "tema 5", 230, 5, "ElGordoAxl", "Album 1"));

        String nombre = "Album 1";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        iAltaAlbum.altaAlbum(data);
    }

    /**
     * Test AltaAlbum: Lista de generos vacia.
     */
    @Test(expected = CampoVacioException.class)
    public void testAltaAlbumSinGeneros() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test Sin generos");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album 2"));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2, "ElGordoAxl", "Album 2"));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3, "ElGordoAxl", "Album 2"));
        temas.add(new DataTemaWeb("url4", "tema 4", 70, 4, "ElGordoAxl", "Album 2"));
        temas.add(new DataTemaWeb("url5", "tema 5", 230, 5, "ElGordoAxl", "Album 2"));

        String nombre = "Album 2";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    /**
     * Test AltaAlbum: Lista de generos vacia.
     */
    @Test(expected = GeneroInexistenteException.class)
    public void testAltaAlbumGeneroInexistente() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test con genero inexistente");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album invalido"));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2, "ElGordoAxl", "Album invalido"));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3, "ElGordoAxl", "Album invalido"));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();

        //Agrego a la lista un genero inexistente
        generos.add("No es un genero");

        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = AlbumRepetidoException.class)
    public void testAltaAlbumRepetido() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception {
        System.out.println("Alta Album - Test con album repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Album valido"));

        String nombre = "Album valido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = DuracionInvalidaException.class)
    public void testAltaAlbumTemaDuracionInvalida() throws CampoVacioException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException, Exception, DuracionInvalidaException {
        System.out.println("Alta Album - Test tema duracion invalida");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", -20, 1, "ElGordoAxl", "Album invalido"));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbumNumeroTemaInvalido1() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por debajo");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 0, "ElGordoAxl", "Album invalido"));
        temas.add(new DataTemaWeb("url1", "tema 1", 123, -3, "ElGordoAxl", "Album invalido"));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbumNumeroTemaInvalido2() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por arriba");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 2, "ElGordoAxl", "Album invalido"));
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 345, "ElGordoAxl", "Album invalido"));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = NumeroTemaInvalidoException.class)
    public void testAltaAlbumNumeroTemaInvalido3() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por estar repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 1, "ElGordoAxl", "Album invalido"));
        temas.add(new DataTemaWeb("url1", "tema 2", 123, 1, "ElGordoAxl", "Album invalido"));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = TemaRepetidoException.class)
    public void testAltaAlbumNombreTemaRepetido() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por estar repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 1, "ElGordoAxl", "Album invalido"));
        temas.add(new DataTemaWeb("url1", "tema 1", 123, 2, "ElGordoAxl", "Album invalido"));

        String nombre = "Album invalido";
        int anio = 2013;
        ArrayList<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt data = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);

        //IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.altaAlbum(data);
    }

    @Test(expected = TemaTipoInvalidoException.class)
    public void testAltaAlbumDataTemaTipoInvalido() throws NumeroTemaInvalidoException, GeneroInexistenteException, GeneroRepetidoException, AlbumRepetidoException, DuracionInvalidaException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException, NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        System.out.println("Alta Album - Test numero de tema invalido por estar repetido");
        //this.testExisteArtista();

        //Crear DataTemas
        ArrayList<DataTema> temas = new ArrayList<>();
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
        iAltaAlbum.altaAlbum(data);
    }
}
