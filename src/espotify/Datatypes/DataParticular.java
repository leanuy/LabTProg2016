package espotify.Datatypes;

public class DataParticular extends DataLista{
    private String nomCliente;

    public String getNomCliente() {
        return nomCliente;
    }

    public DataParticular(String nomCliente, String nombre, String img) {
        super(nombre, img);
        this.nomCliente = nomCliente;
    }
    
}
