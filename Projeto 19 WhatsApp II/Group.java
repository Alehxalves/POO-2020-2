public class Group extends Chat{

    public Group(String id, User user){
        setChatId(id);
        addUserChat(user);
    }
    @Override
    void addByInvite(User invite, User guest){
        if(!hasUser(invite.getId()))
            throw new RuntimeException("fail: usuario " + invite.getId() + " nao conhece o group " + getChatId());
        if(hasUser(guest.getId()))
            throw new RuntimeException("fail: usuario " + invite.getId() + " ja conhece o group " + getChatId());
        addUserChat(guest);
    } 
    
}
