

public class calango {
    //atributos
    int bucho;
    int maxBucho;
    int nPatas;
    int vida;
    boolean alive;

    //construtor - mesmo nome da classe = sombreamento de variavel
    calango(int bucho, int maxBucho, int nPatas, int vida){ //parametros
        this.bucho = bucho; //this se refere aos atributos.
        this.maxBucho = maxBucho;
        this.nPatas = nPatas;
        this.vida = vida;
        this.alive = true;
    }

    void comer(int comida){
        bucho += comida;
        if(bucho >= (0.3 * maxBucho) + maxBucho){
            vida = 0;
            alive = false;
            System.out.println("RIP deadlango - Causa da morte: Buxo cheio");
            return;
        }
        System.out.println("Nhame que delícia!");
        vida += 2;
    }

    void andar(){
        if(nPatas < 2){
            System.out.println("Estou impossibilitado de tal tarefa, preciso me curar");
            return;
        }
        if(bucho > 0){
            bucho -= 1;
            System.out.println("Que passeio agradável");
            return;
        }
        System.out.println("Estou muito Cansado, Já estou vendo uma luz branca");
    } 

    void acidentar(){
        if(nPatas > 2){
            nPatas -= 1;
            vida -=2;
            System.out.println("Ouch! Estou machucado perdi uma pata");
        }
        else{
            System.out.println("Já virei cobra!!");
            vida = 0;
            System.out.println("RIP deadlango ;( - Causa da morte: Desconhecida");
            alive = false;
        }
    }

    void regenerar(){
        if(nPatas == 4){
            System.out.println("Estou perfeito");
        }
        else if(bucho > 0){
            nPatas += 1;
            bucho -= 1;
            System.out.println("Opa! Recuperei uma pata!");
        }
        else{
            System.out.println("Não tenho energia suficiente para me recuperar");
        }
    }

    public String toString(){
        return "Bucho: " + bucho + "/" + maxBucho + " Patas: " + nPatas + " Vida: " + vida + " Alive: " + alive;
    }
    
    public static void main(String[] args){

        //referencia      = criando objeto
        calango deadlango = new calango(0, 20, 4, 5);
        System.out.println(deadlango);
        deadlango.comer(5);
        deadlango.comer(15);
        deadlango.comer(5);
        deadlango.andar();
        deadlango.acidentar();
        deadlango.acidentar();
        deadlango.andar();
        deadlango.acidentar();
        System.out.println(deadlango);
    }
}
