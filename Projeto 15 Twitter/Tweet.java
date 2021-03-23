import java.util.Iterator;
import java.util.TreeSet;

public class Tweet {
    private int idTw;
    private String username;
    private String msg;
    private TreeSet<String> likes;

    public Tweet(int id, String username, String msg){
        this.idTw = id;
        this.username = username;
        this.msg = msg;
        likes = new TreeSet<>();
    }
    public void like(String username){
        for(String user : likes)
            if(user.equals(username))
                return;
        likes.add(username);
    }
    public String toString(){
        Iterator<String> iterator = likes.iterator();
        StringBuilder saida = new StringBuilder();
        saida.append(getIdTw() + ":" + getUsername() + " (" + getMsg() + ") ");
        while(iterator.hasNext())
            saida.append(iterator.next() + " ");
        return saida.toString();
    }
}
