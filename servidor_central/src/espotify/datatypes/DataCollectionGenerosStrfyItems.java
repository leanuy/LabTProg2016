/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataCollectionGenerosStrfyItems {

    @XmlElement
    public String key;
    @XmlElement
    public String value;

    private DataCollectionGenerosStrfyItems() {
    } //Required by JAXB

    public DataCollectionGenerosStrfyItems(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
