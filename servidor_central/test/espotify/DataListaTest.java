/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import static espotify.AgregarTemaListaTest.iAdd;
import espotify.datatypes.DataCliente;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataParticular;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IPublicarLista;
import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author santiagoserantes
 */
public class DataListaTest {
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iAdd = Fabrica.getIAgregarTemaLista();
        
        new AltaListaTest().testAltaListaDefecto1();
        new AltaPerfilTest().testAltaArtista1();
        new AltaPerfilTest().testAltaCliente1();
        IAltaGenero iAltaGenero = Fabrica.getIAltaGenero();
        iAltaGenero.altaGenero(new DataGenero("Pop", ""));
        iAltaGenero.altaGenero(new DataGenero("Jazz", ""));
        new AltaAlbumTest().testAltaAlbum();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, ""));
        iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null, ""));
        DataParticular data = new DataParticular("TesterLista", "Mi Lista Publica", null);
        IAltaLista instance = Fabrica.getIAltaLista();
        instance.altaListaParticular(data);
        IPublicarLista iPublicar = Fabrica.getIPublicarLista();
        iPublicar.publicarLista("Mi Lista Publica", "TesterLista");
    }
    
    @Test
    public void getDataParticular() {
        
    }
}
