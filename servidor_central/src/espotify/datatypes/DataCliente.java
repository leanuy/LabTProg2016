package espotify.datatypes;

import java.io.File;
import java.util.Calendar;
import java.util.List;

public class DataCliente extends DataUsuario {

    public DataCliente(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, File img, List<String> segdores) {
        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
    }
    
    public DataCliente(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, File img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
    }
    
}
