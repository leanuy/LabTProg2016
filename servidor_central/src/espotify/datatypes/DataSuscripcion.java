package espotify.datatypes;

import java.util.Calendar;

public class DataSuscripcion {
    private final Calendar fechaCreacion;
    private final EstadoSuscripcion estado;
    private final TipoSuscripcion tipo;

    public DataSuscripcion(Calendar fechaCreacion, EstadoSuscripcion estado, TipoSuscripcion tipo) {
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
        this.tipo = tipo;
    }
    
    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    public EstadoSuscripcion getEstado() {
        return estado;
    }
    
    public TipoSuscripcion getTipo() {
        return tipo;
    }
}
