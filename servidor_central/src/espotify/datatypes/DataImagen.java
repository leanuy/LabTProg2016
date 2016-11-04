/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import java.awt.image.BufferedImage;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

/**
 *
 * @author santiagoserantes
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class DataImagen {
    
    private final BufferedImage Image;
    
    public DataImagen(BufferedImage img) {
        this.Image = img;
    }
    
    public BufferedImage getImage() {
        return this.Image;
    }
    
}
