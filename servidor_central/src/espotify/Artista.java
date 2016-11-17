package espotify;

import espotify.datatypes.DataAlbumExt;
import espotify.datatypes.DataArtista;
import espotify.datatypes.DataArtistaExt;
import espotify.datatypes.DataTema;
import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;

import java.io.BufferedInputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import static javax.persistence.TemporalType.DATE;
import javax.persistence.Transient;

@Entity
class Artista extends Usuario implements Serializable {
    //attr
    
    private String bio;
    private String url;
    @OneToMany(mappedBy="artista", cascade=CascadeType.PERSIST, fetch=FetchType.LAZY)
    private Map<String,Album> albums;
    @Transient
    private DataAlbumExt albumTemp;
    @Temporal(DATE)
    private Calendar fechaBaja;
    //getters
    
    void addAlbum(Album album) {
        this.albums.put(album.getNombre(), album);
    }
    void addAlbumTemp(DataAlbumExt album) {
        this.albumTemp = album;
    }

    boolean tieneAlbum(String album) {
        return this.albums.containsKey(album);
    }
    boolean tieneAlbumTemp(String album) {
        return this.albumTemp.getNombre().equals(album);
    }
    
    Map<String, Album> getAlbums() {
        return this.albums;
    }
    DataAlbumExt getAlbumTemp() {
        return this.albumTemp;
    }
    
    //constructores
    Artista(DataArtista data) {
        super(data);
        albums = new HashMap<>();
        albumTemp = null;
        bio = data.getBio();
        url = data.getUrl();
    }
    
    DataAlbumExt getDataAlbumExt(String nomAlbum) throws AlbumInexistenteException {
        Album album = buscarAlbum(nomAlbum);
        return album.getDataExt();
    }
    
    //otros métodos
    static boolean validarDatosArtista(DataArtista dataArtista) {
        return Usuario.validarDatosUsuario(dataArtista);
    }

    DataArtistaExt getDataArtistaExt() {
        List<String> segdores = new ArrayList();
        String namef;
        Cliente cli;
        if(this.getSeguidores()!=null) {
            for (Map.Entry<String, Cliente> entry : this.getSeguidores().entrySet()) {
                cli = entry.getValue();
                namef = cli.getNick();
                segdores.add(namef);
            }
        }
        return new DataArtistaExt(getNick(), getNombre(), getApellido(),
                getCorreo(), getFechaNac(), getImg(), bio, url, albums, segdores);
    }
    
    Album buscarAlbum(String nombre) throws AlbumInexistenteException {
        Album album = albums.get(nombre);
        if (album == null) {
            throw new AlbumInexistenteException();
        }
        return album;
    }
    
    ArrayList<String> listarAlbumes() {
        ArrayList<String> listaAlbums = new ArrayList();
        Iterator iterador = albums.entrySet().iterator();
        Album albumActual;
        while (iterador.hasNext()) {
            Map.Entry pair = (Map.Entry)iterador.next();
            albumActual = (Album) pair.getValue();
            listaAlbums.add(albumActual.getNombre());
        }
        return listaAlbums;
    }
    
    Tema devolverTema(DataTema data) {
        String album = data.getAlbum();
        String tema = data.getNombre();
        Album alb = albums.get(album);
        return alb.devolverTema(tema);
    }
    
    DataTema consultaTema(String nomAlbum, String nomTema)
            throws AlbumInexistenteException {
        return buscarAlbum(nomAlbum).devolverTema(nomTema).getData();
    }

    BufferedInputStream getAudio(String album, String tema) throws AlbumInexistenteException, TemaTipoInvalidoException {
        return buscarAlbum(album).getAudio(tema);
    }
    
    void registrarEscucha(String album, String tema) throws AlbumInexistenteException {
        buscarAlbum(album).registrarEscucha(tema);
    }
    
    void registrarDescarga(String album, String tema) throws AlbumInexistenteException {
        buscarAlbum(album).registrarDescarga(tema);
    }

    void addTemaAlbumTemp(DataTema tema) {
        this.albumTemp.addTema(tema);
    }
    void deleteTemaAlbumTemp(String tema) {
        this.albumTemp.deleteTema(tema);
    }
    
    public List<DataTema> DevolverTemas() {
        List<DataTema> temas = new ArrayList();
        Iterator entries = albums.entrySet().iterator();
        while (entries.hasNext()) {
          Map.Entry thisEntry = (Map.Entry) entries.next();
          Album alb1 = (Album)thisEntry.getValue();
            List<DataTema> datatem = alb1.getDataTemas();
            temas.addAll(datatem);
        }
        return temas;
    }

    FixedSizePriorityQueue<Tema> aportarSugerencias(FixedSizePriorityQueue<Tema> cola) {
        for (Map.Entry<String, Album> entry : albums.entrySet()) {
            Album alb = entry.getValue();
            cola = alb.aportarSugerencias(cola);
        }
        return cola;
    }

    public Artista() {
    }

    void persistirTemas(EntityManager em) {
         for (Map.Entry<String, Album> entry : albums.entrySet()) {
            Album alb = entry.getValue();
            alb.persistirTemas(em);
        }
    }

    int getCantDescargasTema(String nomAlbum, String nomTema) throws AlbumInexistenteException {
        return buscarAlbum(nomAlbum).devolverTema(nomTema).getCantDescargas();
    }

    void prepararBaja() {
        this.fechaBaja = Calendar.getInstance();
    }

    Calendar getFechaBaja() {
        return this.fechaBaja;
    }
}