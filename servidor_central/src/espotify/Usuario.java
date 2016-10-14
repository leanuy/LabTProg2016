package espotify;

import espotify.datatypes.DataUsuario;
import espotify.excepciones.SeguidoRepetidoException;

import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

class Usuario {
    private String nick;
    private String nombre;
    private String apellido;
    private String correo;
    private Calendar fechaNac;
    private BufferedImage img;
    private Map<String, Cliente> seguidores;
    private String password;

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
    
    String getPassword() {
        return this.password;
    }
    
    Map<String, Cliente> getSeguidores() {
        return this.seguidores;
    }
    
    static boolean validarDatosUsuario(DataUsuario data) {
        return validarCorreo(data.getCorreo()) && !(data.getNick().equals("")
                || data.getNombre().equals("") || data.getApellido().equals(""));
    }

    private static boolean validarCorreo(String correo) {
        boolean salida = correo.contains("@");
        if (salida) {
            int arroba = correo.indexOf('@');
            String aux = correo.substring(arroba + 1);
            salida = !aux.contains("@") && aux.contains(".");
        }
        return salida;
    }
    
    public void agregarSeguidor(Cliente cli) throws SeguidoRepetidoException {
        String nombreSeguidor = cli.getNick();
        Cliente seguido = seguidores.get(nombreSeguidor);
        if (seguido != null) {
            throw new SeguidoRepetidoException();
        }
        seguidores.put(nombreSeguidor, cli);
    }
    
    public void noMeSiguenMas(Cliente cli) {
        seguidores.remove(cli.getNick(), cli);
    }
    
    Usuario(DataUsuario dataUsuario) {
        this.nick = dataUsuario.getNick();
        this.nombre = dataUsuario.getNombre();
        this.apellido = dataUsuario.getApellido();
        this.correo = dataUsuario.getCorreo();
        this.fechaNac = (Calendar) dataUsuario.getfNac().clone();
        this.img = dataUsuario.getImg();
        this.seguidores = new HashMap();
        this.password = dataUsuario.getPassword();
    }
}