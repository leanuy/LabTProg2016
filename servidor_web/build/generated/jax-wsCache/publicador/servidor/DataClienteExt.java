
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataClienteExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataClienteExt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataCliente">
 *       &lt;sequence>
 *         &lt;element name="seg" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="lis" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataClienteExt", propOrder = {
    "seg",
    "lis"
})
public class DataClienteExt
    extends DataCliente
{

    @XmlElement(nillable = true)
    protected List<String> seg;
    @XmlElement(nillable = true)
    protected List<String> lis;

    /**
     * Gets the value of the seg property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the seg property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSeg().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getSeg() {
        if (seg == null) {
            seg = new ArrayList<String>();
        }
        return this.seg;
    }

    /**
     * Gets the value of the lis property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the lis property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getLis().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getLis() {
        if (lis == null) {
            lis = new ArrayList<String>();
        }
        return this.lis;
    }

}
