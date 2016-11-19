
package servidor;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for tipoSuscripcion.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="tipoSuscripcion">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="SEMANAL"/>
 *     &lt;enumeration value="MENSUAL"/>
 *     &lt;enumeration value="ANUAL"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "tipoSuscripcion")
@XmlEnum
public enum TipoSuscripcion {

    SEMANAL,
    MENSUAL,
    ANUAL;

    public String value() {
        return name();
    }

    public static TipoSuscripcion fromValue(String v) {
        return valueOf(v);
    }

}
