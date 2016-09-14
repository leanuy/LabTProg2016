package espotify.Datatypes;

import java.util.ArrayList;
import java.util.List;


public class DataGenero {
    private final String nombre;
    private final String padre;
    private final List<DataGenero> hijos;

    public String getNombre() {
        return nombre;
    }
    
    public String getPadre() {
        return padre;
    }
    
    public List<DataGenero> getHijos() {
        return hijos;
    }

    public DataGenero(String nombre, String padre) {
        this.nombre = nombre;
        this.padre = padre;
        this.hijos = new ArrayList<>();
    }
    //para testing
    public DataGenero(String nombre,String padre,List<DataGenero> hijos) {
        this.nombre = nombre;
        this.padre = padre;
        this.hijos = hijos;
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
        DataGenero dGenero = (DataGenero) obj;
        if (!dGenero.getNombre().equals(nombre)) {
            return false;
        }
        if (!dGenero.getPadre().equals(padre)) {
            return false;
        }
        return this.hijos.equals(dGenero.hijos);
    }
}
