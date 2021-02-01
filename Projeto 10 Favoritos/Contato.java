import java.util.ArrayList;

public class Contato{
    private String name;
    private ArrayList<Fone> fones;
    private boolean favorito;

    public Contato(String name){
        this.name = name;
        this.favorito = false;
        fones = new ArrayList<>();

    }

    public void addFone(String label, String number){
        if(!Fone.isValid(number)){
            System.out.println("Número inválido");
            return;
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

    public boolean isFavorito(){
        return this.favorito;
    }

    public void setFavorito(boolean bool){
        this.favorito = bool;
    }

    public String toString(){
        String saida = "";
        if(this.isFavorito()){
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
