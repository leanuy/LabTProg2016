package espotify.excepciones;

public class GeneroInexistenteException extends Exception {
    public GeneroInexistenteException() {
        super();
    }

    public GeneroInexistenteException(String message) {
        super(message);
    }
}