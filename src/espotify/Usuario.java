package espotify;

import espotify.Datatypes.DataUsuario;
import espotify.Excepciones.SeguidoRepetidoException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;

class Usuario {


    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fNac;
    protected BufferedImage img;
    protected HashMap<String,Cliente> seguidores;

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
    
    HashMap<String,Cliente> getSeguidores(){
        return this.seguidores;
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
    
    public void AgregarSeguidor(Cliente c)throws SeguidoRepetidoException{
        String name2 = c.nick;
        Cliente c2 = seguidores.get(name2);
        if (c2 != null){
            throw new SeguidoRepetidoException();
        }
        seguidores.put(name2, c);
    }
    
    public void NoMeSiguenMas(Cliente c){
        seguidores.remove(c.nick, c);
    }
    
    Usuario(DataUsuario d){
        this.nick = d.getNick();
        this.nombre = d.getNombre();
        this.apellido = d.getApellido();
        this.correo = d.getCorreo();
        this.fNac = (Calendar) d.getfNac().clone();
        this.img = d.getImg();
        this.seguidores = new HashMap();
    }
}