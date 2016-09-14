package espotify.datatypes;

import java.awt.image.BufferedImage;

public class DataParticular extends DataLista {
    private final String nomCliente;

    public String getNomCliente() {
        return nomCliente;
    }

    public DataParticular(String nomCliente, String nombre, BufferedImage img) {
        super(nombre, img);
        this.nomCliente = nomCliente;
    }
    
}
