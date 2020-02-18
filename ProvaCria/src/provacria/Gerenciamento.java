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
public class Gerenciamento implements Serializable {
    private static final long serialVersionUID =   -6381940001768359885l;
    private ArrayList<Locadora> locadoras;
    //Contruturor 
    public Gerenciamento() {
        locadoras =  new ArrayList<>();
    }
    //Metodo para adicionar carros
    public void addLocadoras(Locadora locadora){
        locadoras.add(locadora);
    } 
    //metodo para obter o indice da locadora 
    private int getIndiceLocadora(String nome){
        
        int i=-1;
        int contador=0;
         for(Locadora loc: locadoras){
           if(nome.equals(loc.getNome())){
               i=contador;
           }
           contador++;
        }
         return i;
    }
    //metodo para adicionar o carro
    public boolean addCarro(Carro carro,String nome){
        int i = getIndiceLocadora(nome);
        if(i!=-1){
            (locadoras.get(i)).addCarro(carro);
            return true;
        }else{
            return false;
        }
    }
    //metodo para remover uma determinada loja
    public boolean removerLoja(String nome){
        int i = getIndiceLocadora(nome);
        if(i!=-1){
            locadoras.remove(i);
            return true;
        }else{
            return false;
        }
    }
    ////metodo para remover um determinado carro
    public boolean removerCarro(String carro,String loja){
        int i = getIndiceLocadora(loja);
        if(i!=-1){
            (locadoras.get(i)).removeCarro(carro);
            return true;
        }else{
            return false;
        }
    }
    //Metodo que encontra a melhor loja e carro para o cliente
    public Locadora limiteIdeal(int limite){
        int i=-1;
        int posicao=0;
        int menor=locadoras.get(0).getLimite();
        for(Locadora loc : locadoras){
            /*Primeiro eu tenho que achar qual é a melhor loja de acordo com o limite, faço isso na
            primeira condição, e a segunda é para garantir que se o limite passado for
            maior que o limite da loja já nem entre na condição
              
            */
           if( ( (loc.getLimite() - limite) >=0) && (loc.getLimite()>=limite)){
                if((loc.getLimite()-limite)<=menor){
 
                    menor =loc.getLimite()-limite;
                    i=posicao;
                }
             }
           posicao++;
        }
        if(i==-1){
            return null;
        }else{
            return locadoras.get(i);
        }
        
    }    
    //metodo para saida do problema
    @Override
    public String toString() {
        String l="";
        for(Locadora loc: locadoras){
            l+=loc+"\n";
        }
        return l;
    }
    //meodo para listas as lojas 
    public String listaLojas(){
        String l="";
        for(Locadora loc: locadoras){
            l+=loc.getNome()+"\n"+loc.listarCarro()+"\n";
        }
        return l;
    }
    //metodo para listas todas as taxas 
    public String listaTaxa(){
       String l="";
        for(Locadora loc: locadoras){
            l+=loc.getNome()+"\n"+ "Regular Semana: "+loc.regular.getSemana()+"\n"+
                    "Regular Fim de Semana: "+loc.regular.getFinalDeSemana()+"\n"+
                    "Fidelidade Semana: "+loc.fidelidade.getSemana()+"\n"+
                            "Fidelidade fim de semana: "+loc.fidelidade.getFinalDeSemana()+"\n";
        } 
        return l;
    }
   
}
   
