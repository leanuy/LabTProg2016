package espotify;

import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataUsuario;
import java.util.ArrayList;
import espotify.Datatypes.DataParticular;
import java.util.HashMap;
import java.util.Map;

public class Cliente extends Usuario {
    private final HashMap<String,Usuario> seguidos;
    private final HashMap<String,Particular> listas;
    
    public Cliente(DataUsuario d) {
        super(d);
        this.seguidos=new HashMap<>();
        this.listas=new HashMap<>();
    }
    
    public DataClienteExt getDataClienteExt() {
        DataClienteExt dc = new DataClienteExt(getNick(), getNombre(), getApellido(), getCorreo(), getfNac(), getImg(), seguidos, listas);
        return dc;
    }
    
    public void Seguir(Usuario u) throws Exception{
        if(this.equals(u))
            throw new Exception("Un usuario no puede seguirse a sí mismo.");
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
    
    ArrayList<String> ListarListasPrivadas() {
        ArrayList<String> a = new ArrayList();
        for(Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular p = entry.getValue();
            if(p instanceof Privada)
                a.add(p.getNombre());
        }
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
        if(ValidarNombreLista(d.getNombre()))
            listas.put(d.getNombre(), new Privada(d));
        else
            throw new Exception("El cliente ya tiene una lista con ese nombre");
    }
    
    private boolean ValidarNombreLista(String nom)
    {
        return !nom.equals("") && !listas.containsKey(nom);
    }

    void QuitarTemaDeLista(String nomLista, String nomTema,String nomAlbum) throws Exception {
        Lista l = listas.get(nombre);
        if(l!=null)
            l.QuitarTema(nomTema,nomAlbum);
        else
            throw new Exception("El cliente no tiene una lista con ese nombre");
    }

    DataLista DarInfoLista(String nomLista) throws Exception{
        Lista l = listas.get(nomLista);
        if(l!=null)
            return l.getData();
        else
            throw new Exception("El cliente no tiene una lista con ese nombre");
    }


}
