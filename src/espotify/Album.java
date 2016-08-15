/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import java.util.ArrayList;
import java.util.HashMap;

public class Album {
    //attrs
    private String nombre;
    private int anio;
    private String img;
    private final HashMap<String,Genero> generos;
    private final ArrayList<Tema> temas;

    //getters
    public String getNombre() {
        return nombre;
    }
    public int getAnio() {
        return anio;
    }
    public String getImg() {
        return img;
    }
    //constructores
    public Album()
    {
        this.generos=new HashMap<>();
        this.temas=new ArrayList<>();
    }
}
