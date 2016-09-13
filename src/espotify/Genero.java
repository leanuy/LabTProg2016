package espotify;

import espotify.Datatypes.DataGenero;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

class Genero {
    //attrs
    private final String nombre;
    private final HashMap<String,Genero> subgeneros;
    private final HashMap<List<String>, Album> albums;

    //getters
    String getNombre() {
        return nombre;
    }
    //constructores
    Genero(String nombre) {
        this.nombre = nombre;
        this.subgeneros=new HashMap<>();
        this.albums=new HashMap<>();
    }
    
     Genero(DataGenero d) {
        this.nombre = d.getNombre();
        this.subgeneros = new HashMap<>();
        this.albums = new HashMap<>();
    }

    ArrayList<String[]> ListarAlbumes() {
        ArrayList<String[]> listaAlbums = new ArrayList();
        Iterator it = albums.entrySet().iterator();
        Album actual;
        String[] valores;
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            actual = (Album) pair.getValue();
            valores = new String[2];
            valores[0] = actual.getNombre();
            valores[1] = actual.getNickArtista();
            listaAlbums.add(valores);
        }
        return listaAlbums;
    }

    void AddHijo(Genero g) {
        subgeneros.put(g.getNombre(), g);
    }
    
     void AddAlbum(Album album) {
        List<String> key = Arrays.asList(album.getNickArtista(), album.getNombre());
        this.albums.putIfAbsent(key, album);
    }

    DataGenero getData(String padre) {
        return new DataGenero(nombre, padre);
    }

    DataGenero ListarseRecursivo(String nomPadre) {
        DataGenero salida = this.getData(nomPadre);
        for (Entry<String, Genero> entry : subgeneros.entrySet()) {
            Genero hijo = entry.getValue();
            salida.getHijos().add(hijo.ListarseRecursivo(this.nombre));
        }
        return salida;
    }

}
