import java.util.TreeMap;
import java.util.Map.Entry;
import java.util.Scanner;

public class Bilheteria{
    private TreeMap<String, Evento> repEventos;
    private TreeMap<String, Pessoa> repPessoas;
    private TreeMap<Integer, Venda> repVendas;
    private double caixa;
    private int nextInt; // Contador de vendas

    public Bilheteria(){
        repEventos = new TreeMap<>();
        repPessoas = new TreeMap<>();
        repVendas = new TreeMap<>();
        caixa = 0;
        nextInt = 1;
    }

    public static void main(String[] args) {
        Bilheteria bilheteria = new Bilheteria();
        Scanner scanner = new Scanner(System.in);
        String line;
        while(true){
            try{
                line = scanner.nextLine();
                String[] ui = line.split(" ");
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addPessoa")){
                    bilheteria.addPessoa(ui[1], Integer.parseInt(ui[2]), Boolean.parseBoolean(ui[3]));
                }else if(ui[0].equals("addEvento")){
                    bilheteria.addEvento(ui[1]);
                }else if(ui[0].equals("addSetor")){
                    bilheteria.addSetor(ui[1], ui[2], Double.parseDouble(ui[3]), Integer.parseInt(ui[4]));
                }else if(ui[0].equals("vender")){
                    bilheteria.vender(ui[1], ui[2], ui[3]);
                }else if(ui[0].equals("showCaixa")){
                    System.out.println(bilheteria.getCaixa());
                }else if(ui[0].equals("showPessoas")){
                    System.out.println(bilheteria.showPessoa());
                }else if(ui[0].equals("showEventos")){
                    System.out.println(bilheteria.showEvento());
                }else if(ui[0].equals("showVendas")){
                    System.out.println(bilheteria.showVendas());
                }else{
                    System.out.println("fail: comando inválido");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println(e);
            }catch(RuntimeException msg){
                System.out.println(msg);
            }
        }
        scanner.close();
    }

    public void vender(String cliente, String evento, String setor){
        if(!repPessoas.containsKey(cliente))
            throw new RuntimeException("fail: cliente não existe.");
        if(!repEventos.containsKey(evento))
            throw new RuntimeException("fail: evento " + evento + " não existe.");
        if(!repEventos.get(evento).repSetores.containsKey(setor))
            throw new RuntimeException("fail: setor " + setor + " não existe.");
        if(repEventos.get(evento).repSetores.get(setor).isCheio())
            throw new RuntimeException("fail: este setor esta lotado");
            
        double valor = repEventos.get(evento).repSetores.get(setor).getPreco();
        if(repPessoas.get(cliente).getMeia())
            valor -= valor * 0.5;
        repEventos.get(evento).repSetores.get(setor).vender();
        repVendas.put(nextInt, new Venda(cliente, evento, setor, valor));
        caixa += valor;
        nextInt++;

    }

    public void addPessoa(String nome, int idade, boolean pagaMeia){
        if(repPessoas.containsKey(nome))
            throw new RuntimeException("fail: esta pessoa ja esta cadastrada");
        repPessoas.put(nome, new Pessoa(nome, idade, pagaMeia));
    }

    public void addEvento(String idEvento){
        if(repEventos.containsKey(idEvento))
            throw new RuntimeException("fail: este evento ja existe");
        repEventos.put(idEvento, new Evento(idEvento));
    }

    public void addSetor(String idEvento, String idSetor, double preco, int capacidade){
        if(!repEventos.containsKey(idEvento))
            throw new RuntimeException("fail: este evento nao existe");
        if(repEventos.get(idEvento).repSetores.containsKey(idSetor))
            throw new RuntimeException("fail: este setor ja existe");
        repEventos.get(idEvento).addSetor(new Setor(idSetor, preco, capacidade));
    }

    public double getCaixa(){
        return this.caixa;
    }

    public String showVendas(){
        StringBuilder saida = new StringBuilder();
        saida.append("- Vendas - " + "\n");
        for(Entry<Integer, Venda> pair: repVendas.entrySet())
            saida.append("[" + pair.getKey() + "] " + pair.getValue() + "\n");
        saida.append("Caixa: R$ " + caixa);
        return saida.toString();
    }

    public String showPessoa(){
        StringBuilder saida = new StringBuilder();
        saida.append("- Pessoas - " + "\n");
        for(Pessoa pessoa: repPessoas.values())
            saida.append(pessoa.toString() + "\n");
        return saida.toString();
    }

    public String showEvento(){
        StringBuilder saida = new StringBuilder();
        saida.append("- Eventos - " + "\n");
        for(Evento evento: repEventos.values())
            saida.append(evento.toString() + "\n");
        return saida.toString();
    }

}