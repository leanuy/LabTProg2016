package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataGenero;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.GeneroRepetidoException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;
import espotify.interfaces.IAltaAlbum;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IConsultaAlbum;
import espotify.interfaces.web.IVerAlbum;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CtrlMusica implements IAltaGenero, IAltaAlbum, IConsultaAlbum,
        IVerAlbum {
    private Artista artistaMem;

//constructor
    public CtrlMusica() {
    }
    
//Acceso al Manejador
    Genero buscarGenero(String nombre) throws GeneroInexistenteException {
        Genero genero = ManejadorColecciones.getInstancia().buscarGenero(nombre);
        if (genero == null) {
            throw new GeneroInexistenteException("El género no existe!");
        }
        return genero;
    }
    
    private void agregarGenero(String nom,Genero genero) {
        ManejadorColecciones.getInstancia().agregarGenero(nom, genero);
    }
    
    private static Map<String, Genero> getGeneros() {
        return ManejadorColecciones.getInstancia().getGeneros();
    }
    
    private static Genero getGeneroBase() {
        return ManejadorColecciones.getInstancia().getGeneroBase();
    }
//Listas
    @Override
    public DataGenero listarGeneros() {
        return getGeneroBase().listarseRecursivo("");
    }

    @Override
    public List<String[]> listarAlbumesDeGenero(String nomGenero)throws GeneroInexistenteException {
        Genero genero = buscarGenero(nomGenero);
        return genero.listarAlbumes();
    }
    
    @Override
    public List<String> listarArtistas() {
        return new CtrlUsuarios().listarArtistas();
    }
    
    @Override
    public List<String> listarAlbumesDeArtista(String nomArtista)
            throws ArtistaInexistenteException {
        return new CtrlUsuarios().listarAlbumesDeArtista(nomArtista);
    }

//Consultas
    @Override
    public DataAlbumExt consultaAlbum(String nomAlbum, String nomArtista)
            throws ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().consultaAlbum(nomAlbum, nomArtista);
    }
    
    private boolean existeGenero(String nombre) {
        return getGeneros().containsKey(nombre);
    }
    
//Operaciones    
    @Override
    public void altaGenero(DataGenero data)
            throws GeneroInexistenteException, GeneroRepetidoException {
        if (!existeGenero(data.getNombre())) {
            String padre;
            if (data.getPadre().equals("")) {
                padre = "Genero";
            } else {
                padre = data.getPadre();
            }
            if (existeGenero(padre)) {
                Genero nuevoGenero = new Genero(data);
                agregarGenero(data.getNombre(), nuevoGenero);
                buscarGenero(padre).addHijo(nuevoGenero);
            } else {
                throw new GeneroInexistenteException("No existe el género padre");
            }
        } else {
            throw new GeneroRepetidoException();
        }
    }
    
    private Map<String, Genero> validarGeneros(List<String> listaGeneros)
            throws GeneroInexistenteException, CampoVacioException {
        if (listaGeneros.isEmpty()) {
            throw new CampoVacioException("Un álbum debe tener al menos un género");
        }
        HashMap<String, Genero> lista = new HashMap<>();
        for (String nombreGenero : listaGeneros) {
            Genero genero = buscarGenero(nombreGenero);
            lista.putIfAbsent(nombreGenero, genero);
        }
        return lista;
    }
    
    public void altaAlbum(DataAlbumExt dataAlbum)
            throws AlbumRepetidoException, GeneroInexistenteException,
            DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException,
            CampoVacioException, TemaTipoInvalidoException,ArtistaInexistenteException {
        //Validar unicidad de nombre para el album
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(dataAlbum.getNickArtista());
        if (art.tieneAlbum(dataAlbum.getNombre())) {
            throw new AlbumRepetidoException();
        }
        //Validar lista de nombres de generos y generar un hash de generos para el album
        Map<String, Genero> lstGeneros = this.validarGeneros(dataAlbum.getGeneros());
        Album album = new Album(dataAlbum, art, lstGeneros);
        lstGeneros.entrySet().stream().forEach((entry) -> {
            entry.getValue().addAlbum(album);
        });
        art.addAlbum(album);
    }
    
}
