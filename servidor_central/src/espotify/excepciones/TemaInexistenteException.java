package espotify.excepciones;

public class TemaInexistenteException extends Exception {
    public TemaInexistenteException() {
        super();
    }

    public TemaInexistenteException(String message) {
        super(message);
    }
}
