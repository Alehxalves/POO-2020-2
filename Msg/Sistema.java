import java.util.ArrayList;

public class Sistema {
    private ArrayList<Usuario> users;
    private int idNextMsg = 0;

    public Sistema(){
        users = new ArrayList<>();
    }

    public void addUser(String username){
        /*
        if(users.contains(new Usuario(username))){
            System.out.println("Username já existe");
        }
        */
        if(this.getUser(username) != null){
            System.out.println("Username já existe");
            return;
        }
        users.add(new Usuario(username));
    }

    public Usuario getUser(String username){
        for(Usuario user : users)
            if(user.getId().equals(username))
                return user;     
        return null;
    }

    public void sendMsg(String sender, String receiver, String text){
        Usuario one = this.getUser(sender);
        Usuario two = this.getUser(receiver);
        if(one == null){
            System.out.println("Usuário " + sender + " inválido");
            return;
        }
        if(two == null){
            System.out.println("Usuário " + receiver + " inválido");
            return;
        }
        one.sendMsg(idNextMsg,two, text);
        idNextMsg++;
    }

    public ArrayList<Msg> readMsgs(String username){
        Usuario one = this.getUser(username);
        if(one == null){
            System.out.println("Usuário " + username + " inválido");
            return new ArrayList<>();
        }
        return one.getInbox();
    }

    public ArrayList<Usuario> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<Usuario> users) {
        this.users = users;
    }
}
