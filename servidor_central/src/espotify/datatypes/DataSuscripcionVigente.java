package espotify.datatypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataSuscripcionVigente extends DataSuscripcion {
    private final Calendar vencimiento;
    private final Calendar desde;
    
    public DataSuscripcionVigente(Calendar fechaCreacion, Calendar fUp, EstadoSuscripcion estado,
            TipoSuscripcion tipo, Calendar vencimiento, Calendar fDesde) {
        super(fechaCreacion, fUp, estado, tipo);
        this.vencimiento = vencimiento;
        this.desde = fDesde;
    }
    
    public Calendar getVencimiento() {
        return vencimiento;
    }
    
    public String getfVenStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(vencimiento.getTime());
    }
    public String getfDesdeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(desde.getTime());
    }
}
