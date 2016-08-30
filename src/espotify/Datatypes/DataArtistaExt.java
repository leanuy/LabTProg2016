package espotify.Datatypes;

import espotify.Album;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 *
 * @author Santiago
 */
public class DataArtistaExt extends DataUsuario {
    private final String bio;
    private final String url;
    private final String[] alb;

    public String getBio() {
        return bio;
    }
    public String getUrl() {
        return url;
    }
    
    public String[] getAlbums(){
        return alb;
    }
    
    public DataArtistaExt(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, String bio, String url, HashMap<String,Album> albums){

        super(nick, nombre, apellido, correo, fNac, img);

        this.bio = bio;
        this.url = url;
        int cant = albums.size();
        alb = new String[cant];
        int i = 0;
        for(Map.Entry<String, Album> entry : albums.entrySet()) {
            String key = entry.getKey();
            alb[i] = key;
            i++;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataArtistaExt other = (DataArtistaExt) obj;
        if (!Objects.equals(this.bio, other.bio)) {
            return false;
        }
        if (!Objects.equals(this.url, other.url)) {
            return false;
        }
        if (!Arrays.deepEquals(this.alb, other.alb)) {
            return false;
        }
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.fNac, other.fNac)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        return true;
    }
    
    
}