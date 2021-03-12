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
        return 999;
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

    void inserirGrafite(Grafite grafite){
        if(calibre != grafite.calibre)
            throw new RuntimeException("fail: calibre do grafite incompatível.");
        this.grafite = grafite;
    }

    Grafite removerGrafite(){
        if(grafite == null)
            throw new RuntimeException("fail: não há grafite na lapiseira.");
        grafite = null;
        return grafite;
    }

    void escreverFolhas(int folhas){
        if(grafite == null)
            throw new RuntimeException("fail: não há grafite na lapiseira.");
        if(grafite.tamanho == 0)
            throw new RuntimeException("fail: grafite acabou, troque-o");
        int total = grafite.desgastePorFolha() * folhas;
        if(total <= grafite.tamanho){
            grafite.tamanho -= total;
            System.out.println("Você escreveu " + folhas + " folhas.");
            return;
        }
        int qtsFolhas = grafite.tamanho / grafite.desgastePorFolha();
        grafite.tamanho = 0;
        System.out.println("Folhas escritas: " + qtsFolhas);
    }

    public String toString(){
        return "Calibre: " + calibre + " Grafite: " + grafite;
    }
}

public class ExecessoesLapiseiraInterativa{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Lapiseira lapiseira = new Lapiseira(0.0f);
        System.out.println("Comando: calibre - inserir(C - D - T) - remover - escrever - show - end\n");

        while(true){
            try{
                String command = scanner.nextLine();
                String[] ui = command.split(" ");
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("show")){
                    System.out.println(lapiseira);
                }else if(ui[0].equals("remover")){
                    lapiseira.removerGrafite();
                }else if(ui[0].equals("calibre")){
                    lapiseira.calibre = Float.parseFloat(ui[1]);
                }else if(ui[0].equals("inserir")){
                    if(ui[2].indexOf("B") == -1)
                        throw new RuntimeException("fail: necessita o B apos o valor da dureza");
                    lapiseira.inserirGrafite(new Grafite(Float.parseFloat(ui[1]), ui[2], Integer.parseInt(ui[3])));
                }else if(ui[0].equals("escrever")){
                    lapiseira.escreverFolhas(Integer.parseInt(ui[1]));
                }else{
                    System.out.println("fail: Comando Inválido");
                }
            }catch(IndexOutOfBoundsException e){
                System.out.println("fail: IndexOutOfBoundsExeception");
            }catch(RuntimeException e){
                System.out.println(e);
            }
        }
        scanner.close();
        
    }
}