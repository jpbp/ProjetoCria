/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author João Paulo
 */
public class Locadora implements Serializable {
    private ArrayList<Carro> carros;
    String nome;
    int limite;
    Taxa regular;
    Taxa fidelidade;
    
    private static final long serialVersionUID =    4364857267638998630l;

    public Locadora(String nome,int limite,Taxa regular,Taxa fidelidade) {
        this.nome = nome;
        this.limite=limite;
        this.fidelidade=fidelidade;
        this.regular=regular;
        carros = new ArrayList<>();
        
    }
    public void addCarro(Carro carro){
        carros.add(carro);
    }
    public void removeCarro(Carro carro){
        carros.remove(carro);
    }

    public String getNome() {
        return nome;
    }

    public int getLimite() {
        return limite;
    }

    @Override
    public String toString() {
        String nomeCarro="";
        for(Carro carro:carros){
            nomeCarro+=carro.getNome()+" ";
        }
        nomeCarro+=": "+this.nome;
        return nomeCarro;
    }
    
    
    
    
}
