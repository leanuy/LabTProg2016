package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaArchivo;
import espotify.Datatypes.DataTemaWeb;
import espotify.Excepciones.DuracionInvalidaException;
import espotify.Excepciones.NumeroTemaInvalidoException;
import espotify.Excepciones.TemaRepetidoException;
import espotify.Excepciones.TemaTipoInvalidoException;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class Album implements Favoriteable {

    //attrs
    private final String nombre;
    private final int anio;
    private final BufferedImage img;
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

    public BufferedImage getImg() {
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

    private ArrayList<Tema> ValidarTemas(ArrayList<DataTema> data_temas) throws DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, TemaTipoInvalidoException {
        int largo = data_temas.size();
        boolean orden[] = new boolean[largo];
        Arrays.fill(orden, false);

        ArrayList<Tema> lista_temas = new ArrayList<>();
        ArrayList<String> nombres_temas = new ArrayList<>();

        for (int i = 0; i < largo; i++) {
            DataTema dt = data_temas.get(i);

            //Validar Duracion
            if (dt.getDuracion() <= 0) {
                throw new DuracionInvalidaException("El tema " + dt.getNombre() + " tiene una duración no válida.");
            }
            //Validar orden: validar que no haya otro tema con ese mismo numero de orden
            //Si el num es mayor a la cantidad de temas tambien tira una exepcion ya que de seguro el orden no es correcto.
            System.out.println(dt.getNum());
            if ((dt.getNum() <= 0) || (dt.getNum() > largo)) {
                throw new NumeroTemaInvalidoException("El tema " + dt.getNombre() + " tiene un número de tema fuera de rango. Pruebe con un número entre 1 y " + largo + ".");
            } else if (orden[dt.getNum() - 1] == true) {
                throw new NumeroTemaInvalidoException("El tema " + dt.getNombre() + " tiene un número de tema que ya le corresponde a otro tema.");
            } else {
                orden[dt.getNum() - 1] = true;
                //Si el numero de orden es correcto lo marco como en uso.
            }
            //Validar unicidad de nombres
            if (nombres_temas.contains(dt.getNombre())) {
                throw new TemaRepetidoException("Intenta ingresar mas de un tema con el nombre " + dt.getNombre() + ". Cada tema debe tener un nombre único en el álbum.");
            } else {
                nombres_temas.add(dt.getNombre());
            }
            //Si el tema paso todas las validaciones
            if (dt instanceof DataTemaArchivo) {
                lista_temas.add(new TemaArchivo((DataTemaArchivo) dt, this));
            } else if (dt instanceof DataTemaWeb) {
                lista_temas.add(new TemaWeb((DataTemaWeb) dt, this));
            }else{
                throw new TemaTipoInvalidoException();
            }
        }
        return lista_temas;
    }

    //constructores
    public Album(DataAlbumExt dt, Artista artista, HashMap<String, Genero> generos) throws DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, TemaTipoInvalidoException {
        this.nombre = dt.getNombre();
        this.anio = dt.getAnio();
        this.img = dt.getImg();
        this.artista = artista;
        this.generos = generos;
        this.temas = this.ValidarTemas(dt.getTemas());
    }
    
    public String getClaveArtista(){
        return artista.getNick();
    }
    
    public DataAlbumExt getDataExt() {
        ArrayList<DataTema> data_temas = new ArrayList();
        Iterator<Tema> it = temas.iterator();
        Tema tema_actual;
        while (it.hasNext()) {
            tema_actual = it.next();
            data_temas.add(tema_actual.getData());
        }
        Iterator itg = generos.entrySet().iterator();
        Genero genero_actual;
        ArrayList<String> nombre_generos = new ArrayList<String>();
        while (it.hasNext()) {
            Map.Entry pair = (Map.Entry)it.next();
            genero_actual = (Genero) pair.getValue();
            nombre_generos.add(genero_actual.getNombre());
        }
        return new DataAlbumExt(data_temas, this.nombre, this.anio, nombre_generos, this.img, artista.getNick());
    }
}
