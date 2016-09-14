package espotify.Excepciones;

public class ListaInexistenteException extends Exception {
    public ListaInexistenteException() {
        super();
    }

    public ListaInexistenteException(String message) {
        super(message);
    }
}
