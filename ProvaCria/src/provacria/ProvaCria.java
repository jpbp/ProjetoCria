
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
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
        }else{
            principal(args[0]);  
            
            //salvar();
            //Gerenciamento g=carregar();
            
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
    public static void salvar(){
        System.out.println("aqui");
        Gerenciamento ger = new Gerenciamento();
         Carro c1 = new Carro("GOL");
          Taxa r1= new Taxa(210,200);
          Taxa p1=new Taxa (150,90);
          Locadora l1 = new Locadora("South",4,r1,p1);
          l1.addCarro(c1);
          ger.addLocadoras(l1);
          try
            {
              //Gera o arquivo para armazenar o objeto
              FileOutputStream arquivoGrav =
              new FileOutputStream("C:\\Users\\joao_\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoCria\\ProvaCria\\saida.dat");
              //Classe responsavel por inserir os objetos
              ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
              //Grava o objeto cliente no arquivo
              objGravar.writeObject(ger);
              objGravar.flush();
              objGravar.close();
              arquivoGrav.flush();
              arquivoGrav.close();
              System.out.println("Objeto gravado com sucesso!");
            }

         catch(Exception e) {
            e.printStackTrace();
           }
          
    }
    public static Gerenciamento carregar(){
     Gerenciamento g = null;
     try
    {
      ObjectInputStream oos= new ObjectInputStream (new FileInputStream("C:\\Users\\joao_\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoCria\\ProvaCria\\saida.dat"));
      g=(Gerenciamento) oos.readObject();
      oos.close();
    }
    catch(Exception e) {
      e.printStackTrace();
    }
     return g;
  }
    
    public static void principal(String dir){
       try{
                
                FileReader arq = new FileReader(dir);
                BufferedReader lerArq = new BufferedReader(arq);

                String linha = lerArq.readLine(); // lê a primeira linha
          // a variável "linha" recebe o valor "null" quando o processo
          // de repetição atingir o final do arquivo texto
               
                 System.out.println(linha);
                 char limite;
                 if(Character.isDigit(linha.charAt(8))){
                     limite=linha.charAt(8);
                     System.out.println(limite);
                 }else{
                     limite=linha.charAt(9);
                 }
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

                Gerenciamento g = carregar();

                l1.addCarro(c1);
                l2.addCarro(c2);
                l3.addCarro(c3);

               // g.addLocadoras(l1);
               // g.addLocadoras(l2);
               // g.addLocadoras(l3);

                Locadora certa = g.limiteIdeal(Character.getNumericValue(limite));
                if(certa!=null){
                    System.out.println(certa);
                }else{
                    System.out.println("nao tem");
                }
               arq.close();
              } catch (IOException e) {
                  System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
              }
        
    }
    
}
