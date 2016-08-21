package espotify;

import espotify.Datatypes.DataTema;

public class Tema implements Favoriteable {
    private String nombre;
    private int duracion;
    private int num;

    public String getNombre() {
        return nombre;
    }
    public int getDuracion() {
        return duracion;
    }
    public int getNum() {
        return num;
    }

    DataTema getData() {
        return new DataTema(nombre, duracion, num);
    }
}
