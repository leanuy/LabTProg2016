package espotify.datatypes;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataSuscripcionVigente extends DataSuscripcion {
    private Calendar vencimiento;
    private Calendar desde;
    
    public DataSuscripcionVigente(Calendar fechaCreacion, Calendar fUp, EstadoSuscripcion estado,
            TipoSuscripcion tipo, Calendar vencimiento, Calendar fDesde) {
        super(fechaCreacion, fUp, estado, tipo);
        this.vencimiento = vencimiento;
        this.desde = fDesde;
    }

    public DataSuscripcionVigente() {
        super();
    }

    public void setVencimiento(Calendar vencimiento) {
        this.vencimiento = vencimiento;
    }

    public void setDesde(Calendar desde) {
        this.desde = desde;
    }
    
    public Calendar getVencimiento() {
        return vencimiento;
    }
    
    @XmlAttribute
    public String getFechaVenStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(vencimiento.getTime());
    }

    @XmlAttribute
    public String getFechaDesdeStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        return sdf.format(desde.getTime());
    }
}
