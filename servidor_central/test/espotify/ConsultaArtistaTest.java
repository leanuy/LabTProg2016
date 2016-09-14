package espotify;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IConsultaArtista;

import org.junit.Test;

import java.util.Calendar;
import java.util.HashMap;



public class ConsultaArtistaTest {
    static IConsultaArtista iConsultaArtista;    

    public ConsultaArtistaTest() {
        iConsultaArtista = Fabrica.getIConsultaArtista();
    }
    
    
    @Test
    public void testConsultaArtista() throws ArtistaInexistenteException {
        ManejadorColecciones.clear();
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataArtista artista = new DataArtista("Soy un artista y me consultan","", "ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null,"");
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            ctrl.AltaArtista(artista);
        } catch (Exception ex) {
        }
        
        System.out.println("ConsultaArtista");
        DataArtistaExt expResult = new DataArtistaExt("ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null, "Soy un artista y me consultan", "", new HashMap<String,Album>(),"");
        DataArtistaExt result = iConsultaArtista.ConsultaArtista("ArtistaConsultado");
        assertEquals(expResult, result);
    }

    @Test (expected = ArtistaInexistenteException.class)
    public void tirameLaExcepcionPapa() throws ArtistaInexistenteException {
        iConsultaArtista.ConsultaArtista("No existo loco");
    }
    
    @Test
    public void retornaInfoCorrecta() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        ManejadorColecciones.clear();
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        iConsultaArtista = Fabrica.getIConsultaArtista();
        String biografia = "Soy un artista y me consultan";
        String url = "elarti.com";
        DataArtista dArtista = new DataArtista(biografia, url, "ArtistaConsultado",
                "Artista", "Consultado", "artista@consultado.com", cal, null,"");
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        ctrl.AltaArtista(dArtista);
        DataArtistaExt data = iConsultaArtista.ConsultaArtista("ArtistaConsultado");
        assertEquals(biografia, data.getBio());
        assertEquals(url, data.getUrl());
        assertArrayEquals(new String[0], data.getAlbums());
        assertEquals(data, data);
        assertEquals(false, data.equals(null));
        assertEquals(false, data.equals(data));
        dArtista = new DataArtista("otra bio", url, "OtroArtistaConsultado",
                "Artista", "Consultado", "otro_artista@consultado.com", cal, null,"");
        ctrl.AltaArtista(dArtista);
        DataArtistaExt otroArtista = iConsultaArtista.ConsultaArtista("OtroArtistaConsultado");
        assertEquals(false, data.equals(otroArtista));
        dArtista = new DataArtista(biografia, url, "AunOtroArtistaConsultado",
                "Artista", "Consultado", "otro_artista2@consultado.com", cal, null,"");
        ctrl.AltaArtista(dArtista);
        otroArtista = iConsultaArtista.ConsultaArtista("AunOtroArtistaConsultado");
        assertEquals(false, data.equals(otroArtista));
    }
}
