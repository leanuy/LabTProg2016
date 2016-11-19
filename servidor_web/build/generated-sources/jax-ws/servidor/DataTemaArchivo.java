
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataTemaArchivo complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataTemaArchivo">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataTema">
 *       &lt;sequence>
 *         &lt;element name="archivo" type="{http://servidor/}bufferedInputStream" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataTemaArchivo", propOrder = {
    "archivo"
})
public class DataTemaArchivo
    extends DataTema
{

    protected BufferedInputStream archivo;

    /**
     * Gets the value of the archivo property.
     * 
     * @return
     *     possible object is
     *     {@link BufferedInputStream }
     *     
     */
    public BufferedInputStream getArchivo() {
        return archivo;
    }

    /**
     * Sets the value of the archivo property.
     * 
     * @param value
     *     allowed object is
     *     {@link BufferedInputStream }
     *     
     */
    public void setArchivo(BufferedInputStream value) {
        this.archivo = value;
    }

}
