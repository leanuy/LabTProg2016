package espotify.datatypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataSuscripcion {
    private Calendar fechaCreacion;
    private Calendar fechaUpdate;
    private EstadoSuscripcion estado;
    private TipoSuscripcion tipo;

    public DataSuscripcion() {
    }    

    public DataSuscripcion(Calendar fechaCreacion, Calendar fUp, EstadoSuscripcion estado, TipoSuscripcion tipo) {
        this.fechaCreacion = fechaCreacion;
        this.fechaUpdate = fUp;
        this.estado = estado;
        this.tipo = tipo;
    }

    public Calendar getFechaCreacion() {
        return fechaCreacion;
    }
    
    public Calendar getFechaUpdate() {
        return fechaUpdate;
    }
    
    public EstadoSuscripcion getEstado() {
        return estado;
    }
    
    public TipoSuscripcion getTipo() {
        return tipo;
    }
    
    @XmlAttribute
    public String getFechaCreacionStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaCreacion.getTime());
    }
    
    public String info() {
        return "Estado: " + estado + " tipo: " + tipo + " Updated: " + getFechaUpdateStr();
    }
    
    @XmlAttribute
    public String getFechaUpdateStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(fechaUpdate.getTime());
    }
    
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        } else {
            final DataSuscripcion other = (DataSuscripcion) obj;
            
            return !(other == null 
                    || !Objects.equals(this.estado, other.estado)
                    || !Objects.equals(this.fechaUpdate, other.fechaUpdate)
                    || !Objects.equals(this.fechaCreacion, other.fechaCreacion)
                    || !Objects.equals(this.tipo, other.tipo)
                    );
        }
    }

    public void setFechaCreacion(Calendar fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setFechaUpdate(Calendar fechaUpdate) {
        this.fechaUpdate = fechaUpdate;
    }

    public void setEstado(EstadoSuscripcion estado) {
        this.estado = estado;
    }

    public void setTipo(TipoSuscripcion tipo) {
        this.tipo = tipo;
    }
}
