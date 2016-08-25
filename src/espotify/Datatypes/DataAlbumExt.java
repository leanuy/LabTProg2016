package espotify.Datatypes;

import java.util.ArrayList;

public class DataAlbumExt extends DataAlbum{
    private ArrayList<DataTema> temas;

    public DataAlbumExt(ArrayList<DataTema> temas, String nombre, int anio, ArrayList<String> generos, String img) {
        super(nombre, anio, generos, img);
        this.temas = temas;
    }
    
    public ArrayList<DataTema> getTemas(){
        return this.temas;
    }
}
