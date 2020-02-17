/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;

/**
 *
 * @author João Paulo
 */
public class Cliente {
    String tipoDoCliente;

    public Cliente(String tipoDoCliente) {
        this.tipoDoCliente = tipoDoCliente;
    }
    public String getTipoDoCliente() {
        return tipoDoCliente;
    }
}
