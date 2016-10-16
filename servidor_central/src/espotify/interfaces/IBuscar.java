/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces;

import espotify.datatypes.DataAlbum;
import java.util.List;

/**
 *
 * @author DJA
 */
public interface IBuscar {
    public List<String[]> buscarTemas(String busqueda);
    
    public List<DataAlbum> buscarAlbums(String busqueda);
    
    public List<String[]> buscarListas(String busqueda);
}
