package espotify;

import espotify.Datatypes.DataGenero;
import espotify.Interfaces.IAltaGenero;
import espotify.Datatypes.DataAlbumExt;
import espotify.Interfaces.IAltaAlbum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CtrlMusica implements IAltaGenero, IAltaAlbum{

    private static CtrlMusica instancia;
    private final HashMap<String,Genero> generos;
    private final Genero generoBase;
    private Artista artistaMEM;
    //getters
    public static CtrlMusica getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlMusica();
        return instancia;
    }
    //constructor
    private CtrlMusica()
    {
        this.generoBase=new Genero("Genero");
        this.generos=new HashMap<>();
        generos.put(generoBase.getNombre(), generoBase);
    }
    
    //otros métodos
    
    @Override
    public DataGenero ListarGeneros()
    {
        return generoBase.ListarseRecursivo("");
    }
    
    @Override
    public void AltaGenero(DataGenero d) throws Exception
    {
        if(!ExisteGenero(d.getNombre()))
        {
            String padre;
            if (d.getPadre().equals("")) {
                padre = "Genero";
            } else {
                padre = d.getPadre();
            }
            if (ExisteGenero(padre))
            {
                Genero g = new Genero(d);
                generos.put(d.getNombre(), g);
                generos.get(d.getPadre()).AddHijo(g);
            }
            else
                throw new Exception("No existe el género padre");
        }
        else
            throw new Exception("Ya existe un género con ese nombre");
    }

    private boolean ExisteGenero(String nombre) {
        return generos.containsKey(nombre);
    }

    Genero BuscarGenero(String genero) {
        return generos.get(genero);
    }
    
    //AltaAlbum
    
    public DataGenero ExisteArtista(String nickArtista) throws Exception {
        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstancia();
        Artista inst_artista = ctrlUsuarios.BuscarArtista(nickArtista);
        if (inst_artista == null) {
            throw new Exception("El artista no existe. Por favor seleccione un artista distinto.");
        }
        this.artistaMEM = inst_artista;
        return this.ListarGeneros();
    }
    
    private Genero getGenero(String nombre) {
        return generos.get(nombre);
    }
    
    private HashMap<String, Genero> ValidarGeneros(ArrayList<String> lista_generos) throws Exception {
        HashMap<String, Genero> lista = new HashMap<>();
        for (String nombre_genero : lista_generos) {
            if (this.ExisteGenero(nombre_genero)) {
                Genero genero = this.getGenero(nombre_genero);
                lista.putIfAbsent(nombre_genero, genero);
            } else {
                throw new Exception("El género " + nombre_genero + " no existe y por lo tanto no se puede agregar al album.");
            }
        }
        return lista;
    }
    
    public void AltaAlbum(DataAlbumExt d) throws Exception {
        //Validar unicidad de nombre para el album
        if (this.artistaMEM.TieneAlbum(d.getNombre())) {
            throw new Exception("El artista que ha ingresado ya tiene un album con ese nombre. Por favor seleccione un nombre distinto.");
        }
        //Validar lista de nombres de generos y generar un hash de generos para el album
        HashMap<String, Genero> lista_generos = this.ValidarGeneros(d.getGeneros());
        Album album = new Album(d, this.artistaMEM, lista_generos);
        lista_generos.entrySet().stream().forEach((entry) -> {
            entry.getValue().AddAlbum(album);
        });
        this.artistaMEM.addAlbum(album);
    }
}
