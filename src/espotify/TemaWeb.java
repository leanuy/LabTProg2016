package espotify;

import espotify.Datatypes.DataTemaWeb;

public class TemaWeb extends Tema {
    private String url;

    public String getUrl() {
        return url;
    }
    
    public TemaWeb(DataTemaWeb dtw, Album album) {
        super(dtw, album);
        this.url = dtw.getUrl();
    }
}
