/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.Datatypes;

import java.util.Calendar;

/**
 *
 * @author Santiago
 */
public class DataArtistaExt extends DataUsuario {
    private String bio;
    private String url;

    public String getBio() {
        return bio;
    }
    public String getUrl() {
        return url;
    }
    
    public DataArtistaExt(String nick, String nombre, String apellido, String correo, Calendar fNac, String img, String bio, String url){

        super(nick, nombre, apellido, correo, fNac, img);

        this.bio = bio;
        this.url = url;
    }
}
