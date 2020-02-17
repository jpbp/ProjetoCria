
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
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
        if(args[0].equals("-adm")){
            System.out.println("nada");
        }else if(args[0].equals("-teste")){
            System.out.println("aquiii");
            try{
                String nome="C:\\Users\\joao_\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoCria\\ProvaCria\\teste.txt";
                FileReader arq = new FileReader(nome);
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine(); // lê a primeira linha
          // a variável "linha" recebe o valor "null" quando o processo
          // de repetição atingir o final do arquivo texto
               
                 System.out.println(linha);
                 char limite;
                 if(Character.isDigit(linha.charAt(8))){
                     limite=linha.charAt(8);
                 }else{
                     limite=linha.charAt(9);
                 }
                 carregarArquivo(limite);
                arq.close();
              } catch (IOException e) {
                  System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
              }
            
            
            
        }
       
    }
    public static void menu(){
        System.out.println("----Bem vindo----");
        System.out.println("1 - Adicionar Carros");
        System.out.println("2 - Remover Carros");
        System.out.println("3 - Adicionar lojas");
        System.out.println("4 - Remover lojas");
        System.out.println("5 - Alteração das taxas");
        System.out.println("6- listar Tudo");
        
        
    }
    public static void carregarArquivo(int limite){
        Carro c1 = new Carro("GOL");
        Carro c2 = new Carro("FERRARI");
        Carro c3 = new Carro("NAVIGATOR");
        
        Taxa r1= new Taxa(210,200);
        Taxa r2= new Taxa(530,200);
        Taxa r3= new Taxa(630,600);
        
        Taxa p1=new Taxa (150,90);
        Taxa p2=new Taxa (150,90);
        Taxa p3=new Taxa (580,590);
        
        Locadora l1 = new Locadora("South",4,r1,p1);
        Locadora l2 = new Locadora("West",2,r2,p2);
        Locadora l3 = new Locadora("North",7,r3,p3);
        
        Cliente cliente = new Cliente("Premium");
        
        Gerenciamento g = new Gerenciamento();
        
        l1.addCarro(c1);
        l2.addCarro(c2);
        l3.addCarro(c3);
        
        g.addLocadoras(l1);
        g.addLocadoras(l2);
        g.addLocadoras(l3);
        
        Locadora certa = g.CarroMaisBarato(3, cliente, 1);
        if(certa!=null){
            System.out.println(certa);
        }else{
            System.out.println("nao tem");
        }
    }
    
}
