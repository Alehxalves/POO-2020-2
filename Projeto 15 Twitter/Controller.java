import java.util.*;

public class Controller{
    private TreeMap<String, User> users;
    private TreeMap<Integer, Tweet> tweets;
    public static int nextTwId;

    public Controller(){
        users = new TreeMap<>();
        tweets = new TreeMap<>();
        nextTwId = 0;
    }
    public void sendTweet(String username, String msg){
        if(!users.containsKey(username)){
            throw new RuntimeException("fail: usuario nao encontrado");
        }
        Tweet tweet = new Tweet(nextTwId, username, msg);;
        tweets.put(nextTwId, tweet);
        users.get(username).sendTweet(tweet);
        nextTwId++;
    }
    public void addUser(String username){
        if(users.containsKey(username)){
            throw new RuntimeException("fail: usuario ja existe");
        }
        users.put(username, new User(username));
    }
    public User getUser(String username){
        if(users.containsKey(username))
            return users.get(username);
        throw new RuntimeException("fail: usuario nao existe");
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(User user : users.values())
            saida.append(user.toString() + "\n");
        return saida.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Controller sistema = new Controller();
      
        while(true){
            String line = scanner.nextLine();
            String ui[] = line.split(" ");
            try{
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addUser")){
                    sistema.addUser(ui[1]);
                }else if(ui[0].equals("show")){
                    System.out.print(sistema);
                }else if(ui[0].equals("follow")){
                    User one = sistema.getUser(ui[1]);
                    User two = sistema.getUser(ui[2]);
                    one.follow(two);
                }else if(ui[0].equals("twittar")){
                    String username = ui[1];
                    String msg = "";
                    for(int i = 2; i < ui.length; i++)
                        msg += ui[i] + " ";
                    sistema.sendTweet(username, msg);
                }else if(ui[0].equals("timeline")){
                    User user = sistema.getUser(ui[1]);
                    System.out.print(user.getTimeLine());
                }else if(ui[0].equals("like")) {
                    User user = sistema.getUser(ui[1]);
                    Tweet tw = user.getTweet(Integer.parseInt(ui[2]));
                    tw.like(ui[1]);
                }else if(ui[0].equals("unfollow")){
                    User user = sistema.getUser(ui[1]);
                    user.unFollow(ui[2]);
                }else{
                    System.out.println("fail: comando invalido");
                }
            }catch(RuntimeException msg){
                System.out.println(msg);
            }
        }
        scanner.close();
    }
}
