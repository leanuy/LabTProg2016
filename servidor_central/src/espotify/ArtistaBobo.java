/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author JavierM42
 */
@Entity
public class ArtistaBobo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    
    private String bio;
    private String url;

    public ArtistaBobo(String bio, String url) {
        this.bio = bio;
        this.url = url;
    }

    public ArtistaBobo() {
    }
    
    
}
