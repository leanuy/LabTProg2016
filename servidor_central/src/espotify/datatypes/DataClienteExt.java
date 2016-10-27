package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author Santiago
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataClienteExt extends DataCliente {
    private String[] seg;
    private String[] lis;
    
    public String[] getSeguidos() {
        return seg;
    }

    public String[] getListas() {
        return lis;
    }
    
    public DataClienteExt(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, String[]seg, String[] lis,
            List<String> segdores) {
        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
        this.seg = seg;
        this.lis = lis;
    }
    
    public DataClienteExt(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, String[]seg, String[]lis, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
        this.seg = seg;
        this.lis = lis;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            final DataClienteExt other = (DataClienteExt) obj;
            return !(other == null
                   || !(Arrays.deepEquals(this.seg, other.seg))
                   || !(Arrays.deepEquals(this.lis, other.lis))
                   || !(Objects.equals(this.getNick(), other.getNick()))
                   || !(Objects.equals(this.getNombre(), other.getNombre()))
                   || !(Objects.equals(this.getApellido(), other.getApellido()))
                   || !(Objects.equals(this.getCorreo(), other.getCorreo()))
                   || !(Objects.equals(this.getfNac(), other.getfNac()))
                   || !(Objects.equals(this.getImg(), other.getImg())));
        }
    }    

    public String[] getSeg() {
        return seg;
    }

    public String[] getLis() {
        return lis;
    }

    public void setSeg(String[] seg) {
        this.seg = seg;
    }

    public void setLis(String[] lis) {
        this.lis = lis;
    }

    public DataClienteExt() {
        super();
    }
}
