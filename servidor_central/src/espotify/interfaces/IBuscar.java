/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces;

import espotify.datatypes.DataAlbum;
import java.util.ArrayList;

/**
 *
 * @author DJA
 */
public interface IBuscar {
    public ArrayList<String[]> buscarTemas(String busqueda);
    
    public ArrayList<DataAlbum> buscarAlbums(String busqueda);
    
    public ArrayList<String[]> buscarListas(String busqueda);
}
