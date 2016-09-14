package espotify;

import espotify.Datatypes.DataParticular;

class Privada extends Particular {

    Privada(DataParticular dParticular) {
        super(dParticular);
    }
    
    Publica hacerPublica() {
        return new Publica(this);
    }
    
}
