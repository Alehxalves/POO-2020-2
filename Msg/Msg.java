public class Msg{
    int id_user;
    String sender;
    String text;

    public Msg(int id_user, String sender, String text){
        this.sender = sender;
        this.text = text;
        this.id_user = id_user;
    }
    
    public String toString(){
        return "" + id_user + ":" + sender + ":" + text;
    }
}