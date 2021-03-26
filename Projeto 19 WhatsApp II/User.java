import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class User {
    private String id;
    protected TreeMap<String, Chat> chats;
    protected List<Notify> notify;

    public User(String id){
        this.id = id;
        chats = new TreeMap<>();
        notify = new ArrayList<>();
    }
    public TreeMap<String, Chat> getChats() {
        return chats;
    }
    public List<Notify> getNotify(){
        return notify;
    }
    public Notify getNotifyUser(String chatId){
        for(Notify not : notify){
            if(not.getChatId().equals(chatId))
                return not;
        }
        return null;
    }
    public void addChat(Chat chat){
        chats.put(chat.getChatId(), chat);
        addNotify(chat);
    }
    public void addNotify(Chat chat){
        if(getNotifyUser(chat.getChatId()) == null){
            notify.add(new Notify(chat));
            return;
        }
        Notify notify = getNotifyUser(chat.getChatId());
        notify.addCout();
    }
    public void rmNotifications(String chatId){
        Notify notify = getNotifyUser(chatId);
        notify.rmNotify();
    }
    public void rmChat(Chat chat){
        chats.remove(chat.getChatId());
    }
    public String getId(){
        return id;
    }
}
