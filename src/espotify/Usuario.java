package espotify;

import espotify.Datatypes.DataUsuario;
import java.util.Calendar;

public class Usuario {


    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fNac;
    protected String img;

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
        return fNac;
    }

    public String getImg() {
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
    
    public Usuario(DataUsuario d){
        this.nick = d.getNick();
        this.nombre = d.getNombre();
        this.apellido = d.getApellido();
        this.correo = d.getCorreo();
        this.fNac = d.getfNac();
        this.img = d.getImg();
    }
}
