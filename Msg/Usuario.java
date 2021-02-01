import java.util.*;

public class Usuario {
    private String id;
    private ArrayList<Msg> inbox;
    private int contNaoLidos;

    public Usuario(String id){
        this.id = id;
        inbox = new ArrayList<>();
        contNaoLidos = 0;
    }

    public void sendMsg(int idMsg, Usuario dest, String text){
        dest.inbox.add(new Msg(idMsg, this.id, text));
        dest.contNaoLidos++;
    }

    public ArrayList<Msg> getInbox(){
       ArrayList<Msg> output = new ArrayList<>();
       for(int i = inbox.size() - this.contNaoLidos; i < inbox.size(); i++){
           output.add(inbox.get(i));
       }
       contNaoLidos = 0;
       return output;
    }
    /*
    public boolean equals(Object obj){
        if(obj instanceof Usuario){
            return id.equals(((Usuario)obj).id);
        }
        return false;
    }
    */
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setInbox(ArrayList<Msg> inbox) {
        this.inbox = inbox;
    }

    
}
