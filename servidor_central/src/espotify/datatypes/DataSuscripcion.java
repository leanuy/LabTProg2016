package espotify.datatypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class DataSuscripcion {
    private final Calendar fechaCreacion;
    private final Calendar fUpdate;
    private final EstadoSuscripcion estado;
    private final TipoSuscripcion tipo;

    public DataSuscripcion(Calendar fechaCreacion, Calendar fUp,EstadoSuscripcion estado, TipoSuscripcion tipo) {
        this.fechaCreacion = fechaCreacion;
        this.fUpdate = fUp;
        this.estado = estado;
        this.tipo = tipo;
    }
    
    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    public Calendar getFechaUpdate() {
        return fUpdate;
    }
    
    public EstadoSuscripcion getEstado() {
        return estado;
    }
    
    public TipoSuscripcion getTipo() {
        return tipo;
    }
    
    public String getfCreacionStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaCreacion.getTime());
    }
    
    public String info() {
        return "Estado: " + estado + " tipo: " + tipo + " Updated: " + getfUpdate();
    }
    
    public String getfUpdate() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fUpdate.getTime());
    }
    
}
