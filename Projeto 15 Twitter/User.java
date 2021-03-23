import java.util.TreeMap;

public class User{
    private String username;
    private TreeMap<String, User> followers;
    private TreeMap<String, User> following;
    private TreeMap<Integer,Tweet> timeline;
    private int unReadCount;

    public User(String username){
        this.username = username;
        followers = new TreeMap<>();
        following = new TreeMap<>();
        timeline = new TreeMap<>();
        unReadCount = 0;
    }
    public void follow(User user){
        if(following.containsKey(user.username))
            return;
        if(user.username.equals(this.username))
            return;
        following.put(user.username, user);
        user.followers.put(this.username, this);
    }
    public void unFollow(String username){
        if(!following.containsKey(username))
            return;
        User other = following.get(username);
        other.followers.remove(this.username);
        following.remove(username);
    }
    public Tweet getTweet(int idTw){
        if(!timeline.containsKey(idTw)){
            throw new RuntimeException("fail: tweet nao encontrado");
        }
        return timeline.get(idTw);
    }
    public void sendTweet(Tweet tweet){
        timeline.put(tweet.getIdTw(), tweet);
        unReadCount++;
        for(User user : followers.values()){
            user.timeline.put(tweet.getIdTw(), tweet);
            user.unReadCount++;
        }
    }
    public String getUnread(){
        StringBuilder saida = new StringBuilder();
        for(int i = timeline.size() - unReadCount; i < timeline.size(); i++){
            saida.append(timeline.get(i).toString() + "\n");
        }
        unReadCount = 0;
        return saida.toString();
    }
    public String getTimeLine(){
        StringBuilder saida = new StringBuilder();
        for(Tweet tweet : timeline.values())
            saida.append(tweet.toString() + "\n");
        unReadCount = 0;
        return saida.toString();
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append(username + "\n");
        saida.append("  following [");
        for(String follow : following.keySet()){
            saida.append(" " + follow);
        }
        saida.append(" ]\n");
        saida.append("  followers [");
        for(String follower : followers.keySet()){
            saida.append(" " + follower);
        }
        saida.append(" ]");
        return saida.toString();
    }
}
