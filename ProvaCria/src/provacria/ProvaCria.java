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
public class ProvaCria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Carro c1 = new Carro("Fusca");
        Carro c2 = new Carro("gol");
        Carro c3 = new Carro("brasilia");
        
        Locadora l1 = new Locadora("South",4);
        Locadora l2 = new Locadora("West",2);
        Locadora l3 = new Locadora("North",7);
        
        Cliente cliente = new Cliente("Premium",210,150);
        
        Gerenciamento g = new Gerenciamento();
        
        l1.addCarro(c1);
        l2.addCarro(c2);
        l3.addCarro(c3);
        
        g.addLocadoras(l1);
        g.addLocadoras(l2);
        g.addLocadoras(l3);
        
        Locadora certa = g.CarroMaisBarato(3, cliente, 6);
        if(certa!=null){
            System.out.println(certa.getNome()+" ");
        }else{
            System.out.println("nao tem");
        }
        
        
        
        
    }
    
}
