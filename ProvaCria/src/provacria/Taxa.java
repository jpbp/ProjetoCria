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
public class Taxa implements Serializable {
    double semana;
    double finalDeSemana;
    private static final long serialVersionUID =   6792098431215253667L;
    //Construtor 
    public Taxa(double semana, double finalDeSemana) {
        this.semana = semana;
        this.finalDeSemana = finalDeSemana;
    }
    //metodo para obter o a taxa da semana
    public double getSemana() {
        return semana;
    }
    //metodo para obter o a taxa do fim de semana
    public double getFinalDeSemana() {
        return finalDeSemana;
    }
    
    
    
}
