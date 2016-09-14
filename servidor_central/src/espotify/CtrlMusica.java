package espotify;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
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
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IConsultaAlbum;

import java.util.List;
import java.util.HashMap;
import java.util.Map;

public class CtrlMusica implements IAltaGenero, IAltaAlbum, IConsultaAlbum {
    private Artista artistaMem;

//constructor
    public CtrlMusica() {
    }
    
//Acceso al Manejador
    Genero BuscarGenero(String nombre) throws GeneroInexistenteException {
        Genero genero = ManejadorColecciones.getInstancia().buscarGenero(nombre);
        if (genero == null) {
            throw new GeneroInexistenteException("El género no existe!");
        }
        return genero;
    }
    
    private void AgregarGenero(String nom,Genero genero) {
        ManejadorColecciones.getInstancia().agregarGenero(nom, genero);
    }
    
    private static Map<String, Genero> GetGeneros() {
        return ManejadorColecciones.getInstancia().getGeneros();
    }
    
    private static Genero GetGeneroBase() {
        return ManejadorColecciones.getInstancia().getGeneroBase();
    }
//Listas
    @Override
    public DataGenero ListarGeneros() {
        return GetGeneroBase().listarseRecursivo("");
    }

    @Override
    public List<String[]> ListarAlbumesDeGenero(String nomGenero)throws GeneroInexistenteException {
        Genero genero = BuscarGenero(nomGenero);
        return genero.listarAlbumes();
    }
    
    @Override
    public List<String> ListarArtistas() {
        return new CtrlUsuarios().listarArtistas();
    }
    
    @Override
    public List<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException {
        return new CtrlUsuarios().listarAlbumesDeArtista(nomArtista);
    }

//Consultas
    @Override
    public DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().consultaAlbum(nomAlbum, nomArtista);
    }
    
    private boolean ExisteGenero(String nombre) {
        return GetGeneros().containsKey(nombre);
    }
    
//Operaciones    
    @Override
    public void AltaGenero(DataGenero dGenero) throws GeneroInexistenteException, GeneroRepetidoException {
        if (!ExisteGenero(dGenero.getNombre())) {
            String padre;
            if (dGenero.getPadre().equals("")) {
                padre = "Genero";
            } else {
                padre = dGenero.getPadre();
            }
            if (ExisteGenero(padre)) {
                Genero nuevoGenero = new Genero(dGenero);
                AgregarGenero(dGenero.getNombre(), nuevoGenero);
                BuscarGenero(padre).addHijo(nuevoGenero);
            } else {
                throw new GeneroInexistenteException("No existe el género padre");
            }
        } else {
            throw new GeneroRepetidoException();
        }
    }
    
    private Map<String, Genero> ValidarGeneros(List<String> listaGeneros)
            throws GeneroInexistenteException, CampoVacioException {
        if (listaGeneros.isEmpty()) {
            throw new CampoVacioException("Un álbum debe tener al menos un género");
        }
        HashMap<String, Genero> lista = new HashMap<>();
        for (String nombreGenero : listaGeneros) {
            Genero genero = BuscarGenero(nombreGenero);
            lista.putIfAbsent(nombreGenero, genero);
        }
        return lista;
    }
    
    public void AltaAlbum(DataAlbumExt dAlbum) throws AlbumRepetidoException, GeneroInexistenteException,
            DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException,
            CampoVacioException, TemaTipoInvalidoException,ArtistaInexistenteException {
        //Validar unicidad de nombre para el album
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(dAlbum.getNickArtista());
        if (art.TieneAlbum(dAlbum.getNombre())) {
            throw new AlbumRepetidoException();
        }
        //Validar lista de nombres de generos y generar un hash de generos para el album
        Map<String, Genero> lstGeneros = this.ValidarGeneros(dAlbum.getGeneros());
        Album album = new Album(dAlbum, art, lstGeneros);
        lstGeneros.entrySet().stream().forEach((entry) -> {
            entry.getValue().addAlbum(album);
        });
        art.addAlbum(album);
    }
    
}
