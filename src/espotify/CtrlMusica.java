package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Interfaces.IAltaGenero;
import espotify.Datatypes.DataAlbumExt;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.AlbumRepetidoException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.CampoVacioException;
import espotify.Excepciones.DuracionInvalidaException;
import espotify.Excepciones.GeneroInexistenteException;
import espotify.Excepciones.GeneroRepetidoException;
import espotify.Excepciones.NumeroTemaInvalidoException;
import espotify.Excepciones.TemaRepetidoException;
import espotify.Excepciones.TemaTipoInvalidoException;
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IConsultaAlbum;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map.Entry;

public class CtrlMusica implements IAltaGenero, IAltaAlbum, IConsultaAlbum{
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
    public DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException, AlbumInexistenteException {
        CtrlUsuarios ctrl_usuarios = CtrlUsuarios.getInstancia();
        DataAlbumExt data_album_ext = ctrl_usuarios.ConsultaAlbum(nomAlbum, nomArtista);
        return data_album_ext;
    }
    
    @Override
    public DataGenero ListarGeneros()
    {
        return generoBase.ListarseRecursivo("");
    }
    
    @Override
    public void AltaGenero(DataGenero d) throws GeneroInexistenteException, GeneroRepetidoException
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
                generos.get(padre).AddHijo(g);
            }
            else
                throw new GeneroInexistenteException("No existe el género padre");
        }
        else
            throw new GeneroRepetidoException();
    }
    
    public ArrayList<String[]> ListarAlbumesDeGenero(String nomGenero)throws GeneroInexistenteException{
        Genero genero = BuscarGenero(nomGenero);
        return genero.ListarAlbumes();
    }
    
    public boolean ExisteGenero(String nombre) {
        return generos.containsKey(nombre);
    }

    Genero BuscarGenero(String nombre) throws GeneroInexistenteException{
       Genero genero = generos.get(nombre);
       if (genero == null){
           throw new GeneroInexistenteException("El género no existe!");
       }
       return genero;
    }
    
    public ArrayList<String> ListarArtistas(){
        CtrlUsuarios ctrl_usuarios = CtrlUsuarios.getInstancia();
        return ctrl_usuarios.ListarArtistas();
    }
    public ArrayList<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException{
        CtrlUsuarios ctrl_usuarios = CtrlUsuarios.getInstancia();
        return ctrl_usuarios.ListarAlbumesDeArtista(nomArtista);
    }
    
    //AltaAlbum
    
    public DataGenero ExisteArtista(String nickArtista) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstancia();
        Artista inst_artista = ctrlUsuarios.BuscarArtista(nickArtista);
        this.artistaMEM = inst_artista;
        return this.ListarGeneros();
    }
    
    private Genero getGenero(String nombre) {
        return generos.get(nombre);
    }
    
    private HashMap<String, Genero> ValidarGeneros(ArrayList<String> lista_generos) throws GeneroInexistenteException, CampoVacioException {
        if(lista_generos.isEmpty()){
            throw new CampoVacioException("Un álbum debe tener al menos un género");
        }
        HashMap<String, Genero> lista = new HashMap<>();
        for (String nombre_genero : lista_generos) {
            if (this.ExisteGenero(nombre_genero)) {
                Genero genero = this.getGenero(nombre_genero);
                lista.putIfAbsent(nombre_genero, genero);
            } else {
                throw new GeneroInexistenteException();
            }
        }
        return lista;
    }
    
    public void AltaAlbum(DataAlbumExt d) throws AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException,ArtistaInexistenteException {
        //Validar unicidad de nombre para el album
        CtrlUsuarios ctrlUsuarios = CtrlUsuarios.getInstancia();
        Artista inst_artista = ctrlUsuarios.BuscarArtista(d.getNickArtista());
        if (inst_artista.TieneAlbum(d.getNombre())) {
            throw new AlbumRepetidoException();
        }
        //Validar lista de nombres de generos y generar un hash de generos para el album
        HashMap<String, Genero> lista_generos = this.ValidarGeneros(d.getGeneros());
        Album album = new Album(d, inst_artista, lista_generos);
        lista_generos.entrySet().stream().forEach((entry) -> {
            entry.getValue().AddAlbum(album);
        });
        inst_artista.addAlbum(album);
    }
}
