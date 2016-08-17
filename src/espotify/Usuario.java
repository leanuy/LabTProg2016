/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import espotify.Datatypes.DataUsuario;
import java.util.Calendar;

/**
 *
 * @author JavierM42
 */
public class Usuario {
    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fNac;
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

    public Calendar getfNac() {
        return fNac;
    }

    public String getImg() {
        return img;
    }
    
    static boolean ValidarDatosUsuario(DataUsuario d) {
        return !(d.getNick().equals("") || d.getNombre().equals("") || d.getApellido().equals("") || d.getCorreo().equals(""));
    }

    public Usuario(DataUsuario d){
        this.nick = d.getNick();
        this.nombre = d.getNombre();
        this.apellido = d.getApellido();
        this.correo = d.getCorreo();
        this.fNac = d.getfNac();
        this.img = d.getImg();
    }
}
