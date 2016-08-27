package espotify.Excepciones;

public class AlbumRepetidoException extends Exception {
    public AlbumRepetidoException(){
        super();
    }

    public AlbumRepetidoException(String message){
        super(message);
    }
}