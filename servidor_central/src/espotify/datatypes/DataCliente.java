package espotify.datatypes;

import java.awt.image.BufferedImage;
import java.util.Calendar;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataCliente extends DataUsuario {
    public DataCliente(String nick, String nombre, String apellido, String correo,
            Calendar fechaNac, BufferedImage img, String pwd) {
        super(nick, nombre, apellido, correo, fechaNac, img, pwd);
    }

    public DataCliente(String nick, String nombre, String apellido, String correo, Calendar fechaNac, BufferedImage img, List<String> segdores) {
        super(nick, nombre, apellido, correo, fechaNac, img, segdores);
    }

    
    
    public DataCliente() {
        super();
    }
    
}
