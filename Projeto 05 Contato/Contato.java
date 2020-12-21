import java.util.ArrayList;
import java.util.Scanner;


class Fone{
    private String label;
    private String number;

    public Fone(String label, String number){
        this.label = label;
        this.number = number;
    }
    public String toString(){
        return  label + ":" + number;
    }

    public static boolean validate(String number){
        String str = ".()0123456789";
        for(int i = 0; i < number.length(); i++){
            char c = number.charAt(i);
            if(str.indexOf(c, 0) == -1){
                return false;
            }
        }
        return true;
    }
}

public class Contato{

    private String name;
    private ArrayList<Fone> fones;

    public Contato(String name){
        this.name = name;
        fones = new ArrayList<>();

    }
    public String toString(){
        String saida = "- " + name + " ";
        for(int i = 0; i < fones.size(); i++){
            Fone tel = fones.get(i);
            saida += "[" + i + ":" + tel + "]";
        }
        return saida;
    }

    public void addFone(String label, String number){
        if(!Fone.validate(number)){
            System.out.println("Número inválido");
            return;
        }
        fones.add(new Fone(label, number));
    }
    public void rmFone(int index){
        if(index < 0 || fones.size() == 0){
            System.out.println("Error");
            return;
        }
        fones.remove(index);
    }
    public void setName(String name){
        this.name = name;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Contato contato = new Contato("");

        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            if(ui[0].equals("end")){
                break;
            }else if(ui[0].equals("show")){
                System.out.println(contato);
            }else if(ui[0].equals("name")){
                contato.setName(ui[1]);
            }else if(ui[0].equals("add")){
                contato.addFone(ui[1], ui[2]);
            }else if(ui[0].equals("rmv")){
                contato.rmFone(Integer.parseInt(ui[1]));
            }else{
                System.out.println("Comando Inválido");
            }

        }
        scanner.close();
    }
}

