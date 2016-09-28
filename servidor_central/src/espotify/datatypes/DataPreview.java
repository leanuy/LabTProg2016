package espotify.datatypes;

import java.io.File;


public class DataPreview {
    private String nombre;
    private File img;

    public DataPreview(String nombre, File img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public File getImg() {
        return img;
    }

    public void setImg(File img) {
        this.img = img;
    }
    
}
