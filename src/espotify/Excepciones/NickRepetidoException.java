package espotify.Excepciones;

public class NickRepetidoException extends Exception{
    public NickRepetidoException(){
        super();
    }

    public NickRepetidoException(String message){
        super(message);
    }
}
