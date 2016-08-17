package espotify;

import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataUsuario;
import java.util.ArrayList;
import espotify.Datatypes.DataParticular;
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

    ArrayList<String> ListarListas() {
        ArrayList a = new ArrayList();
        listas.keySet().stream().forEach((key) -> {
            a.add(key);
        });
        return a;
    }

    ArrayList<DataTema> ListarTemasDeLista(String nombre) throws Exception {
        Lista l = listas.get(nombre);
        if(l!=null)
            return l.ListarTemas();
        else
            throw new Exception("El cliente no tiene una lista con ese nombre");
    }
    
    void AltaLista(DataParticular d) throws Exception {
        if(!listas.containsKey(d.getNombre()))
            listas.put(d.getNombre(), new Privada(d));
        else
            throw new Exception("El cliente ya tiene una lista con ese nombre");
    }
}
