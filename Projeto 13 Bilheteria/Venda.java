public class Venda {
    private String cliente;
    private String evento;
    private String setor;
    private double valor;

    public Venda(String cliente, String evento, String setor, double preco){
        this.cliente = cliente;
        this.evento = evento;
        this.setor = setor;
        this.valor = preco;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append(cliente + " : " + evento + " : " + setor + " : R$" + valor);
        return saida.toString();
    }
}
