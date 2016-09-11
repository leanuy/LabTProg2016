/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.Datatypes;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Objects;

/**
 *
 * @author JavierM42
 */
public class DataUsuario {
    protected String nick;
    protected String nombre;
    protected String apellido;
    protected String correo;
    protected Calendar fNac;
    protected BufferedImage img;
    protected ArrayList<String> seguidores;
    protected String password;

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
    public BufferedImage getImg() {
        return img;
    }
    public ArrayList<String> getSeguidores(){
        return this.seguidores;
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, ArrayList<String> segdores) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fNac = fNac;
        this.img = img;
        this.seguidores = segdores;
    }

    public DataUsuario(String nick, String nombre, String apellido, String correo, Calendar fNac, BufferedImage img, String pwd) {
        this.nick = nick;
        this.nombre = nombre;
        this.apellido = apellido;
        this.correo = correo;
        this.fNac = fNac;
        this.img = img;
        ArrayList<String> segdores = new ArrayList();
        this.seguidores = segdores;
        this.password = pwd;
    }

    public String getPassword() {
        return this.password;
    }
}
