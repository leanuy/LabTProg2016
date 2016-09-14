package espotify.Interfaces;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataCliente;
import espotify.Excepciones.CorreoRepetidoException;
import espotify.Excepciones.FormatoIncorrectoException;
import espotify.Excepciones.NickRepetidoException;

public interface IAltaPerfil {
    public void altaCliente(DataCliente dCli)
            throws NickRepetidoException,
            CorreoRepetidoException, FormatoIncorrectoException;

    public void altaArtista(DataArtista dArt)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException;
}
