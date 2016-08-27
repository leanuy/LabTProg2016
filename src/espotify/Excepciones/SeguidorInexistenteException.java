package espotify.Excepciones;

public class SeguidorInexistenteException extends Exception {
    public SeguidorInexistenteException(){
        super();
    }

    public SeguidorInexistenteException(String message){
        super(message);
    }
}
