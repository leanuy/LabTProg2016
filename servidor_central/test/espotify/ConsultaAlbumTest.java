package espotify;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaArchivo;
import espotify.Datatypes.DataTemaWeb;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IConsultaAlbum;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ConsultaAlbumTest {
    static IConsultaAlbum iConsultaAlbum;
    
    public ConsultaAlbumTest() {
    }

    @Before
    public void setUpMethod() throws Exception {
        ManejadorColecciones.clear();
        iConsultaAlbum = Fabrica.getIConsultaAlbum();
        new AltaPerfilTest().testAltaArtista1();
        IAltaGenero iAltaGenero = Fabrica.getIAltaGenero();
        iAltaGenero.AltaGenero(new DataGenero("Pop", ""));
        iAltaGenero.AltaGenero(new DataGenero("Jazz", ""));
        AltaAlbumTest albTest = new AltaAlbumTest();
        albTest.testAltaAlbum();
    }
    
    @Test
    public void testListarAlbumesDeGenero() throws Exception {
        System.out.println("Listar Albumes De Genero");
        String[] valores = new String[2];
        valores[0] = "Album 1";
        valores[1] = "ElGordoAxl";
        List<String[]> expResult = new ArrayList<>();
        expResult.add(valores);
        List<String[]> result = iConsultaAlbum.ListarAlbumesDeGenero("Pop");
        assertEquals(expResult.size(),result.size());
        assertArrayEquals(expResult.get(0),result.get(0));
    }
    
    @Test (expected=GeneroInexistenteException.class)
    public void testListarAlbumesDeGenero2() throws Exception {
        System.out.println("Listar Albumes De Genero:género inexistente");
        List<String[]> result = iConsultaAlbum.ListarAlbumesDeGenero("asf");
    }
    
    @Test
    public void testListarArtistas() throws Exception {
        System.out.println("Listar Artistas");
        List<String> expResult = new ArrayList<>();
        expResult.add("ElGordoAxl");
        List<String> result = iConsultaAlbum.ListarArtistas();
        assertEquals(expResult, result);
    }
    
    @Test
    public void testListarAlbumesDeArtista() throws Exception {
        System.out.println("Listar Albumes De Artista");
        List<String> expResult = new ArrayList<>();
        expResult.add("Album 1");
        List<String> result = iConsultaAlbum.ListarAlbumesDeArtista("ElGordoAxl");
        assertEquals(expResult,result);
    }
    
    @Test (expected=ArtistaInexistenteException.class)
    public void testListarAlbumesDeArtista2() throws Exception {
        System.out.println("Listar Albumes De Artista:Artista inexistente");
        List<String> result = iConsultaAlbum.ListarAlbumesDeArtista("CHPP");
    }
    
    @Test
    public void testConsultaAlbum() throws Exception {
        System.out.println("Consulta Album: ok");
        
        List<DataTema> temas = new ArrayList<>();
        temas.add(new DataTemaWeb("url1", "tema 1", 160, 1, "ElGordoAxl", "Alb"));
        temas.add(new DataTemaWeb("url2", "tema 2", 190, 2, "ElGordoAxl", "Alb"));
        temas.add(new DataTemaWeb("url3", "tema 3", 200, 3, "ElGordoAxl", "Alb"));
        temas.add(new DataTemaArchivo(null, "tema 4", 70, 4, "ElGordoAxl", "Alb"));
        temas.add(new DataTemaArchivo(null, "tema 5", 230, 5, "ElGordoAxl", "Alb"));
        String nombre = "Alb";
        int anio = 2013;
        List<String> generos = new ArrayList<>();
        generos.add("Pop");
        BufferedImage img = null;
        String nickArtista = "ElGordoAxl";
        DataAlbumExt expResult = new DataAlbumExt(temas, nombre, anio, generos, img, nickArtista);
        IAltaAlbum iAltaAlbum = Fabrica.getIAltaAlbum();
        iAltaAlbum.AltaAlbum(expResult);
        DataAlbumExt result = iConsultaAlbum.ConsultaAlbum("Alb", "ElGordoAxl");
        assertEquals(expResult,result);
    }
    
    @Test (expected=ArtistaInexistenteException.class)
    public void testConsultaAlbum2() throws Exception {
        System.out.println("Consulta Album: Artista inexistente");
        DataAlbumExt result = iConsultaAlbum.ConsultaAlbum("Album 1", "ElGordoasdfasdfAxl");
    }
    
    @Test (expected=AlbumInexistenteException.class)
    public void testConsultaAlbum3() throws Exception {
        System.out.println("Consulta Album: Album inexistente");
        DataAlbumExt result = iConsultaAlbum.ConsultaAlbum("Album 2", "ElGordoAxl");
    }
    
        

    
}
