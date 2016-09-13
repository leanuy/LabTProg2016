package espotify.Excepciones;

public class NumeroTemaInvalidoException extends Exception {
    public NumeroTemaInvalidoException(){
        super();
    }

    public NumeroTemaInvalidoException(String message){
        super(message);
    }
}