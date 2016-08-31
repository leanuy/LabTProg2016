package espotify;

import espotify.Datatypes.DataClienteExt;
import espotify.Datatypes.DataLista;
import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataUsuario;
import java.util.ArrayList;
import espotify.Datatypes.DataParticular;
import espotify.Excepciones.AutoSeguirseException;
import espotify.Excepciones.ListaInexistenteException;
import espotify.Excepciones.ListaRepetidaException;
import espotify.Excepciones.SeguidoInexistenteException;
import espotify.Excepciones.SeguidoRepetidoException;
import espotify.Excepciones.YaPublicaException;
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
    
    public void Seguir(Usuario u) throws AutoSeguirseException, SeguidoRepetidoException{
        if(this.equals(u))
            throw new AutoSeguirseException();
        String clave = u.getNick();
        Usuario u2 = this.seguidos.get(clave);
        if(u2 != null){
            throw new SeguidoRepetidoException();
        }
        this.seguidos.put(clave, u);
    }
    
    public void DejarDeSeguir(Usuario u) throws SeguidoInexistenteException{
        String clave = u.getNick();
        Usuario u2 = this.seguidos.get(clave);
        if (u2 == null){
            throw new SeguidoInexistenteException();
        }
        this.seguidos.remove(clave);
    }


    void PublicarLista(String nomLista) throws YaPublicaException, ListaInexistenteException {
       Particular l = BuscarLista(nomLista);
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
    
        ArrayList<String> ListarListasPublicas() {
        ArrayList<String> a = new ArrayList();
        for(Map.Entry<String, Particular> entry : listas.entrySet()) {
            Particular p = entry.getValue();
            if(!(p instanceof Privada))
                a.add(p.getNombre());
        }
        return a;
    }

    ArrayList<DataTema> ListarTemasDeLista(String nombre) throws ListaInexistenteException {
        return BuscarLista(nombre).ListarTemas();
    }
    
    ArrayList<Tema> ListarTemasDeLista2(String nombre) throws Exception {
        Lista l = listas.get(nombre);
        if(l!=null)
            return l.DevolverTemas();
        else
            throw new Exception("El cliente no tiene una lista con ese nombre");
    }
    

    void AltaLista(DataParticular d) throws ListaRepetidaException {
        if(ValidarNombreLista(d.getNombre()))
            listas.put(d.getNombre(), new Privada(d));
        else
            throw new ListaRepetidaException();
    }
    
    private boolean ValidarNombreLista(String nom)
    {
        return !nom.equals("") && !listas.containsKey(nom);
    }

    void QuitarTemaDeLista(String nomLista, String nomTema,String nomAlbum) throws ListaInexistenteException {
        BuscarLista(nomLista).QuitarTema(nomTema,nomAlbum);
    }

    DataLista DarInfoLista(String nomLista) throws ListaInexistenteException{
        return BuscarLista(nomLista).getData();
    }
    
    Particular BuscarLista(String nomLista) throws ListaInexistenteException
    {
        Particular l = listas.get(nomLista);
        if(l!=null)
            return l;
        else
            throw new ListaInexistenteException();
    }

    public void AgregarTemaLista(Tema t, String lis) throws Exception{
        Lista l = listas.get(lis);
        if(l==null){
            throw new Exception("La lista que tiene que existir no se encontro");
        }
        l.AgregarTema(t);
    }

}
