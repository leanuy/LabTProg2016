package espotify.Excepciones;

public class ClienteInexistenteException extends Exception {
    public ClienteInexistenteException() {
        super();
    }

    public ClienteInexistenteException(String message) {
        super(message);
    }
}