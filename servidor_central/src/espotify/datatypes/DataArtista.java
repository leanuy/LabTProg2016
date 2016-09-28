package espotify.datatypes;

import java.io.File;
import java.util.Calendar;
import java.util.List;


public class DataArtista extends DataUsuario {
    private final String bio;
    private final String url;

    public String getBio() {
        return bio;
    }
    
    public String getUrl() {
        return url;
    }

    public DataArtista(String bio, String url, String nick, String nombre, String apellido,
            String correo, Calendar fechaNac, File img, List<String> segdores) {
        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
        this.bio = bio;
        this.url = url;
    }
    
    public DataArtista(String bio, String url, String nick, String nombre, String apellido,
            String correo, Calendar fechaNac, File img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
        this.bio = bio;
        this.url = url;
    }
    
}
