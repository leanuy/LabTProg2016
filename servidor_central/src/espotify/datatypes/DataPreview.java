package espotify.datatypes;

import java.awt.image.BufferedImage;

public class DataPreview {
    private String nombre;
    private BufferedImage img;

    public DataPreview(String nombre, BufferedImage img) {
        this.nombre = nombre;
        this.img = img;
    }

    public String getNombre() {
        return nombre;
    }

    public BufferedImage getImg() {
        return img;
    }

    public void setImg(BufferedImage img) {
        this.img = img;
    }
    
}
