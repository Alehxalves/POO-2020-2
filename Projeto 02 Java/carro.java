import java.util.Scanner;

public class carro {
    int gas;
    int gasMax;
    int pass;
    int passMax;
    int km;

    carro(int gas, int gasMax, int pass, int passMax, int km){
        this.gas = gas;
        this.gasMax = gasMax;
        this.pass = pass;
        this.passMax = passMax;
        this.km = km;
    }


    void embarcar(){
        if(pass < passMax)
            pass +=1;
        else
            System.out.println("Limite de pessoas atingido.");
    }
    void desembarcar(){
        if(pass > 0)
            pass -=1;
        else
            System.out.println("Não há ninguém no carro.");
    }
    void abastecer(int fuel){
        gas = fuel;
        if(gas > gasMax)
            gas = gasMax;
    }
    void dirigir(int drive){
        if(pass > 0 && gas > 0){
            for(int i = 0; i < drive; i++){
                km += 1;
                gas -=1;
                if(gas == 0){
                    System.out.println("Tanque vazio após andar "+ km + "Km.");
                    break;
                }
            }
        }else if(pass < 1){
            System.out.println("Não há ninguém no carro");
        }else if(gas < 1)
            System.out.println("Não há combustível");     
    }

    public String toString(){
        return "Pass: " + pass + " Gas: " + gas + " Km: " + km;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        carro porshe = new carro(0, 100, 0, 2, 0);

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(line.equals("$in")){
                porshe.embarcar();
            }else if(line.equals("$out")){
                porshe.desembarcar();
            }else if(line.equals("$show")){
                System.out.println(porshe);
            }else if(ui[0].equals("$fuel")){
                porshe.abastecer(Integer.parseInt(ui[1]));
            }else if(ui[0].equals("$drive")){
                porshe.dirigir(Integer.parseInt(ui[1]));
            }else if(line.equals("$end")){
                break;
            }else
                System.out.println("Comando inválido");
        }
        scanner.close();
    }
}
