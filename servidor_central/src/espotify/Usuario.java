package espotify;

import espotify.Datatypes.DataUsuario;
import espotify.Excepciones.SeguidoRepetidoException;

import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class Usuario {


    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fechaNac;
    protected BufferedImage img;
    protected Map<String,Cliente> seguidores;
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
    
    Map<String,Cliente> getSeguidores() {
        return this.seguidores;
    }
    
    static boolean ValidarDatosUsuario(DataUsuario dUsuario) {
        return ValidarCorreo(dUsuario.getCorreo()) && !(dUsuario.getNick().equals("") ||
                dUsuario.getNombre().equals("") || dUsuario.getApellido().equals(""));
    }

    private static boolean ValidarCorreo(String correo) {
        boolean salida = correo.contains("@");
        if (salida) {
            int arroba = correo.indexOf("@");
            correo = correo.substring(arroba + 1);
            salida = !correo.contains("@") && correo.contains(".");
        }
        return salida;
    }
    
    public void AgregarSeguidor(Cliente cli) throws SeguidoRepetidoException {
        String name2 = cli.nick;
        Cliente seguido = seguidores.get(name2);
        if (seguido != null) {
            throw new SeguidoRepetidoException();
        }
        seguidores.put(name2, cli);
    }
    
    public void NoMeSiguenMas(Cliente cli) {
        seguidores.remove(cli.nick, cli);
    }
    
    Usuario(DataUsuario dUsuario) {
        this.nick = dUsuario.getNick();
        this.nombre = dUsuario.getNombre();
        this.apellido = dUsuario.getApellido();
        this.correo = dUsuario.getCorreo();
        this.fechaNac = (Calendar) dUsuario.getfNac().clone();
        this.img = dUsuario.getImg();
        this.seguidores = new HashMap();
        this.password = dUsuario.getPassword();
    }
}