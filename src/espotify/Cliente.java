/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataParticular;
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
    
    public DataClienteExt getDataClienteExt() {
        DataClienteExt dc = new DataClienteExt(getNick(), getNombre(), getApellido(), getCorreo(), getfNac(), getImg());
        return dc;
    }
    
    public void Seguir(Usuario u) throws Exception{
        String clave = u.getNick();
        Usuario u2 = this.seguidos.get(clave);
        if(u2 != null){
            throw new Exception("Ya se esta siguiendo a ese usuario");
        }
        this.seguidos.put(clave, u);
    }
    
    public void DejarDeSeguir(Usuario u) throws Exception{
        String clave = u.getNick();
        Usuario u2 = this.seguidos.get(clave);
        if (u2 == null){
            throw new Exception("El usuario no puede dejar de seguir alguien que no seguía");
        }
        this.seguidos.remove(clave);
    }

    void AltaLista(DataParticular d) throws Exception {
        if(!listas.containsKey(d.getNombre()))
            listas.put(d.getNombre(), new Privada(d));
        else
            throw new Exception("El cliente ya tiene una lista con ese nombre");
    }
}
