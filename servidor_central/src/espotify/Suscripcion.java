package espotify;

import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.DataSuscripcionVigente;
import espotify.datatypes.EstadoSuscripcion;
import espotify.datatypes.TipoSuscripcion;
import espotify.excepciones.TransicionSuscripcionInvalidaException;

import java.util.Calendar;

public class Suscripcion {
    private Calendar fechaCreacion;
    private Calendar fechaDesde;
    private final TipoSuscripcion tipo;
    private boolean cancelada;
    
    Suscripcion(TipoSuscripcion tipo) {
        this.fechaCreacion = Calendar.getInstance();
        this.tipo = tipo;
        this.fechaDesde = null;
        this.cancelada = false;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    boolean estaPendiente() {
        return this.fechaDesde == null;
    }
    
    boolean estaCancelada() {
        return this.cancelada;
    }
    
    void cancelar() throws TransicionSuscripcionInvalidaException {
        if (!estaCancelada() && (!estaVigente() || estaPendiente())) {
            this.cancelada = true;
        } else {
            throw new TransicionSuscripcionInvalidaException();
        }
    }
    
    void aprobar() throws TransicionSuscripcionInvalidaException {
        if (estaPendiente()) {
            this.fechaDesde = Calendar.getInstance();
        } else {
            throw new TransicionSuscripcionInvalidaException();
        }
    }
    
    int getDuracion() {
        if (tipo == TipoSuscripcion.ANUAL) {
            return 365;
        } else if (tipo == TipoSuscripcion.MENSUAL) {
            return 30;
        }
        return 7;
    }
    
    Calendar getVencimiento() {
        Calendar cal = null;
        if (!estaPendiente() && !estaCancelada()) {
            cal = (Calendar) fechaDesde.clone();
            cal.add(Calendar.DAY_OF_MONTH, getDuracion());
        }
        return cal;
        
    }
    
    boolean estaVigente() {
        if (estaPendiente() || estaCancelada()) {
            return false;
        } else {
            return Calendar.getInstance().compareTo(getVencimiento()) <= 0;
        }
    }
        
    EstadoSuscripcion getEstado() {
        if (estaCancelada()) {
            return EstadoSuscripcion.CANCELADA;
        } else if (estaPendiente()) {
            return EstadoSuscripcion.PENDIENTE;
        } else if (estaVigente()) {
            return EstadoSuscripcion.VIGENTE;
        }
        return EstadoSuscripcion.VENCIDA;
    }

    DataSuscripcion getData() {
        if (estaVigente()) {
            return new DataSuscripcionVigente(fechaCreacion, EstadoSuscripcion.VIGENTE,
                    tipo, getVencimiento());
        } else {
            return new DataSuscripcion(fechaCreacion, getEstado(), tipo);
        }
    }
    
    public void renovar() {
        if ( getEstado() == EstadoSuscripcion.VENCIDA ) {
            this.fechaDesde = null;
            this.fechaCreacion = Calendar.getInstance();
        }       
    }
    
    public void vencer() {
        fechaDesde.clear();
    }
}
