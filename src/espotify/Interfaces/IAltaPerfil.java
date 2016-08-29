package espotify.Interfaces;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataCliente;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;

public interface IAltaPerfil {
    public void AltaCliente(DataCliente d) throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException;
    public void AltaArtista(DataArtista d) throws NickRepetidoException, CorreoRepetidoException, FormatoIncorrectoException;
}
