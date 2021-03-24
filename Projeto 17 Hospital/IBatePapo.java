import java.util.List;

interface IBatePapo{
    String getId();
    void sendMessage(Msg msg, IBatePapo batePapo);
    void addMessage(Msg msg);
    List<Msg> getInbox();
}