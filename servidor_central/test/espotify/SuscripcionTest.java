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
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        Calendar creacion3 = (Calendar) creacion.clone();
        Calendar update3 = (Calendar) creacion.clone();
        
        update3.set(2016,9,1);
        creacion3.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(creacion3, update3, null, TipoSuscripcion.MENSUAL, false);
        acts.encajarSuscripcion("TesterLista", susc3);
        acts.aprobarSuscripcion("TesterLista");
        DataSuscripcion datasusc = acts.getSuscripcionDeCliente("TesterLista");
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(creacion3, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test (expected = ClienteInexistenteException.class)
    public void altaSuscripcionTest_2() throws ClienteInexistenteException {
        acts.listarClientes();
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        Calendar creacion3 = (Calendar) creacion.clone();
        Calendar update3 = (Calendar) creacion.clone();
        
        update3.set(2016,9,1);
        creacion3.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(creacion3, update3, null, TipoSuscripcion.MENSUAL, false);
        acts.encajarSuscripcion("Excepcion", susc3);
    }
    
    @Test (expected = NoHaySuscripcionException.class)
    public void altaSuscripcionTest_3() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        acts.listarClientes();
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        Calendar creacion3 = (Calendar) creacion.clone();
        Calendar update3 = (Calendar) creacion.clone();
        
        update3.set(2016,9,1);
        creacion3.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(creacion3, update3, null, TipoSuscripcion.MENSUAL, false);
        acts.encajarSuscripcion("TesterLista", susc3);
        acts.aprobarSuscripcion("TesterLista2");
        DataSuscripcion datasusc = acts.getSuscripcionDeCliente("TesterLista");
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(creacion3, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test (expected = TransicionSuscripcionInvalidaException.class)
    public void altaSuscripcionTest_4() throws ClienteInexistenteException, TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        acts.listarClientes();
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        Calendar creacion2 = (Calendar) creacion.clone();
        Calendar update2 = (Calendar) creacion.clone();
        Calendar desde2 = (Calendar) creacion.clone();
        
        update2.set(2016,8,3);
        creacion2.set(2016,8,3);
        desde2.set(2016,8,3);
        espotify.Suscripcion susc2 = new espotify.Suscripcion(creacion2, update2, desde2, TipoSuscripcion.ANUAL, false);
        acts.encajarSuscripcion("TesterLista", susc2);
        acts.aprobarSuscripcion("TesterLista");
        DataSuscripcion datasusc = acts.getSuscripcionDeCliente("TesterLista");
        Calendar cal2 = datasusc.getFechaUpdate();
        DataSuscripcion dsesp = new DataSuscripcion(creacion2, cal2,EstadoSuscripcion.VIGENTE, TipoSuscripcion.MENSUAL);
        assertEquals(datasusc, dsesp);
    }
    
    @Test
    public void crear_suscripcion() {
         //SUSCRIPCIONES
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        
        update.set(2016,8,2);
        creacion.set(2016, 7, 26);
        desde.set(2016, 7, 26);
        espotify.Suscripcion susc1 = new espotify.Suscripcion(creacion, update, desde, TipoSuscripcion.SEMANAL, false);

        Calendar creacion2 = (Calendar) creacion.clone();
        Calendar update2 = (Calendar) creacion.clone();
        Calendar desde2 = (Calendar) creacion.clone();
        
        update2.set(2016,8,3);
        creacion2.set(2016,8,3);
        desde2.set(2016,8,3);
        espotify.Suscripcion susc2 = new espotify.Suscripcion(creacion2, update2, desde2, TipoSuscripcion.ANUAL, false);
        
        Calendar creacion3 = (Calendar) creacion.clone();
        Calendar update3 = (Calendar) creacion.clone();
        
        update3.set(2016,9,1);
        creacion3.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(creacion3, update3, null, TipoSuscripcion.MENSUAL, false);
        
        Calendar creacion4 = (Calendar) creacion.clone();
        Calendar update4 = (Calendar) creacion.clone();
        Calendar desde4 = (Calendar) creacion.clone();
        
        update4.set(2016,2,1);
        creacion4.set(2015, 1, 28);
        desde4.set(2015, 1, 28);
        espotify.Suscripcion susc4 = new espotify.Suscripcion(creacion4, update4, desde4, TipoSuscripcion.ANUAL, false);
        
        Calendar creacion5 = (Calendar) creacion.clone();
        Calendar update5 = (Calendar) creacion.clone();
        Calendar desde5 = (Calendar) creacion.clone();
        
        update5.set(2016,4,3);
        creacion5.set(2016, 4, 2);
        desde5.set(2016, 4, 2);
        espotify.Suscripcion susc5 = new espotify.Suscripcion(creacion5, update5, desde5, TipoSuscripcion.MENSUAL,true);
        
        Calendar creacion6 = (Calendar) creacion.clone();
        Calendar update6 = (Calendar) creacion.clone();
        Calendar desde6 = (Calendar) creacion.clone();
        
        update6.set(2016,9,16);
        creacion6.set(2016,9,16);
        desde6.set(2016,9,16);
        espotify.Suscripcion susc6 = new espotify.Suscripcion(creacion6, update6, desde6, TipoSuscripcion.SEMANAL, false);
        
        Calendar creacion7 = (Calendar) creacion.clone();
        Calendar update7 = (Calendar) creacion.clone();
        Calendar desde7 = (Calendar) creacion.clone();
        
        update7.set(2015,5,10);
        creacion7.set(2015, 5, 9);
        desde7.set(2015, 5, 9);
        espotify.Suscripcion susc7 = new espotify.Suscripcion(creacion7, update7, desde7, TipoSuscripcion.ANUAL, false);
        
        Calendar creacion8 = (Calendar) creacion.clone();
        Calendar update8 = (Calendar) creacion.clone();
        
        update8.set(2016,9,15);
        creacion8.set(2016,9,15);
        espotify.Suscripcion susc8 = new espotify.Suscripcion(creacion8, update8, null, TipoSuscripcion.MENSUAL, false);
        
        Calendar creacion9 = (Calendar) creacion.clone();
        Calendar update9 = (Calendar) creacion.clone();
        Calendar desde9 = (Calendar) creacion.clone();
        
        update9.set(2016,8,2);
        creacion9.set(2016, 8, 1);
        desde9.set(2016, 8, 1);
        espotify.Suscripcion susc9 = new espotify.Suscripcion(creacion9, update9, desde9, TipoSuscripcion.ANUAL, true);
        
        Calendar creacion10 = (Calendar) creacion.clone();
        Calendar update10 = (Calendar) creacion.clone();
        Calendar desde10 = (Calendar) creacion.clone();
        
        update10.set(2016,8,25);
        creacion10.set(2016,8,25);
        desde10.set(2016,8,25);
        espotify.Suscripcion susc10 = new espotify.Suscripcion(creacion10, update10, desde10, TipoSuscripcion.MENSUAL, false);
        
        Calendar creacion11 = (Calendar) creacion.clone();
        Calendar update11 = (Calendar) creacion.clone();
        Calendar desde11 = (Calendar) creacion.clone();
        
        update11.set(2016,4,1);
        creacion11.set(2016, 3, 23);
        desde11.set(2016, 3, 23);
        espotify.Suscripcion susc11 = new espotify.Suscripcion(creacion11, update11, desde11, TipoSuscripcion.SEMANAL, false);
       
        Calendar creacion12 = (Calendar) creacion.clone();
        Calendar update12 = (Calendar) creacion.clone();
        Calendar desde12 = (Calendar) creacion.clone();
        
        update12.set(2016,9,2);
        creacion12.set(2016, 8, 25);
        desde12.set(2016, 8, 25);
        espotify.Suscripcion susc12 = new espotify.Suscripcion(creacion12, update12, desde12, TipoSuscripcion.ANUAL, true);
        
        Calendar creacion13 = (Calendar) creacion.clone();
        Calendar update13 = (Calendar) creacion.clone();
       
        update13.set(2016,9,15);
        creacion13.set(2016,9,15);
        espotify.Suscripcion susc13 = new espotify.Suscripcion(creacion13, update13, null, TipoSuscripcion.ANUAL, false);
    }
    
    @Test (expected = NoHaySuscripcionException.class)
    public void cancelar_suscripcion() throws ClienteInexistenteException, NoHaySuscripcionException, TransicionSuscripcionInvalidaException {
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        Calendar creacion3 = (Calendar) creacion.clone();
        Calendar update3 = (Calendar) creacion.clone();
        
        update3.set(2016,9,1);
        creacion3.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(creacion3, update3, null, TipoSuscripcion.MENSUAL, false);
        acts.encajarSuscripcion("TesterLista3", susc3);
        acts.cancelarSuscripcion("TesterLista3");
        acts.getSuscripcionDeCliente("TesterLista3");
    }
    
    @Test
    public void vencer_suscripcion() throws ClienteInexistenteException, NoHaySuscripcionException, TransicionSuscripcionInvalidaException {
        Calendar creacion = Calendar.getInstance();
        Calendar update = (Calendar) creacion.clone();
        Calendar desde = (Calendar) creacion.clone();
        Calendar creacion3 = (Calendar) creacion.clone();
        Calendar update3 = (Calendar) creacion.clone();
        
        update3.set(2016,9,1);
        creacion3.set(2016,9,1);
        espotify.Suscripcion susc3 = new espotify.Suscripcion(creacion3, update3, null, TipoSuscripcion.MENSUAL, false);
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
