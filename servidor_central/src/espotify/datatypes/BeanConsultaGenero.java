package espotify.datatypes;

import java.util.ArrayList;

public class BeanConsultaGenero {
    private ArrayList<String> listas;
    private ArrayList<String[]> albums;
    private DataGenero data;

    public BeanConsultaGenero() {
    }

    public ArrayList<String> getListas() {
        return listas;
    }

    public void setListas(ArrayList<String> listas) {
        this.listas = listas;
    }

    public ArrayList<String[]> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<String[]> albums) {
        this.albums = albums;
    }

    public DataGenero getData() {
        return data;
    }

    public void setData(DataGenero data) {
        this.data = data;
    }
    
    
}
