package espotify;

import espotify.Datatypes.DataUsuario;
import espotify.Excepciones.SeguidoRepetidoException;

import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.HashMap;

class Usuario {


    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fechaNac;
    protected BufferedImage img;
    protected HashMap<String,Cliente> seguidores;
    protected String password;

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

    Calendar getFechaNac() {
        return fechaNac;
    }

    BufferedImage getImg() {
        return img;
    }
    
    HashMap<String,Cliente> getSeguidores() {
        return this.seguidores;
    }
    
    static boolean ValidarDatosUsuario(DataUsuario d) {
        return ValidarCorreo(d.getCorreo()) && !(d.getNick().equals("") ||
                d.getNombre().equals("") || d.getApellido().equals(""));
    }

    private static boolean ValidarCorreo(String correo) {
        boolean ok = correo.contains("@");
        if(ok) {
            int arroba = correo.indexOf("@");
            correo=correo.substring(arroba+1);
            ok = !correo.contains("@") && correo.contains(".");
        }
        return ok;
    }
    
    public void AgregarSeguidor(Cliente cli) throws SeguidoRepetidoException {
        String name2 = cli.nick;
        Cliente c2 = seguidores.get(name2);
        if (c2 != null) {
            throw new SeguidoRepetidoException();
        }
        seguidores.put(name2, cli);
    }
    
    public void NoMeSiguenMas(Cliente c) {
        seguidores.remove(c.nick, c);
    }
    
    Usuario(DataUsuario d) {
        this.nick = d.getNick();
        this.nombre = d.getNombre();
        this.apellido = d.getApellido();
        this.correo = d.getCorreo();
        this.fechaNac = (Calendar) d.getfNac().clone();
        this.img = d.getImg();
        this.seguidores = new HashMap();
        this.password = d.getPassword();
    }
}