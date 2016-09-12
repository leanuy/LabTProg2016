package espotify;

import espotify.Datatypes.DataLista;
import espotify.Excepciones.YaPublicaException;

public class Publica extends Particular implements Favoriteable {

    public Publica(Privada p) {
        super(p);
    }    

    public Publica(DataLista d) {
        super(d);
    }
    
    public Publica HacerPublica() throws YaPublicaException
    {
        throw new YaPublicaException();
    }
}
