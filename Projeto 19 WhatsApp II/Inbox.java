import java.util.ArrayList;
import java.util.List;

public class Inbox {
    public User user;
    public List<Msg> msgs;

    public Inbox(User user){
        this.user = user;
        msgs = new ArrayList<>();
    }
    public void addMsg(Msg msg){
        msgs.add(msg);
    }
    public List<Msg> getMsgs(){
        return msgs;
    }
    public User getUser(){
        return user;
    }
}
