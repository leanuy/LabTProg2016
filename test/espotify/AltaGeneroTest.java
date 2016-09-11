package espotify;

import espotify.Datatypes.DataGenero;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaGenero;
import java.util.ArrayList;
import org.junit.After;
import org.junit.AfterClass;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaGeneroTest {
    
    static IAltaGenero iAltaGenero;
    public AltaGeneroTest() {
    }

    @BeforeClass
    public static void setUpClass() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException, GeneroInexistenteException, GeneroRepetidoException {
        ManejadorColecciones.clear();
        iAltaGenero = Fabrica.getIAltaGenero();
        
    }

    @Test
    public void test6ListarGeneros()
    {
        System.out.println("Listar Generos");
        DataGenero result = iAltaGenero.ListarGeneros();
        ArrayList<DataGenero>a = new ArrayList<>();
        a.add(new DataGenero("Hard Rock","Rock",new ArrayList<>()));
        ArrayList<DataGenero>b = new ArrayList<>();
        b.add(new DataGenero("Rock","Genero",a));
        b.add(new DataGenero("Jazz","Genero",new ArrayList<>()));
        DataGenero expResult = new DataGenero("Genero","",b);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test1ListarGeneros2()
    {
        System.out.println("Listar Generos 2:vacío");
        DataGenero result = iAltaGenero.ListarGeneros();
        DataGenero expResult = new DataGenero("Genero","",new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    @Test
    public void test2AltaGenero() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre nulo");
        DataGenero d = new DataGenero("Rock", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
    }
    @Test
    public void test3AltaGenero2() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre existente");
        DataGenero d = new DataGenero("Hard Rock", "Rock");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
    }
    @Test (expected = GeneroInexistenteException.class)
    public void test4AltaGenero3() throws Exception {
        System.out.println("AltaGenero: Padre inexistente");
        DataGenero d = new DataGenero("Cumbia Plancha", "Rombai");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
    }
    
    @Test (expected = GeneroRepetidoException.class)
    public void test5AltaGenero4() throws Exception {
        System.out.println("AltaGenero: Género repetido");
        DataGenero d = new DataGenero("Jazz", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.AltaGenero(d);
        instance.AltaGenero(d);
    }
}