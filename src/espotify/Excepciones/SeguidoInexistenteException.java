package espotify.Excepciones;

public class SeguidoInexistenteException extends Exception {
    public SeguidoInexistenteException(){
        super();
    }

    public SeguidoInexistenteException(String message){
        super(message);
    }
}