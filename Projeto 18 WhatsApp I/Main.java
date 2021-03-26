import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        WhatsappService whatsapp = new WhatsappService();
        Scanner scanner = new Scanner(System.in);
        String line;
        while(true){
            line = scanner.nextLine();
            String[] ui = line.split(" ");
            try {
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addUser")){
                    whatsapp.createUser(ui[1]);
                }else if(ui[0].equals("newChat")){
                    whatsapp.createChat(ui[1], ui[2]);
                }else if(ui[0].equals("invite")){
                    whatsapp.addByInvite(ui[1], ui[2], ui[3]);
                }else if(ui[0].equals("chats")){
                    System.out.println(whatsapp.getChatsUser(ui[1]));
                }else if(ui[0].equals("usersChat")){
                    System.out.println(whatsapp.getUsersChat(ui[1]));
                }else if(ui[0].equals("leave")){
                    whatsapp.removerUserChat(ui[1], ui[2]);
                }else if(ui[0].equals("notify")){
                    System.out.println(whatsapp.getNotifyUser(ui[1]));
                }else if(ui[0].equals("zap")){
                    String[] token = line.split(ui[2]);
                    whatsapp.sendMessage(ui[1], ui[2], token[1]);
                }else if(ui[0].equals("inbox")){
                    System.out.println(whatsapp.readMessageUserChat(ui[1], ui[2]));
                }else if(ui[0].equals("showUsers")){
                    System.out.println(whatsapp.allUsers());
                }else
                    System.out.println("fail: command invalid");
            }catch (RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
