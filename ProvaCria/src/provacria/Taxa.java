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
public class Taxa {
    double semana;
    double finalDeSemana;

    public Taxa(double semana, double finalDeSemana) {
        this.semana = semana;
        this.finalDeSemana = finalDeSemana;
    }

    public double getSemana() {
        return semana;
    }

    public double getFinalDeSemana() {
        return finalDeSemana;
    }
    
    
    
}
