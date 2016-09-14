package espotify.interfaces;

import espotify.datatypes.DataArtista;
import espotify.datatypes.DataCliente;
import espotify.excepciones.CorreoRepetidoException;
import espotify.excepciones.FormatoIncorrectoException;
import espotify.excepciones.NickRepetidoException;

public interface IAltaPerfil {
    public void altaCliente(DataCliente dataCli)
            throws NickRepetidoException,
            CorreoRepetidoException, FormatoIncorrectoException;

    public void altaArtista(DataArtista dataArt)
            throws NickRepetidoException, CorreoRepetidoException,
            FormatoIncorrectoException;
}
