package espotify;

import espotify.datatypes.DataGenero;
import java.io.Serializable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
class Genero implements Serializable {
    //attrs
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private final String nombre;
    private final Map<String,Genero> subgeneros;
    @ManyToMany(mappedBy="generos")
    private final Map<List<String>, Album> albums;

    String getNombre() {
        return nombre;
    }
    
    Genero(final String nombre) {
        this.nombre = nombre;
        this.subgeneros = new HashMap<>();
        this.albums = new HashMap<>();
    }
    
    Genero(DataGenero data) {
        this.nombre = data.getNombre();
        this.subgeneros = new HashMap<>();
        this.albums = new HashMap<>();
    }

    ArrayList<String[]> listarAlbumes() {
        ArrayList<String[]> listaAlbums = new ArrayList();
        Iterator iterador = albums.entrySet().iterator();
        Album actual;
        String[] valores;
        while (iterador.hasNext()) {
            Map.Entry pair = (Map.Entry)iterador.next();
            actual = (Album) pair.getValue();
            valores = new String[2];
            valores[0] = actual.getNombre();
            valores[1] = actual.getNickArtista();
            listaAlbums.add(valores);
        }
        return listaAlbums;
    }

    void addHijo(Genero genero) {
        subgeneros.put(genero.getNombre(), genero);
    }
    
    void addAlbum(Album album) {
        List<String> key = Arrays.asList(album.getNickArtista(), album.getNombre());
        this.albums.putIfAbsent(key, album);
    }

    DataGenero getData(String padre) {
        return new DataGenero(nombre, padre);
    }

    DataGenero listarseRecursivo(String nomPadre) {
        DataGenero salida = this.getData(nomPadre);
        for (Entry<String, Genero> entry : subgeneros.entrySet()) {
            Genero hijo = entry.getValue();
            salida.getHijos().add(hijo.listarseRecursivo(this.nombre));
        }
        return salida;
    }
}
