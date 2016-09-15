/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces;

import espotify.datatypes.DataUsuario;
import espotify.excepciones.UsuarioInexistenteException;

/**
 *
 * @author agustina
 */
public interface IIniciarSesion {
    public DataUsuario BuscarUsuario(String nickUsuario) throws UsuarioInexistenteException;
    public boolean checkPassword(String nickUsuario, String password) throws UsuarioInexistenteException;
}
