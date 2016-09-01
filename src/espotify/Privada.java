package espotify;

import espotify.Datatypes.DataParticular;
import java.awt.image.BufferedImage;

class Privada extends Particular {

    Privada(DataParticular d) {
        super(d);
    }
    
    Publica HacerPublica()
    {
        return new Publica(this);
    }
    
}
