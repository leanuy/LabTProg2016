
package espotify.datatypes;

public class DataRanking implements Comparable<DataRanking>{
    private final String nick;
    private final int cantSeguidores;

    public DataRanking(String nick, int cantSeguidores) {
        this.nick = nick;
        this.cantSeguidores = cantSeguidores;
    }

    public String getNick() {
        return nick;
    }

    public int getCantSeguidores() {
        return cantSeguidores;
    }
    
    @Override
    public int compareTo(DataRanking otro) {
        return otro.getCantSeguidores() - this.getCantSeguidores();
    }
}
