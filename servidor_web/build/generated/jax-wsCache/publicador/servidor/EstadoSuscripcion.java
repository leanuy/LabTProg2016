
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for estadoSuscripcion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="estadoSuscripcion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="PENDIENTE"/>
 *     &lt;enumeration value="VIGENTE"/>
 *     &lt;enumeration value="CANCELADA"/>
 *     &lt;enumeration value="VENCIDA"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "estadoSuscripcion")
@XmlEnum
public enum EstadoSuscripcion {

    PENDIENTE,
    VIGENTE,
    CANCELADA,
    VENCIDA;

    public String value() {
        return name();
    }

    public static EstadoSuscripcion fromValue(String v) {
        return valueOf(v);
    }

}
