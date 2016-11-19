
package servidor;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NumeroTemaInvalidoException", targetNamespace = "http://servidor/")
public class NumeroTemaInvalidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NumeroTemaInvalidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NumeroTemaInvalidoException_Exception(String message, NumeroTemaInvalidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NumeroTemaInvalidoException_Exception(String message, NumeroTemaInvalidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.NumeroTemaInvalidoException
     */
    public NumeroTemaInvalidoException getFaultInfo() {
        return faultInfo;
    }

}
