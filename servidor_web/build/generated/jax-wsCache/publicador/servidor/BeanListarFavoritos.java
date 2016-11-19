
package servidor;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for beanListarFavoritos complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="beanListarFavoritos">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="albumsFavoritos" type="{http://servidor/}dataAlbum" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="defectoFavoritas" type="{http://servidor/}dataDefecto" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="particularesFavoritas" type="{http://servidor/}dataParticular" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="temasFavoritos" type="{http://servidor/}dataTema" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "beanListarFavoritos", propOrder = {
    "albumsFavoritos",
    "defectoFavoritas",
    "particularesFavoritas",
    "temasFavoritos"
})
public class BeanListarFavoritos {

    @XmlElement(nillable = true)
    protected List<DataAlbum> albumsFavoritos;
    @XmlElement(nillable = true)
    protected List<DataDefecto> defectoFavoritas;
    @XmlElement(nillable = true)
    protected List<DataParticular> particularesFavoritas;
    @XmlElement(nillable = true)
    protected List<DataTema> temasFavoritos;

    /**
     * Gets the value of the albumsFavoritos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the albumsFavoritos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAlbumsFavoritos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataAlbum }
     * 
     * 
     */
    public List<DataAlbum> getAlbumsFavoritos() {
        if (albumsFavoritos == null) {
            albumsFavoritos = new ArrayList<DataAlbum>();
        }
        return this.albumsFavoritos;
    }

    /**
     * Gets the value of the defectoFavoritas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the defectoFavoritas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDefectoFavoritas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataDefecto }
     * 
     * 
     */
    public List<DataDefecto> getDefectoFavoritas() {
        if (defectoFavoritas == null) {
            defectoFavoritas = new ArrayList<DataDefecto>();
        }
        return this.defectoFavoritas;
    }

    /**
     * Gets the value of the particularesFavoritas property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the particularesFavoritas property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getParticularesFavoritas().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataParticular }
     * 
     * 
     */
    public List<DataParticular> getParticularesFavoritas() {
        if (particularesFavoritas == null) {
            particularesFavoritas = new ArrayList<DataParticular>();
        }
        return this.particularesFavoritas;
    }

    /**
     * Gets the value of the temasFavoritos property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the temasFavoritos property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTemasFavoritos().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link DataTema }
     * 
     * 
     */
    public List<DataTema> getTemasFavoritos() {
        if (temasFavoritos == null) {
            temasFavoritos = new ArrayList<DataTema>();
        }
        return this.temasFavoritos;
    }

}
