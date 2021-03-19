public class Pessoa{
    private String nome;
    private int idade;
    private String meiaOuInteira;
    private boolean meia;

    public Pessoa(String nome, int idade, boolean pagaMeia){
        this.nome = nome;
        this.idade = idade;
        this.meia = pagaMeia;
        meiOuInt(pagaMeia);
    }

    public String getNome() {
        return nome;
    }

    public boolean getMeia(){
        return this.meia;
    }

    public void meiOuInt(boolean m_i){ // Paga meia ou inteira, True = meia, false = inteira
        if(m_i)
            meiaOuInteira = "Paga Meia";
        else    
            meiaOuInteira = "Paga Inteira";
    }

    public String toString(){
        return nome + " : " + idade + " anos" + " - " + meiaOuInteira;
    }
    
}