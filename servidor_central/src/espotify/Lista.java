package espotify;

import espotify.datatypes.DataLista;
import espotify.datatypes.DataTema;
import espotify.excepciones.TemaRepetidoException;

import java.awt.image.BufferedImage;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Lista {
    protected String nombre;
    protected BufferedImage img;
    protected final Map<String, Tema> temas;
    protected final int anoCreacion;

    String getNombre() {
        return nombre;
    }
     
   BufferedImage getImg() {
        return img;
    }
    
    Map<String, Tema> getTemas() {
        return this.temas;
    }
    
    int getAnoCreacion() {
        return this.anoCreacion;
    }
    
    Lista(String nombre, BufferedImage img) {
        this.nombre = nombre;
        this.img = img;
        this.temas = new HashMap<>();
        this.anoCreacion = currentDate();
    }
    
    Lista(DataLista data) {
        this.nombre = data.getNombre();
        this.img = data.getImg();
        this.temas = new HashMap<>();
        this.anoCreacion = currentDate();
    }
    
    Lista(Lista lst) {
        this.nombre = lst.getNombre();
        this.img = lst.getImg();
        this.temas = lst.temas;
        this.anoCreacion = currentDate();
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
    
    private int currentDate() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy");
        return Integer.parseInt(dateFormat.format(new Date()));
    }
}
