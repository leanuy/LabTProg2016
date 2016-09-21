/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package espotify.interfaces.web;

import espotify.datatypes.DataSuscripcion;
import espotify.datatypes.DataSuscripcionVigente;
import java.util.List;

/**
 *
 * @author leandro
 */
public interface ISuscripcionWeb {
    public List<DataSuscripcion> listarSuscripcionesCliente(String nickname); 
    public DataSuscripcionVigente obtenerSuscripcionVigente(String nickname);
}
