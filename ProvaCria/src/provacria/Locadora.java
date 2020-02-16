/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;

import java.util.ArrayList;

/**
 *
 * @author João Paulo
 */
public class Locadora {
    private ArrayList<Carro> carros;
    String nome;

    public Locadora(String nome) {
        this.nome = nome;
        carros = new ArrayList<>();
    }
    public void addCarro(Carro carro){
        carros.add(carro);
    }
    
    
}
