package espotify;

import espotify.Datatypes.DataGenero;

public class Espotify {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here ESTE MAIN VUELA DESPUES Y LA APP ARRANCA DESDE EL FRAME.. LO VEMOS
        CtrlMusica c = CtrlMusica.getInstancia();
        try {
            c.AltaGenero(new DataGenero("Rock",""));
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        
    }
    
}
