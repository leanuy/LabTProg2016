package espotify;

import espotify.Datatypes.DataParticular;

public class Privada extends Particular {

    Privada(DataParticular d) {
        super(d);
    }
    
    public Publica HacerPublica()
    {
        return new Publica(this);
    }

    public Privada(String nombre, String img) {
        super(nombre, img);
    }
    
    
}
