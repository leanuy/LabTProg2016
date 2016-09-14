package espotify;

import java.util.HashMap;
import java.util.Map;

class ManejadorColecciones {
    private static ManejadorColecciones instancia;
    private final Map<String,Cliente> clientes;
    private final Map<String,Artista> artistas;
    private final Map<String,Defecto> listas; //POR DEFECTO
    private final Map<String,Genero> generos;
    private final Genero generoBase;

//SINGLETON
    static ManejadorColecciones getInstancia() {
        if (instancia == null) {
            instancia=new ManejadorColecciones();
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
    }
    
//Clientes
    Map<String, Cliente> getClientes() {
        return clientes;
    }
    
    Cliente BuscarCliente(String nick) {
        return clientes.get(nick);
    }
    
    void AgregarCliente(String nick, Cliente c) {
        clientes.put(nick, c);
    }

//Artistas
    Map<String, Artista> getArtistas() {
        return artistas;
    }
    
    Artista BuscarArtista(String nick) {
        return artistas.get(nick);
    }
    
    void AgregarArtista(String nick, Artista art) {
        artistas.put(nick, art);
    }
    
//ListasDefecto
    Map<String, Defecto> getListas() {
        return listas;
    }
    
    Defecto BuscarLista(String nombre) {
        return listas.get(nombre);
    }
    
    void AgregarLista(String nombre, Defecto def) {
        listas.put(nombre, def);
    }

//Generos
    Map<String, Genero> getGeneros() {
        return generos;
    }
    
    Genero BuscarGenero(String nombre) {
        return generos.get(nombre);
    }
    
    void AgregarGenero(String nombre, Genero gen) {
        generos.put(nombre, gen);
    }
    
    Genero getGeneroBase() {
        return generoBase;
    }
    
}
