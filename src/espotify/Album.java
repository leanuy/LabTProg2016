package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaArchivo;
import espotify.Datatypes.DataTemaWeb;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Album implements Favoriteable {

    //attrs
    private final String nombre;
    private final int anio;
    private final String img;
    private final Artista artista;
    private HashMap<String, Genero> generos;
    private final ArrayList<Tema> temas;

    //getters
    public String getNombre() {
        return nombre;
    }

    public int getAnio() {
        return anio;
    }

    public String getImg() {
        return img;
    }

    public String getNickArtista() {
        return this.artista.getNick();
    }

    public void addGeneros(HashMap<String, Genero> generos) {
        this.generos = generos;
    }

    public ArrayList<Tema> getTemas() {
        return this.temas;
    }

    private ArrayList<Tema> ValidarTemas(ArrayList<DataTema> data_temas) throws Exception {
        int largo = data_temas.size();
        boolean orden[] = new boolean[largo];
        Arrays.fill(orden, true);

        ArrayList<Tema> lista_temas = new ArrayList<>();
        ArrayList<String> nombres_temas = new ArrayList<>();

        for (int i = 0; i < largo; i++) {
            DataTema dt = data_temas.get(i);

            //Validar Duracion
            if (dt.getDuracion() <= 0) {
                throw new Exception("El tema " + dt.getNombre() + " tiene una duración no válida.");
            }
            //Validar orden: validar que no haya otro tema con ese mismo numero de orden
            //Si el num es mayor a la cantidad de temas tambien tira una exepcion ya que de seguro el orden no es correcto.
            if (dt.getNum() <= 0 || dt.getNum() >= largo) {
                throw new Exception("El tema " + dt.getNombre() + " tiene un número de tema fuera de rango. Pruebe con un número entre 1 y " + largo + ".");
            } else if (orden[dt.getNum() - 1] == true) {
                throw new Exception("El tema " + dt.getNombre() + " tiene un número de tema que ya le corresponde a otro tema.");
            } else {
                orden[dt.getNum() - 1] = true;
                //Si el numero de orden es correcto lo marco como en uso.
            }
            //Validar unicidad de nombres
            if (nombres_temas.contains(dt.getNombre())) {
                throw new Exception("Intenta ingresar mas de un tema con el nombre " + dt.getNombre() + ". Cada tema debe tener un nombre único en el álbum.");
            } else {
                nombres_temas.add(dt.getNombre());
            }
            //Si el tema paso todas las validaciones
            if (dt instanceof DataTemaArchivo) {
                lista_temas.add(new TemaArchivo((DataTemaArchivo) dt, this));
            } else {
                lista_temas.add(new TemaWeb((DataTemaWeb) dt, this));
            }
        }
        return lista_temas;
    }

    //constructores
    public Album(DataAlbumExt dt, Artista artista, HashMap<String, Genero> generos) throws Exception {
        this.nombre = dt.getNombre();
        this.anio = dt.getAnio();
        this.img = dt.getImg();
        this.artista = artista;
        this.generos = generos;
        this.temas = this.ValidarTemas(dt.getTemas());
    }
}
