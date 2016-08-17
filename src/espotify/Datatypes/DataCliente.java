package espotify.Datatypes;

import java.util.Calendar;

public class DataCliente extends DataUsuario{

    public DataCliente(String nick, String nombre, String apellido, String correo, Calendar fNac, String img) {
        super(nick, nombre, apellido, correo, fNac, img);
    }
    
}
