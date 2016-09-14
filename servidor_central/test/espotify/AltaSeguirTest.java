package espotify;


import espotify.Datatypes.DataCliente;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import static org.junit.Assert.assertEquals;


@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaSeguirTest {
    static IAltaSeguir iAltaSeguir;

    public AltaSeguirTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        iAltaSeguir = Fabrica.getIAltaSeguir();
        AltaPerfilTest testPerfil = new AltaPerfilTest();
        testPerfil.testAltaArtista1();
        testPerfil.testAltaCliente1();
    }

    @Test
    public void test1ListarClientes() {
        System.out.println("ListarClientes");
        List<String> expResult = new ArrayList<>();
        expResult.add("JavierM42");
        List<String> result = iAltaSeguir.ListarClientes();
        assertEquals(expResult, result);
    }
    
    @Test
    public void test2ListarSeguibles() throws SeguidorInexistenteException {
        System.out.println("ListarSeguibles 1");
        List<String> expResult = new ArrayList<>();
        expResult.add("ElGordoAxl");
        List<String> result = iAltaSeguir.listarSeguibles("JavierM42");
        assertEquals(expResult, result);
    }
    
    @Test
    public void test4ListarSeguibles() throws SeguidorInexistenteException {
        System.out.println("ListarSeguibles 2");
        List<String> expResult = new ArrayList<>();
        List<String> result = iAltaSeguir.listarSeguibles("JavierM42");
        assertEquals(expResult, result);
    }
    
    @Test (expected = SeguidorInexistenteException.class)
    public void test5ListarSeguibles() throws SeguidorInexistenteException {
        System.out.println("ListarSeguibles 3");
        List<String> result = iAltaSeguir.listarSeguibles("asdfasdf");
    }
    
    @Test
    public void testAltaSeguir() throws Exception {
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
            instance.altaCliente(dCli);
            dCli = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null,"");
            instance.altaCliente(dCli);
        }
        catch (NickRepetidoException | CorreoRepetidoException e) { }
        
        System.out.println("AltaSeguir: Normal a Cliente");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguido";
        IAltaSeguir ctrl = Fabrica.getIAltaSeguir();
        ctrl.altaSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = SeguidorInexistenteException.class)
    public void testAltaSeguir2() throws SeguidorInexistenteException,SeguidoInexistenteException, SeguidoRepetidoException, AutoSeguirseException {
        System.out.println("AltaSeguir: Seguidor inexistente");
        String nomSeguidor = "Seguidorasdfasfd";
        String nomSeguido = "Seguido";
        iAltaSeguir.altaSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = SeguidoInexistenteException.class)
    public void testAltaSeguir3() throws SeguidorInexistenteException,SeguidoInexistenteException, SeguidoRepetidoException, AutoSeguirseException {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
            ctrl.altaCliente(dCli);
            dCli = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null,"");
            ctrl.altaCliente(dCli);
        }
        catch (NickRepetidoException | CorreoRepetidoException | FormatoIncorrectoException e) { }
        
        System.out.println("AltaSeguir: Seguido inexistente");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguidoasdf";
        iAltaSeguir.altaSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test
    public void test3AltaSeguir4() throws Exception {
        System.out.println("AltaSeguir: Normal a Artista");
        String nomSeguidor = "JavierM42";
        String nomSeguido = "ElGordoAxl";
        iAltaSeguir.altaSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = AutoSeguirseException.class)
    public void testAltaSeguir5() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
            ctrl.altaCliente(dCli);
        }
        catch (NickRepetidoException | CorreoRepetidoException e) { }
        
        System.out.println("AltaSeguir: Seguirse A si Mismo");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguidor";
        iAltaSeguir.altaSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = SeguidoRepetidoException.class)
    public void testAltaSeguir6() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
            ctrl.altaCliente(dCli);
            dCli = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null,"");
            ctrl.altaCliente(dCli);
        }
        catch (NickRepetidoException | CorreoRepetidoException e) { }
        
        System.out.println("AltaSeguir: Seguir dos veces");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguido";
        try {
            iAltaSeguir.altaSeguir(nomSeguidor, nomSeguido);
        } catch (Exception e) {}
        iAltaSeguir.altaSeguir(nomSeguidor, nomSeguido);
    }

    
}
