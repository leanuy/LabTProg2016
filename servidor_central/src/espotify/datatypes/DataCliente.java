package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.Calendar;

public class DataCliente extends DataUsuario {
    public DataCliente(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
    }
    
}
