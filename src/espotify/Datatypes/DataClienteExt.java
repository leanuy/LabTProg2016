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
public class DataClienteExt extends DataUsuario {
    

    public DataClienteExt(String nick, String nombre, String apellido, String correo, Calendar fNac, String img) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fNac = fNac;
        this.img = img;
    }
    
}
