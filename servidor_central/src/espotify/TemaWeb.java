package espotify;

import espotify.datatypes.DataTema;
import espotify.datatypes.DataTemaWeb;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
class TemaWeb extends Tema {
    @Transient
    private String url;
    
    TemaWeb(DataTemaWeb dtw, final Album album) {
        super(dtw, album);
        String str = dtw.getUrl();
        if (!str.startsWith("http")) {
            str = "http://" + str;
        }
        this.url = str;
    }
    
    @Override
    public DataTema getData() {
        final DataTema root = super.getData();
        return new DataTemaWeb(url, root.getNombre(), root.getDuracion(), root.getNum(),
                root.getNomArtista(), root.getAlbum()); 
    }  

    public TemaWeb() {
    }
    
}
