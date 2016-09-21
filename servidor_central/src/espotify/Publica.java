package espotify;

import espotify.datatypes.DataLista;
import espotify.datatypes.DataParticular;
import espotify.excepciones.YaPublicaException;

public class Publica extends Particular implements Favoriteable {

    Publica(Privada priv) {
        super(priv);
    }    
    
    @Override
    public Publica hacerPublica() throws YaPublicaException {
        throw new YaPublicaException();
    }
    
    @Override
    public DataParticular getData() {
        return new DataParticular(getNickCliente(),nombre,img);
    }
}
