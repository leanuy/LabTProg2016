package espotify;

import espotify.interfaces.IAgregarTemaLista;
import espotify.interfaces.IAltaAlbum;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IAltaSeguir;
import espotify.interfaces.IConsultaAlbum;
import espotify.interfaces.IConsultaArtista;
import espotify.interfaces.IConsultaCliente;
import espotify.interfaces.IConsultaLista;
import espotify.interfaces.IDejarDeSeguir;
import espotify.interfaces.IDesFavoritear;
import espotify.interfaces.IFavoritear;
import espotify.interfaces.IIniciarSesion;
import espotify.interfaces.IPublicarLista;
import espotify.interfaces.IQuitarTemaLista;
import espotify.interfaces.web.IListarArtistas;
import espotify.interfaces.web.IListarClientes;
import espotify.interfaces.web.IValidar;
import espotify.interfaces.web.IVerAlbum;
import espotify.interfaces.web.IVerGenero;
import espotify.interfaces.web.IVerListaParticular;
import espotify.interfaces.web.IVerPerfil;
import espotify.interfaces.web.IWebSeguir;

public class Fabrica {



    private Fabrica() {
    }
    
    public static IAltaGenero getIAltaGenero() {
        return new CtrlMusica();
    }
    
    public static IAltaPerfil getIAltaPerfil() {
        return new CtrlUsuarios();
    }
    
    public static IIniciarSesion getIIniciarSesion() {
        return new CtrlUsuarios();
    }
    
    public static IAltaSeguir getIAltaSeguir() {
        return new CtrlUsuarios();
    }
    
    public static IConsultaArtista getIConsultaArtista() {
        return new CtrlUsuarios();
    }
    
    public static IConsultaCliente getIConsultaCliente() {
        return new CtrlUsuarios();
    }
    
    public static IDejarDeSeguir getIDejarDeSeguir() {
        return new CtrlUsuarios();
    }
    
    public static IAltaLista getIAltaLista() {
        return new CtrlListas();
    }
    
    public static IPublicarLista getIPublicarLista() {
        return new CtrlListas();
    }

    public static IConsultaLista getIConsultaLista() {
        return new CtrlListas();
    }

    public static IAltaAlbum getIAltaAlbum() {
        return new CtrlMusica();
    }
    
    public static IConsultaAlbum getIConsultaAlbum() {
        return new CtrlMusica();
    }
    
    public static IFavoritear getIFavoritear() {
        return new CtrlUsuarios();
    }
    
    public static IDesFavoritear getIDesFavoritear() {
        return new CtrlUsuarios();
    }  
    
    public static IAgregarTemaLista getIAgregarTemaLista() {
        return new CtrlListas();
    }
    
    public static IQuitarTemaLista getIQuitarTemaLista() {
        return new CtrlListas();
    }
    
    public static void clear() { //cuando todo ande, esto tiene que morir. Fuerte.
        ManejadorColecciones.clear();
    }
    
    public static IVerPerfil getIVerPerfil() {
        return new CtrlUsuarios();
    }
    
    public static IVerAlbum getIVerAlbum() {
        return new CtrlMusica();
    }
    
    public static IVerListaParticular getIVerListaParticular() {
        return new CtrlListas();
    }
    
    public static IWebSeguir getIWebSeguir() {
        return new CtrlUsuarios();
    }
    
    public static IListarArtistas getIListarArtistas() {
        return new CtrlUsuarios();
    }
    
    public static IListarClientes getIListarClientes() {
        return new CtrlUsuarios();
    }
    
    public static IVerGenero getIVerGenero() {
        return new CtrlMusica();
    }
    
    public static IValidar getIValidar() {
        return new CtrlUsuarios();
    }
}
