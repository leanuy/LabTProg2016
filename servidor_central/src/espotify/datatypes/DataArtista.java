package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataArtista extends DataUsuario {
    private String bio;
    private String url;

    public String getBio() {
        return bio;
    }
    
    public String getUrl() {
        return url;
    }
    
    public DataArtista(String bio, String url, String nick, String nombre, String apellido,
            String correo, Calendar fechaNac, BufferedImage img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
        this.bio = bio;
        this.url = url;
    }

    public DataArtista(String bio, String url, String nick, String nombre, String apellido, String correo, Calendar fechaNac, BufferedImage img, List<String> segdores) {
        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
        this.bio = bio;
        this.url = url;
    }
    
    public DataArtista() {
        super();
    }

    public void setBio(String bio) {
        this.bio = bio;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
