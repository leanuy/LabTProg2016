package espotify;

import static org.junit.Assert.assertEquals;

import espotify.datatypes.DataGenero;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.GeneroRepetidoException;
import espotify.excepciones.NickRepetidoException;
import espotify.interfaces.IAltaGenero;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;


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
    public void test6ListarGeneros() {
        System.out.println("Listar Generos");
        DataGenero result = iAltaGenero.listarGeneros();
        ArrayList<DataGenero> generos1 = new ArrayList<>();
        generos1.add(new DataGenero("Hard Rock","Rock",new ArrayList<>()));
        ArrayList<DataGenero> generos2 = new ArrayList<>();
        generos2.add(new DataGenero("Rock","Genero",generos1));
        generos2.add(new DataGenero("Jazz","Genero",new ArrayList<>()));
        DataGenero expResult = new DataGenero("Genero","",generos2);
        assertEquals(expResult, result);
    }
    
    @Test
    public void test1ListarGeneros2() {
        System.out.println("Listar Generos 2:vacío");
        DataGenero result = iAltaGenero.listarGeneros();
        DataGenero expResult = new DataGenero("Genero","",new ArrayList<>());
        assertEquals(expResult, result);
    }
    
    @Test
    public void test2AltaGenero() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre nulo");
        DataGenero data = new DataGenero("Rock", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.altaGenero(data);
    }

    @Test
    public void test3AltaGenero2() throws Exception {
        System.out.println("AltaGenero: Ingreso normal, padre existente");
        DataGenero data = new DataGenero("Hard Rock", "Rock");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.altaGenero(data);
    }

    @Test (expected = GeneroInexistenteException.class)
    public void test4AltaGenero3() throws Exception {
        System.out.println("AltaGenero: Padre inexistente");
        DataGenero dGenero = new DataGenero("Cumbia Plancha", "Rombai");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.altaGenero(dGenero);
    }
    
    @Test (expected = GeneroRepetidoException.class)
    public void test5AltaGenero4() throws Exception {
        System.out.println("AltaGenero: Género repetido");
        DataGenero dGenero = new DataGenero("Jazz", "");
        IAltaGenero instance = Fabrica.getIAltaGenero();
        instance.altaGenero(dGenero);
        instance.altaGenero(dGenero);
    }
}
