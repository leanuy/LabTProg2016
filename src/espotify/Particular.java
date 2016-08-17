package espotify;

import espotify.Datatypes.DataLista;

public abstract class Particular extends Lista{
    
    abstract Publica HacerPublica() throws Exception;

    public Particular(String nombre, String img) {
        super(nombre, img);
    }
    public Particular(DataLista d) {
        super(d);
    }
}
