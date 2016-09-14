package espotify;

import static org.junit.Assert.assertEquals;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataClienteExt;
import espotify.excepciones.ClienteInexistenteException;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IConsultaCliente;

import org.junit.Test;

import java.util.Calendar;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertEquals;

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
        DataCliente dCliente = new DataCliente("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null,"");
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();

        try {
            ctrl.altaCliente(dCliente);
        } catch (Exception ex) {
        }
        
        System.out.println("ConsultaCliente");
        DataClienteExt expResult = new DataClienteExt("clienteconsultado", "cli", "consultado", "cliente@consultado.com", cal, null, new String[0], new String[0],"");
        IConsultaCliente instance = Fabrica.getIConsultaCliente();

        DataClienteExt result = iConsultaCliente.consultaCliente("clienteconsultado");
        assertEquals(expResult, result);
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void testConsultaCliente2() throws ClienteInexistenteException {
        System.out.println("ConsultaCliente:no existe cliente");
        DataClienteExt result = iConsultaCliente.consultaCliente("clienteconsasdfultado");
    }

}
