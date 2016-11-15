package espotify;

import espotify.datatypes.DataTema;
import java.io.Serializable;
import java.util.Comparator;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

@MappedSuperclass
class Tema implements Favoriteable, Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String nombre;
    private int duracion;
    private int num;
    private Album album;
    @Transient
    private int cantReproducciones;
    @Transient
    private int cantDescargas;
    @Transient
    private int listasCon;
    @Transient
    private int favoritosCon;

    String getNombre() {
        return nombre;
    }
    
    String getNombreAlbum() {
        return album.getNombre();
    }
    
    String getNomArtista() {
        return album.getNickArtista();
    }
    
    Album getAlbum() {
        return this.album;
    }

    public DataTema getData() {
        return new DataTema(nombre, duracion, num, getNomArtista(), getNombreAlbum(), this instanceof TemaWeb);
    }

    Tema(DataTema dataTema, Album album) {
        this.nombre = dataTema.getNombre();
        this.duracion = dataTema.getDuracion();
        this.num = dataTema.getNum();
        this.album = album;
        this.cantDescargas=0;
        this.cantReproducciones=0;
        this.listasCon=0;
        this.favoritosCon=0;
    }

    void registrarUso(boolean esDescarga) {
        if (esDescarga) {
            cantDescargas++;
        } else {
            cantReproducciones++;
        }
    }

    void fueAgregadoALista() {
        listasCon++;
    }

    void fueQuitadoDeLista() {
        listasCon--;
    }

    void fueDesFavoriteado() {
        favoritosCon--;
    }

    void fueFavoriteado() {
        favoritosCon++;
    }
    
    public static Comparator comparadorTemas() {
        return new Comparator<Tema>() {
                @Override
                public int compare(Tema o1, Tema o2) {
                    return (int)(1000000*(o2.puntaje() - o1.puntaje()) + Math.random()*2000 - 1000);
                }
            };
    }

    private double puntaje() {
        return cantDescargas*0.2 + cantReproducciones*0.3 + listasCon*0.2 + favoritosCon*0.3;
    }

    public Tema() {
    }
    
}
