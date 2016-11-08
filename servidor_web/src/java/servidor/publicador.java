/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;

import javax.jws.WebService;

/**
 *
 * @author DJA
 */
@WebService(serviceName = "PublicadorService", portName = "PublicadorPort", endpointInterface = "servidor.Publicador", targetNamespace = "http://servidor/", wsdlLocation = "WEB-INF/wsdl/publicador/localhost_9128/publicador.wsdl")
public class publicador {

    public void altaCliente(servidor.DataCliente arg0) throws servidor.FormatoIncorrectoException_Exception, servidor.NickRepetidoException_Exception, servidor.CorreoRepetidoException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void altaArtista(servidor.DataArtista arg0) throws servidor.NickRepetidoException_Exception, servidor.FormatoIncorrectoException_Exception, servidor.CorreoRepetidoException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void altaSeguir(java.lang.String arg0, java.lang.String arg1) throws servidor.SeguidoInexistenteException_Exception, servidor.AutoSeguirseException_Exception, servidor.SeguidorInexistenteException_Exception, servidor.SeguidoRepetidoException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void altaListaParticular(servidor.DataParticular arg0) throws servidor.ListaRepetidaException_Exception, servidor.ClienteInexistenteException_Exception, servidor.CampoVacioException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void publicarLista(java.lang.String arg0, java.lang.String arg1) throws servidor.YaPublicaException_Exception, servidor.ClienteInexistenteException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionString listarListasDeCliente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataClienteExt consultaCliente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionString listarListasPrivadasDeCliente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void dejarDeSeguir(java.lang.String arg0, java.lang.String arg1) throws servidor.SeguidorInexistenteException_Exception, servidor.SeguidoInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataLista darInfoParticular(java.lang.String arg0, java.lang.String arg1) throws servidor.ListaInexistenteException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataLista darInfoDefecto(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionString listarListasPublicasDeCliente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public byte[] getImageLista(java.lang.String arg0, java.lang.String arg1) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionRanking darRanking() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void desFavoritearParticular(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ListaInexistenteException_Exception, servidor.ClienteInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionString listarClientes() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionString listarArtistas() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataArtistaExt consultaArtista(java.lang.String arg0) throws servidor.ArtistaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionString listarAlbumesDeArtista(java.lang.String arg0) throws servidor.ArtistaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataAlbumExt consultaAlbum(java.lang.String arg0, java.lang.String arg1) throws servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public byte[] getImageUsuario(java.lang.String arg0) throws servidor.UsuarioInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean siguiendo(java.lang.String arg0, java.lang.String arg1) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean checkPassword(java.lang.String arg0, java.lang.String arg1) throws servidor.UsuarioInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void favoritearDefecto(java.lang.String arg0, java.lang.String arg1) throws servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.ListaInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void favoritearParticular(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.ClienteInexistenteException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void desFavoritearAlbum(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.AlbumInexistenteException_Exception, servidor.ListaInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.ClienteInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean esFavoritoAlbum(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ArtistaInexistenteException_Exception, servidor.ClienteInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void desFavoritearTema(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws servidor.ListaInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.ClienteInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean contratarSuscripcion(servidor.TipoSuscripcion arg0, java.lang.String arg1) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean listaEsPrivada(java.lang.String arg0, java.lang.String arg1) throws servidor.ClienteInexistenteException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean existeUsuarioCorreo(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean tieneSuscripcionVigente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean existeUsuarioNick(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void cancelarSuscripcion(java.lang.String arg0) throws servidor.TransicionSuscripcionInvalidaException_Exception, servidor.NoHaySuscripcionException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionSuscripcion listarSuscripcionesCliente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void renovarSuscripcion(java.lang.String arg0) throws servidor.NoHaySuscripcionException_Exception, servidor.TransicionSuscripcionInvalidaException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataSuscripcion obtenerSuscripcionActual(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception, servidor.NoHaySuscripcionException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void favoritearTema(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws servidor.ClienteInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.ListaInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean esCliente(java.lang.String arg0) throws servidor.UsuarioInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean esFavoritoTema(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3) throws servidor.ArtistaInexistenteException_Exception, servidor.ListaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public byte[] getImageAlbum(java.lang.String arg0, java.lang.String arg1) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataUsuario buscarUsuario(java.lang.String arg0) throws servidor.UsuarioInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void desFavoritearDefecto(java.lang.String arg0, java.lang.String arg1) throws servidor.ClienteInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataColeccionTemas sugerir() {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean esFavoritoDefecto(java.lang.String arg0, java.lang.String arg1) throws servidor.ClienteInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.ListaInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void favoritearAlbum(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ListaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.FavoritoRepetidoException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void altaArtistaConImagen(servidor.DataArtista arg0, byte[] arg1) throws servidor.CorreoRepetidoException_Exception, servidor.NickRepetidoException_Exception, servidor.FormatoIncorrectoException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean esArtista(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void agregarTemaWebxAlbum(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, java.lang.String arg3, java.lang.String arg4) throws servidor.AlbumInexistenteException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.ListaInexistenteException_Exception, servidor.TemaRepetidoException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.DataTema consultaTema(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.BeanConsultaGenero consultaGenero(java.lang.String arg0) throws servidor.GeneroInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public boolean esFavoritoParticular(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ArtistaInexistenteException_Exception, servidor.ListaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception, servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.BeanListarFavoritos listarFavoritos(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void altaClienteConImagen(servidor.DataCliente arg0, byte[] arg1) throws servidor.FormatoIncorrectoException_Exception, servidor.NickRepetidoException_Exception, servidor.CorreoRepetidoException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public void altaListaParticularConImagen(servidor.DataParticular arg0, byte[] arg1) throws servidor.ClienteInexistenteException_Exception, servidor.CampoVacioException_Exception, servidor.ListaRepetidaException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public byte[] getAudio(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2, boolean arg3) throws servidor.TemaTipoInvalidoException_Exception, servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public servidor.BeanBusqueda buscar(java.lang.String arg0) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String consultaURLTema(java.lang.String arg0, java.lang.String arg1, java.lang.String arg2) throws servidor.ArtistaInexistenteException_Exception, servidor.AlbumInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public java.lang.String consultaFechaVencimientoSuscripcionVigente(java.lang.String arg0) throws servidor.ClienteInexistenteException_Exception {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
