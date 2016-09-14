package espotify.excepciones;

public class CampoVacioException extends Exception {
    public CampoVacioException() {
        super();
    }

    public CampoVacioException(String message) {
        super(message);
    }
}