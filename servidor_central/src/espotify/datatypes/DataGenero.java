package espotify.datatypes;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataGenero {
    private String nombre;
    private String padre;
    private ArrayList<DataGenero> hijos;

    public DataGenero() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setPadre(String padre) {
        this.padre = padre;
    }

    public void setHijos(ArrayList<DataGenero> hijos) {
        this.hijos = hijos;
    }

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
    public DataGenero(String nombre,String padre,ArrayList<DataGenero> hijos) {
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
        DataGenero data = (DataGenero) obj;
        if (!data.getNombre().equals(nombre)) {
            return false;
        }
        if (!data.getPadre().equals(padre)) {
            return false;
        }
        return this.hijos.equals(data.hijos);
    }
}
