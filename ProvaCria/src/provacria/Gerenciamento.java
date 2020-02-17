/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;

import java.util.ArrayList;

/**
 *
 * @author João Paulo
 */
public class Gerenciamento {
    
    private ArrayList<Locadora> locadoras;

    public Gerenciamento() {
        locadoras =  new ArrayList<>();
    }
    
    public void addLocadoras(Locadora locadora){
        locadoras.add(locadora);
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
    public Locadora CarroMaisBarato(int dias,Cliente cliente,int limite){
        if(cliente.getTipoDoCliente().equals("normal")){
            return limiteIdeal(limite);
        }else{
            return limiteIdeal(limite);
        }
    }
        
}
   
