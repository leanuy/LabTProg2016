package espotify.Interfaces;



public interface IDejarDeSeguir {
    
    public String[] DevolverClientes();
    public String[] getSeguidos(String usr);
    public void DejarDeSeguir(String nomSeguidor, String nomSeguido) throws Exception;
}