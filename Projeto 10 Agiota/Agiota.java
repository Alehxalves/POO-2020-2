import java.util.ArrayList;
import java.util.TreeMap;

public class Agiota{
    private int nextId;
    private float balance;
    private TreeMap<String, Client> clientes;
    private TreeMap<Integer, Transaction> transacoes;
    /*
    TreeMap ou HashMap.
    TreeMap -> Arvore -> Chave Ordenável -> Menos memória -> Desempenho menor
    HashMap -> Tabela Hash -> Chave Hashavel -> Mias memória -> Melhor desempenho
    */
    public Agiota(float balance){
        this.balance = balance;
        this.clientes = new TreeMap<>();
        this.transacoes = new TreeMap<>();
        this.nextId = 0;
    }

    public void addTransaction(String codename, float value, String type){
        this.transacoes.put(this.nextId, new Transaction(this.nextId, codename, value, type));
        this.nextId++;
    }   
    
    public void addCli(String codename, float limite){
        if(this.clientes.containsKey(codename)){
            System.out.println("Fail: Cliente já existe");
            return;
        }
        clientes.put(codename, new Client(codename, limite));
    }

    public void lend(String codename, float value){
        Client client = clientes.get(codename);
        if(!this.clientes.containsKey(codename)){
            System.out.println("Fail: Cliente não existe");
        }else if(this.balance < value){
            System.out.println("Fail: Fundos insuficientes");
        }else if(value > (client.getLimite() - client.getBalance())){
            System.out.println("Fail: Limite de cliente excedido");
        }else{
            this.balance -= value;
            client.setBalance(value);
            this.addTransaction(codename, -value, "Saída");
        }
    }

    public void receive(String codename, float value){
        Client client = clientes.get(codename);
        if(!this.clientes.containsKey(codename)){
            System.out.println("Fail: Cliente não existe");
        }else if(value > client.getBalance()){
            System.out.println("Fail: Valor maior que a dívida");
        }else{
            this.balance += value;
            client.setBalance(-value);
            this.addTransaction(codename, value, "Entrada");
        }
    }

    public void kill(String codename){
        if(this.clientes.containsKey(codename)){
            this.clientes.remove(codename);
            System.out.println("Hasta la vista baby!");
            ArrayList<Integer> indices = new ArrayList<>();
            for(Transaction transaction : this.transacoes.values())
                if(transaction.getCodename().equals(codename))
                    indices.add(transaction.getId());
            for(Integer i : indices)
                transacoes.remove(i);
        }else{
            System.out.println("Fail: Cliente não encontrado");
        }
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append("Clientes\n");
        for(Client client : this.clientes.values()){
            saida.append("-> " + client + "\n");
        }
        saida.append("Transações\n");
        for(Transaction transaction : this.transacoes.values()){
            saida.append("-> " + transaction + "\n");
        }
        saida.append("Balance: " + this.balance);
        return saida.toString();
    }
    public static void main(String[] args) {
        Agiota ag = new Agiota(500);
        ag.addCli("maria", 500);
        ag.addCli("josue", 60);
        ag.addCli("maria", 300); 
    
        ag.lend("maria", 300);
        ag.lend("josue", 50);
        ag.lend("maria", 100);
    
        System.out.println(ag);
    
        ag.lend("bruno", 30);
        ag.lend("maria", 60);
        ag.lend("josue", 30);
    
        System.out.println(ag);


        ag.receive("maria", 1000);
        ag.receive("maria", 350);
        ag.receive("josue", 1);
        ag.receive("maria", 10);
    
        System.out.println(ag);

        ag.kill("maria");
    
        System.out.println(ag);

    }
}