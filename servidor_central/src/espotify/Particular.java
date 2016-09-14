package espotify;

import espotify.Datatypes.DataLista;
import espotify.Excepciones.YaPublicaException;

import java.awt.image.BufferedImage;

abstract class Particular extends Lista {
    
    abstract Publica HacerPublica() throws YaPublicaException;

    Particular(String nombre, BufferedImage img) {
        super(nombre, img);
    }
    
    Particular(DataLista dLista ) {
        super(dLista);
    }
    
    Particular(Lista lst) {
        super(lst);
    }
    
}
