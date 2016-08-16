/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.Datatypes;

import java.util.Date;

/**
 *
 * @author JavierM42
 */
public class DataUsuario {
    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Date fNac;
    protected String img;

    public String getNick() {
        return nick;
    }
    public String getNombre() {
        return nombre;
    }
    public String getApellido() {
        return apellido;
    }
    public String getCorreo() {
        return correo;
    }
    public Date getfNac() {
        return fNac;
    }
    public String getImg() {
        return img;
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo, Date fNac, String img) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fNac = fNac;
        this.img = img;
    }
    
}
