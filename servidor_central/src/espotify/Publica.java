package espotify;

import espotify.Datatypes.DataLista;
import espotify.Excepciones.YaPublicaException;

public class Publica extends Particular implements Favoriteable {

    public Publica(Privada priv) {
        super(priv);
    }    

    public Publica(DataLista data) {
        super(data);
    }
    
    @Override
    public Publica HacerPublica() throws YaPublicaException {
        throw new YaPublicaException();
    }
}
