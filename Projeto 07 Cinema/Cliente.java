public class Cliente {
    
    public String id;
    public String fone;

    public Cliente(String id, String fone){
        this.id = id;
        this.fone = fone;
    }

    public String toString(){

        return this.id + this.fone;
    }

}
