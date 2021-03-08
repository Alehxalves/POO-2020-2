import java.util.*;

public class Agenda{
    private TreeMap<String, Contato> contatos;
    private TreeMap<String, Contato> brookmarks;

    public Agenda(){
        contatos = new TreeMap<>();
        brookmarks = new TreeMap<>();
    }

    public void addContact(String name, List<Fone> fones){
        if(contatos.containsKey(name)){
            System.out.println("Fail: Este contato já está na agenda.");
            return;
        }
        contatos.put(name, new Contato(name));
        for(Fone fone : fones){
            contatos.get(name).addFone(fone.label, fone.number);
        }
    }
    
    public void rmContact(String name){
        if(contatos.containsKey(name)){
            System.out.println("Contato removido.");
            contatos.remove(name);

        }else
            System.out.println("Fail: Este contato já está na agenda.");
    }

    public Contato getContact(String name){
        if(contatos.containsKey(name)){
            return contatos.get(name);
        }
        return null;
    }

    public void brookmark(String name){
        if(getContact(name) == null){
            System.out.println("Impossível favoritar, contato não existente.");
            return;
        }
        contatos.get(name).setStarred(true);
        brookmarks.put(name, getContact(name));
    }

    public void unBrookmark(String name){
        if(brookmarks.containsKey(name)){
            contatos.get(name).setStarred(false);
            brookmarks.remove(name);
            return;
        }else{
            System.out.println("Este contato não existe.");
            return;
        }
    }

    public ArrayList<Contato> getBrookmarks(){
        ArrayList<Contato> starred = new ArrayList<>();
        for(Contato contato : brookmarks.values()){
            starred.add(contato);
        }
        return starred;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(Contato contato : contatos.values()){
            saida.append(contato + "\n");
        }
        return saida.toString();
    }

    public static void main(String[] args) {
        Agenda agenda = new Agenda();
        agenda.addContact("eva", Arrays.asList(new Fone("oio", "8585"), new Fone("cla", "9999")));
        agenda.addContact("ana", Arrays.asList(new Fone("Tim", "3434")));
        agenda.addContact("bia", Arrays.asList(new Fone("viv", "5454")));
        agenda.addContact("ana", Arrays.asList(new Fone("cas", "4567"), new Fone("oio", "8754")));
        agenda.contatos.get("ana").addFone("Casa", "997102240");
        System.out.println(agenda);
        agenda.brookmark("bia");
        agenda.brookmark("ana");
        System.out.println(agenda);
        for(Contato fav : agenda.getBrookmarks()){
            System.out.println(fav);
        }
        System.out.println("\n");
        agenda.unBrookmark("ana");
        agenda.rmContact("eva");
        System.out.println(agenda);
    }
}