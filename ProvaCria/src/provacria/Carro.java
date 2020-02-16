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
public class Carro {
    String nome;
    Locadora locadora;

    public Carro(String nome, Locadora locadora) {
        this.nome = nome;
        this.locadora = locadora;
    }
    
}
