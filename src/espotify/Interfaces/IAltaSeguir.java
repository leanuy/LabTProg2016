package espotify.Interfaces;



public interface IAltaSeguir {
    public String[] DevolverClientes();
    public String[] DevolverArtistas();
    public void AltaSeguir(String nomSeguidor, String nomSeguido) throws Exception;
}