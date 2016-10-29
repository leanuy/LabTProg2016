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
public class DataColeccionRanking {
    private ArrayList<DataRanking> data;

    public DataColeccionRanking() {
    }

    public DataColeccionRanking(ArrayList<DataRanking> data) {
        this.data = data;
    }

    public ArrayList<DataRanking> getData() {
        return data;
    }

    public void setData(ArrayList<DataRanking> data) {
        this.data = data;
    }
}
