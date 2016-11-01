/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.datatypes;

import java.util.ArrayList;

public class DataColeccionTemas {
    private ArrayList<DataTema> data;

    public ArrayList<DataTema> getData() {
        return data;
    }

    public void setData(ArrayList<DataTema> data) {
        this.data = data;
    }

    public DataColeccionTemas() {
    }

    public DataColeccionTemas(ArrayList<DataTema> data) {
        this.data = data;
    }
}