
package servidor;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "TemaTipoInvalidoException", targetNamespace = "http://servidor/")
public class TemaTipoInvalidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private TemaTipoInvalidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public TemaTipoInvalidoException_Exception(String message, TemaTipoInvalidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public TemaTipoInvalidoException_Exception(String message, TemaTipoInvalidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.TemaTipoInvalidoException
     */
    public TemaTipoInvalidoException getFaultInfo() {
        return faultInfo;
    }

}
