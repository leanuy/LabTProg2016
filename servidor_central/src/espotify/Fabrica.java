package espotify;

import espotify.interfaces.IActualizarSuscripcion;
import espotify.interfaces.IAgregarTemaLista;
import espotify.interfaces.IAltaAlbum;
import espotify.interfaces.IAltaGenero;
import espotify.interfaces.IAltaLista;
import espotify.interfaces.IAltaPerfil;
import espotify.interfaces.IAltaSeguir;
import espotify.interfaces.IBuscar;
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
import espotify.interfaces.web.IAgregarTemaListaWeb;
import espotify.interfaces.web.IAltaAlbumWeb;
import espotify.interfaces.web.IFavoritos;
import espotify.interfaces.web.IListarGeneros;
import espotify.interfaces.web.IObtenerAudio;
import espotify.interfaces.web.IObtenerImagen;
import espotify.interfaces.web.ISuscripcionWeb;
import espotify.interfaces.web.IValidar;
import espotify.interfaces.web.IVerAlbum;
import espotify.interfaces.web.IVerGenero;
import espotify.interfaces.web.IVerListaDefecto;
import espotify.interfaces.web.IVerListaParticular;
import espotify.interfaces.web.IVerPerfil;
import espotify.interfaces.web.IWebSeguir;
import espotify.interfaces.web.IListarUsuarios;

public final class Fabrica {

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
    
    public static IVerListaDefecto getIVerListaDefecto() {
        return new CtrlListas();
    }
    
    public static IWebSeguir getIWebSeguir() {
        return new CtrlUsuarios();
    }
    
    public static IListarUsuarios getIListarUsuarios() {
        return new CtrlUsuarios();
    }
    
    public static IVerGenero getIVerGenero() {
        return new CtrlMusica();
    }
    
    public static IListarGeneros getIListarGeneros() {
        return new CtrlMusica();
    }
    public static ISuscripcionWeb getISuscripcionWeb() {
        return new CtrlUsuarios();
    }
    
    public static IValidar getIValidar() {
        return new CtrlUsuarios();
    }
    
    public static IActualizarSuscripcion getIActualizarSuscripcion() {
        return new CtrlUsuarios();
    }
    
    public static IFavoritos getIFavoritos() {
        return new CtrlUsuarios();
    }
    
    public static IObtenerImagen getIImagen() {
        return new CtrlImagenes();
    }

    public static IBuscar getIBuscar() {
        return new CtrlMusica();
    }
    
<<<<<<< 8383eff3a2e48fc01b956df11f3bc7ded87018d7
    public static IObtenerAudio getIObtenerAudio() {
        return new CtrlUsuarios();
    }
    
    
    public static IAgregarTemaListaWeb getIAgregarTemaListaWeb() {
        return new CtrlListas();
=======
    public static IAltaAlbumWeb getIAltaAlbumWeb() {
        return new CtrlMusica();
>>>>>>> separacion en pasos
    }
}
