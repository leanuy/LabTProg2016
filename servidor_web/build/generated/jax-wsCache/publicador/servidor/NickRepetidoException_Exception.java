
package servidor;

import javax.xml.ws.WebFault;


/**
 * This class was generated by the JAX-WS RI.
 * JAX-WS RI 2.2.6-1b01 
 * Generated source version: 2.2
 * 
 */
@WebFault(name = "NickRepetidoException", targetNamespace = "http://servidor/")
public class NickRepetidoException_Exception
    extends Exception
{

    /**
     * Java type that goes as soapenv:Fault detail element.
     * 
     */
    private NickRepetidoException faultInfo;

    /**
     * 
     * @param faultInfo
     * @param message
     */
    public NickRepetidoException_Exception(String message, NickRepetidoException faultInfo) {
        super(message);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @param faultInfo
     * @param cause
     * @param message
     */
    public NickRepetidoException_Exception(String message, NickRepetidoException faultInfo, Throwable cause) {
        super(message, cause);
        this.faultInfo = faultInfo;
    }

    /**
     * 
     * @return
     *     returns fault bean: servidor.NickRepetidoException
     */
    public NickRepetidoException getFaultInfo() {
        return faultInfo;
    }

}