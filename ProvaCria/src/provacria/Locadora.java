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
    private int getIndiceCarro(String nome){
        
        int i=-1;
        int contador=0;
         for(Carro carro: carros){
           if(nome.equals(carro.getNome())){
               i=contador;
           }
           contador++;
        }
         return i;
    }
    public void removeCarro(String carro){
        int i = getIndiceCarro(carro);
        carros.remove(i);   
    }

    public String getNome() {
        return nome;
    }

    public int getLimite() {
        return limite;
    }
    public String listarCarro(){
       String nomeCarro="";
        for(Carro carro:carros){
            nomeCarro+=carro.getNome()+" ";
        }
        return nomeCarro;
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
