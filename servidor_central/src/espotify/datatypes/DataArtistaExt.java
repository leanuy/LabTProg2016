package espotify.datatypes;

import espotify.Album;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
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
    
    public String[] getAlbums() {
        return alb;
    }
    
    public DataArtistaExt(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, String bio, String url, Map<String, Album> albums,
            List<String> segdores) {

        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
        this.bio = bio;
        this.url = url;
        int cant = albums.size();
        alb = new String[cant];
        int idx = 0;
        for (Map.Entry<String, Album> entry : albums.entrySet()) {
            String key = entry.getKey();
            alb[idx] = key;
            idx++;
        }
    }
    
    public DataArtistaExt(String nick, String nombre, String apellido, String correo, Calendar fechaNac,
            BufferedImage img, String bio, String url, Map<String, Album> albums, String pwd) {

        super(nick, nombre, apellido, correo, fechaNac, img, pwd);

        this.bio = bio;
        this.url = url;
        int cant = albums.size();
        alb = new String[cant];
        int idx = 0;
        for (Map.Entry<String, Album> entry : albums.entrySet()) {
            String key = entry.getKey();
            alb[idx] = key;
            idx++;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        else {
            final DataArtistaExt other = (DataArtistaExt) obj;
            return !((other == null) || 
                    !(Objects.equals(this.bio, other.bio)) || 
                    !(Objects.equals(this.url, other.url)) || 
                    !(Objects.equals(this.getNick(), other.getNick())) || 
                    !(Objects.equals(this.getNombre(), other.getNombre())) ||
                    !(Objects.equals(this.getApellido(), other.getApellido())) ||
                    !(Objects.equals(this.getCorreo(), other.getCorreo())) ||
                    !(Objects.equals(this.getfNac(), other.getfNac())) ||
                    !(Objects.equals(this.getImg(), other.getImg())) ||
                    !(Arrays.deepEquals(this.alb, other.alb)));
        }
    }
}