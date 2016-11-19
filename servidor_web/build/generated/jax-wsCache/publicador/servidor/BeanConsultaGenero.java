
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import net.java.dev.jaxb.array.StringArray;


/**
 * <p>Java class for beanConsultaGenero complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanConsultaGenero">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="albums" type="{http://jaxb.dev.java.net/array}stringArray" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="data" type="{http://servidor/}dataGenero" minOccurs="0"/>
 *         &lt;element name="listas" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanConsultaGenero", propOrder = {
    "albums",
    "data",
    "listas"
})
public class BeanConsultaGenero {

    @XmlElement(nillable = true)
    protected List<StringArray> albums;
    protected DataGenero data;
    @XmlElement(nillable = true)
    protected List<String> listas;

    /**
     * Gets the value of the albums property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the albums property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlbums().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link StringArray }
     * 
     * 
     */
    public List<StringArray> getAlbums() {
        if (albums == null) {
            albums = new ArrayList<StringArray>();
        }
        return this.albums;
    }

    /**
     * Gets the value of the data property.
     * 
     * @return
     *     possible object is
     *     {@link DataGenero }
     *     
     */
    public DataGenero getData() {
        return data;
    }

    /**
     * Sets the value of the data property.
     * 
     * @param value
     *     allowed object is
     *     {@link DataGenero }
     *     
     */
    public void setData(DataGenero value) {
        this.data = value;
    }

    /**
     * Gets the value of the listas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the listas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getListas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getListas() {
        if (listas == null) {
            listas = new ArrayList<String>();
        }
        return this.listas;
    }

}
