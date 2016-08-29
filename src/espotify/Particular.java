package espotify;

import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.YaPublicaException;
import java.awt.image.BufferedImage;

public abstract class Particular extends Lista{
    
    abstract Publica HacerPublica() throws YaPublicaException;

    public Particular(String nombre, BufferedImage img) {
        super(nombre, img);
    }
    public Particular(DataLista d ) {
        super(d);
    }
    
}
