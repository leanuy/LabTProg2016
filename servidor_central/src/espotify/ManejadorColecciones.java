package espotify;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

final class ManejadorColecciones {
    private static ManejadorColecciones instancia;

    private final Map<String,Cliente> clientes;
    private final Map<String,Artista> artistas;
    private final Map<String,Defecto> listas; //POR DEFECTO
    private final Map<String,Genero> generos;
    private final Genero generoBase;
    private final List<Acceso> accesos;

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
        this.accesos = new ArrayList<>();
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
    
    void eliminarArtista(String nick) {
        artistas.remove(nick);
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
    
    static String getAudioFolder() {
        final String dir = System.getProperty("user.dir") + "/audiofolder/";
        new File(dir).mkdirs();
        return dir;
    }
    
    List<Acceso> getAccesos() {
        return accesos;
    }
    
    void agregarAcceso(Acceso acceso) {
        accesos.add(acceso);
    }
}
