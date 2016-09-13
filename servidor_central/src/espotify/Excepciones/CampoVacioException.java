package espotify.Excepciones;

public class CampoVacioException extends Exception {
    public CampoVacioException(){
        super();
    }

    public CampoVacioException(String message){
        super(message);
    }
}