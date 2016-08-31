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
        cal.set(1984, 11, 27);
        d = new DataCliente("scarlettO", "Scarlett", "O'Hara", "scarlettO@tuta.io", cal, null);
        ctrl.AltaCliente(d);
        cal.set(1955, 2, 14);
        d = new DataCliente("ppArgento", "Pepe", "Argento", "ppArgento@hotmail.com", cal, null);
        ctrl.AltaCliente(d);
        cal.set(1056, 3, 7);
        d = new DataCliente("Heisenberg", "Walter", "White", "Heisenberg@tuta.io", cal, null);
        ctrl.AltaCliente(d);
        cal.set(1914, 4, 2);
        d = new DataCliente("benKenobi", "Obi-Wan", "Kenobi", "benKenobi@gmail.com", cal, null);
        ctrl.AltaCliente(d);
        cal.set(1927, 2, 23);
        d = new DataCliente("lachiqui", "Mirtha", "Legrand", "lachiqui@hotmail.com.ar", cal, null);
        ctrl.AltaCliente(d);
        //cal.set(1937, 5, 8);
        //d = new DataCliente("Eleven11", "Eleven", "", "Eleven11@gmail.com", cal, null);
        //ctrl.AltaCliente(d);
    }
    
    
}
