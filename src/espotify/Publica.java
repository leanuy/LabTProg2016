package espotify;
public class Publica extends Particular implements Favoriteable {

    Publica(Privada p) {
        super(p.getNombre(), p.getImg());
    }    
    
    public Publica HacerPublica() throws Exception
    {
        throw new Exception("La lista ya es pública");
    }
}
