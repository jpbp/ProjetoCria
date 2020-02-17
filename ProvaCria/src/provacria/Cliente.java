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
    double taxaSemana;
    double taxaFimDeSemena;

    public Cliente(String tipoDoCliente, double taxaSemana, double taxaFimDeSemena) {
        this.tipoDoCliente = tipoDoCliente;
        this.taxaSemana = taxaSemana;
        this.taxaFimDeSemena = taxaFimDeSemena;
    }


    public String getTipoDoCliente() {
        return tipoDoCliente;
    }
}
