package espotify;

import espotify.Datatypes.DataTemaWeb;

class TemaWeb extends Tema {
    private String url;
    
    TemaWeb(DataTemaWeb dtw, Album album) {
        super(dtw, album);
        this.url = dtw.getUrl();
    }
}
