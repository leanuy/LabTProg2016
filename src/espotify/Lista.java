package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataLista;
import java.util.ArrayList;

public abstract class Lista {
    protected String nombre;
    protected String img;
    protected final ArrayList<Tema> temas;

    public String getNombre() {
        return nombre;
    }
    public String getImg() {
        return img;
    }
    
    public Lista(String nombre, String img)
    {
        this.nombre=nombre;
        this.img=img;
        this.temas=new ArrayList<>();
        }
    public Lista(DataLista d)
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

    void QuitarTema(String nomTema,String nomAlbum) {
        for (Tema t: temas){
            if(t.getNombre().equals(nomTema) && t.getNombreAlbum().equals(nomAlbum))
                temas.remove(t);
        }
    }

}
