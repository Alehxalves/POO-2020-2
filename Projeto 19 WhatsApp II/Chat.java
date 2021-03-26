import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

abstract class Chat {
    private String chatId;
    private List<Msg> historico;
    protected TreeMap<String, Inbox> inboxes;
    protected TreeMap<String, User> users;

    Chat(){
        users = new TreeMap<>();
        inboxes = new TreeMap<>();
        historico = new ArrayList<>();
    }
    public List<Msg> getMsg(String userId){
        if(!hasUser(userId))
            throw new RuntimeException("fail: " + userId + " nao conhece o chat " + getChatId());
        List<Msg> msgs = new ArrayList<>();
        Inbox inbox = getInboxUser(users.get(userId));
        msgs.addAll(inbox.getMsgs());
        return msgs;
    }
    public List<Msg> getHistorico(User user){
        if(!hasUser(user.getId()))
            throw new RuntimeException("fail: " + user.getId() + " nao conhece o chat " + getChatId());
        return historico;
    }
    public TreeMap<String, User> getUsers(){
        return users;
    }
    public void deliverZap(User userSend, String message){
        if(!hasUser(userSend.getId()))
            throw new RuntimeException("fail: user " + userSend.getId() + " nao conhece o " + getChatId());
        User user = users.get(userSend.getId());
        for(Inbox inbox : inboxes.values())
            if(inbox.getUser() != user){
                inbox.addMsg(new Msg(userSend.getId(), message));
                inbox.getUser().addNotify(this);
            }
        historico.add(new Msg(user.getId(), message));
    }
    public Inbox getInboxUser(User user){
        Inbox inbox = inboxes.get(user.getId());
        return inbox;
    }
    public int unreadCount(String userId){
        User user = users.get(userId);
        int cont = 0;
        if(user.getNotifyUser(getChatId()) != null);
            cont = user.getNotifyUser(getChatId()).getUnreadCount();
        return cont;
    }
    public boolean hasUser(String userId){
        if(!users.containsKey(userId))
            return false;
        return true;
    }
    public void addUserChat(User user){
        users.put(user.getId(), user);
        inboxes.put(user.getId(), new Inbox(user));
        user.addChat(this);
    }
    abstract void addByInvite(User invite, User guest);
    public void rmUserChat(User user){
        if(!hasUser(user.getId()))
            throw new RuntimeException("fail: " + user.getId() + " nao conhece o group " + getChatId());
        users.remove(user.getId());
        user.rmChat(this);
    }
    public String getChatId(){
        return chatId;
    }
    public void setChatId(String chatId){
        this.chatId = chatId;
    }
}
