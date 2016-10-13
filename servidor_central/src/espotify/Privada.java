package espotify;

import espotify.datatypes.DataParticular;

class Privada extends Particular {

    Privada(DataParticular dataPart, Cliente cli) {
        super(dataPart, cli);
    }
    
    Publica hacerPublica() {
        return new Publica(this);
    }
    
}
