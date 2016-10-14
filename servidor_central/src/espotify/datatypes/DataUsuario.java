package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DataUsuario {
    private final String nick;
    private final String nombre;
    private final String apellido;
    private final String correo;
    private final Calendar fechaNac;
    private final BufferedImage img;
    private final List<String> seguidores;
    private String password;

    public String getNick() {
        return nick;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public String getApellido() {
        return apellido;
    }
    
    public String getCorreo() {
        return correo;
    }
    
    public Calendar getfNac() {
        return fechaNac;
    }
    
    public BufferedImage getImg() {
        return img;
    }
    
    public List<String> getSeguidores() {
        return this.seguidores;
    }
    
    
    public String getfNacStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaNac.getTime());
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, List<String> segdores) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.img = img;
        this.seguidores = segdores;
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo, Calendar fechaNac,
            BufferedImage img, String pwd) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.img = img;
        this.seguidores = new ArrayList();
        this.password = pwd;
    }

    public String getPassword() {
        return this.password;
    }
}
