package espotify;

import espotify.Datatypes.DataParticular;

class Privada extends Particular {

    Privada(DataParticular d) {
        super(d);
    }
    
    Publica HacerPublica() {
        return new Publica(this);
    }
    
}
