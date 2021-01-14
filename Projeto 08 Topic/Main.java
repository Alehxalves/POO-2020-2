import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        
        Scanner scanner = new Scanner(System.in);
        Topic van = new Topic(5, 2);
        
        while(true){
            String input = scanner.nextLine();
            String[] token = input.split(" ");

            if(input.equals("sair")){
                break;
            }else if(input.equals("mostrar")){
                System.out.println(van);
            }else if(token[0].equals("new")){
                van = new Topic(Integer.parseInt(token[1]), Integer.parseInt(token[2]));
            }else if(token[0].equals("embarcar")){
                van.subir(new Pass(token[1], Integer.parseInt(token[2])));
            }else if(token[0].equals("descer")){
                van.descer(token[1]);
            }else{
                System.out.println("Erro!");
            }
        }
        scanner.close();
    }
}
