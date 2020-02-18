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
        if (args[0].equals("adm")) {
            menu();
        } else if(args[0].equals("init")){
            init();
        }else {
            principal(args[0]);
            /*
            Gerenciamento g = new Gerenciamento();
            Carro c1 = new Carro("FERRARI");
            Carro c2= new Carro("NAVIGATOR");
            Carro c3= new Carro("MOBI");
            Taxa taxaRS1= new Taxa(210,200);
            Taxa taxaRF1= new Taxa(150,90);
            Taxa taxaRS2= new Taxa(530,200);
            Taxa taxaRF2= new Taxa(150,90);
            Taxa taxaRS3= new Taxa(630,600);
            Taxa taxaRF3= new Taxa(580,590);
            Locadora l1 = new Locadora("SouthCar",4,taxaRS1,taxaRF1);
            Locadora l2 = new Locadora("WestCar",2,taxaRS2,taxaRF2);
            Locadora l3 = new Locadora("NorthCar",7,taxaRS3,taxaRF3);
            l1.addCarro(c3);
            l2.addCarro(c1);
            l3.addCarro(c2);
            g.addLocadoras(l1);
            g.addLocadoras(l2);
            g.addLocadoras(l3);
            System.out.println(g.limiteIdeal(1));
            salvar(g);
            */
        }
    }
    //funcao para iniciar o programar
    public static void init(){
    
            Gerenciamento g = new Gerenciamento();
            Carro c1 = new Carro("FERRARI");
            Carro c2= new Carro("NAVIGATOR");
            Carro c3= new Carro("MOBI");
            Taxa taxaRS1= new Taxa(210,200);
            Taxa taxaRF1= new Taxa(150,90);
            Taxa taxaRS2= new Taxa(530,200);
            Taxa taxaRF2= new Taxa(150,90);
            Taxa taxaRS3= new Taxa(630,600);
            Taxa taxaRF3= new Taxa(580,590);
            Locadora l1 = new Locadora("SouthCar",4,taxaRS1,taxaRF1);
            Locadora l2 = new Locadora("WestCar",2,taxaRS2,taxaRF2);
            Locadora l3 = new Locadora("NorthCar",7,taxaRS3,taxaRF3);
            l1.addCarro(c3);
            l2.addCarro(c1);
            l3.addCarro(c2);
            g.addLocadoras(l1);
            g.addLocadoras(l2);
            g.addLocadoras(l3);
            salvar(g);
            
    }
    //Metodo para exibição do menu aparecendo as opçoes
    public static void menu() {
        Scanner ler = new Scanner(System.in);
        Gerenciamento g = carregar();
        int escolha = 0;
        while (escolha != 8) {
            System.out.println("-------Bem vindo-------");
            System.out.println("1 - Adicionar Carros");
            System.out.println("2 - Remover Carros");
            System.out.println("3 - Adicionar lojas");
            System.out.println("4 - Remover lojas");
            System.out.println("5 - Alteração das taxas");
            System.out.println("6 - Taxas das lojas");
            System.out.println("7 - Listar todas as lojas");
            System.out.println("8 - Salvar atualizações e sair");
            System.out.print("Escolha uma das opções acima: ");
            escolha = ler.nextInt();
            
            if (escolha == 1) {
                System.out.print("Nome da loja para adicionar um carro: ");
                String nomeLoja = ler.next();

                System.out.print("Nome do carro a ser adicionado na loja " + nomeLoja + ":");
                String nomeCarro = ler.next();

                Carro c1 = new Carro(nomeCarro);

                if (g.addCarro(c1, nomeLoja)) {
                    System.out.println("Carro Adicionada com sucesso!!");
                } else {
                    System.out.println("Ocorreu algum erro, tente de novo!!");
                }

            }else if (escolha == 2) {
                System.out.print("Nome da loja para remover um carro: ");
                String nomeLoja = ler.next();

                System.out.println("Nome do carro a ser removido na loja: ");
                String nomeCarro = ler.next();

                System.out.println("aqui" + nomeLoja + " " + nomeCarro);
                if (g.removerCarro(nomeCarro, nomeLoja)) {
                    System.out.println("Carro Removido com sucesso!!");
                }else {
                    System.out.println("Ocorreu algum erro, tente de novo!!");
                }

            }else if (escolha == 3) {
                System.out.print("Nome da loja para ser adicionar: ");
                String nomeLoja = ler.next();
                System.out.print("limite de pessoas da loja:");
                int limite = ler.nextInt();
                System.out.print("Taxa Regular Semana:");
                double taxaRS = ler.nextDouble();
                System.out.print("Taxa Regular fim deSemana:");
                double taxaRFS = ler.nextDouble();
                System.out.print("Taxa fidelidade Semana:");
                double taxaFS = ler.nextDouble();
                System.out.print("Taxa fidelidade fim de semana");
                double taxaFFS = ler.nextDouble();
                Taxa taxaR = new Taxa(taxaRS, taxaRFS);
                Taxa taxaF = new Taxa(taxaFS, taxaFFS);
                Locadora loc = new Locadora(nomeLoja, limite, taxaR, taxaF);
                g.addLocadoras(loc);
                System.out.println("Adicionado com Sucesso");
            }else if (escolha == 4) {
                System.out.println("Nome da loja para ser removida");
                String loja = ler.next();
                if (g.removerLoja(loja)) {
                    System.out.println("Loja removida com sucesso");
                } else {
                    System.out.println("Ocorreu algum erro, tente de novo!!");
                }
            } else if (escolha == 5) {
                System.out.println("De qual loja você precisa alterar as taxas?: ");
                String loja = ler.next();
                System.out.println("1- Taxa regular:");
            } else if (escolha == 6) {
                System.out.println(g.listaTaxa());
            } else if (escolha == 7) {
                System.out.println(g.listaLojas());
            } else if (escolha == 8) {
                salvar(g);
                System.out.println("Atualizações prontas. Saindo...");
            }
            System.out.println();
        }
    }
    //Metodo para salvar o programa
    public static void salvar(Gerenciamento g) {
        try {
            //Gera o arquivo para armazenar o objeto
            FileOutputStream arquivoGrav
                    = new FileOutputStream("saida.dat");
            //Classe responsavel por inserir os objetos
            ObjectOutputStream objGravar = new ObjectOutputStream(arquivoGrav);
            //Grava o objeto cliente no arquivo
            objGravar.writeObject(g);
            objGravar.flush();
            objGravar.close();
            arquivoGrav.flush();
            arquivoGrav.close();
            System.out.println("Objeto gravado com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
    //metodo para poder carregar o programa
    public static Gerenciamento carregar() {
        Gerenciamento g = null;
        try {
            ObjectInputStream oos = new ObjectInputStream(new FileInputStream("C:\\Users\\joao_\\OneDrive\\Documentos\\NetBeansProjects\\ProjetoCria\\ProvaCria\\dist\\saida.dat"));
            g = (Gerenciamento) oos.readObject();
            
            oos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
        return g;
    }
    //Metodo principal do programa para achar o carro ideal
    public static String principal(String dir) {
        String certa=null;
        try {

            FileReader arq = new FileReader(dir);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); // lê a primeira linha
            // a variável "linha" recebe o valor "null" quando o processo
            // de repetição atingir o final do arquivo texto

            //pegar o valor do limite passado pelo arquivo caso seja 2 digitos e cliente normal
            String limite;
            if (Character.isDigit(linha.charAt(8)) && Character.isDigit(linha.charAt(9))) {
                limite =  Character.toString(linha.charAt(8));
                limite+=Character.toString(linha.charAt(9));
                
             //pegar o valor do limite passado pelo arquivo caso seja 2 digitos e cliente Premium
            }else if(Character.isDigit(linha.charAt(9)) && Character.isDigit(linha.charAt(10))){
                limite =Character.toString(linha.charAt(9));
                limite+=Character.toString(linha.charAt(10));
                
             //pegar o valor do limite passado pelo arquivo caso seja 1 digitos e cliente normal
            }else if(Character.isDigit(linha.charAt(8))){
                limite =Character.toString(linha.charAt(8));
                
            } 
             //pegar o valor do limite passado pelo arquivo caso seja 1 digitos e cliente Premium
            else{
                limite = Character.toString(linha.charAt(9));
            }
           
            Gerenciamento g = carregar();
            certa = g.limiteIdeal(Integer.parseInt(limite));
            //Caso positivo a resposta certa
            if (certa != null) {
                System.out.println(certa);
            }
            //Caso não exista
            else {
                System.out.println("Não existe essa opção!!!!");
            }
            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
        return certa;
    }

}