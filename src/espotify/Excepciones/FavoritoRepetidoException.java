package espotify.Excepciones;

public class FavoritoRepetidoException extends Exception {
    public FavoritoRepetidoException(){
        super();
    }

    public FavoritoRepetidoException(String message){
        super(message);
    }
}