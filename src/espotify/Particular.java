package espotify;

public abstract class Particular extends Lista{
    
    abstract Publica HacerPublica() throws Exception;

    public Particular(String nombre, String img) {
        super(nombre, img);
    }
}
