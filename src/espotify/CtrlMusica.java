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
    private Artista artistaMEM;

//constructor
    public CtrlMusica()
    {
    }
    
//Acceso al Manejador
    Genero BuscarGenero(String nombre) throws GeneroInexistenteException{
       Genero genero = ManejadorColecciones.getInstancia().BuscarGenero(nombre);
       if (genero == null){
           throw new GeneroInexistenteException("El género no existe!");
       }
       return genero;
    }
    private void AgregarGenero(String nom,Genero g) {
        ManejadorColecciones.getInstancia().AgregarGenero(nom, g);
    }
    private static HashMap<String, Genero> GetGeneros() {
        return ManejadorColecciones.getInstancia().getGeneros();
    }
    private static Genero GetGeneroBase() {
        return ManejadorColecciones.getInstancia().getGeneroBase();
    }
//Listas
    @Override
    public DataGenero ListarGeneros() {
        return GetGeneroBase().ListarseRecursivo("");
    }
    @Override
    public ArrayList<String[]> ListarAlbumesDeGenero(String nomGenero)throws GeneroInexistenteException{
        Genero genero = BuscarGenero(nomGenero);
        return genero.ListarAlbumes();
    }
    @Override
    public ArrayList<String> ListarArtistas(){
        CtrlUsuarios ctrl_usuarios = new CtrlUsuarios();
        return ctrl_usuarios.ListarArtistas();
    }
    @Override
    public ArrayList<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException{
        CtrlUsuarios ctrl_usuarios = new CtrlUsuarios();
        return ctrl_usuarios.ListarAlbumesDeArtista(nomArtista);
    }

//Consultas
    @Override
    public DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException, AlbumInexistenteException {
        CtrlUsuarios ctrl_usuarios = new CtrlUsuarios();
        DataAlbumExt data_album_ext = ctrl_usuarios.ConsultaAlbum(nomAlbum, nomArtista);
        return data_album_ext;
    }
    private boolean ExisteGenero(String nombre) {
        return GetGeneros().containsKey(nombre);
    }
    @Override
    public DataGenero ExisteArtista(String nickArtista) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista inst_artista = ctrlUsuarios.BuscarArtista(nickArtista);
        this.artistaMEM = inst_artista;
        return this.ListarGeneros();
    }
    
//Operaciones    
    @Override
    public void AltaGenero(DataGenero d) throws GeneroInexistenteException, GeneroRepetidoException {
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
                AgregarGenero(d.getNombre(), g);
                BuscarGenero(padre).AddHijo(g);
            }
            else
                throw new GeneroInexistenteException("No existe el género padre");
        }
        else
            throw new GeneroRepetidoException();
    }
    private HashMap<String, Genero> ValidarGeneros(ArrayList<String> lista_generos) throws GeneroInexistenteException, CampoVacioException {
        if(lista_generos.isEmpty()){
            throw new CampoVacioException("Un álbum debe tener al menos un género");
        }
        HashMap<String, Genero> lista = new HashMap<>();
        for (String nombre_genero : lista_generos) {
            Genero genero = BuscarGenero(nombre_genero);
            lista.putIfAbsent(nombre_genero, genero);
        }
        return lista;
    }
    @Override
    public void AltaAlbum(DataAlbumExt d) throws AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
       
//Validar unicidad de nombre para el album
        if (this.artistaMEM.TieneAlbum(d.getNombre())) {
            throw new AlbumRepetidoException();
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
