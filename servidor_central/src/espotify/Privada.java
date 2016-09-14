package espotify;

import espotify.datatypes.DataParticular;

class Privada extends Particular {

    Privada(DataParticular dataPart) {
        super(dataPart);
    }
    
    Publica hacerPublica() {
        return new Publica(this);
    }
    
}
