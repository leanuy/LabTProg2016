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
    String getNombre() {
        return nombre;
    }
    
    String getNickArtista() {
        return this.artista.getNick();
    }
    
    ArrayList<DataTema> getDataTemas() {
        ArrayList<DataTema> salida = new ArrayList<>();
        DataTema dt;
        for (Tema t : temas) {
            dt = t.getData();
            salida.add(dt);
        }
        return salida;
    }
    
    DataAlbumExt getDataExt() {
        ArrayList<DataTema> dataTemas = new ArrayList();
        Iterator<Tema> it = temas.iterator();
        Tema temaActual;
        while (it.hasNext()) {
            temaActual = it.next();
            dataTemas.add(temaActual.getData());
        }
        Iterator itg = generos.entrySet().iterator();
        Genero generoActual;
        ArrayList<String> nombreGeneros = new ArrayList<String>();
        while (itg.hasNext()) {
            Map.Entry pair = (Map.Entry)itg.next();
            generoActual = (Genero) pair.getValue();
            nombreGeneros.add(generoActual.getNombre());
        }
        return new DataAlbumExt(dataTemas, this.nombre, this.anio,
                nombreGeneros, this.img, artista.getNick());
    }

    private ArrayList<Tema> ValidarTemas(ArrayList<DataTema> data_temas) throws
            DuracionInvalidaException, NumeroTemaInvalidoException,
            TemaRepetidoException, TemaTipoInvalidoException {
        int largo = data_temas.size();
        boolean[] orden = new boolean[largo];
        Arrays.fill(orden, false);

        ArrayList<Tema> listaTemas = new ArrayList<>();
        ArrayList<String> nombresTemas = new ArrayList<>();

        for (int i = 0; i < largo; i++) {
            DataTema dt = data_temas.get(i);

            //Validar Duracion
            if (dt.getDuracion() <= 0) {
                throw new DuracionInvalidaException("El tema " + dt.getNombre() + " tiene una duración no válida.");
            }
            //Validar orden: validar que no haya otro tema con ese mismo numero de orden
            //Si el num es mayor a la cantidad de temas tambien tira una exepcion
            // ya que de seguro el orden no es correcto.
            if ((dt.getNum() <= 0) || (dt.getNum() > largo)) {
                throw new NumeroTemaInvalidoException("El tema " + dt.getNombre() + " tiene un número de tema fuera de rango. Pruebe con un número entre 1 y " + largo + ".");
            } else if (orden[dt.getNum() - 1] == true) {
                throw new NumeroTemaInvalidoException("El tema " + dt.getNombre() + " tiene un número de tema que ya le corresponde a otro tema.");
            } else {
                orden[dt.getNum() - 1] = true;
                //Si el numero de orden es correcto lo marco como en uso.
            }
            //Validar unicidad de nombres
            if (nombresTemas.contains(dt.getNombre())) {
                throw new TemaRepetidoException("Intenta ingresar mas de un tema con el nombre " + dt.getNombre() + ". Cada tema debe tener un nombre único en el álbum.");
            } else {
                nombresTemas.add(dt.getNombre());
            }
            //Si el tema paso todas las validaciones
            if (dt instanceof DataTemaArchivo) {
                listaTemas.add(new TemaArchivo((DataTemaArchivo) dt, this));
            } else if (dt instanceof DataTemaWeb) {
                listaTemas.add(new TemaWeb((DataTemaWeb) dt, this));
            } else {
                throw new TemaTipoInvalidoException();
            }
        }
        return listaTemas;
    }
    //constructores
    Album(DataAlbumExt dt, Artista artista, HashMap<String, Genero> generos)
            throws DuracionInvalidaException, NumeroTemaInvalidoException,
            TemaRepetidoException, TemaTipoInvalidoException {
        this.nombre = dt.getNombre();
        this.anio = dt.getAnio();
        this.img = dt.getImg();
        this.artista = artista;
        this.generos = generos;
        this.temas = this.ValidarTemas(dt.getTemas());
    }

    Tema DevolverTema(String nombretema) {
        Tema salida = null;
        for (Tema t2 : temas) {
            if (t2.getNombre().equals(nombretema)) {
                salida = t2;
            }
        }
        return salida;
    }
}
