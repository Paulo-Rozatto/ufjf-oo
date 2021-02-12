
package br.com.ufjf.estudante.main;



/**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Classe base para montros e jogador
 */
public class Personagem {
   
    private String nomePersonagem;//nome da criatura/player
    
    private int hitPoints;//pontos de vida
    private int manaPoints;//pontos de mana     
    private int defesa;//defesa da criatura/player
    
    private int modForça;// modficador de força da criatura/player
    private int modInteligencia;//modificador de inteligencia da criatura/player
    private int modDestreza;// modificador de destreza da criatura/player
    
    AtackFisico atackFisico;//calcula o dano do ataque fisico(ideal transformar isso em arry o lista encadeada)
    AtackMagico atackMagico;//calcula o dano do ataque magico(ideal transformar isso em arry o lista encadeada)
    Dado dado;//Dado para rolar os valores na classe
    int classe;//classe escolhida pela criatura/player para gerar valores de combate
    //Itens[] mochila;// implementação futura
    //Itens arma;// implementação futura
    //itens armadura;// implementação futura
 
    
    
    
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Gera os hitPoints do personagem valida e se variavel classe e valida
 */

    private void geraHP(){
        switch (classe){
            case 1:
                hitPoints= 5+dado.RodaDado(8)+(modForça*2);//Guerreiro
                break;
            case 2:
                hitPoints= 3+dado.RodaDado(6)+modForça+(modInteligencia/2);//Mago
                break;
            case 3: 
                hitPoints= 5+dado.RodaDado(6)+modForça;//Ladino
                break;
            default:
                classe=-1;
                System.out.println("Escolha de classe invalida");
        } 
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Gera os manaPontis do personagem e valida se variavel classe e valida
 */
    
    private void geraMP() {
        switch (classe) {
            case 1:
               this.manaPoints = 3 + dado.RodaDado(2) + this.modInteligencia;//Guerreiro
                break;
            case 2:
                this.manaPoints = 6 + dado.RodaDado(4) + (this.modInteligencia*2);//Mago
                break;
            case 3:
                this.manaPoints = 3 + dado.RodaDado(3) + this.modInteligencia+ (this.modDestreza/2);//Ladino
                break;
            default:
                classe=-1;
                System.out.println("Escolha de classe invalida");
        }
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Gera os defesa do personagem e valida se variavel classe e valida
 */
    
    private void geraDefesa(){
        switch (classe) {
            case 1:
                defesa = 10 + modDestreza+ ((this.modForça/2)-1);//Guerreiro
                break;
            case 2:
                defesa = 10 + modDestreza;//Mago
                break;
            case 3:
                defesa = 10 + (modDestreza*2);//Ladino
                break;
            default:
                classe=-1;
                System.out.println("Escolha de classe invalida");
        }
        
    }
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Escolhe a classe para o calculo dos status de combate ou realiza nova escolha de classe caso o valor foi invalido
 */
            
        public void escolhaClasse(int classe) {
        if (classe > 3) {
            System.out.println("Classe invalida por favor digite de numero " + 1 + "a " + 3 + "sendo: \n1-Guerreiro\n2=Mago\n3-Ladino");
            this.classe=-1;
        } else {
            if (this.classe!= -1){
                this.classe = classe;
                geraHP();
                geraMP();
                geraDefesa();
            }
        }

    } /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * construtor
 */

    public Personagem(String nomePersonagem, int modForça, int modInteligencia, int modDestreza, int classe) {
        this.nomePersonagem = nomePersonagem;
        this.modForça = modForça;
        this.modInteligencia = modInteligencia;
        this.modDestreza = modDestreza;
        this.classe = classe;
        escolhaClasse(classe);
    }
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * realiza ataque
 */
    
    public int ataqueFisico(int defesaInimiga, int dadoDano){
        
        int guardaDado= this.dado.RodaDado(20);
        int guardaDado2;
        if(modForça < modDestreza && guardaDado+this.modDestreza > defesaInimiga){
           System.out.println("O dado girado foi de " + (guardaDado+modDestreza) + " e precisava de " + defesaInimiga);
           return this.ataqueFisico(dadoDano, this.modDestreza);             
        }
        if(this.dado.RodaDado(20)+this.modForça > defesaInimiga){
            System.out.println("O dado girado foi de " + (guardaDado+modForça) + " e precisava de " + defesaInimiga);
            return this.ataqueFisico(dadoDano, this.modForça);  
        }
        else{
            System.out.println("O ataque não acertou o inimigo o dado tirado foi " + guardaDado);
            return 0;
        }
    }
    
  /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Descrição da morte(sugerido cara criatura/montros ter uma diferente)
 */
    
    public void morte(){
        System.out.println("YOU DIE");
    }
    
 /**
 *
 * @author MATHEUS NP
 * Data 12/02/21 ultima modfificação
 * Calcula os pontos de vida e verifica a morte do personagem
 */
    
    public void sofreAtack(int danoInimigo){
        this.hitPoints= this.hitPoints-danoInimigo;
        if(this.hitPoints<=0){
            this.morte();
    }
    }
        
        
        
}
    
    
    
    
    

    
    
   
   
    

