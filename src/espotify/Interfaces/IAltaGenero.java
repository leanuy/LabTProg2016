package espotify.Interfaces;

import espotify.Datatypes.DataGenero;
import java.util.ArrayList;

public interface IAltaGenero {
    public DataGenero ListarGeneros();
    public void AltaGenero(DataGenero d) throws Exception;
}
