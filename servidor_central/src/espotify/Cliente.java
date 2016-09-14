package espotify;

import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataParticular;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataUsuario;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.FavoritoRepetidoException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.YaPublicaException;

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


    void PublicarLista(String nomLista) throws YaPublicaException, ListaInexistenteException {
        Particular lista = BuscarLista(nomLista);
        Publica listaPublica = lista.hacerPublica();
        listas.remove(nomLista);
        listas.put(nomLista, listaPublica);
    }

    List<String> ListarListas() {
        List salida = new ArrayList();
        listas.keySet().stream().forEach((key) -> {
            salida.add(key);
        });
        return salida;
    }
    
    List<String> ListarListasPrivadas() {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular part = entry.getValue();
            if (part instanceof Privada) {
                salida.add(part.getNombre());
            }
        }
        return salida;
    }
    
    List<String> ListarListasPublicas() {
        List<String> salida = new ArrayList();
        for (Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular part = entry.getValue();
            if (!(part instanceof Privada)) {
                salida.add(part.getNombre());
            }
        }
        return salida;
    }

    List<DataTema> ListarTemasDeLista(String nombre) throws ListaInexistenteException {
        return BuscarLista(nombre).listarTemas();
    }
    
    void AltaLista(DataParticular dLista) throws ListaRepetidaException {
        if (ValidarNombreLista(dLista.getNombre())) {
            listas.put(dLista.getNombre(), new Privada(dLista));
        } else {
            throw new ListaRepetidaException();
        }
    }
    
    private boolean ValidarNombreLista(String nom) {
        return !listas.containsKey(nom) && !nom.equals("");
    }

    void QuitarTemaDeLista(String nomLista, String nomTema,String nomAlbum) throws ListaInexistenteException {
        BuscarLista(nomLista).quitarTema(nomTema,nomAlbum);
    }

    DataLista DarInfoLista(String nomLista) throws ListaInexistenteException {
        return BuscarLista(nomLista).getData();
    }
    
    Particular BuscarLista(String nomLista) throws ListaInexistenteException {
        Particular lista = listas.get(nomLista);
        if (lista != null) {
            return lista;
        } else {
            throw new ListaInexistenteException();
        }
    }

    void Favoritear(Favoriteable fav) throws FavoritoRepetidoException {
        if (!favoritos.contains(fav)) {
            favoritos.add(fav);
        } else {
            throw new FavoritoRepetidoException();
        }
    }

    Publica BuscarListaPublica(String nomLista) throws ListaInexistenteException {
        Particular lista = BuscarLista(nomLista);
        if (lista instanceof Publica) {
            return (Publica) lista;
        } else {
            throw new ListaInexistenteException();
        }
    }

    void DesFavoritear(Favoriteable fav) throws FavoritoRepetidoException {
        if (favoritos.contains(fav)) {
            favoritos.remove(fav);
        } else {
            throw new FavoritoRepetidoException();
        }
    }
    
    void AgregarTemaLista(Tema tema, String lis) throws Exception {
        Lista lista = listas.get(lis);
        if (lista == null) {
            throw new Exception("La lista que tiene que existir no se encontro");
        }
        lista.agregarTema(tema);
    }

    boolean SigueA(String nomSeguido) {
        return seguidos.containsKey(nomSeguido);
    }

}
