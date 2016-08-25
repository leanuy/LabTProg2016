package espotify;

import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import java.awt.image.BufferedImage;

public abstract class Particular extends Lista{
    
    abstract Publica HacerPublica() throws Exception;

    public Particular(String nombre, BufferedImage img) {
        super(nombre, img);
    }
    public Particular(DataLista d ) {
        super(d);
    }
    
}
