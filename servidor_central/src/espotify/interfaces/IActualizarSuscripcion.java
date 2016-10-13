package espotify.interfaces;

import espotify.Suscripcion;
import espotify.datatypes.DataSuscripcion;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;

import java.util.List;

public interface IActualizarSuscripcion {
    public List<String> listarClientes();
    
    public DataSuscripcion getSuscripcionDeCliente(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException;
    public List<DataSuscripcion> listarSuscripcionesCliente(String nickname) throws ClienteInexistenteException ; 
    public void aprobarSuscripcion(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException;
    
    public void cancelarSuscripcion(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException;
    public void vencerSuscripcionActual(String nickname) throws ClienteInexistenteException;
    //si se desea ver el histórico habria que agregar otra operacion que las traiga.
    public void encajarSuscripcion(String nick, Suscripcion s) throws ClienteInexistenteException;
}
