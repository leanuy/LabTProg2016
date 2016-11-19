
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataAlbumExt complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataAlbumExt">
 *   &lt;complexContent>
 *     &lt;extension base="{http://servidor/}dataAlbum">
 *       &lt;sequence>
 *         &lt;element name="temas" type="{http://servidor/}dataTema" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataAlbumExt", propOrder = {
    "temas"
})
public class DataAlbumExt
    extends DataAlbum
{

    @XmlElement(nillable = true)
    protected List<DataTema> temas;

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
