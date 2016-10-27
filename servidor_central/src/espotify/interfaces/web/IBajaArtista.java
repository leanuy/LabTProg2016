/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.excepciones.ArtistaInexistenteException;

/**
 *
 * @author santiagoserantes
 */
public interface IBajaArtista {
    public void BajaArtista(String nick) throws ArtistaInexistenteException;
}
