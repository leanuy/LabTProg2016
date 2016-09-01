package espotify.Datatypes;
import java.util.ArrayList;


public class DataGenero {
    private String nombre;
    private String padre;
    private ArrayList<DataGenero> hijos;

    public String getNombre() {
        return nombre;
    }
    public String getPadre() {
        return padre;
    }
    public ArrayList<DataGenero> getHijos()
    {
        return hijos;
    }

    public DataGenero(String nombre, String padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.hijos=new ArrayList<>();
    }
    //para testing
    public DataGenero(String nombre,String padre,ArrayList<DataGenero> hijos){
        this.nombre = nombre;
        this.padre = padre;
        this.hijos=hijos;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (this == null) {
            return false;
        }
        if (this.getClass() != obj.getClass()) {
            return false;
        }

        
        // igualdades propias de la clase
        DataGenero dt = (DataGenero) obj;
        if(!dt.getNombre().equals(nombre))
            return false;
        if(!dt.getPadre().equals(padre))
            return false;
        return this.hijos.equals(dt.hijos);
    }
}
