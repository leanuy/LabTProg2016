package espotify;

import espotify.Datatypes.DataParticular;

class Privada extends Particular {

    Privada(DataParticular dParticular) {
        super(dParticular);
    }
    
    Publica HacerPublica() {
        return new Publica(this);
    }
    
}
