package espotify.interfaces;

import espotify.datatypes.DataArtista;
import espotify.datatypes.DataCliente;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.NickRepetidoException;

public interface IAltaPerfil {
    public void altaCliente(DataCliente dCli)
            throws NickRepetidoException,
            CorreoRepetidoException, FormatoIncorrectoException;

    public void altaArtista(DataArtista dArt)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException;
}
