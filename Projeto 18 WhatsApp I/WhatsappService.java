import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class WhatsappService{
    private TreeMap<String, Chat> rep_chat;
    private TreeMap<String, User> rep_user;

    public WhatsappService(){
        rep_user = new TreeMap<>();
        rep_chat = new TreeMap<>();
    }
    protected User getUser(String userId){
        if(!userExist(userId))
            throw new RuntimeException("fail: usuario " + userId + " nao existe");
        return rep_user.get(userId);
    }
    protected Chat getChat(String chatId){
        if(!chatExist(chatId))
            throw new RuntimeException("fail: chat " + chatId + " nao existe");
        return rep_chat.get(chatId);
    }
    protected boolean userExist(String userId){
        if(!rep_user.containsKey(userId))
            return false;
        return true;
    }
    protected boolean chatExist(String chatId){
        if(!rep_chat.containsKey(chatId))
            return false;
        return true;
    }
    public String getChatsUser(String userId){
        User user = getUser(userId);
        StringBuilder saida = new StringBuilder();
        saida.append("[");
        for(String chat : user.getChats().keySet())
            saida.append(chat + " ");
        if(saida.lastIndexOf(" ") != -1)saida.deleteCharAt(saida.lastIndexOf(" "));
        saida.append("]");
        return saida.toString();
    }
    public String getUsersChat(String chatId){
        Chat chat = getChat(chatId);
        StringBuilder saida = new StringBuilder();
        saida.append("[");
        for(String user : chat.getUsers().keySet())
            saida.append(user + " ");
        if(saida.lastIndexOf(" ") != -1)saida.deleteCharAt(saida.lastIndexOf(" "));
        saida.append("]");
        return saida.toString();
    }
    public String getNotifyUser(String userId){
        User user = getUser(userId);
        StringBuilder saida = new StringBuilder();
        saida.append("[");
        for(Map.Entry<String, Chat> pair : user.getChats().entrySet()){
            saida.append(pair.getKey());
            if(pair.getValue().unreadCount(userId) > 0){
                saida.append("(" + pair.getValue().unreadCount(userId) + ") ");
                continue;
            }
            saida.append("() ");
        }
        if(saida.lastIndexOf(" ") != -1)saida.deleteCharAt(saida.lastIndexOf(" "));
        saida.append("]");
        return saida.toString();
    }
    public void createUser(String userId){
        if(userExist(userId))
            throw new RuntimeException("fail: usuario " + userId + " ja existe");
        rep_user.put(userId, new User(userId));
    }
    public void createChat(String userId, String chatId){
        User user = getUser(userId);
        if(chatExist(chatId)){
            throw new RuntimeException("fail: chat " + chatId + " ja existe");
        }
        rep_chat.put(chatId, new Chat(chatId, user));
    }
    public void addByInvite(String inviteId, String guestId, String chatId){
        User invate = getUser(inviteId);
        User guest = getUser(guestId);
        Chat chat = getChat(chatId);
        chat.addByInvite(invate, guest);
        System.out.println(guestId + " juntou-se ao chat " + chatId);
    }
    public String allUsers(){
        StringBuilder saida = new StringBuilder();
        saida.append("[");
        for(String userId : rep_user.keySet())
            saida.append(userId + " ");
        if(saida.lastIndexOf(" ") != -1)saida.deleteCharAt(saida.lastIndexOf(" "));
        saida.append("]");
        return saida.toString();
    }
    public void removerUserChat(String userId, String chatId){
        User user = getUser(userId);
        Chat chat = getChat(chatId);
        chat.rmUserChat(user);
        if(chat.getUsers().size() == 0) // Se todos users sairem do chat ele é deletado automaticamente
            rep_chat.remove(chatId);
        System.out.println(userId + " deixou o chat " + chatId);
    }
    public void sendMessage(String userId, String chatId, String message){
        User user = getUser(userId);
        Chat chat = getChat(chatId);
        chat.deliverZap(user, message);
    }
    public String readMessageUserChat(String userId, String chatId){
        User user = getUser(userId);
        Chat chat = getChat(chatId);
        if(!chat.hasUser(userId))
            throw new RuntimeException("fail: " + userId + " nao conhece o chat " + chatId);
        List<Msg> msgs = chat.getMsg(userId);
        int unreadcount = chat.unreadCount(userId);
        StringBuilder saida = new StringBuilder();
        if(unreadcount > 0){
            unreadcount = msgs.size() - unreadcount;
            for(int i = unreadcount; i < msgs.size(); i++){
                saida.append("[");
                saida.append(msgs.get(i).toString());
                saida.append("]" + "\n");
            }
            saida.deleteCharAt(saida.lastIndexOf("\n"));
            user.rmNotifications(chatId);
        }else
            saida.append("[EMPTY]");
        return saida.toString();
    }
}