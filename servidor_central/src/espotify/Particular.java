package espotify;

import espotify.datatypes.DataLista;
import espotify.excepciones.YaPublicaException;

import java.awt.image.BufferedImage;

abstract class Particular extends Lista {
    
    abstract Publica hacerPublica() throws YaPublicaException;

    Particular(String nombre, BufferedImage img) {
        super(nombre, img);
    }
    
    Particular(DataLista data ) {
        super(data);
    }
    
    Particular(Lista lst) {
        super(lst);
    }
    
}
