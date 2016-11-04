package espotify.datatypes;

import java.util.ArrayList;

/**
 *
 * @author JavierM42
 */
public class BeanListarFavoritos {
    private ArrayList<DataAlbum> albumsFavoritos;
    private ArrayList<DataParticular> particularesFavoritas;
    private ArrayList<DataTema> temasFavoritos;
    private ArrayList<DataDefecto> defectoFavoritas;

    public BeanListarFavoritos() {
    }

    public BeanListarFavoritos(ArrayList<DataAlbum> albumsFavoritos, ArrayList<DataParticular> particularesFavoritas, ArrayList<DataTema> temasFavoritos, ArrayList<DataDefecto> defectoFavoritas) {
        this.albumsFavoritos = albumsFavoritos;
        this.particularesFavoritas = particularesFavoritas;
        this.temasFavoritos = temasFavoritos;
        this.defectoFavoritas = defectoFavoritas;
    }

    public ArrayList<DataAlbum> getAlbumsFavoritos() {
        return albumsFavoritos;
    }

    public ArrayList<DataParticular> getParticularesFavoritas() {
        return particularesFavoritas;
    }

    public ArrayList<DataTema> getTemasFavoritos() {
        return temasFavoritos;
    }

    public ArrayList<DataDefecto> getDefectoFavoritas() {
        return defectoFavoritas;
    }

    public void setAlbumsFavoritos(ArrayList<DataAlbum> albumsFavoritos) {
        this.albumsFavoritos = albumsFavoritos;
    }

    public void setParticularesFavoritas(ArrayList<DataParticular> particularesFavoritas) {
        this.particularesFavoritas = particularesFavoritas;
    }

    public void setTemasFavoritos(ArrayList<DataTema> temasFavoritos) {
        this.temasFavoritos = temasFavoritos;
    }

    public void setDefectoFavoritas(ArrayList<DataDefecto> defectoFavoritas) {
        this.defectoFavoritas = defectoFavoritas;
    }
    
    
}
