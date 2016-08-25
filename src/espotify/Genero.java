package espotify;

import espotify.Datatypes.DataGenero;
import espotify.Datatypes.DataDefecto;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;




public class Genero {
    //attrs
    private String nombre;
    private final HashMap<String,Genero> subgeneros;
    private final HashMap<List<String>, Album> albums;

    Genero(String nombre, String genero) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    //getters
    public String getNombre() {
        return nombre;
    }
    //constructores
    public Genero(String nombre)
    {
        this.nombre = nombre;
        this.subgeneros=new HashMap<>();
        this.albums=new HashMap<>();
    }
    public Genero(DataGenero d)
    {
        this.nombre = d.getNombre();
        this.subgeneros = new HashMap<>();
        this.albums = new HashMap<>();
    }

    void AddHijo(Genero g) {
        subgeneros.put(g.getNombre(), g);
    }
    
    public void AddAlbum(Album album) {
        List<String> key = Arrays.asList(album.getArtista().getNick(), album.getNombre());
        this.albums.putIfAbsent(key, album);
    }

    DataGenero getData(String padre) {
        return new DataGenero(nombre, padre);
    }

    DataGenero ListarseRecursivo(String nomPadre) {
        DataGenero d = this.getData(nomPadre);
        for(Entry<String, Genero> entry : subgeneros.entrySet()) {
            Genero g = entry.getValue();
            d.getHijos().add(g.ListarseRecursivo(this.nombre));
        }
        return d;
    }

}
