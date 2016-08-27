package espotify.Excepciones;

public class AlbumInexistenteException extends Exception {
    public AlbumInexistenteException(){
        super();
    }

    public AlbumInexistenteException(String message){
        super(message);
    }
}
