package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataLista;
import java.awt.image.BufferedImage;
import java.util.ArrayList;

abstract class Lista {
    protected String nombre;
    protected BufferedImage img;
    protected final ArrayList<Tema> temas;

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
        this.temas=new ArrayList<>();
        }
    Lista(DataLista d)
    {
        this.nombre = d.getNombre();
        this.img = d.getImg();
        this.temas = new ArrayList<>();
    }

    ArrayList<DataTema> ListarTemas() {
        ArrayList<DataTema> a = new ArrayList();
        for (Tema t: temas)
            a.add(t.getData());
        return a;
    }
    
/*KILL    ArrayList<Tema> DevolverTemas(){
        return this.temas;
    }*/
    
    void AgregarTema(Tema t){
        temas.add(t);
    }

    void QuitarTema(String nomTema,String nomAlbum) {
        for (Tema t: temas){
            if(t.getNombre().equals(nomTema) && t.getNombreAlbum().equals(nomAlbum))
                temas.remove(t);
        }
    }
    
    DataLista getData()
    {
        ArrayList<DataTema> lst = new ArrayList<>();
        for(Tema t:temas)
            lst.add(t.getData());
        return new DataLista(nombre, img, lst);
    }

}
