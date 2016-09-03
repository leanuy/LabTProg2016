package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataLista;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

abstract class Lista {
    protected String nombre;
    protected BufferedImage img;
    protected final HashMap<String, Tema> themas;

    String getNombre() {
        return nombre;
    }
    BufferedImage getImg() {
        return img;
    }
    
    
    Lista(String nombre, BufferedImage img)
    {
        this.nombre=nombre;
        this.img=img;
        this.themas = new HashMap<>();
    }
    Lista(DataLista d)
    {
        this.nombre = d.getNombre();
        this.img = d.getImg();
        this.themas = new HashMap<>();
    }

    ArrayList<DataTema> ListarTemas() {
        ArrayList<DataTema> a = new ArrayList();
        Tema t;
        for(Map.Entry<String, Tema> entry : themas.entrySet()){
            t = entry.getValue();
            a.add(t.getData());
        }
        return a;
    }
    
/*KILL    ArrayList<Tema> DevolverTemas(){
        return this.temas;
    }*/
    
    void AgregarTema(Tema t) throws Exception{
        String s = t.getNombre()+t.getNombreAlbum();
        Tema t2 = themas.get(s);
        if (t2 != null){
            throw new Exception("El tema ya existe en la lista");
        }
        themas.put(s, t);
    }

    void QuitarTema(String nomTema,String nomAlbum) {
        String s = nomTema+nomAlbum;
        themas.remove(s);
    }
    
    DataLista getData()
    {
        ArrayList<DataTema> lst = this.ListarTemas();
        DataLista dl = new DataLista(this.nombre, this.img, lst);
        return dl;
    }
}
