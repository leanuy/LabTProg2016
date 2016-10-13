package espotify.interfaces.web;

import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;
import java.util.List;

/**
 *
 * @author leandro
 */
public interface ISuscripcionWeb {
    public List<DataSuscripcion> listarSuscripcionesCliente(String nickname) throws ClienteInexistenteException;
    
    public DataSuscripcion obtenerSuscripcionActual(String nickname) throws ClienteInexistenteException;
    
    public boolean contratarSuscripcion(TipoSuscripcion tipo, String nickname) throws ClienteInexistenteException;
    
    public void cancelarSuscripcionVencida(String nickname) throws 
            NoHaySuscripcionException, TransicionSuscripcionInvalidaException,
            ClienteInexistenteException;
    
    public void renovarSuscripcion(String nickname) throws ClienteInexistenteException,
            TransicionSuscripcionInvalidaException, NoHaySuscripcionException;
    
    public void aprobarSuscripcionPendiente(String nickname) throws NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException, ClienteInexistenteException;
    
    public void actualizarEstadoSuscripcion(String nickname);
    
    public void vencerSuscripcionActual(String nickname) throws ClienteInexistenteException;
    
    public boolean tieneSuscripcionVigente(String nick) throws ClienteInexistenteException;
}
