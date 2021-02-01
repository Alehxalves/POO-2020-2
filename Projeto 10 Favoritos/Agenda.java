import java.util.*;

class ComparatorContato implements Comparator<Contato>{

    @Override
    public int compare(Contato c1, Contato c2) {
        if(c1 == null)
            return -1;
        if(c2 == null)
            return -1;
        return c1.getName().compareTo(c2.getName());
    }

}

public class Agenda{
    private ArrayList<Contato> contatos;

    public Agenda(){
       contatos = new ArrayList<Contato>();

    }

    public int findContato(String name){
        for(int i = 0; i < contatos.size(); i++){
            if(contatos.get(i).getName().equals(name))
                return i;
        }
        return -1;

    }

    public void addContato(String name, ArrayList<Fone> fones){  
        int index = findContato(name); 
        boolean contem;      
        if(index == -1){
            contatos.add(new Contato(name));
            for(Fone fone : fones){
                contatos.get(findContato(name)).addFone(fone.label, fone.number);
            }
            Collections.sort(contatos, new ComparatorContato());
            return;
        }
        for(Fone fone : fones){
            contem = false;
            for(int i = 0; i < contatos.get(index).getFones().size(); i++){
                if(contatos.get(index).getFones().get(i).equals(fone.label)){
                    contatos.get(index).getFones().get(i).number = fone.number;
                    contem = true;
                    break;
                }
            }
            if(!contem)
                contatos.get(index).addFone(fone.label, fone.number);
        }
        Collections.sort(contatos, new ComparatorContato());
    }

    public void rmContato(String name){
        if(findContato(name) == -1)
            System.out.println("Este contato não está na agenda.");
        contatos.remove(findContato(name));
    }

    public ArrayList<Contato> search(String pattern){
        ArrayList<Contato> search = new ArrayList<>();
        boolean isValid = Fone.isValid(pattern);
        if(isValid){
            for(int i = 0; i < contatos.size(); i++){
                for(Fone fone : contatos.get(i).getFones()){
                    if(fone.number.indexOf(pattern) != -1){
                        search.add(contatos.get(i));
                    }
                }
            }
        }else{
            for(Contato contato : contatos){
                if(contato.getName().indexOf(pattern) != -1)
                    search.add(contato);
            }  
        }
        return search; 
    }

    public void brookmark(String name){
        int index = findContato(name);
        if(index == -1){
            System.out.println("Este contato não existe");
            return;
        }
        if(contatos.get(index).isFavorito()){
            return;
        }
        contatos.get(index).setFavorito(true);
    }

    public void unBrookmark(String name){
        int index = findContato(name);
        if(index == -1){
            System.out.println("Este contato não existe");
            return;
        }
        if(contatos.get(index).isFavorito()){
            contatos.get(index).setFavorito(false);
            return;
        }
        System.out.println("Este contato não está como favorito");
    }

    public ArrayList<Contato> getContatos(){
        return this.contatos;
    }

    public ArrayList<Contato> getBrookmarks(){
        ArrayList<Contato> getBrookmarks = new ArrayList<>();
        for(Contato contato : contatos){
            if(contato.isFavorito())
                getBrookmarks.add(contato);
        }
        return getBrookmarks;
    }

    public Contato getContato(String name){
        if(findContato(name) == -1){
            System.out.println("Este contato não está na agenda.");
            return null;
        }
        return contatos.get(findContato(name));
    }

    public String toString(){
        String saida = "";
        for(int i = 0; i < contatos.size(); i++){
            saida += contatos.get(i) + "\n";
        }
        return saida;
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.addContato("eva", new ArrayList<Fone>(Arrays.asList(new Fone("oio:8585"), 
                            new Fone("cla:9999"))));
        agenda.addContato("ana", new ArrayList<Fone>(Arrays.asList(new Fone("tim:3434"))));
        agenda.addContato("bia", new ArrayList<Fone>(Arrays.asList(new Fone("viv:5454")))); 
        agenda.addContato("ana", new ArrayList<Fone>(Arrays.asList(new Fone("cas:4567"),
                            new Fone("oio:8754"))));
                              
        agenda.getContato("ana").rmFone(0);                   
        System.out.println(agenda);
        agenda.rmContato("bia");
        System.out.println(agenda);
        agenda.addContato("ava", new ArrayList<Fone>(Arrays.asList(new Fone("tim:5454"))));
        agenda.addContato("rui", new ArrayList<Fone>(Arrays.asList(new Fone("viv:2222"),
        new Fone("oio:9991"))));
        agenda.addContato("zac", new ArrayList<Fone>(Arrays.asList(new Fone("rec:3131"))));

        System.out.println(agenda);
        for(Contato contato : agenda.search("va")){
            System.out.println(contato);
        }
        System.out.println("\n");
        for(Contato contato : agenda.search("999")){
            System.out.println(contato);
        }

        agenda.brookmark("ana");
        agenda.brookmark("zac");
        agenda.brookmark("eva");

        for(Contato contato : agenda.getBrookmarks()){
            System.out.println(contato);
        }
        System.out.println("\n");
        System.out.println(agenda);
    }

}