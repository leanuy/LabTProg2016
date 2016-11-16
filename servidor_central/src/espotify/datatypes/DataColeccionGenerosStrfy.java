/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeMap;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataColeccionGenerosStrfy {

    private ArrayList<DataCollectionGenerosStrfyItems> data;

    public List<DataCollectionGenerosStrfyItems> getData() {
        return data;
    }

    public void setData(TreeMap<String, String> data) {
        Set<String> keys = data.keySet();
             
        for (String key : keys) {
            this.data.add(new DataCollectionGenerosStrfyItems(key, data.get(key)));
        }
    }

    public DataColeccionGenerosStrfy() {
        this.data = new ArrayList<>();
    }
}
