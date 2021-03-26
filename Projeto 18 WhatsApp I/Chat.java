import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

public class Chat {
    private String id;
    protected TreeMap<String, Inbox> inboxes;
    protected TreeMap<String, User> users;

    public Chat(String id, User user){
        this.id = id;
        users = new TreeMap<>();
        inboxes = new TreeMap<>();
        addUserChat(user);
    }
    public List<Msg> getMsg(String userId){
        List<Msg> msgs = new ArrayList<>();
        Inbox inbox = getInboxUser(users.get(userId));
        msgs.addAll(inbox.getMsgs());
        return msgs;
    }
    public TreeMap<String, User> getUsers(){
        return users;
    }
    public void deliverZap(User userSend, String message){
        if(!hasUser(userSend.getId()))
            throw new RuntimeException("fail: user " + userSend.getId() + " nao esta no chat" + getId());
        User user = users.get(userSend.getId());
        for(Inbox inbox : inboxes.values())
            if(inbox.getUser() != user){
                inbox.addMsg(new Msg(userSend.getId(), message));
                inbox.getUser().addNotify(this);
            }
    }
    public Inbox getInboxUser(User user){
        if(!hasUser(user.getId()))
            throw new RuntimeException("fail: user " + user.getId() + " nao esta no chat" + getId());
        Inbox inbox = inboxes.get(user.getId());
        return inbox;
    }
    public int unreadCount(String userId){
        User user = users.get(userId);
        int cont = 0;
        if(user.getNotifyUser(getId()) != null);
            cont = user.getNotifyUser(getId()).getUnreadCount();
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
    public void addByInvite(User invite, User gest){
        if(!hasUser(invite.getId()))
            throw new RuntimeException("fail: " + invite.getId() + " nao conhece o chat " + getId());
        if(hasUser(gest.getId()))
            throw new RuntimeException("fail: " + gest.getId() + " ja esta no chat " + getId());
        addUserChat(gest);
    }
    public void rmUserChat(User user){
        if(!hasUser(user.getId()))
            throw new RuntimeException("fail: " + user.getId() + " nao esta no chat " + getId());
        users.remove(user.getId());
        user.rmChat(this);
    }
    public String getId(){
        return id;
    }
}
