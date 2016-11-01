/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import java.util.ArrayList;

/**
 *
 * @author JavierM42
 */
public class DataColeccionString {
    private ArrayList<String> data;

    public DataColeccionString(ArrayList<String> data) {
        this.data = data;
    }

    public DataColeccionString() {
    }

    public ArrayList<String> getData() {
        return data;
    }

    public void setData(ArrayList<String> data) {
        this.data = data;
    }   
}
