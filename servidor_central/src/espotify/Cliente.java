package espotify;

import espotify.datatypes.DataClienteExt;
import espotify.datatypes.DataLista;
import espotify.datatypes.DataParticular;
import espotify.datatypes.DataTema;
import espotify.datatypes.DataUsuario;
import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.FavoritoRepetidoException;
import espotify.excepciones.ListaInexistenteException;
import espotify.excepciones.ListaRepetidaException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.YaPublicaException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Cliente extends Usuario {
    private final Map<String,Usuario> seguidos;
    private final Map<String,Particular> listas;
    private final List<Favoriteable> favoritos;
    
    Cliente(DataUsuario data) {
        super(data);
        this.seguidos = new HashMap<>();
        this.listas = new HashMap<>();
        this.favoritos = new ArrayList<>();
    }
    
    DataClienteExt getDataClienteExt() {
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
        for (Map.Entry<String, Cliente> entry : this.seguidores.entrySet()) {
            cli = entry.getValue();
            namef = cli.nick;
            segdores.add(namef);
        }
        return new DataClienteExt(getNick(),
                getNombre(),getApellido(),getCorreo(),
                getFechaNac(), getImg(), seg, lis, segdores);
    }
    
    void seguir(Usuario usuario) throws AutoSeguirseException, SeguidoRepetidoException {
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
    
    void dejarDeSeguir(Usuario usuario) throws SeguidoInexistenteException {
        String clave = usuario.getNick();
        Usuario seguido = this.seguidos.get(clave);
        if (seguido == null) {
            throw new SeguidoInexistenteException();
        }
        this.seguidos.remove(clave);
    }


    void publicarLista(String nomLista) throws YaPublicaException, ListaInexistenteException {
        Particular lista = buscarLista(nomLista);
        Publica listaPublica = lista.hacerPublica();
        listas.remove(nomLista);
        listas.put(nomLista, listaPublica);
    }

    List<String> listarListas() {
        List salida = new ArrayList();
        listas.keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    List<String> listarListasPrivadas() {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular part = entry.getValue();
            if (part instanceof Privada) {
                salida.add(part.getNombre());
            }
        }
        return salida;
    }
    
    List<String> listarListasPublicas() {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular part = entry.getValue();
            if (!(part instanceof Privada)) {
                salida.add(part.getNombre());
            }
        }
        return salida;
    }

    List<DataTema> listarTemasDeLista(String nombre) throws ListaInexistenteException {
        return buscarLista(nombre).listarTemas();
    }
    
    void altaLista(DataParticular dataLista) throws ListaRepetidaException {
        if (validarNombreLista(dataLista.getNombre())) {
            listas.put(dataLista.getNombre(), new Privada(dataLista));
        } else {
            throw new ListaRepetidaException();
        }
    }
    
    private boolean validarNombreLista(String nom) {
        return !listas.containsKey(nom) && !nom.equals("");
    }

    void quitarTemaDeLista(String nomLista, String nomTema,String nomAlbum) throws ListaInexistenteException {
        buscarLista(nomLista).quitarTema(nomTema,nomAlbum);
    }

    DataLista darInfoLista(String nomLista) throws ListaInexistenteException {
        return buscarLista(nomLista).getData();
    }
    
    Particular buscarLista(String nomLista) throws ListaInexistenteException {
        Particular lista = listas.get(nomLista);
        if (lista != null) {
            return lista;
        } else {
            throw new ListaInexistenteException();
        }
    }

    void favoritear(Favoriteable fav) throws FavoritoRepetidoException {
        if (!favoritos.contains(fav)) {
            favoritos.add(fav);
        } else {
            throw new FavoritoRepetidoException();
        }
    }

    Publica buscarListaPublica(String nomLista) throws ListaInexistenteException {
        Particular lista = buscarLista(nomLista);
        if (lista instanceof Publica) {
            return (Publica) lista;
        } else {
            throw new ListaInexistenteException();
        }
    }

    void desFavoritear(Favoriteable fav) throws FavoritoRepetidoException {
        if (favoritos.contains(fav)) {
            favoritos.remove(fav);
        } else {
            throw new FavoritoRepetidoException();
        }
    }
    
    void agregarTemaLista(Tema tema, String lis) throws Exception {
        Lista lista = listas.get(lis);
        if (lista == null) {
            throw new Exception("La lista que tiene que existir no se encontro");
        }
        lista.agregarTema(tema);
    }

    boolean sigueA(String nomSeguido) {
        return seguidos.containsKey(nomSeguido);
    }

}
