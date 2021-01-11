public class Cliente {
    
    public String id;
    public String fone;

    public Cliente(String id, String fone){
        setId(id);
        setFone(fone);
    }

    public String getId() {
        return id;
    }

    private void setId(String id) {
        this.id = id;
    }

    public String getFone() {
        return fone;
    }

    private void setFone(String fone) {
        this.fone = fone;
    }

    public String toString(){

        return getId() + getFone();
    }

}
