package espotify;

import espotify.Datatypes.DataParticular;
import java.awt.image.BufferedImage;

public class Privada extends Particular {

    Privada(DataParticular d) {
        super(d);
    }
    
    public Publica HacerPublica()
    {
        return new Publica(this);
    }

    public Privada(String nombre, BufferedImage img) {
        super(nombre, img);
    }
    
    
}
