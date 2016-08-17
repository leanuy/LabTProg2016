/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.Datatypes.DataArtistaExt;
import espotify.Datatypes.DataClienteExt;
import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author JavierM42
 */
public class CtrlUsuarios {
    private CtrlUsuarios instancia;
    private final HashMap<String,Cliente> clientes;
    private final HashMap<String,Artista> artistas;
    
    public CtrlUsuarios getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlUsuarios();
        return instancia;
    }
    
    public CtrlUsuarios()
    {
        this.clientes=new HashMap<>();
        this.artistas=new HashMap<>();
    }
    
    public ArrayList<String> ListarClientes(){
        ArrayList a = new ArrayList();
        clientes.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    
    public DataClienteExt ConsultaCliente(String s){
        Cliente c = clientes.get(s);
        DataClienteExt dc = c.getDataClienteExt();
        return dc;
    }
    
    public ArrayList<String> ListarArtistas(){
        ArrayList a = new ArrayList();
        artistas.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }
    
    public DataArtistaExt ConsultaArtista(String s){
        Artista a = artistas.get(s);
        DataArtistaExt da = a.getDataArtistaExt();
        return da;
    }
    
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws Exception{
        Cliente c = clientes.get(nomSeguidor);
        if (c==null){
            throw new Exception("No existe el usuario que quiere seguir");
        }
        Usuario u = clientes.get(nomSeguido);
        if (u==null){
            u = artistas.get(nomSeguido);
        }
        if (u==null){
            throw new Exception("no existe ese usuario a seguir");
        }
        c.Seguir(u);
    }
    
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws Exception{
        Cliente c = clientes.get(nomSeguidor);
        if (c==null){
            throw new Exception("No existe el usuario que quiere seguir");
        }
        Usuario u = clientes.get(nomSeguido);
        if (u==null){
            u = artistas.get(nomSeguido);
        }
        if (u==null){
            throw new Exception("no existe el usuario que se quiere dejar de seguir");
        }
        c.DejarDeSeguir(u);
    }
}