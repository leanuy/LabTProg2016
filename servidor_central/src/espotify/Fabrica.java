package espotify;

import espotify.Interfaces.IAgregarTemaLista;
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaAlbum;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IDejarDeSeguir;
import espotify.Interfaces.IDesFavoritear;
import espotify.Interfaces.IFavoritear;
import espotify.Interfaces.IPublicarLista;
import espotify.Interfaces.IQuitarTemaLista;

public abstract class Fabrica {
    public static IAltaGenero getIAltaGenero() {
        return new CtrlMusica();
    }
    
    public static IAltaPerfil getIAltaPerfil() {
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
}