package espotify;

import espotify.Datatypes.DataLista;
import espotify.Excepciones.YaPublicaException;

public class Publica extends Particular implements Favoriteable {

    Publica(Privada priv) {
        super(priv);
    }    

    public Publica(DataLista data) {
        super(data);
    }
    
    @Override
    public Publica hacerPublica() throws YaPublicaException {
        throw new YaPublicaException();
    }
}
