package espotify.excepciones;

public class ListaInexistenteException extends Exception {
    public ListaInexistenteException() {
        super();
    }

    public ListaInexistenteException(String message) {
        super(message);
    }
}
