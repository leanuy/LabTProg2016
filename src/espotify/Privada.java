package espotify;

public class Privada extends Particular {
    
    public Publica HacerPublica()
    {
        return new Publica(this);
    }

    public Privada(String nombre, String img) {
        super(nombre, img);
    }
    
    
}
