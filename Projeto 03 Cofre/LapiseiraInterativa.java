import java.util.Scanner;

class Grafite{
    float calibre;
    String dureza;
    int tamanho;

    Grafite(float calibre, String dureza, int tamanho){
        this.calibre = calibre;
        this.dureza = dureza;
        this.tamanho = tamanho; 
    }

    int desgastePorFolha(){
        if(dureza.equals("HB")){
            return 1;
        }
        if(dureza.equals("2B")){
            return 2;
        }
        if(dureza.equals("4B")){
            return 4;
        }
        if(dureza.equals("6B")){
            return 6;
        }
        System.out.println("2");
        return 0;
    }

    public String toString(){
        return "C:" + calibre + " D:" + dureza + " T:" + tamanho;
    }
}

class Lapiseira{
    float calibre;
    Grafite grafite;

    Lapiseira(float calibre){
        this.calibre = calibre;
        this.grafite = null;
    }

    boolean inserirGrafite(Grafite grafite){
        if(calibre != grafite.calibre){
            System.out.println("Calibre do grafite incompatível.");
            return false;
        }
        this.grafite = grafite;
        return true;
    }

    Grafite removerGrafite(){
        if(grafite == null){
            System.out.println("Não há grafite na lapiseira.");
            return null;
        }
        grafite = null;
        return null;
    }

    void escreverFolhas(int folhas){
        if(grafite == null){
            System.out.println("Não há grafite na lapiseira.");
            return; 
        }
        int total = grafite.desgastePorFolha() * folhas;
        if(total <= grafite.tamanho){
            grafite.tamanho -= total;
            if(grafite.tamanho == 0){
                this.grafite = null;
                System.out.println("O grafite acabou.");
                return;
            }
            return;
        }
        if(total > grafite.tamanho){
            int qtsFolhas = grafite.tamanho / grafite.desgastePorFolha();
            System.out.println("ERROR, folhas escritas: " + qtsFolhas);
        }
        grafite.tamanho = 0;
        this.grafite = null;
        System.out.println("O grafite acabou.");
    }

    public String toString(){
        return "Calibre: " + calibre + " Grafite: " + grafite;
    }
}

public class LapiseiraInterativa{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Lapiseira lapiseira = new Lapiseira(0.0f);
        System.out.println("Comando: calibre - inserir - remover - escrever - show - end\n");

        while(true){
            String command = scanner.nextLine();
            String[] ui = command.split(" ");
            if(command.equals("end")){
                break;
            }else if(command.equals("show")){
                System.out.println(lapiseira);
            }else if(command.equals("remover")){
                lapiseira.removerGrafite();
            }
            else if(ui[0].equals("calibre")){
                lapiseira.calibre = Float.parseFloat(ui[1]);
            }else if(ui[0].equals("inserir")){
                lapiseira.inserirGrafite(new Grafite(Float.parseFloat(ui[1]), ui[2], Integer.parseInt(ui[3])));
            }else if(ui[0].equals("escrever")){
                lapiseira.escreverFolhas(Integer.parseInt(ui[1]));
            }else{
                System.out.println("Comando Inválido");
            }
        }
        scanner.close();
    }
}

