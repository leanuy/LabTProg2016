package espotify.datatypes;

import java.util.ArrayList;

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
