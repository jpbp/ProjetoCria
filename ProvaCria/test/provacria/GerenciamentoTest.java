/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package provacria;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;


/**
 *
 * @author João Paulo
 */
public class GerenciamentoTest {
    private Gerenciamento g;
    public GerenciamentoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
         g = carregar();
         
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of addLocadoras method, of class Gerenciamento.
     */
    
    /**
     * Test of limiteIdeal method, of class Gerenciamento.
     * @return 
     */
    
    public Gerenciamento carregar() {
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
    @Test
    public void testLimiteIdeal() {
       //Testes com todas as input criadas
        assertEquals("Caso1","FERRARI : West",g.limiteIdeal(1));
        assertEquals("Caso2","NAVIGATOR : North",g.limiteIdeal(6));
        assertEquals("Caso3","GOL : South",g.limiteIdeal(4));
        assertEquals(null,g.limiteIdeal(10));
 
        // TODO review the generated test code and remove the default call to fail.
       
    }

    
}
