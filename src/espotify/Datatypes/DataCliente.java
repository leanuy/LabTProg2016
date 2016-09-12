package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;

public class DataCliente extends DataUsuario {

    public DataCliente(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, ArrayList<String> segdores) {
        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
    }
    
    public DataCliente(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img,pwd);
    }
    
}
