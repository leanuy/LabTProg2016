package espotify.Datatypes;

import java.util.Date;

public class DataCliente extends DataUsuario{

    public DataCliente(String nick, String nombre, String apellido, String correo, Date fNac, String img) {
        super(nick, nombre, apellido, correo, fNac, img);
    }
    
}
