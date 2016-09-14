package espotify;

import static org.junit.Assert.assertEquals;

import espotify.Datatypes.DataCliente;
import espotify.Datatypes.DataClienteExt;
import espotify.Excepciones.ClienteInexistenteException;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IConsultaCliente;

import org.junit.Test;

import java.util.Calendar;

public class ConsultaClienteTest {
    static IConsultaCliente iConsultaCliente;    

    public ConsultaClienteTest() {
        iConsultaCliente = Fabrica.getIConsultaCliente();
    }
    
    @Test
    public void testConsultaCliente() throws ClienteInexistenteException {
        //tests de santiago que hice yo -JM42
        Calendar cal = Calendar.getInstance();
        cal.set(1996, 5, 17);
        DataCliente d = new DataCliente("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null,"");
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();

        try {
            ctrl.AltaCliente(d);
        } catch (Exception ex) {
        }
        
        System.out.println("ConsultaCliente");
        String s = "clienteconsultado";
        DataClienteExt expResult = new DataClienteExt("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null, new String[0], new String[0],"");
        IConsultaCliente instance = Fabrica.getIConsultaCliente();

        DataClienteExt result = iConsultaCliente.ConsultaCliente(s);
        assertEquals(expResult, result);
    }
    
    @Test (expected=ClienteInexistenteException.class)
    public void testConsultaCliente2() throws ClienteInexistenteException {
        System.out.println("ConsultaCliente:no existe cliente");
        String s = "clienteconsasdfultado";
        DataClienteExt result = iConsultaCliente.ConsultaCliente(s);
    }

}
