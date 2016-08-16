/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.Datatypes.DataClienteExt;
import java.util.HashMap;

/**
 *
 * @author JavierM42
 */
public class Cliente extends Usuario {
    private final HashMap<String,Usuario> seguidos;
    private final HashMap<String,Particular> listas;
    
    public Cliente()
    {
        this.seguidos=new HashMap<>();
        this.listas=new HashMap<>();
    }
    
    public DataClienteExt CrearDataClienteExt() {
        DataClienteExt dc = new DataClienteExt(getNick(), getNombre(), getApellido(), getCorreo(), getfNac(), getImg());
        return dc;
    }
    
    public void Seguir(Usuario u){
        String clave = u.getNick();
        this.seguidos.put(clave, u);
    }
    
    public void DejarDeSeguir(Usuario u){
        String clave = u.getNick();
        this.seguidos.remove(clave);
    }
}
