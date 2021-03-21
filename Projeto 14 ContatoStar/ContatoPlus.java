import java.util.ArrayList;

public class ContatoPlus extends Contato{
    private boolean starred;

    public ContatoPlus(String name, ArrayList<Fone> fones){
        super(name, fones);
        this.starred = false;
    }
    public boolean isStarred(){
        return this.starred;
    }
    public void setBrookmark(boolean value){
        this.starred = value;
    }
    @Override
    public String toString() {
        if(this.isStarred())
            return "@ " + super.toString();
        return "- " + super.toString();
    }
}
