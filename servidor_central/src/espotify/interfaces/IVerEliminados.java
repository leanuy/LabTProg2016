/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces;

import espotify.datatypes.DataArtistaExt;
import java.util.Calendar;
import java.util.List;

/**
 *
 * @author JavierM42
 */
public interface IVerEliminados {
    
    public List<String> cargarArtistasEliminados();

    public DataArtistaExt consultaArtistaEliminado(String usr);

    public Calendar consultaFechaBajaArtista(String usr);

    public List<String> consultaGenerosAlbumEliminado(String usr, String alb);

    public List<String> consultaTemasAlbumEliminado(String usr, String alb);
}
