package espotify;

import espotify.datatypes.DataLista;
import espotify.datatypes.DataTema;
import espotify.excepciones.TemaRepetidoException;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

abstract class Lista {
    protected String nombre;
    protected File img;
    protected final Map<String, Tema> temas;

    String getNombre() {
        return nombre;
    }
    
    File getImg() {
        return img;
    }
    
    
    Lista(String nombre, File img) {
        this.nombre = nombre;
        this.img = img;
        this.temas = new HashMap<>();
    }
    
    Lista(DataLista data) {
        this.nombre = data.getNombre();
        this.img = data.getImg();
        this.temas = new HashMap<>();
    }
    
    Lista(Lista lst) {
        this.nombre = lst.getNombre();
        this.img = lst.getImg();
        this.temas = lst.temas;
    }

    List<DataTema> listarTemas() {
        List<DataTema> salida = new ArrayList();
        Tema tema;
        for (Map.Entry<String, Tema> entry : temas.entrySet()) {
            tema = entry.getValue();
            salida.add(tema.getData());
        }
        return salida;
    }
    
    void agregarTema(Tema tema) throws Exception {
        String clave = tema.getNombre() + tema.getNombreAlbum();
        Tema tema2 = temas.get(clave);
        if (tema2 != null) {
            throw new TemaRepetidoException("El tema ya existe en la lista");
        }
        temas.put(clave, tema);
    }

    void quitarTema(String nomTema,String nomAlbum) {
        String clave = nomTema + nomAlbum;
        temas.remove(clave);
    }
    
    DataLista getDataExt() {
        return new DataLista(nombre, img, listarTemas());
    }
}
