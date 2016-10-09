/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.excepciones.AlbumInexistenteException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.TemaTipoInvalidoException;
import java.io.BufferedInputStream;
import java.io.File;
import java.util.ArrayList;

/**
 *
 * @author JavierM42
 */
public interface IObtenerAudio {
    public BufferedInputStream getAudio(String nick, String album, String tema)
        throws ArtistaInexistenteException, AlbumInexistenteException, TemaTipoInvalidoException;
}
