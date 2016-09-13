package espotify;

import espotify.Datatypes.DataCliente;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidorInexistenteException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IDejarDeSeguir;
import java.util.Calendar;
import org.junit.BeforeClass;
import org.junit.Test;

public class DejarDeSeguirTest {
    static IDejarDeSeguir iDejar;    

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

        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        ctrl2.AltaSeguir("Seguidor", "Seguido");
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Normal");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguido";
        IDejarDeSeguir instance = Fabrica.getIDejarDeSeguir();
        instance.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected=SeguidorInexistenteException.class)
    public void testDejarDeSeguir2() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();
        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        ctrl2.AltaSeguir("Seguidor", "Seguido");
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Seguidor Inexistente");
        String nomSeguidor = "Seguidorasdf";
        String nomSeguido = "Seguido";
        iDejar.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected=SeguidoInexistenteException.class)
    public void testDejarDeSeguir3() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        IAltaSeguir ctrl2 = Fabrica.getIAltaSeguir();
        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor", "Javier", "Morales", "seguidor@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido", "Javier", "Morales", "seguido@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        ctrl2.AltaSeguir("Seguidor", "Seguido");
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Seguido Inexistente");
        String nomSeguidor = "Seguidor";
        String nomSeguido = "Seguidoasdf";
        iDejar.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
    
    @Test (expected=SeguidoInexistenteException.class)
    public void testDejarDeSeguir4() throws Exception {
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        try{
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("Seguidor2", "Javier", "Morales", "seguidor2@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        d = new DataCliente("Seguido2", "Javier", "Morales", "seguido2@hotmail.com", cal, null,"");
        ctrl.AltaCliente(d);
        }
        catch(Exception e)
        {}
        
        System.out.println("DejarDeSeguir: Seguido al que no seguían");
        String nomSeguidor = "Seguidor2";
        String nomSeguido = "Seguido2";
        iDejar.DejarDeSeguir(nomSeguidor, nomSeguido);
    }
}