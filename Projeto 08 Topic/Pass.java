public class Pass {
    
    private String nome;
    private int idade;

    public Pass(String nome, int idade){
        setNome(nome);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        this.idade = idade;
    }

    public String toString(){
        return nome + idade;
    }



}
