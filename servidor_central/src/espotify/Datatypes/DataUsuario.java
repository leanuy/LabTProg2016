package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Calendar;

public class DataUsuario {
    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fechaNac;
    protected BufferedImage img;
    protected List<String> seguidores;
    protected String password;

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
        List<String> segdores = new ArrayList();
        this.seguidores = segdores;
        this.password = pwd;
    }

    public String getPassword() {
        return this.password;
    }
}
