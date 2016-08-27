/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.Interfaces;

import espotify.Datatypes.DataAlbumExt;
import espotify.Datatypes.DataGenero;
import espotify.Excepciones.AlbumInexistenteException;
import espotify.Excepciones.ArtistaInexistenteException;
import espotify.Excepciones.GeneroInexistenteException;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public interface IConsultaAlbum { 
    public DataGenero ListarGeneros();
    public ArrayList<String[]> ListarAlbumesDeGenero(String nomGenero) throws GeneroInexistenteException;
    public ArrayList<String> ListarArtistas();
    public ArrayList<String> ListarAlbumesDeArtista(String nomArtista) throws ArtistaInexistenteException;
    public DataAlbumExt ConsultaAlbum(String nomAlbum, String nomArtista) throws ArtistaInexistenteException, AlbumInexistenteException;
}
