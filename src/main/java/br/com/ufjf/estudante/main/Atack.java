
package br.com.ufjf.estudante.main;

/**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Classe base para AtackFisico e AtackMagico
 */
public class Atack {

    private Dado dado;//dado para rolagem do dano
    private int dano;//numero de faces do(s) dados
    private int danoB;//dano Base do ataque
    private int numDados;//Numero de dados rodados

  /**
 *
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Construtor
 */   
    public Atack(int dano, int danoB, int numDados) {
        this.dado = new Dado();
        this.dano = dano;
        this.danoB = danoB;
        this.numDados = numDados;
    }
    

    /**
     *
     * @author MATHEUS NP
     * Data 14/02/21 ultima modfificação
     * Roda dano do ataque
     * 
     */
    
    public int rodaDano(int mod) {
        return this.dado.rodaDadoMultiplos(dano, this.numDados)+ this.danoB + mod;
    }
    
       
   /**
 * @author MATHEUS NP
 * Data 14/02/21 ultima modfificação
 * Geters E Seters
 */   

    public int getDano() {
        return dano;
    }

    public int getDanoB() {
        return danoB;
    }
    
}



