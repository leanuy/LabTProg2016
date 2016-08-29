package espotify.Excepciones;

public class YaPublicaException extends Exception {
    public YaPublicaException(){
        super();
    }

    public YaPublicaException(String message){
        super(message);
    }
}
