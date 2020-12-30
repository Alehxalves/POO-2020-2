import java.util.ArrayList;
import java.util.Scanner;

class Operacao{

    String descricao;
    float valor;
    float saldo;

    Operacao(String descricao, float valor, float saldo){
        this.descricao = descricao;
        this.valor = valor;
        this.saldo = saldo;
    }
    public String toString(){
        return descricao + ": " + valor + ": " + saldo;
    }

}
class ContaBancaria{

    private float saldo;
    private int numero;
    private ArrayList<Operacao> extrato;

    public ContaBancaria(int numero){
        this.numero = numero;
        this.extrato = new ArrayList<Operacao>();
        this.extrato.add(new Operacao("Abertura", 0.0f, 0.0f));
        
    }

    public boolean depositar(float value){
        if(value <= 0){
            System.out.println("Valor inválido.");
            return false;
        }
        this.saldo += value;
        extrato.add(new Operacao("Deposito", value, this.saldo));
        return true;

        
    }
    public boolean sacar(float value){
        if(value > this.saldo){
            System.out.println("Saldo insuficiente.");
            return false;
        }
        if(value < 0){value *= -1;}
        this.saldo -= value;
        this.extrato.add(new Operacao("Saque", -value, this.saldo));
        return true;
    }
    public void extornar(String value){
        String[] line = value.split(" ");
        if(line.length < 1)
            return;
        for(int i = 1; i < line.length; i++){
            if(Integer.parseInt(line[i]) <= 0){
                System.out.println("Indice " + Integer.parseInt(line[i]) + " inválido");
            }else{
                if(extrato.get(Integer.parseInt(line[i])).descricao.equals("Tarifa")){
                    this.saldo += extrato.get(Integer.parseInt(line[i])).valor * -1;
                    extrato.add(new Operacao("Extorno", extrato.get(Integer.parseInt(line[i])).valor * -1, this.saldo));
                }else{
                    System.out.println("Indice " + Integer.parseInt(line[i]) + " não é tarifa");
                }
            }
        }
    }
    public void tarifas(float value){
        if(value < 0){value *= -1;}
        this.saldo -= value;
        this.extrato.add(new Operacao("Tarifa", -value, this.saldo));

    }

    public ArrayList<Operacao> getExtrato(){
        String saida = "";
        for(int i = 0; i < extrato.size(); i++){
            saida += i + ": " + extrato.get(i).descricao + ": " + extrato.get(i).valor + ": " + extrato.get(i).saldo;
            if(i < extrato.size() - 1)
                saida += "\n";
        }
        System.out.println(saida);
        return extrato;
    }
    public ArrayList<Operacao> getExtratoLast(int qtd){
        if(qtd < 0){
            System.out.println("Indice inválido");
            return extrato;
        }
        String saida = "";
        for(int i = extrato.size() - qtd; i < extrato.size(); i++){
            saida += i + ": " + extrato.get(i).descricao + ": " + extrato.get(i).valor + ": " + extrato.get(i).saldo ;
            if(i < extrato.size() - 1)
                saida += "\n";
        }
        System.out.println(saida);
        return extrato;
    }
    public String toString(){
        return "Conta: " + numero + " Saldo: " + saldo;
    }

}
public class Tarifas{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContaBancaria conta = new ContaBancaria(555);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");

            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("show")){
                System.out.println(conta);
            }else if(ui[0].equals("depositar")){
                conta.depositar(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("sacar")){
                conta.sacar(Float.parseFloat(ui[1]));
            }else if(ui[0].equals("tarifa")){
                conta.tarifas(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("extrato")){
                conta.getExtrato();
            }else if(ui[0].equals("extratoN")){
                conta.getExtratoLast(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("extornar")){
                conta.extornar(line);
            }else{
                System.out.println("Comando inválido");
            }
        }
        scanner.close();
        
    }
}