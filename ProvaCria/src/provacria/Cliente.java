/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;

import java.io.Serializable;

/**
 *
 * @author João Paulo
 */
public class Cliente implements Serializable {
    String tipoDoCliente;
    private static final long serialVersionUID =  6529685098267757690L;
    public Cliente(String tipoDoCliente) {
        this.tipoDoCliente = tipoDoCliente;
    }
    public String getTipoDoCliente() {
        return tipoDoCliente;
    }
}
