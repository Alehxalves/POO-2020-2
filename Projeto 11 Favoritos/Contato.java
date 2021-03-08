import java.util.ArrayList;

public class Contato{
    private String name;
    private ArrayList<Fone> fones;
    private boolean starred;

    public Contato(String name){
        this.name = name;
        this.starred = false;
        fones = new ArrayList<>();

    }

    public void addFone(String label, String number){
        if(!Fone.isValid(number)){
            System.out.println("Número inválido");
            return;
        }
        for(Fone fone : this.fones){
            if(fone.label.equals(label)){
                fone.number = number;
                return;
            }
        }
        fones.add(new Fone(label, number));
    }
    
    public void rmFone(int index){
        if(index < 0 || fones.size() == 0){
            System.out.println("Error");
            return;
        }
        fones.remove(index);
    }

    public void rm(String label){
        for(int i = 0; i < fones.size(); i++){
            if(fones.get(i).label.equals(label)){
                fones.remove(i);
                return;
            }
        }
        System.out.println("Label inválido");  
    }

    public String getName(){
        return this.name;
    }

    public ArrayList<Fone> getFones(){
        return fones;
    }

    public boolean isStarred(){
        return this.starred;
    }

    public void setStarred(boolean bool){
        this.starred = bool;
    }

    public String toString(){
        String saida = "";
        if(this.isStarred()){
            saida += "@ " + name + " ";
        }else{
            saida += "- " + name + " ";
        }
        for(int i = 0; i < fones.size(); i++){
            Fone tel = fones.get(i);
            saida += "[" + i + ":" + tel + "]" + " ";
        }
        return saida;
    }
}
