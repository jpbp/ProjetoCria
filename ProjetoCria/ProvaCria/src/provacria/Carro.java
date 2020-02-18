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
public class Carro implements Serializable {
    String nome;
    private static final long serialVersionUID =  -4419856798427564309L;
    //Connstrutor 
    public Carro(String nome) {
        this.nome = nome;
        
    }
    //metodo para obter o nome
    public String getNome() {
        return nome;
    }
    
}
