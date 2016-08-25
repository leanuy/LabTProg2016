package espotify.Datatypes;

import espotify.Album;
import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

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
}