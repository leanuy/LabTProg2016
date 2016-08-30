package espotify.Datatypes;

import espotify.Particular;
import espotify.Usuario;
import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

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
    
    public DataClienteExt(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, HashMap<String,Usuario> seguidos, HashMap<String,Particular> listas) {
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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DataClienteExt other = (DataClienteExt) obj;
        if (!Arrays.deepEquals(this.seg, other.seg)) {
            return false;
        }
        if (!Arrays.deepEquals(this.lis, other.lis)) {
            return false;
        }
        if (!Objects.equals(this.nick, other.nick)) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.apellido, other.apellido)) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.fNac, other.fNac)) {
            return false;
        }
        if (!Objects.equals(this.img, other.img)) {
            return false;
        }
        return true;
    }
    
    
}
