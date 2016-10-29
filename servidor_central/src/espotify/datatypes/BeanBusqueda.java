/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import java.util.ArrayList;

/**
 *
 * @author JavierM42
 */
public class BeanBusqueda {
    private ArrayList<String[]> temas;
    private ArrayList<DataAlbum> albums;
    private ArrayList<String[]> listas;

    public BeanBusqueda() {
    }

    public ArrayList<String[]> getTemas() {
        return temas;
    }

    public void setTemas(ArrayList<String[]> temas) {
        this.temas = temas;
    }

    public ArrayList<DataAlbum> getAlbums() {
        return albums;
    }

    public void setAlbums(ArrayList<DataAlbum> albums) {
        this.albums = albums;
    }

    public ArrayList<String[]> getListas() {
        return listas;
    }

    public void setListas(ArrayList<String[]> listas) {
        this.listas = listas;
    }
    
    
}
