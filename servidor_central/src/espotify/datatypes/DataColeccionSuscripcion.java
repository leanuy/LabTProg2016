package espotify.datatypes;

import java.util.ArrayList;

public class DataColeccionSuscripcion {
    private ArrayList<DataSuscripcion> data;

    public ArrayList<DataSuscripcion> getData() {
        return data;
    }

    public void setData(ArrayList<DataSuscripcion> data) {
        this.data = data;
    }

    public DataColeccionSuscripcion() {
    }

    public DataColeccionSuscripcion(ArrayList<DataSuscripcion> data) {
        this.data = data;
    }
}
