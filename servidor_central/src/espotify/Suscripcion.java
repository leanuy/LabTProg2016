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
    private Calendar fechaUpdate;
    private EstadoSuscripcion estado;
    private final TipoSuscripcion tipo;
    private boolean cancelada;
    
    public Suscripcion(TipoSuscripcion tipo) {
        this.fechaCreacion = Calendar.getInstance();
        this.fechaUpdate = Calendar.getInstance();
        this.tipo = tipo;
        this.fechaDesde = null;
        this.cancelada = false;
        this.estado = EstadoSuscripcion.PENDIENTE;
    }
    
    public Suscripcion(Calendar creacion, Calendar update, Calendar desde, TipoSuscripcion type, boolean cancel){
        this.fechaUpdate = update;
        this.tipo = type;
        this.cancelada = cancel;
        this.fechaCreacion = creacion;
        this.fechaDesde = desde;
    }
    
    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    public Calendar getFechaUpdate() {
        return fechaUpdate;
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
            this.fechaUpdate = Calendar.getInstance();
        } else {
            throw new TransicionSuscripcionInvalidaException();
        }
    }
    
    void aprobar() throws TransicionSuscripcionInvalidaException {
        if (estaPendiente()) {
            this.fechaDesde = Calendar.getInstance();
            this.fechaUpdate = Calendar.getInstance();
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
            estado = EstadoSuscripcion.CANCELADA;
        } else if (estaPendiente()) {
            estado = EstadoSuscripcion.PENDIENTE;
        } else if (estaVigente()) {
            estado = EstadoSuscripcion.VIGENTE;
        } else {
            estado = EstadoSuscripcion.VENCIDA;
        }        
        return estado;
    }

    DataSuscripcion getData() {
        if (estaVigente()) {
            return new DataSuscripcionVigente(fechaCreacion, fechaUpdate, EstadoSuscripcion.VIGENTE,
                    tipo, getVencimiento(), fechaDesde);
        } else {
            return new DataSuscripcion(fechaCreacion, fechaUpdate, getEstado(), tipo);
        }
    }
    
    public void renovar() {
        if ( getEstado() == EstadoSuscripcion.VENCIDA ) {
            this.fechaDesde = null;
            this.fechaCreacion = Calendar.getInstance();
            this.fechaUpdate = Calendar.getInstance();
        }       
    }
    
    public void vencer() {
        fechaDesde.clear();
    }
    
    Calendar getFechaDesde() {
        return this.fechaDesde;
    }

    public TipoSuscripcion getTipo() {
        return tipo;
    }
}
