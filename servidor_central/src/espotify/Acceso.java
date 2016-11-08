package espotify;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 *
 * @author JavierM42
 */
public class Acceso {
    private final Calendar fecha;
    private final String ip;
    private final String url;
    private final String browser;
    private final String so;

    public Acceso(Calendar fecha, String ip, String url, String browser, String so) {
        this.fecha = fecha;
        this.ip = ip;
        this.url = url;
        this.browser = browser;
        this.so = so;
    }

    public String getIp() {
        return ip;
    }

    public String getUrl() {
        return url;
    }

    public String getBrowser() {
        return browser;
    }

    public String getSo() {
        return so;
    }

    public Calendar getFecha() {
        return fecha;
    }
    
    public String getFechaStr() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yy hh:mm:ss.S");
        return sdf.format(fecha.getTime());
    }
}
