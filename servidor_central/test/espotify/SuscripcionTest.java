/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.web.IValidar;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author santiagoserantes
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuscripcionTest {
    
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
    public void altaSuscripcionTest() {
        
    }
    
}
