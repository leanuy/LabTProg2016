package espotify;

import espotify.datatypes.DataAlbum;
import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataColeccionTemas;
import espotify.datatypes.DataGenero;
import espotify.datatypes.DataTema;
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
import espotify.interfaces.web.IAltaAlbumWeb;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IBuscar;
import espotify.interfaces.IConsultaAlbum;
import espotify.interfaces.web.IListarGeneros;
import espotify.interfaces.web.ISugerencias;
import espotify.interfaces.web.IVerAlbum;
import espotify.interfaces.web.IVerGenero;
import java.util.ArrayList;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import java.util.TreeMap;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class CtrlMusica implements IAltaGenero, IAltaAlbum, IConsultaAlbum,
        IVerAlbum, IVerGenero, IListarGeneros, IBuscar, IAltaAlbumWeb, ISugerencias{

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
    
    private Map<String, String> stringifyGenerosRecursivo(DataGenero root, String path) {
        Map<String, String> mapa = new TreeMap<>();
        mapa.put(path + root.getNombre(), root.getNombre());
        List<DataGenero> hijos = root.getHijos();
        for (DataGenero next : hijos) {
            mapa.putAll(stringifyGenerosRecursivo(next, path + root.getNombre() + " / "));
        }
        return mapa;
    }
    
    @Override
    public TreeMap<String, String> stringifyDataGeneros() {
        TreeMap<String, String> mapa = new TreeMap<>();
        DataGenero root = listarGeneros();
        List<DataGenero> hijos = root.getHijos();
        for (DataGenero next : hijos) {
            mapa.putAll(stringifyGenerosRecursivo(next, ""));
        }
        return mapa;
    }
    

    @Override
    public ArrayList<String[]> listarAlbumesDeGenero(String nomGenero)throws GeneroInexistenteException {
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
        if (existeGenero(data.getNombre())) {
            throw new GeneroRepetidoException();
        } else {
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
                persistirGenero(nuevoGenero);
            } else {
                throw new GeneroInexistenteException("No existe el género padre");
            }
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
        if (dataAlbum.getNombre().isEmpty()) {
            throw new CampoVacioException();
        }
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
    
    @Override
    public void addAlbumTemp(DataAlbumExt album) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(album.getNickArtista());
        art.addAlbumTemp(album);
    }
    @Override
    public void addTemaAlbumTemp(String artista, DataTema tema) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(artista);
        art.addTemaAlbumTemp(tema);
    }
    @Override
    public void deleteTemaAlbumTemp(String artista, String tema) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(artista);
        art.deleteTemaAlbumTemp(tema);
    }
    @Override
    public DataAlbumExt getAlbumTemp(String nick_artista) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(nick_artista);
        return art.getAlbumTemp();
    }
    @Override
    public void aceptarAltaAlbum(String nick_artista) throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(nick_artista);
        DataAlbumExt data = art.getAlbumTemp();
        altaAlbum(data);
    }
    @Override
    public boolean esAlbumDeArtista(String nick_artista, String album) throws ArtistaInexistenteException {
        CtrlUsuarios ctrlUsuarios = new CtrlUsuarios();
        Artista art = ctrlUsuarios.buscarArtista(nick_artista);
        return art.tieneAlbum(album);
    }
    
    @Override
    public ArrayList<String> listarListasDeGenero(String nomGenero) throws GeneroInexistenteException {
        return new CtrlListas().listarListasDeGenero(nomGenero);
    }
    
    public DataGenero consultaGenero(String nomGenero) throws GeneroInexistenteException {
        return buscarGenero(nomGenero).listarseRecursivo("");
    }
    
    public DataTema consultaTema(String nick, String nomAlbum, String nomTema)
            throws ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().consultaTema(nick,nomAlbum,nomTema);
    }

    public ArrayList<String[]> buscarTemas(String busqueda) {
        busqueda = busqueda.toLowerCase();
        ArrayList<String[]> result = new ArrayList<String[]>();
        ManejadorColecciones manejador = ManejadorColecciones.getInstancia(); 
        Map<String, Artista> artistas = manejador.getArtistas();
        List<Artista> listaArtistas = new ArrayList<Artista>(artistas.values());
        Iterator itArtistas = listaArtistas.iterator();
        Artista artistaActual;
        String[] toAdd;
        while (itArtistas.hasNext()) {
            artistaActual = (Artista) itArtistas.next();
            Map<String, Album> albums = artistaActual.getAlbums();
            List<Album> listaAlbums = new ArrayList<Album>(albums.values());
            Iterator itAlbums = listaAlbums.iterator();
            Album albumActual;
            Integer anoAlbum;
            while (itAlbums.hasNext()) {
                albumActual = (Album) itAlbums.next();
                DataAlbumExt dataAlbumExt = albumActual.getDataExt();
                anoAlbum = dataAlbumExt.getAnio();
                List<String> generos = dataAlbumExt.getGeneros();
                Iterator itGeneros = generos.iterator();
                boolean generoMatchea = false;
                while (itGeneros.hasNext() && !generoMatchea) {
                    generoMatchea = ((String) itGeneros.next()).toLowerCase().contains(busqueda);
                }
                List<DataTema> listaTemas = dataAlbumExt.getTemas();
                Iterator itTemas = listaTemas.iterator();
                DataTema dataTemaActual;
                while (itTemas.hasNext()) {
                    dataTemaActual = (DataTema) itTemas.next();
                    if (generoMatchea || dataTemaActual.getNombre().toLowerCase().contains(busqueda)) {
                        toAdd = new String[4];
                        toAdd[0] = dataTemaActual.getNombre();
                        toAdd[1] = dataTemaActual.getAlbum();
                        toAdd[2] = dataTemaActual.getNomArtista();
                        toAdd[3] = String.valueOf(anoAlbum);
                        result.add(toAdd);
                    }
                }              
            }
        }
       return result;
    }
    
    public ArrayList<DataAlbum> buscarAlbums(String busqueda) {
        busqueda = busqueda.toLowerCase();
        ArrayList<DataAlbum> result = new ArrayList<DataAlbum>();
        ManejadorColecciones manejador = ManejadorColecciones.getInstancia(); 
        Map<String, Artista> artistas = manejador.getArtistas();
        List<Artista> listaArtistas = new ArrayList<Artista>(artistas.values());
        Iterator itArtistas = listaArtistas.iterator();
        Artista artistaActual;
        while (itArtistas.hasNext()) {
            artistaActual = (Artista) itArtistas.next();
            Map<String, Album> albums = artistaActual.getAlbums();
            List<Album> listaAlbums = new ArrayList<Album>(albums.values());
            Iterator itAlbums = listaAlbums.iterator();
            Album albumActual;
            while (itAlbums.hasNext()) {
                albumActual = (Album) itAlbums.next();
                boolean matchea = false;
                DataAlbum dataAlbum = albumActual.getData();
                matchea = dataAlbum.getNombre().toLowerCase().contains(busqueda);
                if (!matchea) {
                    List<String> generos = dataAlbum.getGeneros();
                    Iterator itGeneros = generos.iterator();
                    while (itGeneros.hasNext() && !matchea) {
                        matchea = ((String) itGeneros.next()).toLowerCase().contains(busqueda);
                    }
                }
                if (matchea) {
                    result.add(dataAlbum);
                }
            }
        }
        return result;
    }
    
    public ArrayList<String[]> buscarListas(String busqueda) {
        busqueda = busqueda.toLowerCase();
        ArrayList<String[]> result = new ArrayList<String[]>();
        ManejadorColecciones manejador = ManejadorColecciones.getInstancia();
        Map<String, ? extends Lista> listasPorDefecto = manejador.getListas();
        List<? extends Lista> listasPorDefectoLista = new ArrayList(listasPorDefecto.values());
        agregarListasDefectoPorBusqueda(busqueda, listasPorDefectoLista, result);
        Map<String, Cliente> clientes = manejador.getClientes();
        List<Cliente> clienteLista = new ArrayList(clientes.values());
        Iterator itClientes = clienteLista.iterator();
        Cliente clienteActual;
        String[] agregar;
        while (itClientes.hasNext()) {
            clienteActual = (Cliente) itClientes.next();
            List<? extends Lista> listasPublicas = clienteActual.getListasPublicas();
            Iterator itPublicas = listasPublicas.iterator();
            Publica publicaActual;
            while (itPublicas.hasNext()) {
                publicaActual = (Publica) itPublicas.next();
                if (hayQueAgregarPublica(busqueda, publicaActual)) {
                    agregar = new String[4];
                    agregar[0] = publicaActual.getNombre();
                    agregar[1] = "Publica";
                    agregar[2] = String.valueOf(publicaActual.getAnoCreacion());
                    agregar[3] = publicaActual.getNickCliente();
                    result.add(agregar);
                }
            }
        }
        return result;
    }
    
    private void agregarListasDefectoPorBusqueda(String busqueda, List<? extends Lista> listasPorDefecto,List<String[]> result) {
        Iterator itDefecto = listasPorDefecto.iterator();
        Defecto defectoActual;
        String[] agregar;
        while (itDefecto.hasNext()) {
            defectoActual = (Defecto) itDefecto.next();
            if (defectoActual.getNombre().toLowerCase().contains(busqueda) || defectoActual.getNomGenero().toLowerCase().contains(busqueda)) {
                agregar = new String[3];
                agregar[0] = defectoActual.getNombre();
                agregar[1] = "Defecto";
                agregar[2] = String.valueOf(defectoActual.getAnoCreacion());
                result.add(agregar);
            }
        }
    }
    
    private boolean hayQueAgregarPublica(String busqueda, Publica listaPublica) {
        boolean result = listaPublica.getNombre().toLowerCase().contains(busqueda);
        if (!result) {
            Map<String, Tema> temas = listaPublica.getTemas();
            List<Tema> listaTemas = new ArrayList(temas.values());
            Iterator itTemas = listaTemas.iterator();
            Album albumActual;
            List<String> generos;
            Iterator itGeneros;
            while (!result && itTemas.hasNext()) {
                albumActual = ((Tema) itTemas.next()).getAlbum();
                result = albumActual.getNombre().toLowerCase().contains(busqueda);
                if (!result) {
                    generos = albumActual.getData().getGeneros();
                    itGeneros = generos.iterator();
                    while (!result && itGeneros.hasNext()) {
                        result = ((String) itGeneros.next()).toLowerCase().contains(busqueda);
                    }
                }
            }
        }
        return result;
    }
    
    @Override
    public DataColeccionTemas sugerir() {
        ArrayList<DataTema> temas = new ArrayList();
        FixedSizePriorityQueue<Tema> cola = new FixedSizePriorityQueue<>(10, Tema.comparadorTemas());
        Map<String, Artista> mapArt = ManejadorColecciones.getInstancia().getArtistas();
        for (Map.Entry<String, Artista> entry : mapArt.entrySet()) {
            Artista art = entry.getValue();
            cola = art.aportarSugerencias(cola);
        }
        Tema tem = cola.pollFirst();
        while (tem!=null) {
            temas.add(tem.getData());
            tem = cola.pollFirst();
        }
        return new DataColeccionTemas(temas);
    }

    private void persistirGenero(Genero genero) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("EspotifyPU");
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        
        Query queryExiste = em.createQuery("SELECT g FROM Genero g WHERE g.nombre=?1");
        queryExiste.setParameter(1, genero.getNombre());
        if (queryExiste.getResultList().isEmpty()) {
            em.persist(genero);
        }
        em.getTransaction().commit();
    }

    @Override
    public int cantDescargas(String nick, String nomAlbum, String nomTema) throws ArtistaInexistenteException, AlbumInexistenteException {
        return new CtrlUsuarios().getCantDescargasTema(nick,nomAlbum,nomTema);
    }
}
