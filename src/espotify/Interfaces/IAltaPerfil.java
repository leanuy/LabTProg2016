package espotify.Interfaces;

import espotify.Datatypes.DataArtista;
import espotify.Datatypes.DataCliente;

public interface IAltaPerfil {
    public void AltaCliente(DataCliente d) throws Exception;
    public void AltaArtista(DataArtista d) throws Exception;
}
