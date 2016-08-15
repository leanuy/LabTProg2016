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
    private String nick;
    private String nombre;
    private String apellido;
    private String correo;
    private Date fNac;
    private String img;

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

}
