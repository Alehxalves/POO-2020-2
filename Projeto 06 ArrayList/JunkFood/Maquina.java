import java.util.ArrayList;

public class Maquina{

    private ArrayList<Espiral> espirais;
    private float saldoCliente;
    private float lucro;
    private int maxProdutos;

    public Maquina(int maxProdutos, int qtdEspirais){
        this.maxProdutos = maxProdutos;
        this.espirais = new ArrayList<Espiral>();
        for(int i = 0; i < qtdEspirais; i++){
            espirais.add(i, new Espiral("VAZIO", 0, 0.0f));
        }

    }

    public boolean inserirDinheiro(float valor){
        if(valor > 0){
            this.saldoCliente += valor;
            System.out.println("Depositou " + "R$ " + valor);
            return true;
        }
        System.out.println("Valor de deposito inválido.");
        return false;
    }

    public float pedirTroco(){
        if(this.saldoCliente == 0){
            System.out.println("Não há dinheiro na máquina.");
            return 0.0f;
        }
        float trocoCliente = this.saldoCliente;
        this.saldoCliente = 0;
        return trocoCliente;
    }

    public boolean vender(int indice){
        if(indice < 0 || indice > espirais.size() - 1){
            System.out.println("Indice do produto inválido");
            return false;
        }
        if(espirais.get(indice).qtd == 0){
            System.out.println("Está vazio");
            return false;
        }

        if(this.saldoCliente >= espirais.get(indice).preco){
                espirais.get(indice).qtd--;
                System.out.println("Comprou " + espirais.get(indice).nome);
                this.saldoCliente -= espirais.get(indice).preco;
                this.lucro += espirais.get(indice).preco;
                // Limpando.
                if(espirais.get(indice).qtd == 0)
                    espirais.set(indice, new Espiral("VAZIO", 0, 0.0f));
                return true;  
        }else{
            System.out.println("Saldo insuficiente");
            return false;
        }

    }

    public boolean alterarEspiral(int indice, String nome, int qtd, float preco){
        if(indice < 0 || indice > espirais.size() - 1){
            System.out.println("Indice inválido.");
            return false;
        }

        if(qtd <= 0 || qtd > this.maxProdutos){
            System.out.println("Quantidade inválida");
            return false;
        }
        espirais.set(indice, new Espiral(nome, qtd, preco));
        return true;
    }

    public float getSaldo(){
        return this.saldoCliente;
    }

    public float getLucro(){
        return this.lucro;
    }

    public void limparEspiral(int indice){
        if(indice < 0 || indice > espirais.size() - 1){
            System.out.println("Indice inválido");
            return;
        }
        espirais.set(indice, new Espiral("VAZIO", 0, 0.0f));
    }

    public String toString(){
        String saida = "";

        for(int i = 0; i < espirais.size(); i ++){
            saida += i + " [ " + espirais.get(i).nome + " : " + espirais.get(i).qtd + " : " + espirais.get(i).preco + " RS]"+"\n";
        }

        return saida;
    }
    
}