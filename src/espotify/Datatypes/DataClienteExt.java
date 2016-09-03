package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
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
    
    public DataClienteExt(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, String[]seg, String[]lis, ArrayList<String> segdores){
        super(nick, nombre, apellido, correo, fNac, img, segdores);
        this.seg=seg;
        this.lis=lis;
    }
    
    public DataClienteExt(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, String[]seg, String[]lis){
        super(nick, nombre, apellido, correo, fNac, img);
        this.seg=seg;
        this.lis=lis;
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
