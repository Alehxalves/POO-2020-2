import java.util.Scanner;

public class Main {
    
    public static void main(String[] args) {
        Cinema cinema = new Cinema(3);
        Scanner scanner = new Scanner(System.in);

        while(true){
            String input = scanner.nextLine();
            String[] token = input.split(" ");
            
            if(input.equals("end")){
                break;
            }else if(token[0].equals("new")){
                cinema = new Cinema(Integer.parseInt(token[1]));
            }else if(input.equals("show")){
                System.out.println(cinema);
            }else if(token[0].equals("reservar")){
                cinema.reservar(token[1], token[2], Integer.parseInt(token[3]));
            }else if(token[0].equals("cancelar")){
                cinema.cancelar(Integer.parseInt(token[1]));
            }else{
                System.out.println("Comando inválido!");
            }
                

        }

        scanner.close();
    }

}
