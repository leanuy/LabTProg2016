package espotify.Excepciones;

public class ArtistaInexistenteException extends Exception {
    public ArtistaInexistenteException(){
        super();
    }

    public ArtistaInexistenteException(String message){
        super(message);
    }
}