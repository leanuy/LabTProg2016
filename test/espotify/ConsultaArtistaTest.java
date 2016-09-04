package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IConsultaArtista;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.junit.Test;


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
        DataArtista d = new DataArtista("Soy un artista y me consultan","", "ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null);
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            ctrl.AltaArtista(d);
        } catch (Exception ex) {
        }
        
        System.out.println("ConsultaArtista");
        String s = "ArtistaConsultado";
        DataArtistaExt expResult = new DataArtistaExt("ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null, "Soy un artista y me consultan", "", new HashMap<String,Album>());
        DataArtistaExt result = iConsultaArtista.ConsultaArtista(s);
        assertEquals(expResult, result);
    }

    @Test (expected=ArtistaInexistenteException.class)
    public void tirameLaExcepcionPapa() throws ArtistaInexistenteException {
        iConsultaArtista.ConsultaArtista("No existo loco");
    }
    
    @Test
    public void retornaInfoCorrecta() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, ArtistaInexistenteException {
        ManejadorColecciones.clear();
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        iConsultaArtista = Fabrica.getIConsultaArtista();
        String bio = "Soy un artista y me consultan";
        String url = "elarti.com";
        DataArtista d = new DataArtista(bio, url, "ArtistaConsultado", "Artista", "Consultado", "artista@consultado.com", cal, null);
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        ctrl.AltaArtista(d);
        DataArtistaExt dt = iConsultaArtista.ConsultaArtista("ArtistaConsultado");
        assertEquals(bio, dt.getBio());
        assertEquals(url, dt.getUrl());
        assertArrayEquals(new String[0], dt.getAlbums());
        assertEquals(dt, dt);
        assertEquals(false, dt.equals(null));
        assertEquals(false, dt.equals(d));
        d = new DataArtista("otra bio", url, "OtroArtistaConsultado", "Artista", "Consultado", "otro_artista@consultado.com", cal, null);
        ctrl.AltaArtista(d);
        DataArtistaExt otro_dt = iConsultaArtista.ConsultaArtista("OtroArtistaConsultado");
        assertEquals(false, dt.equals(otro_dt));
        d = new DataArtista(bio, url, "AunOtroArtistaConsultado", "Artista", "Consultado", "otro_artista2@consultado.com", cal, null);
        ctrl.AltaArtista(d);
        otro_dt = iConsultaArtista.ConsultaArtista("AunOtroArtistaConsultado");
        assertEquals(false, dt.equals(otro_dt));
    }
}
