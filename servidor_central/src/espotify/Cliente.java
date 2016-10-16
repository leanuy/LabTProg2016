package espotify;

import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataFavoriteable;
import espotify.datatypes.DataLista;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataUsuario;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.FavoritoRepetidoException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.NoHaySuscripcionException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.TransicionSuscripcionInvalidaException;
import espotify.excepciones.YaPublicaException;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class Cliente extends Usuario {
    private final Map<String, Usuario> seguidos;
    private final Map<String, Particular> listas;
    private final List<Favoriteable> favoritos;
    private final Map<Calendar, Suscripcion> suscripciones; //por fechaCreacion
    private Suscripcion suscripcionActiva;
    
    public Cliente(DataUsuario data) {
        super(data);
        this.seguidos = new HashMap<>();
        this.listas = new HashMap<>();
        this.favoritos = new ArrayList<>();
        this.suscripciones = new HashMap<>();
        this.suscripcionActiva = null;
    }
    
    public Map<String, Particular> getListas() {
        return this.listas;
    }
    
    public List<Publica> getListasPublicas() {
        List<Publica> result = new ArrayList<Publica>();
        List<Lista> listaListas = new ArrayList<Lista>(listas.values());
        Iterator itListas = listaListas.iterator();
        Lista listaActual;
        Publica publicaActual;
        while (itListas.hasNext()) {
            listaActual = (Lista) itListas.next();
            if (listaActual instanceof Publica) {
                publicaActual = (Publica) listaActual;
                result.add(publicaActual);
            }
        }
        return result;
    }
    
    public DataClienteExt getDataClienteExt() {
        int cant = seguidos.size();
        String[] seg = new String[cant];
        int idx = 0;
        for (Map.Entry<String, Usuario> entry : seguidos.entrySet()) {
            String key = entry.getKey();
            seg[idx] = key;
            idx++;
        }
        cant = listas.size();
        String[] lis = new String[cant];
        idx = 0;
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular value = entry.getValue();
            String nomb = value.getNombre();
            lis[idx] = nomb;
            idx++;
        }
        List<String> segdores = new ArrayList();
        String namef;
        Cliente cli;
        for (Map.Entry<String, Cliente> entry : this.getSeguidores().entrySet()) {
            cli = entry.getValue();
            namef = cli.getNick();
            segdores.add(namef);
        }
        return new DataClienteExt(getNick(),
                getNombre(),getApellido(),getCorreo(),
                getFechaNac(), getImg(), seg, lis, segdores);
    }
    
    public void seguir(Usuario usuario) throws AutoSeguirseException, SeguidoRepetidoException {
        if (this.equals(usuario)) {
            throw new AutoSeguirseException();
        }
        String clave = usuario.getNick();
        Usuario seguido = this.seguidos.get(clave);
        if (seguido != null) {
            throw new SeguidoRepetidoException();
        }
        this.seguidos.put(clave, usuario);
    }
    
    public void dejarDeSeguir(Usuario usuario) throws SeguidoInexistenteException {
        String clave = usuario.getNick();
        Usuario seguido = this.seguidos.get(clave);
        if (seguido == null) {
            throw new SeguidoInexistenteException();
        }
        this.seguidos.remove(clave);
    }


    public void publicarLista(String nomLista) throws YaPublicaException, ListaInexistenteException {
        Particular lista = buscarLista(nomLista);
        Publica listaPublica = lista.hacerPublica();
        listas.remove(nomLista);
        listas.put(nomLista, listaPublica);
    }

    public List<String> listarListas() {
        List salida = new ArrayList();
        listas.keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    public List<String> listarListasPrivadas() {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular part = entry.getValue();
            if (part instanceof Privada) {
                salida.add(part.getNombre());
            }
        }
        return salida;
    }
    
    public List<String> listarListasPublicas() {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular part = entry.getValue();
            if (!(part instanceof Privada)) {
                salida.add(part.getNombre());
            }
        }
        return salida;
    }

    public List<DataTema> listarTemasDeLista(String nombre) throws ListaInexistenteException {
        return buscarLista(nombre).listarTemas();
    }
    
    public void altaLista(DataParticular dataLista) throws ListaRepetidaException, CampoVacioException {
        
        if (dataLista.getNombre().equals("")) {
            throw new CampoVacioException();
        } else if (listas.containsKey(dataLista.getNombre())) {
            throw new ListaRepetidaException();
        } else {
            listas.put(dataLista.getNombre(), new Privada(dataLista, this));
        }
    }

    public void quitarTemaDeLista(String nomLista, String nomTema,String nomAlbum) throws ListaInexistenteException {
        buscarLista(nomLista).quitarTema(nomTema,nomAlbum);
    }

    public DataLista darInfoLista(String nomLista) throws ListaInexistenteException {
        return buscarLista(nomLista).getDataExt();
    }
    
    public Particular buscarLista(String nomLista) throws ListaInexistenteException {
        Particular lista = listas.get(nomLista);
        if (lista == null) {
            throw new ListaInexistenteException();
        } else {
            return lista;
        }
    }

    public void favoritear(Favoriteable fav) throws FavoritoRepetidoException {
        if (favoritos.contains(fav)) {
            throw new FavoritoRepetidoException();
        } else {
            favoritos.add(fav);
        }
    }

    public Publica buscarListaPublica(String nomLista) throws ListaInexistenteException {
        Particular lista = buscarLista(nomLista);
        if (lista instanceof Publica) {
            return (Publica) lista;
        } else {
            throw new ListaInexistenteException();
        }
    }

    public void desFavoritear(Favoriteable fav) throws FavoritoRepetidoException {
        if (favoritos.contains(fav)) {
            favoritos.remove(fav);
        } else {
            throw new FavoritoRepetidoException();
        }
    }
    
    public void agregarTemaLista(Tema tema, String lis) throws Exception {
        Lista lista = listas.get(lis);
        if (lista == null) {
            throw new Exception("La lista que tiene que existir no se encontro");
        }
        lista.agregarTema(tema);
    }

    public boolean sigueA(String nomSeguido) {
        return seguidos.containsKey(nomSeguido);
    }

    public DataSuscripcion getSuscripcionActiva() throws NoHaySuscripcionException {
        if (suscripcionActiva == null) {
            throw new NoHaySuscripcionException();
        } else {
            return suscripcionActiva.getData();
        }
    }
    
    public ArrayList<DataSuscripcion> getSuscripciones() {
        ArrayList<DataSuscripcion> lstSusc = new ArrayList();
        Iterator iterador = suscripciones.entrySet().iterator();
        Suscripcion suscActual;
        while (iterador.hasNext()) {
            Map.Entry pair = (Map.Entry)iterador.next();
            suscActual = (Suscripcion) pair.getValue();
            lstSusc.add(suscActual.getData());
        }
        return lstSusc;
    }

    public void aprobarSuscripcion() throws NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException {
        if (suscripcionActiva == null) {
            throw new NoHaySuscripcionException();
        } else {
            suscripcionActiva.aprobar();
        }
    }

    public void cancelarSuscripcion() throws NoHaySuscripcionException,
            TransicionSuscripcionInvalidaException {
        if (suscripcionActiva == null) {
            throw new NoHaySuscripcionException();
        } else {
            suscripcionActiva.cancelar();
            suscripcionActiva = null;
        }
    }
    
    //para servidor web, probablemente sea algo asi.
    public void contratar(TipoSuscripcion tipo) throws TransicionSuscripcionInvalidaException {
        if (suscripcionActiva == null || !suscripcionActiva.estaVigente()) {
            suscripcionActiva = new Suscripcion(tipo);
            suscripciones.put(suscripcionActiva.getFechaCreacion(),suscripcionActiva);
        } else {
            throw new TransicionSuscripcionInvalidaException();
        }
    }
    
    public boolean siguiendo(String seguido) {
        return seguidos.containsKey(seguido);
    }

    public boolean listaEsPrivada(String nomLista) throws ListaInexistenteException {
        return buscarLista(nomLista) instanceof Privada;
    }

    public boolean esFavorito(Favoriteable fav) {
        return favoritos.contains(fav);
    }

    public List<DataFavoriteable> listarFavoritos() {
        List<DataFavoriteable> salida = new ArrayList();
        for (Favoriteable fav : favoritos) {
            salida.add(fav.getData());
        }
        return salida;
    }
    
    public void renovarSuscripcion() throws TransicionSuscripcionInvalidaException, NoHaySuscripcionException {
        if ( suscripcionActiva == null ) {
            throw new NoHaySuscripcionException();
        }
        if (suscripcionActiva == null || suscripcionActiva.estaVigente()) {
            throw new TransicionSuscripcionInvalidaException();
        } else {
            suscripcionActiva.renovar();
        }
    }
    public void vencerSuscripcion() {
        suscripcionActiva.estaVigente();
        suscripcionActiva.vencer();
    }
    
    public boolean tieneSuscripcionVigente() {
        if (suscripcionActiva == null) {
            return false;
        }
        return suscripcionActiva.estaVigente();
    }
    
    public void encajarSuscripcion(Suscripcion suscripcion) {
        suscripcionActiva = suscripcion;
        suscripciones.put(suscripcionActiva.getFechaDesde(),suscripcionActiva);
    }
}
