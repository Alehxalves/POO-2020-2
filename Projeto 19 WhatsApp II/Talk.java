public class Talk extends Chat{
    public Talk(User userOne, User userTwo, String chatId){
        setChatId(chatId);
        serPair(userOne, userTwo);
    }
    public void serPair(User userOne, User userTwo){
        addUserChat(userOne);
        addUserChat(userTwo);       
    }
    @Override
    void addByInvite(User invite, User guest) {
        throw new RuntimeException("fail: operacao de adicionar usuarios nao suportada");
    }
    @Override
    public void rmUserChat(User user) {
        throw new RuntimeException("fail: operacao de sair do chat nao suportada");
    }
}
