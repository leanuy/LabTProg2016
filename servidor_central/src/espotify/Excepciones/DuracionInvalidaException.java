package espotify.Excepciones;

public class DuracionInvalidaException extends Exception {
    public DuracionInvalidaException(){
        super();
    }

    public DuracionInvalidaException(String message){
        super(message);
    }
}