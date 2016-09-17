package espotify.datatypes;

import java.util.Calendar;

public class DataSuscripcionVigente extends DataSuscripcion {
    private Calendar vencimiento;
    
    public DataSuscripcionVigente(Calendar fechaCreacion, EstadoSuscripcion estado,
            TipoSuscripcion tipo, Calendar vencimiento) {
        super(fechaCreacion, estado, tipo);
        this.vencimiento = vencimiento;
    }
    
    public Calendar getVencimiento() {
        return vencimiento;
    }
    
}
