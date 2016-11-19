
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for dataTema complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataTema">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="nombre" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="duracion" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="num" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="nomArtista" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="album" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="esWeb" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *       &lt;/sequence>
 *       &lt;attribute name="duracionStr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataTema", propOrder = {
    "nombre",
    "duracion",
    "num",
    "nomArtista",
    "album",
    "esWeb"
})
@XmlSeeAlso({
    DataTemaArchivo.class,
    DataTemaWeb.class
})
public class DataTema {

    protected String nombre;
    protected int duracion;
    protected int num;
    protected String nomArtista;
    protected String album;
    protected boolean esWeb;
    @XmlAttribute(name = "duracionStr")
    protected String duracionStr;

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
     * Gets the value of the duracion property.
     * 
     */
    public int getDuracion() {
        return duracion;
    }

    /**
     * Sets the value of the duracion property.
     * 
     */
    public void setDuracion(int value) {
        this.duracion = value;
    }

    /**
     * Gets the value of the num property.
     * 
     */
    public int getNum() {
        return num;
    }

    /**
     * Sets the value of the num property.
     * 
     */
    public void setNum(int value) {
        this.num = value;
    }

    /**
     * Gets the value of the nomArtista property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getNomArtista() {
        return nomArtista;
    }

    /**
     * Sets the value of the nomArtista property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setNomArtista(String value) {
        this.nomArtista = value;
    }

    /**
     * Gets the value of the album property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAlbum() {
        return album;
    }

    /**
     * Sets the value of the album property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAlbum(String value) {
        this.album = value;
    }

    /**
     * Gets the value of the esWeb property.
     * 
     */
    public boolean isEsWeb() {
        return esWeb;
    }

    /**
     * Sets the value of the esWeb property.
     * 
     */
    public void setEsWeb(boolean value) {
        this.esWeb = value;
    }

    /**
     * Gets the value of the duracionStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDuracionStr() {
        return duracionStr;
    }

    /**
     * Sets the value of the duracionStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDuracionStr(String value) {
        this.duracionStr = value;
    }

}
