public class Mensagens {
    public static void main(String[] args) {
        Sistema sistema = new Sistema();
        sistema.addUser("Joao");
        sistema.addUser("Maria");
        sistema.sendMsg("Joao", "Maria", "Cineminha hj?");
        sistema.sendMsg("Joao", "Maria", "vai passar os vingadores às 20:00hrs");
        for(Msg msg : sistema.getUser("Maria").getInbox())
            System.out.println(msg);
        sistema.sendMsg("Maria", "Joao", "Demorô");
        for(Msg msg : sistema.getUser("Joao").getInbox())
        System.out.println(msg);
    }
}
