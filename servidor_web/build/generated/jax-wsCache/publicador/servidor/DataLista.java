
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataLista complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataLista">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="img" type="{http://servidor/}bufferedImage" minOccurs="0"/>
 *         &lt;element name="temas" type="{http://servidor/}dataTema" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataLista", propOrder = {
    "nombre",
    "img",
    "temas"
})
@XmlSeeAlso({
    DataParticular.class,
    DataDefecto.class
})
public class DataLista {

    protected String nombre;
    protected BufferedImage img;
    @XmlElement(nillable = true)
    protected List<DataTema> temas;

    /**
     * Gets the value of the nombre property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Sets the value of the nombre property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNombre(String value) {
        this.nombre = value;
    }

    /**
     * Gets the value of the img property.
     * 
     * @return
     *     possible object is
     *     {@link BufferedImage }
     *     
     */
    public BufferedImage getImg() {
        return img;
    }

    /**
     * Sets the value of the img property.
     * 
     * @param value
     *     allowed object is
     *     {@link BufferedImage }
     *     
     */
    public void setImg(BufferedImage value) {
        this.img = value;
    }

    /**
     * Gets the value of the temas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataTema }
     * 
     * 
     */
    public List<DataTema> getTemas() {
        if (temas == null) {
            temas = new ArrayList<DataTema>();
        }
        return this.temas;
    }

}
