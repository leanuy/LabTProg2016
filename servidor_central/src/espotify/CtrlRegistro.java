package espotify;

import espotify.interfaces.IVerRegistroAccesos;
import espotify.interfaces.web.IRegistrarAcceso;
import java.util.Calendar;
import java.util.List;

public class CtrlRegistro implements IRegistrarAcceso, IVerRegistroAccesos {
    @Override
    public void RegistrarAcceso(String ip, String url, String browser, String so) {
        Acceso acceso = new Acceso(Calendar.getInstance(), ip, url, browser, so);
        List<Acceso> accesos = ManejadorColecciones.getInstancia().getAccesos();
        if (accesos.size() >= 10000) {
            accesos.remove(0);
        }
        ManejadorColecciones.getInstancia().agregarAcceso(acceso);
    }
   
    @Override
    public List<Acceso> listarAccesos() {
        return ManejadorColecciones.getInstancia().getAccesos();
    }
}
