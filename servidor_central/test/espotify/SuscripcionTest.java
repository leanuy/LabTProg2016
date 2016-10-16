/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import static org.junit.Assert.assertEquals;

import espotify.datatypes.DataCliente;
import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.EstadoSuscripcion;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.NickRepetidoException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;
import espotify.interfaces.IActualizarSuscripcion;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.web.ISuscripcionWeb;
import espotify.interfaces.web.IValidar;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

/**
 *
 * @author santiagoserantes
 */
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class SuscripcionTest {
    
    private static IActualizarSuscripcion acts = Fabrica.getIActualizarSuscripcion();
    private static ISuscripcionWeb susweb = Fabrica.getISuscripcionWeb();
    
    @BeforeClass
    public static void setUpClass() throws Exception {
        ManejadorColecciones.clear();
        IValidar interf;
        interf = Fabrica.getIValidar();
        IAltaPerfil iPerfil = Fabrica.getIAltaPerfil();
        try {
            iPerfil.altaCliente(new DataCliente("TesterLista", "Test", "Lista", "test@lista.com", Calendar.getInstance(), null, ""));
            iPerfil.altaCliente(new DataCliente("TesterLista2", "Test", "Lista", "test2@lista.com", Calendar.getInstance(), null, ""));
            iPerfil.altaCliente(new DataCliente("TesterLista3", "Test", "Lista", "test3@lista.com", Calendar.getInstance(), null, ""));
        } catch (NickRepetidoException | CorreoRepetidoException | FormatoIncorrectoException ex) {
             Logger.getLogger("Algo salió mal").log(Level.SEVERE, null, ex);
        }
    }
    
    @Test
    public void altaSuscripcionTest_1() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        acts.listarClientes();
        Calendar cal = Calendar.getInstance();
        cal.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 3);
        acts.encajarSuscripcion("TesterLista", susc3);
        acts.aprobarSuscripcion("TesterLista");
        DataSuscripcion datasusc = acts.getSuscripcionDeCliente("TesterLista");
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(cal, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void altaSuscripcionTest_2() throws ClienteInexistenteException {
        acts.listarClientes();
        Calendar cal = Calendar.getInstance();
        cal.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 3);
        acts.encajarSuscripcion("Excepcion", susc3);
    }
    
    @Test (expected = NoHaySuscripcionException.class)
    public void altaSuscripcionTest_3() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        acts.listarClientes();
        Calendar cal = Calendar.getInstance();
        cal.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 3);
        acts.encajarSuscripcion("TesterLista", susc3);
        acts.aprobarSuscripcion("TesterLista2");
        DataSuscripcion datasusc = acts.getSuscripcionDeCliente("TesterLista");
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(cal, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test (expected = TransicionSuscripcionInvalidaException.class)
    public void altaSuscripcionTest_4() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        acts.listarClientes();
        Calendar cal = Calendar.getInstance();
        cal.set(2016,8,3);
        espotify.Suscripcion susc2 = new espotify.Suscripcion(cal, TipoSuscripcion.ANUAL, false, 2);
        acts.encajarSuscripcion("TesterLista", susc2);
        acts.aprobarSuscripcion("TesterLista");
        DataSuscripcion datasusc = acts.getSuscripcionDeCliente("TesterLista");
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(cal, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test
    public void crear_suscripcion() {
        Calendar cal2 = Calendar.getInstance();
        Calendar cal = Calendar.getInstance();
        cal2.set(2016,8,2);
        espotify.Suscripcion susc1 = new espotify.Suscripcion(cal2, TipoSuscripcion.SEMANAL, false, 1);
        
        cal.set(2016,8,3);
        espotify.Suscripcion susc2 = new espotify.Suscripcion(cal, TipoSuscripcion.ANUAL, false, 2);
        
        cal.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 3);
        
        cal.set(2016,2,1);
        espotify.Suscripcion susc4 = new espotify.Suscripcion(cal, TipoSuscripcion.ANUAL, false, 4);
        
        cal.set(2016,4,3);
        espotify.Suscripcion susc5 = new espotify.Suscripcion(cal,TipoSuscripcion.MENSUAL,true, 5);
        
        cal.set(2016,9,16);
        espotify.Suscripcion susc6 = new espotify.Suscripcion(cal, TipoSuscripcion.SEMANAL, false, 6);
        
        cal.set(2015,5,10);
        espotify.Suscripcion susc7 = new espotify.Suscripcion(cal, TipoSuscripcion.ANUAL, false, 7);
        
        cal.set(2016,9,15);
        espotify.Suscripcion susc8 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 8);
        
        cal.set(2016,8,2);
        espotify.Suscripcion susc9 = new espotify.Suscripcion(cal, TipoSuscripcion.ANUAL, true, 9);
        
        cal2.set(2016,8,25);
        espotify.Suscripcion s10 = new espotify.Suscripcion(cal2, TipoSuscripcion.MENSUAL, false, 10);
        
        cal.set(2016,4,1);
        espotify.Suscripcion s11 = new espotify.Suscripcion(cal, TipoSuscripcion.SEMANAL, false, 11);
       
        cal2.set(2016,9,2);
        espotify.Suscripcion s12 = new espotify.Suscripcion(cal2, TipoSuscripcion.ANUAL, true, 12);
        
        cal.set(2016,9,15);
        espotify.Suscripcion s13 = new espotify.Suscripcion(cal, TipoSuscripcion.ANUAL, false, 13);
    }
    
    @Test (expected = NoHaySuscripcionException.class)
    public void cancelar_suscripcion() throws ClienteInexistenteException, NoHaySuscripcionException, TransicionSuscripcionInvalidaException {
        Calendar cal = Calendar.getInstance();
        cal.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 3);
        acts.encajarSuscripcion("TesterLista3", susc3);
        acts.cancelarSuscripcion("TesterLista3");
        acts.getSuscripcionDeCliente("TesterLista3");
    }
    
    @Test
    public void vencer_suscripcion() throws ClienteInexistenteException, NoHaySuscripcionException, TransicionSuscripcionInvalidaException {
        Calendar cal = Calendar.getInstance();
        cal.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(cal, TipoSuscripcion.MENSUAL, false, 3);
        acts.encajarSuscripcion("TesterLista3", susc3);
        acts.aprobarSuscripcion("TesterLista3");
        acts.vencerSuscripcionActual("TesterLista3");
        acts.getSuscripcionDeCliente("TesterLista3");
    }
    
    
    @Test
    public void altaSuscripcionTestWEB_1() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        susweb.contratarSuscripcion(TipoSuscripcion.MENSUAL, "TesterLista");
        susweb.aprobarSuscripcionPendiente("TesterLista");
        DataSuscripcion datasusc = susweb.obtenerSuscripcionActual("TesterLista");
        Calendar cal = datasusc.getFechaCreacion();
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(cal, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test
    public void cosasSuscripcionTestWEB_2() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        susweb.contratarSuscripcion(TipoSuscripcion.MENSUAL, "TesterLista3");
        susweb.aprobarSuscripcionPendiente("TesterLista3");
        susweb.vencerSuscripcionActual("TesterLista3");
        boolean sus = susweb.tieneSuscripcionVigente("TesterLista3");
        boolean esperado = false;
        assertEquals(sus, esperado);
    }
    
}
