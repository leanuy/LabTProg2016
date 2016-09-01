package espotify;

import espotify.Datatypes.DataTema;
import espotify.Datatypes.DataTemaWeb;

class TemaWeb extends Tema {
    private String url;
    
    TemaWeb(DataTemaWeb dtw, Album album) {
        super(dtw, album);
        this.url = dtw.getUrl();
    }
    @Override
    DataTema getData() {
        DataTema root = super.getData();
        return new DataTemaWeb(url,root.getNombre(),root.getDuracion(),root.getNum()); 
    } 
}
