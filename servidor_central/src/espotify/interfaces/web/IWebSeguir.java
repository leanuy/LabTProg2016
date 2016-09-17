/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.excepciones.AutoSeguirseException;
import espotify.excepciones.SeguidoInexistenteException;
import espotify.excepciones.SeguidoRepetidoException;
import espotify.excepciones.SeguidorInexistenteException;

/**
 *
 * @author Santiago
 */
public interface IWebSeguir {
    public void altaSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidorInexistenteException, SeguidoInexistenteException,
            SeguidoRepetidoException, AutoSeguirseException;
    
    public void dejarDeSeguir(String nomSeguidor, String nomSeguido)
            throws SeguidoInexistenteException, SeguidorInexistenteException;
    

}
