/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import java.io.BufferedInputStream;

/**
 *
 * @author leandro
 */
public class DataArchivo {
     private BufferedInputStream archivo;

    public BufferedInputStream getArchivo() {
        return archivo;
    }

    public DataArchivo() {
        archivo = null;
    }

    public void setArchivo(BufferedInputStream archivo) {
        this.archivo = archivo;
    }
}
