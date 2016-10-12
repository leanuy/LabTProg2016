/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.datatypes.DataAlbumExt;
import espotify.excepciones.AlbumRepetidoException;
import espotify.excepciones.ArtistaInexistenteException;
import espotify.excepciones.CampoVacioException;
import espotify.excepciones.DuracionInvalidaException;
import espotify.excepciones.GeneroInexistenteException;
import espotify.excepciones.NumeroTemaInvalidoException;
import espotify.excepciones.TemaRepetidoException;
import espotify.excepciones.TemaTipoInvalidoException;

/**
 *
 * @author agustina
 */
public interface IAltaAlbumWeb {
    public void addAlbumTemp(DataAlbumExt album) throws ArtistaInexistenteException;
    public DataAlbumExt getAlbumTemp(String nick_artista, String album) throws ArtistaInexistenteException;
    public void cancelarAltaAlbum(String nick_artista, String album) throws ArtistaInexistenteException;
    public void AceptarAltaAlbum(String nick_artista, String album) throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException;
    public boolean esAlbumDeArtista(String nick_artista, String album) throws ArtistaInexistenteException, AlbumRepetidoException, GeneroInexistenteException, DuracionInvalidaException, NumeroTemaInvalidoException, TemaRepetidoException, CampoVacioException, TemaTipoInvalidoException;
}
