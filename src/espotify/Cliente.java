package espotify;

import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataUsuario;
import java.util.HashMap;

public class Cliente extends Usuario {
    private final HashMap<String,Usuario> seguidos;
    private final HashMap<String,Particular> listas;
    
    public Cliente(DataUsuario d) {
        super(d);
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

    void PublicarLista(String nomLista) throws Exception {
       Particular l = listas.get(nomLista);
       Publica l2 = l.HacerPublica();
       listas.remove(nomLista);
       listas.put(nomLista, l2);
    }
}
