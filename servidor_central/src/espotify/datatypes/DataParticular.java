package espotify.datatypes;

import java.awt.image.BufferedImage;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataParticular extends DataLista {
    private String nomCliente;

    public String getNomCliente() {
        return nomCliente;
    }

    public DataParticular(String nomCliente, String nombreLista, BufferedImage img) {
        super(nombreLista, img);
        this.nomCliente = nomCliente;
    }

    public DataParticular() {
    }

    public void setNomCliente(String nomCliente) {
        this.nomCliente = nomCliente;
    }
    
    
}
