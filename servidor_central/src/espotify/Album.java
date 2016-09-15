package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaArchivo;
import espotify.datatypes.DataTemaWeb;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Album implements Favoriteable {
    //attrs
    private final String nombre;
    private final int anio;
    private final BufferedImage img;
    private final Artista artista;
    private final Map<String, Genero> generos;
    private final List<Tema> temas;
    
    //getters
    String getNombre() {
        return nombre;
    }
    
    String getNickArtista() {
        return this.artista.getNick();
    }
    
    List<DataTema> getDataTemas() {
        ArrayList<DataTema> salida = new ArrayList<>();
        DataTema dTema;
        for (Tema t : temas) {
            dTema = t.getData();
            salida.add(dTema);
        }
        return salida;
    }
    
    DataAlbumExt getDataExt() {
        List<DataTema> dataTemas = new ArrayList();
        Iterator<Tema> iterador = temas.iterator();
        Tema temaActual;
        while (iterador.hasNext()) {
            temaActual = iterador.next();
            dataTemas.add(temaActual.getData());
        }
        Iterator itg = generos.entrySet().iterator();
        Genero generoActual;
        List<String> nombreGeneros = new ArrayList<String>();
        while (itg.hasNext()) {
            Map.Entry pair = (Map.Entry)itg.next();
            generoActual = (Genero) pair.getValue();
            nombreGeneros.add(generoActual.getNombre());
        }
        return new DataAlbumExt(dataTemas, this.nombre, this.anio,
                nombreGeneros, this.img, artista.getNick());
    }

    private List<Tema> validarTemas(List<DataTema> dataTemas) throws
            DuracionInvalidaException, NumeroTemaInvalidoException,
            TemaRepetidoException, TemaTipoInvalidoException {
        int largo = dataTemas.size();
        boolean[] orden = new boolean[largo];
        Arrays.fill(orden, false);

        List<Tema> listaTemas = new ArrayList<>();
        List<String> nombresTemas = new ArrayList<>();

        for (int i = 0; i < largo; i++) {
            DataTema dTema = dataTemas.get(i);

            //Validar Duracion
            if (dTema.getDuracion() <= 0) {
                throw new DuracionInvalidaException(
                        "El tema " + dTema.getNombre() + " tiene una duración no válida.");
            }
            //Validar orden: validar que no haya otro tema con ese mismo numero de orden
            //Si el num es mayor a la cantidad de temas tambien tira una exepcion
            // ya que de seguro el orden no es correcto.
            if (dTema.getNum() <= 0 || dTema.getNum() > largo) {
                throw new NumeroTemaInvalidoException(
                        "El tema " + dTema.getNombre() + " tiene un número de tema fuera de rango. "
                        + "Pruebe con un número entre 1 y " + largo + ".");
            } else if (orden[dTema.getNum() - 1] == true) {
                throw new NumeroTemaInvalidoException(
                        "El tema " + dTema.getNombre() +
                        " tiene un número de tema que ya le corresponde a otro tema.");
            } else {
                orden[dTema.getNum() - 1] = true;
                //Si el numero de orden es correcto lo marco como en uso.
            }
            //Validar unicidad de nombres
            if (nombresTemas.contains(dTema.getNombre())) {
                throw new TemaRepetidoException("Intenta ingresar mas de un tema con el nombre "
                        + dTema.getNombre() + ". Cada tema debe tener un nombre único en el álbum.");
            } else {
                nombresTemas.add(dTema.getNombre());
            }
            //Si el tema paso todas las validaciones
            if (dTema instanceof DataTemaArchivo) {
                listaTemas.add(new TemaArchivo((DataTemaArchivo) dTema, this));
            } else if (dTema instanceof DataTemaWeb) {
                listaTemas.add(new TemaWeb((DataTemaWeb) dTema, this));
            } else {
                throw new TemaTipoInvalidoException();
            }
        }
        return listaTemas;
    }
    //constructores
    Album(DataAlbumExt dataAlbum, Artista artista, Map<String, Genero> generos)
            throws DuracionInvalidaException, NumeroTemaInvalidoException,
            TemaRepetidoException, TemaTipoInvalidoException {
        this.nombre = dataAlbum.getNombre();
        this.anio = dataAlbum.getAnio();
        this.img = dataAlbum.getImg();
        this.artista = artista;
        this.generos = generos;
        this.temas = this.validarTemas(dataAlbum.getTemas());
    }

    Tema devolverTema(String nombretema) {
        Tema salida = null;
        for (Tema t2 : temas) {
            if (t2.getNombre().equals(nombretema)) {
                salida = t2;
            }
        }
        return salida;
    }
}
