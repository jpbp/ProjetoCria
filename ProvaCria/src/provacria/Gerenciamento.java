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

    public Gerenciamento() {
        locadoras =  new ArrayList<>();
    }
    
    public void addLocadoras(Locadora locadora){
        locadoras.add(locadora);
    } 
    
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
    public boolean addCarro(Carro carro,String nome){
        int i = getIndiceLocadora(nome);
        if(i!=-1){
            (locadoras.get(i)).addCarro(carro);
            return true;
        }else{
            return false;
        }
    }
    public boolean removerLoja(String nome){
        int i = getIndiceLocadora(nome);
        if(i!=-1){
            locadoras.remove(i);
            return true;
        }else{
            return false;
        }
    }
    public boolean removerCarro(String carro,String loja){
        int i = getIndiceLocadora(loja);
        if(i!=-1){
            (locadoras.get(i)).removeCarro(carro);
            return true;
        }else{
            return false;
        }
    }
    public Locadora limiteIdeal(int limite){
        int i=-1;
        int posicao=0;
        int menor=locadoras.get(0).getLimite();
        for(Locadora loc : locadoras){
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

    @Override
    public String toString() {
        String l="";
        for(Locadora loc: locadoras){
            l+=loc+"\n";
        }
        return l;
    }
    public String listaTaxa(){
       String l="";
        for(Locadora loc: locadoras){
            l+=loc.getNome()+" Regular Semana: "+loc.regular.getSemana()+"\n"+
                    "Regular Fim de Semana: "+loc.regular.getFinalDeSemana()+"\n"+
                    "Fidelidade Semana: "+loc.fidelidade.getSemana()+"\n"+
                            "Fidelidade fim de semana: "+loc.fidelidade.getFinalDeSemana();
        } 
        return l;
    }
   
}
   
