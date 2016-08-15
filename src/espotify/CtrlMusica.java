/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import java.util.HashMap;

public class CtrlMusica {
    private CtrlMusica instancia;
    private final HashMap<String,Genero> generos;
    private final Genero generoBase;
    //getters
    public CtrlMusica getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlMusica();
        return instancia;
    }
    //constructor
    private CtrlMusica()
    {
        this.generoBase=new Genero(); //!!!parámetros
        this.generos=new HashMap<>();
    }
}
