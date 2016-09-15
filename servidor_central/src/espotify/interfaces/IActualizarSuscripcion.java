package espotify.interfaces;

import espotify.datatypes.DataSuscripcion;
import espotify.excepciones.ClienteInexistenteException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;

import java.util.List;

public interface IActualizarSuscripcion {
    public List<String> listarClientes();
    
    public DataSuscripcion getSuscripcionDeCliente(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException;
    
    public void aprobarSuscripcion(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException;
    
    public void cancelarSuscripcion(String nick)
            throws ClienteInexistenteException, NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException;
    
    //si se desea ver el histórico habria que agregar otra operacion que las traiga.
}
