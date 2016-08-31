package espotify;

import espotify.Datatypes.DataCliente;
import espotify.Interfaces.IAltaPerfil;
import java.util.Calendar;

public abstract class CtrlDatosIniciales {
    public static void CargarDatosIniciales() throws Exception
    {
        //ALTA DE CLIENTES:
        IAltaPerfil ctrl = Fabrica.getIAltaPerfil();
        
        Calendar cal = Calendar.getInstance();
        cal.set(1972, 3, 8);
        DataCliente d = new DataCliente("el_padrino", "Vito", "Corleone", "el_padrino@tuta.io", cal, null);
        ctrl.AltaCliente(d);
        
    }
    
    
}
