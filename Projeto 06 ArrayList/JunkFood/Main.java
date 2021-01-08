import java.util.Scanner;

public class Main{
    public String toString(){
        String saida = "";
        saida += "MENU\n" + "Digite:\n[depositar, para colocar dinheiro na máquina.]\n[mostrar, para ver as comidas presentes na máquina.]\n"+
                  "[comprar + indice da comida, para compra-la.]\n[saldo, para ver seu saldo na máquina.]\n[troco, para retirar o dinheiro da maquina.]\n"+
                  "[fechar, para sair.]\n[alterar + indice + nome da comida + quantidade + valor, para colocar comida na máquina.]\n[limpar + indice, para remover ou limpar.]\n"+
                  "[lucro, para ver quanto você arrecadou com a máquina.]";
        return saida;
    }
    public static void main(String[] args){

        Maquina machine = new Maquina(5, 3);
        Scanner scanner = new Scanner(System.in);
        Main main = new Main();
        System.out.println(main.toString());

        while(true){
            String in = scanner.nextLine();
            String[] token = in.split(" ");

            if(in.equals("fechar")){
                break;
            }else if(token[0].equals("alterar")){
                machine.alterarEspiral(Integer.parseInt(token[1]), token[2], Integer.parseInt(token[3]), Float.parseFloat(token[4]));
            }else if(token[0].equals("depositar")){
                machine.inserirDinheiro(Float.parseFloat(token[1]));
            }else if(in.equals("mostrar")){
                System.out.println(machine);
            }else if(in.equals("saldo")){
                System.out.println("Seu saldo é " + "R$ " + machine.getSaldo());
            }else if(in.equals("lucro")){
                System.out.println("Seu lucro com a máquina foi de " + "R$ " + machine.getLucro());
            }else if(token[0].equals("limpar")){
                machine.limparEspiral(Integer.parseInt(token[1]));
            }else if(token[0].equals("comprar")){
                machine.vender(Integer.parseInt(token[1]));
            }else if(in.equals("troco")){
                System.out.println("Você recebeu " + "R$ " + machine.pedirTroco());
            }else if(token[0].equals("new")){
                machine = new Maquina(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
            }else{
                System.out.println("Erro");
            }


        }

        scanner.close();
    }   

}