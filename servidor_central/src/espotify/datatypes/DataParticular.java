package espotify.datatypes;

import java.io.File;


public class DataParticular extends DataLista {
    private final String nomCliente;

    public String getNomCliente() {
        return nomCliente;
    }

    public DataParticular(String nomCliente, String nombre, File img) {
        super(nombre, img);
        this.nomCliente = nomCliente;
    }
    
}
