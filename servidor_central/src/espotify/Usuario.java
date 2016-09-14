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
    
    static boolean validarDatosUsuario(DataUsuario data) {
        return validarCorreo(data.getCorreo()) && !(data.getNick().equals("") ||
                data.getNombre().equals("") || data.getApellido().equals(""));
    }

    private static boolean validarCorreo(String correo) {
        boolean salida = correo.contains("@");
        if (salida) {
            int arroba = correo.indexOf('@');
            correo = correo.substring(arroba + 1);
            salida = !correo.contains("@") && correo.contains(".");
        }
        return salida;
    }
    
    public void agregarSeguidor(Cliente cli) throws SeguidoRepetidoException {
        String nombreSeguidor = cli.nick;
        Cliente seguido = seguidores.get(nombreSeguidor);
        if (seguido != null) {
            throw new SeguidoRepetidoException();
        }
        seguidores.put(nombreSeguidor, cli);
    }
    
    public void noMeSiguenMas(Cliente cli) {
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