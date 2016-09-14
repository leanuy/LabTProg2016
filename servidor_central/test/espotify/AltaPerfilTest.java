package espotify;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataCliente;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;
import espotify.Interfaces.IAltaPerfil;

import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.Calendar;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AltaPerfilTest {
    static IAltaPerfil iAltaPerfil;
    
    public AltaPerfilTest() {
    }

    @BeforeClass
    public static void setUpClass() {
        ManejadorColecciones.clear();
        iAltaPerfil = Fabrica.getIAltaPerfil();
    }

    
    @Test
    public void testAltaCliente1() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaCliente: ingreso normal");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente dCli = new DataCliente("JavierM42", "Javier", "Morales", "javiermorales42@hotmail.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaCliente(dCli);
    }
    
    
    @Test (expected = FormatoIncorrectoException.class)
    public void testAltaCliente2() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaCliente: campo vacío");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente dCli = new DataCliente("", "Javier", "Morales", "javiermorales42@hotmail.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaCliente(dCli);
    }
    
    @Test (expected = NickRepetidoException.class)
    public void testAltaCliente3() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaCliente: nick repetido.");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente dCli = new DataCliente("b", "Javier", "Morales", "javiermorales422@hotmail.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaCliente(dCli);
        dCli = new DataCliente("b", "Javier", "Morales", "javiermorales4222@hotmail.com", cal, null,"");
        instance.altaCliente(dCli);
    }

    @Test (expected = CorreoRepetidoException.class)
    public void testAltaCliente4() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaCliente: correo repetido.");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente dCli = new DataCliente("d", "Javier", "Morales", "a@hotmail.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaCliente(dCli);
        dCli = new DataCliente("e", "Javier", "Morales", "a@hotmail.com", cal, null,"");
        instance.altaCliente(dCli);
    }
    
    @Test (expected = FormatoIncorrectoException.class)
    public void testAltaCliente5() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaCliente: correo sin formato de correo.");
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente dCli = new DataCliente("e", "Javier", "Morales", "hola", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaCliente(dCli);
    }
    
    @Test
    public void testAltaArtista1() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaArtista: ingreso normal");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","ElGordoAxl", "Axl", "Rose", "axl@rose.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaArtista(dArt);
    }
    
    @Test (expected = FormatoIncorrectoException.class)
    public void testAltaArtista2() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException {
        System.out.println("AltaArtista: campo vacío");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","", "Axl", "Rose", "axl2@rose.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaArtista(dArt);
    }
    
    @Test (expected = NickRepetidoException.class)
    public void testAltaArtista3()throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException  {
        System.out.println("AltaArtista: nick repetido");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl3", "Axl", "Rose", "axl3@rose.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaArtista(dArt);
        dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl3", "Axl", "Rose", "axl33@rose.com", cal, null,"");
        instance.altaArtista(dArt);
    }
    
    @Test (expected = CorreoRepetidoException.class)
    public void testAltaArtista4() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException  {
        System.out.println("AltaArtista: correo repetido");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl4", "Axl", "Rose", "axl4@rose.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaArtista(dArt);
        dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl4", "Axl", "Rose", "axl4@rose.com", cal, null,"");
        instance.altaArtista(dArt);
    }
    
    @Test (expected = FormatoIncorrectoException.class)
    public void testAltaArtista5() throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException  {
        System.out.println("AltaArtista: correo sin formato de correo");
        Calendar cal = Calendar.getInstance();
        cal.set(1970, 5, 17);
        DataArtista dArt = new DataArtista("El gordo Axl es gordo y usa bandanas.","axlrose.com","Axl4", "Axl", "Rose", "axl4rose.com", cal, null,"");
        IAltaPerfil instance = Fabrica.getIAltaPerfil();
        instance.altaArtista(dArt);
    }
}
