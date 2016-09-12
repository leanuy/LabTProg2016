package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;


public class DataArtista extends DataUsuario {
    private String bio;
    private String url;

    public String getBio() {
        return bio;
    }
    public String getUrl() {
        return url;
    }

    public DataArtista(String bio, String url, String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, ArrayList<String> segdores) {
        super(nick, nombre, apellido, correo, fNac, img, segdores);
        this.bio = bio;
        this.url = url;
    }
    
    public DataArtista(String bio, String url, String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, String pwd) {
        super(nick, nombre, apellido, correo, fNac, img, pwd);
        this.bio = bio;
        this.url = url;
    }
    
}
