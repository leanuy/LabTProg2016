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
            Calendar fechaNac, BufferedImage img, String bio, String url, Map<String,Album> albums,
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
            BufferedImage img, String bio, String url, Map<String,Album> albums, String pwd) {

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
        System.out.println("Borrame");
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
        if (!Objects.equals(this.fechaNac, other.fechaNac)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        if (!Arrays.deepEquals(this.alb, other.alb)) {
            return false;
        }
        return true;
    }
    
    
}