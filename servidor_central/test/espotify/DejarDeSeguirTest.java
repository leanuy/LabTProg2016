package espotify;

import espotify.datatypes.DataCliente;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidorInexistenteException;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IAltaSeguir;
import espotify.interfaces.IDejarDeSeguir;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.Calendar;

public class DejarDeSeguirTest {
    private static IDejarDeSeguir iDejar;    

    public DejarDeSeguirTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        iDejar = Fabrica.getIDejarDeSeguir();
    }
    
    
    @Test
    public void testDejarDeSeguir() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();

        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            dCli = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            ctrl2.altaSeguir("Seguidor", "Seguido");
        } catch (Exception e) {
            System.out.println("You are doomed to fail");
        }
        
        System.out.println("DejarDeSeguir: Normal");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguido";
        IDejarDeSeguir instance = Fabrica.getIDejarDeSeguir();
        instance.dejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = SeguidorInexistenteException.class)
    public void testDejarDeSeguir2() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            dCli = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            ctrl2.altaSeguir("Seguidor", "Seguido");
        } catch (Exception e) {
            System.out.println("You are doomed to fail");
        } 
        
        System.out.println("DejarDeSeguir: Seguidor Inexistente");
        String nomSeguidor = "Seguidorasdf";
        String nomSeguido = "Seguido";
        iDejar.dejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = SeguidoInexistenteException.class)
    public void testDejarDeSeguir3() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            dCli = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            ctrl2.altaSeguir("Seguidor", "Seguido");
        } catch (Exception e) {
            System.out.println("You are doomed to fail");
        }
        
        System.out.println("DejarDeSeguir: Seguido Inexistente");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguidoasdf";
        iDejar.dejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected = SeguidoInexistenteException.class)
    public void testDejarDeSeguir4() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try {
            Calendar cal = Calendar.getInstance();
            cal.set(1996, 5, 17);
            DataCliente dCli = new DataCliente("Seguidor2", "Javier", "Morales", "seguidor2@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
            dCli = new DataCliente("Seguido2", "Javier", "Morales", "seguido2@hotmail.com", cal, null, "");
            ctrl.altaCliente(dCli);
        } catch (Exception e) { 
            System.out.println("You are doomed to fail");
        }
        
        System.out.println("DejarDeSeguir: Seguido al que no seguían");
        String nomSeguidor = "Seguidor2";
        String nomSeguido = "Seguido2";
        iDejar.dejarDeSeguir(nomSeguidor, nomSeguido);
    }
}
