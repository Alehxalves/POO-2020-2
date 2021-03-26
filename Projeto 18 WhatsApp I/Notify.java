public class Notify {
    public String chatId;
    public int unreadCount;

    public Notify(Chat chat){
        this.chatId = chat.getId();
        unreadCount = 0;
    }
    public String getChatId(){
        return chatId;
    }
    public int getUnreadCount(){
        return this.unreadCount;
    }
    public void addCout(){
        unreadCount++;
    }
    public void rmNotify(){
        unreadCount = 0;
    }
}
