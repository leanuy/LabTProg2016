package espotify.Excepciones;

public class FormatoIncorrectoException extends Exception {
    public FormatoIncorrectoException(){
        super();
    }

    public FormatoIncorrectoException(String message){
        super(message);
    }
}