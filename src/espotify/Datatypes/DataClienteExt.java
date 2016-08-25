package espotify.Datatypes;

import espotify.Particular;
import espotify.Usuario;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author Santiago
 */
public class DataClienteExt extends DataUsuario {
    private final String[] seg;
    private final String[] lis;
    
    public String[] getSeguidos(){
        return seg;
    }

    public String[] getListas(){
        return lis;
    }
    
    public DataClienteExt(String nick, String nombre, String apellido, String correo, Calendar fNac, String img, HashMap<String,Usuario> seguidos, HashMap<String,Particular> listas) {
        super(nick, nombre, apellido, correo, fNac, img);
        int cant = seguidos.size();
        seg = new String[cant];
        int i = 0;
        for(Map.Entry<String, Usuario> entry : seguidos.entrySet()) {
            String key = entry.getKey();
            seg[i] = key;
            i++;
        }
        cant = listas.size();
        lis = new String[cant];
        i = 0;
        for(Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular value = entry.getValue();
            String nomb = value.getNombre();
            lis[i] = nomb;
            i++;
        }
    }
}
