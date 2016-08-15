/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import java.util.HashMap;

/**
 *
 * @author JavierM42
 */
public class CtrlUsuarios {
    private CtrlUsuarios instancia;
    private final HashMap<String,Cliente> clientes;
    private final HashMap<String,Artista> artistas;
    
    public CtrlUsuarios getInstancia()
    {
        if(instancia==null)
            instancia=new CtrlUsuarios();
        return instancia;
    }
    
    public CtrlUsuarios()
    {
        this.clientes=new HashMap<>();
        this.artistas=new HashMap<>();
    }
}
