package espotify;


public class Defecto extends Lista implements Favoriteable{
    private Genero genero;

    public Defecto(Genero genero, String nombre, String img) {
        super(nombre, img);
        this.genero = genero;
    }
}
