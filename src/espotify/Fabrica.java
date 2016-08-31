package espotify;

import espotify.Interfaces.IAgregarTemaLista;
import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IDejarDeSeguir;
import espotify.Interfaces.IPublicarLista;
import espotify.Interfaces.IAltaAlbum;
import espotify.Interfaces.IConsultaAlbum;
import espotify.Interfaces.IFavoritear;
import espotify.Interfaces.IQuitarTemaLista;

public abstract class Fabrica {
    public static IAltaGenero getIAltaGenero()
    {
        return CtrlMusica.getInstancia();
    }
    public static IAltaPerfil getIAltaPerfil()
    {
        return new CtrlUsuarios();
    }
    public static IAltaSeguir getIAltaSeguir()
    {
        return new CtrlUsuarios();
    }
    public static IConsultaArtista getIConsultaArtista()
    {
        return new CtrlUsuarios();
    }
    public static IConsultaCliente getIConsultaCliente()
    {
        return new CtrlUsuarios();
    }
    public static IDejarDeSeguir getIDejarDeSeguir()
    {
        return new CtrlUsuarios();
    }
    public static IAltaLista getIAltaLista()
    {
        return CtrlListas.getInstancia();
    }
    public static IPublicarLista getIPublicarLista()
    {
        return CtrlListas.getInstancia();
    }

    public static IConsultaLista getIConsultaLista()
    {
        return CtrlListas.getInstancia();
    }

    public static IAltaAlbum getIAltaAlbum()
    {
        return CtrlMusica.getInstancia();
    }
    
    public static IConsultaAlbum getIConsultaAlbum() {
        return CtrlMusica.getInstancia();
    }
    public static IFavoritear getIFavoritear() {
        return new CtrlUsuarios();
    }  
    
    public static IAgregarTemaLista getIAgregarTemaLista(){
        return CtrlListas.getInstancia();
    }
    
    public static IQuitarTemaLista getIQuitarTemaLista(){
        return CtrlListas.getInstancia();
    }
}
