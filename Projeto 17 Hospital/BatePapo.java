import java.util.ArrayList;
import java.util.List;

class Msg{
    private String remetente;
    private String destinario;
    private String msg;

    Msg(String remetente, String destinatario, String msg){
        this.destinario = destinatario;
        this.remetente = remetente;
        this.msg = msg;
    }
    public String getDestinario(){
        return this.destinario;
    }
    public String getId(){
        return this.remetente;
    }
    public String toString(){
        return remetente + ": " + msg;
    }
}
public class BatePapo implements IBatePapo{
    private String id;
    private List<Msg> inbox;

    BatePapo(String id){
        inbox = new ArrayList<>();
    }
    @Override
    public String getId(){
        return id;
    }
    @Override
    public void sendMessage(Msg msg, IBatePapo batePapo){
        batePapo.addMessage(msg);
    }
    @Override
    public void addMessage(Msg msg){
        inbox.add(msg);
    }
    @Override
    public List<Msg> getInbox(){
        return inbox;
    }
    public void apagarMsgs(String id){
        List<Msg> remove = new ArrayList<>();
        for(Msg msg : inbox){
            if(msg.getDestinario().equals(id))
                remove.add(msg);
        }
        for(Msg msg : remove)
            inbox.remove(msg);
    }
    public String toString(String id){
        StringBuilder saida = new StringBuilder();
        saida.append("[INBOX]\n");
        for(Msg msg : inbox)
            if(msg.getDestinario().equals(id))
                saida.append(msg.toString() + "\n");
        if(saida.lastIndexOf("\n") != -1)
            saida.deleteCharAt(saida.lastIndexOf("\n"));
        apagarMsgs(id);
        return saida.toString();
    }
}
