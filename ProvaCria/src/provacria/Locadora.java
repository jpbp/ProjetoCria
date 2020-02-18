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
    //Construtor da classe
    public Locadora(String nome,int limite,Taxa regular,Taxa fidelidade) {
        this.nome = nome;
        this.limite=limite;
        this.fidelidade=fidelidade;
        this.regular=regular;
        carros = new ArrayList<>();
        
    }
    //Metodo para poder adicionar um carro 
    public void addCarro(Carro carro){
        carros.add(carro);
    }
    //metodo para obter o indice do carro dentro do array carros
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
    //metodo para remover um carro 
    public void removeCarro(String carro){
        int i = getIndiceCarro(carro);
        carros.remove(i);   
    }
    //metodo que retorna o nome da Locadora
    public String getNome() {
        return nome;
    }
    // retorna o limite da loja
    public int getLimite() {
        return limite;
    }
    //lista os carro para melhor visualização na tela
    public String listarCarro(){
       String nomeCarro="";
        for(Carro carro:carros){
            nomeCarro+=carro.getNome()+" ";
        }
        return nomeCarro;
    }
    //metodo para saida do problema
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
