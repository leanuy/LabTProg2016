package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataUsuario {
    private String nick;
    private String nombre;
    private String apellido;
    private String correo;
    private Calendar fechaNac;
    private BufferedImage img;
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
    
    public BufferedImage getImg() {
        return img;
    }
    
    public List<String> getSeguidores() {
        return this.seguidores;
    }
    
    @XmlAttribute
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

    public DataUsuario() {
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setFechaNac(Calendar fechaNac) {
        this.fechaNac = fechaNac;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }

    public void setSeguidores(List<String> seguidores) {
        this.seguidores = seguidores;
    }
    
    
}
