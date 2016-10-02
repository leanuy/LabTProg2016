package espotify;

import espotify.datatypes.DataLista;
import espotify.excepciones.YaPublicaException;

import java.awt.image.BufferedImage;

abstract class Particular extends Lista {
    private final Cliente cli;
    
    abstract Publica hacerPublica() throws YaPublicaException;

    public String getNickCliente() {
        return cli.getNick();
    }
    
    Particular(DataLista data,Cliente cli ) {
        super(data);
        this.cli = cli;
    }
    
    Particular(Particular lst) {
        super(lst);
        this.cli = lst.cli;
    }
    
}
