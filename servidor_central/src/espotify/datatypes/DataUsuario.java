package espotify.datatypes;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class DataUsuario {
    private String nick;
    private String nombre;
    private String apellido;
    private String correo;
    private Calendar fechaNac;
    private File img;
    private List<String> seguidores;
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
    
    public File getImg() {
        return img;
    }
    
    public List<String> getSeguidores() {
        return this.seguidores;
    }
    
    public String getImgUrl() {
        return "assets/img/profile.png";
    }
    
    public String getfNacStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaNac.getTime());
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, File img, List<String> segdores) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fechaNac = fechaNac;
        this.img = img;
        this.seguidores = segdores;
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo, Calendar fechaNac,
            File img, String pwd) {
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
