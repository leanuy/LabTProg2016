package espotify.datatypes;

import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataTema implements DataFavoriteable {
    private String nombre;
    private int duracion;
    private int num;
    private String nomArtista;
    private String album;
    private boolean esWeb;
    
    public String getNombre() {
        return nombre;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
    public int getNum() {
        return num;
    }
    
    public String getNomArtista() {
        return nomArtista;
    }
    
    public String getAlbum() {
        return album;
    }
    
    @XmlAttribute
    public String getDuracionStr() {
        if ((duracion % 60) < 10) {
            return duracion / 60 + ":0" + duracion % 60;
        } else {
            return duracion / 60 + ":" + duracion % 60;
        }
    }
    

    public DataTema(String nombre, int duracion, int num) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista = "";
    }

    public DataTema(String nombre, int duracion, int num, String nomArtista, String album) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista = nomArtista;
        this.album = album;
    }

    public DataTema(String nombre, int duracion, int num, String nomArtista, String album, boolean esWeb) {
        this.nombre = nombre;
        this.duracion = duracion;
        this.num = num;
        this.nomArtista = nomArtista;
        this.album = album;
        this.esWeb = esWeb;
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        final DataTema other = (DataTema) obj;
        if (this.duracion != other.duracion) {
            return false;
        }
        if (this.num != other.num) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.nomArtista, other.nomArtista)) {
            return false;
        }
        return Objects.equals(this.album, other.album);
    }

    public boolean getEsWeb() {
        return esWeb;
    }

    public DataTema() {
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setNomArtista(String nomArtista) {
        this.nomArtista = nomArtista;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public void setEsWeb(boolean esWeb) {
        this.esWeb = esWeb;
    }
}
