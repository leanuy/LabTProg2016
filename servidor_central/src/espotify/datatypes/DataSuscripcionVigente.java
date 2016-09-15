package espotify.datatypes;

import java.util.Calendar;

public class DataSuscripcionVigente extends DataSuscripcion {
    Calendar vencimiento;
    
    public DataSuscripcionVigente(Calendar fechaCreacion, EstadoSuscripcion estado,
            TipoSuscripcion tipo, Calendar vencimiento) {
        super(fechaCreacion, estado, tipo);
        this.vencimiento = vencimiento;
    }
    
}
