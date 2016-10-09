package espotify;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

final class ManejadorColecciones {
    private static ManejadorColecciones instancia;

    private final Map<String,Cliente> clientes;
    private final Map<String,Artista> artistas;
    private final Map<String,Defecto> listas; //POR DEFECTO
    private final Map<String,Genero> generos;
    private final Genero generoBase;

//SINGLETON
    static ManejadorColecciones getInstancia() {
        if (instancia == null) {
            instancia = new ManejadorColecciones();
        }
        return instancia;
    }
    
    private ManejadorColecciones() {
        this.clientes = new HashMap<>();
        this.artistas = new HashMap<>();
        this.listas = new HashMap<>();
        this.generoBase = new Genero("Genero");
        this.generos = new HashMap<>();
        generos.put(generoBase.getNombre(), generoBase);
    }
    
    static void clear() {
        instancia = null;
        File files = new File(getAudioFolder());
        for (File f : files.listFiles()) {
            f.delete();
        }
    }
    
//Clientes
    Map<String, Cliente> getClientes() {
        return clientes;
    }
    
/*    Cliente buscarCliente(String nick) {
        return clientes.get(nick);
    }*/
    
    void agregarCliente(String nick, Cliente cli) {
        clientes.put(nick, cli);
    }

//Artistas
    Map<String, Artista> getArtistas() {
        return artistas;
    }
    
    Artista buscarArtista(String nick) {
        return artistas.get(nick);
    }
    
    void agregarArtista(String nick, Artista art) {
        artistas.put(nick, art);
    }
    
//ListasDefecto
    Map<String, Defecto> getListas() {
        return listas;
    }
    
    Defecto buscarLista(String nombre) {
        return listas.get(nombre);
    }
    
    void agregarLista(String nombre, Defecto def) {
        listas.put(nombre, def);
    }

//Generos
    Map<String, Genero> getGeneros() {
        return generos;
    }
    
    Genero buscarGenero(String nombre) {
        return generos.get(nombre);
    }
    
    void agregarGenero(String nombre, Genero gen) {
        generos.put(nombre, gen);
    }
    
    Genero getGeneroBase() {
        return generoBase;
    }
    
    /*
    Tienen que cambiar el retorno cada uno en su máquina por una carpeta de su sistema,
    que exista y ESTÉ VACÍA. 100% VACÍA. EN SERIO GURISES, VACÍA.
    Que lo que tenga vuela al carajo cada vez que ejecutan la cuestión.
    */
    static String getAudioFolder() {
        return "/Users/santiagoserantes/Vacia/";
    }
}
