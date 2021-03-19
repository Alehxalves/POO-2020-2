public class Setor {
    private String id;
    private double preco;
    private int qtd;
    private int capacidade;

    public Setor(String id, double preco, int capacidade){
        this.id = id;
        this.preco = preco;
        this.qtd = 0;
        this.capacidade = capacidade;
    }

    public void vender(){
        if(!isCheio())
            qtd++;
    }

    public boolean isCheio(){
        if(qtd == capacidade)
            return true;
        return false;
    }

    public String getId(){
        return this.id;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getCapacidade(){
        return this.capacidade;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append(id + " : R$" + preco + " : " + qtd + "/" + capacidade);
        return saida.toString();
    }
}
