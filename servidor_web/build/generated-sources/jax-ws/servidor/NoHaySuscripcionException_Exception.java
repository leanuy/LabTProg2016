
package servidor;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NoHaySuscripcionException", targetNamespace = "http://servidor/")
public class NoHaySuscripcionException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NoHaySuscripcionException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NoHaySuscripcionException_Exception(String message, NoHaySuscripcionException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NoHaySuscripcionException_Exception(String message, NoHaySuscripcionException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.NoHaySuscripcionException
     */
    public NoHaySuscripcionException getFaultInfo() {
        return faultInfo;
    }

}
