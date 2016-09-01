package espotify;

import static espotify.AltaGeneroTest.iAltaGenero;
import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaLista;
import java.util.ArrayList;
import java.util.Calendar;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)

public class ConsultaListaTest {
    static IConsultaLista iConsultaLista;
    public ConsultaListaTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iConsultaLista = Fabrica.getIConsultaLista();
        AltaPerfilTest a = new AltaPerfilTest();
        a.testAltaArtista1();
        a.testAltaCliente1();
    }
    
    @Test
    public void testListarGeneros()
    {
        System.out.println("Listar Generos 2:vacío");
        DataGenero result = iConsultaLista.ListarGeneros();
        DataGenero expResult = new DataGenero("Genero","",new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    
    
    
    
}
