package espotify.datatypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataSuscripcionVigente extends DataSuscripcion {
    private final Calendar vencimiento;
    
    public DataSuscripcionVigente(Calendar fechaCreacion, EstadoSuscripcion estado,
            TipoSuscripcion tipo, Calendar vencimiento) {
        super(fechaCreacion, estado, tipo);
        this.vencimiento = vencimiento;
    }
    
    public Calendar getVencimiento() {
        return vencimiento;
    }
    
    public String getfVenStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(vencimiento.getTime());
    }
}
