package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataArtistaExt;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IConsultaArtista;
import java.util.Calendar;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.assertEquals;
import org.junit.Test;


public class ConsultaArtistaTest {
    static IConsultaArtista iConsultaArtista;    

    public ConsultaArtistaTest() {
        iConsultaArtista = Fabrica.getIConsultaArtista();
    }
    
    
    @Test
    public void testConsultaArtista() {
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

}
