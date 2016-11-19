
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataParticular complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataParticular">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataLista">
 *       &lt;sequence>
 *         &lt;element name="nomCliente" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataParticular", propOrder = {
    "nomCliente"
})
public class DataParticular
    extends DataLista
{

    protected String nomCliente;

    /**
     * Gets the value of the nomCliente property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomCliente() {
        return nomCliente;
    }

    /**
     * Sets the value of the nomCliente property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomCliente(String value) {
        this.nomCliente = value;
    }

}
