package espotify;

import espotify.Interfaces.IAltaGenero;
import espotify.Interfaces.IAltaLista;
import espotify.Interfaces.IAltaPerfil;
import espotify.Interfaces.IAltaSeguir;
import espotify.Interfaces.IConsultaArtista;
import espotify.Interfaces.IConsultaCliente;
import espotify.Interfaces.IConsultaLista;
import espotify.Interfaces.IDejarDeSeguir;
import espotify.Interfaces.IPublicarLista;

public abstract class Fabrica {
    public static IAltaGenero getIAltaGenero()
    {
        return CtrlMusica.getInstancia();
    }
    public static IAltaPerfil getIAltaPerfil()
    {
        return CtrlUsuarios.getInstancia();
    }
    public static IAltaSeguir getIAltaSeguir()
    {
        return CtrlUsuarios.getInstancia();
    }
    public static IConsultaArtista getIConsultaArtista()
    {
        return CtrlUsuarios.getInstancia();
    }
    public static IConsultaCliente getIConsultaCliente()
    {
        return CtrlUsuarios.getInstancia();
    }
    public static IDejarDeSeguir getIDejarDeSeguir()
    {
        return CtrlUsuarios.getInstancia();
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
    
}
