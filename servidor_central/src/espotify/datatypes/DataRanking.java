
package espotify.datatypes;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class DataRanking implements Comparable<DataRanking>{
    private String nick;
    private int cantSeguidores;

    public DataRanking(String nick, int cantSeguidores) {
        this.nick = nick;
        this.cantSeguidores = cantSeguidores;
    }

    public DataRanking() {
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public void setCantSeguidores(int cantSeguidores) {
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
