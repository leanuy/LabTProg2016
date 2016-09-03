package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;

public class DataCliente extends DataUsuario{

    public DataCliente(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, ArrayList<String> segdores) {
        super(nick, nombre, apellido, correo, fNac, img, segdores);
    }
    public DataCliente(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img) {
        super(nick, nombre, apellido, correo, fNac, img);
    }
    
}
