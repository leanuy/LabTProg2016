package espotify;

import espotify.datatypes.DataParticular;

class Privada extends Particular {

    Privada(DataParticular dParticular) {
        super(dParticular);
    }
    
    Publica hacerPublica() {
        return new Publica(this);
    }
    
}
