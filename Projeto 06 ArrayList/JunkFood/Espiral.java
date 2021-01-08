public class Espiral{
    
    public String nome;
    public int qtd;
    public float preco;

    public Espiral(String nome, int qtd, float preco){
        this.nome = nome;
        this.qtd = qtd;
        this.preco = preco;
    }

    public String toString(){
        return nome + qtd + preco;
    }

}