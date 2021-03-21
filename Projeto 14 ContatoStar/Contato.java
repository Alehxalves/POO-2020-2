import java.util.ArrayList;

public class Contato{
    private String name;
    private ArrayList<Fone> fones;

    public Contato(String name, ArrayList<Fone> fone){
        this.name = name;
        this.fones = fone;

    }
    public void addFone(String label, String number){
        if(!Fone.isValid(number))
            return;
        for(Fone fone : this.fones){
            if(fone.label.equals(label)){
                fone.number = number;
                return;
            }
        }
        this.fones.add(new Fone(label, number));
    }
    public void rmFone(int index){
        if(index < 0 || fones.size() == 0){
            System.out.println("Error");
            return;
        }
        fones.remove(index);
    }
    public void rm(String label){
        for(int i = 0; i < fones.size(); i++)
            if(fones.get(i).label.equals(label)){
                fones.remove(i);
                return;
            }
        throw new RuntimeException("fail: label invalido");  
    }
    public String getName(){
        return this.name;
    }
    public ArrayList<Fone> getFones(){
        return fones;
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append(name + " [ ");
        for(int i = 0; i < this.fones.size(); i++){
            saida.append(i + ":" + this.fones.get(i).toString() + " ");
        }
        saida.append("]");
        return saida.toString();
    }
}
