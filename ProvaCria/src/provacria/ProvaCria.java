
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
import java.util.Scanner;
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
        if(args[0].equals("adm")){
            menu();
        }else{
            principal(args[0]);  
            
            //salvar();
            //Gerenciamento g=carregar();
           // System.out.println(g.toString());
        }
    }
    
    public static void menu(){
        Scanner ler = new Scanner(System.in); 
        System.out.println("----Bem vindo----");
        System.out.println("1 - Adicionar Carros");
        System.out.println("2 - Remover Carros");
        System.out.println("3 - Adicionar lojas");
        System.out.println("4 - Remover lojas");
        System.out.println("5 - Alteração das taxas");
        System.out.println("6- listar Tudo");
        System.out.print("Escolha uma das opções acima: ");
        int escolha = ler.nextInt();
        Gerenciamento g =carregar();
        if(escolha==1){
            System.out.print("Nome da loja para adicionar um carro: ");
            String nomeLoja= ler.next();
            
            
            System.out.print("Nome do carro a ser adicionado na loja "+nomeLoja+":");
            String nomeCarro = ler.next();
           
            Carro c1 = new Carro(nomeCarro);
           
            if(g.addCarro(c1, nomeLoja)){
                System.out.println("Carro Adicionada com sucesso!!");
            }else{
                System.out.println("Ocorreu algum erro, tente de novo!!");
            }
            
        }else if(escolha==2){
            System.out.println("Nome da loja para remover um carro: ");
            String nomeLoja= ler.next();
            
            
            System.out.println("Nome do carro a ser removido na loja: ");
            String nomeCarro = ler.next();
           
            
            System.out.println("aqui"+nomeLoja+" "+nomeCarro);
            if(g.removerCarro(nomeCarro, nomeLoja)){
                System.out.println("Carro Removido com sucesso!!");
            }else{
                System.out.println("Ocorreu algum erro, tente de novo!!");
            }
            
        }
        if(escolha==6){
            System.out.println(g);
        }
        salvar(g);
    }
    public static void salvar(Gerenciamento g){
          try
            {
              //Gera o arquivo para armazenar o objeto
              FileOutputStream arquivoGrav =
              new FileOutputStream("saida.dat");
              //Classe responsavel por inserir os objetos
              ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
              //Grava o objeto cliente no arquivo
              objGravar.writeObject(g);
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
      ObjectInputStream oos= new ObjectInputStream (new FileInputStream("saida.dat"));
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
                Gerenciamento g = carregar();
                Locadora certa = g.limiteIdeal(Character.getNumericValue(limite));
                if(certa!=null){
                    System.out.println(certa);
                }else{
                    System.out.println("Não existe essa opção!!!!");
                }
               arq.close();
              } catch (IOException e) {
                  System.err.printf("Erro na abertura do arquivo: %s.\n",
                    e.getMessage());
              }
        
    }
    
}
