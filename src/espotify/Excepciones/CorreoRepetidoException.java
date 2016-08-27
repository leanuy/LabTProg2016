package espotify.Excepciones;

public class CorreoRepetidoException extends Exception {
    public CorreoRepetidoException(){
        super();
    }

    public CorreoRepetidoException(String message){
        super(message);
    }
}