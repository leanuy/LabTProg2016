package espotify;

import espotify.Datatypes.DataUsuario;
import java.awt.image.BufferedImage;
import java.util.Calendar;

class Usuario {


    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fNac;
    protected BufferedImage img;

    String getNick() {
        return nick;
    }

    String getNombre() {
        return nombre;
    }

    String getApellido() {
        return apellido;
    }

    String getCorreo() {
        return correo;
    }

    Calendar getfNac() {
        return fNac;
    }

    BufferedImage getImg() {
        return img;
    }
    
    static boolean ValidarDatosUsuario(DataUsuario d) {
        return ValidarCorreo(d.getCorreo()) && !(d.getNick().equals("") || d.getNombre().equals("") || d.getApellido().equals(""));
    }

    private static boolean ValidarCorreo(String s) {
        boolean ok = s.contains("@");
        if(ok)
        {
            int arroba = s.indexOf("@");
            s=s.substring(arroba+1);
            ok = !s.contains("@") && s.contains(".");
        }
        return ok;
        
    }
    
    Usuario(DataUsuario d){
        this.nick = d.getNick();
        this.nombre = d.getNombre();
        this.apellido = d.getApellido();
        this.correo = d.getCorreo();
        this.fNac = (Calendar) d.getfNac().clone();
        this.img = d.getImg();
    }
}
