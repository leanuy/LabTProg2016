package espotify.Interfaces;

import espotify.Datatypes.DataArtistaExt;

public interface IConsultaArtista {
    public String[] DevolverArtistas();
    public DataArtistaExt ConsultaArtista(String s);
    
}