
package servidor;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for dataSuscripcion complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="dataSuscripcion">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="fechaCreacion" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="fechaUpdate" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="estado" type="{http://servidor/}estadoSuscripcion" minOccurs="0"/>
 *         &lt;element name="tipo" type="{http://servidor/}tipoSuscripcion" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="fechaCreacionStr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="fechaUpdateStr" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "dataSuscripcion", propOrder = {
    "fechaCreacion",
    "fechaUpdate",
    "estado",
    "tipo"
})
public class DataSuscripcion {

    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaCreacion;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar fechaUpdate;
    protected EstadoSuscripcion estado;
    protected TipoSuscripcion tipo;
    @XmlAttribute(name = "fechaCreacionStr")
    protected String fechaCreacionStr;
    @XmlAttribute(name = "fechaUpdateStr")
    protected String fechaUpdateStr;

    /**
     * Gets the value of the fechaCreacion property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaCreacion() {
        return fechaCreacion;
    }

    /**
     * Sets the value of the fechaCreacion property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaCreacion(XMLGregorianCalendar value) {
        this.fechaCreacion = value;
    }

    /**
     * Gets the value of the fechaUpdate property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getFechaUpdate() {
        return fechaUpdate;
    }

    /**
     * Sets the value of the fechaUpdate property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setFechaUpdate(XMLGregorianCalendar value) {
        this.fechaUpdate = value;
    }

    /**
     * Gets the value of the estado property.
     * 
     * @return
     *     possible object is
     *     {@link EstadoSuscripcion }
     *     
     */
    public EstadoSuscripcion getEstado() {
        return estado;
    }

    /**
     * Sets the value of the estado property.
     * 
     * @param value
     *     allowed object is
     *     {@link EstadoSuscripcion }
     *     
     */
    public void setEstado(EstadoSuscripcion value) {
        this.estado = value;
    }

    /**
     * Gets the value of the tipo property.
     * 
     * @return
     *     possible object is
     *     {@link TipoSuscripcion }
     *     
     */
    public TipoSuscripcion getTipo() {
        return tipo;
    }

    /**
     * Sets the value of the tipo property.
     * 
     * @param value
     *     allowed object is
     *     {@link TipoSuscripcion }
     *     
     */
    public void setTipo(TipoSuscripcion value) {
        this.tipo = value;
    }

    /**
     * Gets the value of the fechaCreacionStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaCreacionStr() {
        return fechaCreacionStr;
    }

    /**
     * Sets the value of the fechaCreacionStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaCreacionStr(String value) {
        this.fechaCreacionStr = value;
    }

    /**
     * Gets the value of the fechaUpdateStr property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getFechaUpdateStr() {
        return fechaUpdateStr;
    }

    /**
     * Sets the value of the fechaUpdateStr property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setFechaUpdateStr(String value) {
        this.fechaUpdateStr = value;
    }

}
