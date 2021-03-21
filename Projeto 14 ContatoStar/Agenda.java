import java.util.*;

public class Agenda{
    private TreeMap<String, Contato> contatos;

    public Agenda(){
        contatos = new TreeMap<>();
    }
    public void addContact(Contato contato){
        if(contatos.containsKey(contato.getName()))
            throw new RuntimeException("fail: contato ja existente");
        contatos.put(contato.getName(), contato);
    }
    public ArrayList<Contato> search(String pattern){
        ArrayList<Contato> search = new ArrayList<>();
        boolean isNumber = Fone.isValid(pattern);
        if(isNumber){
            for(Contato contato : contatos.values())
                for(Fone fone : contato.getFones())
                    if(fone.number.indexOf(pattern) != -1)
                        search.add(contato);
            return search;
        }
        for(Contato contato : contatos.values())
            if(contato.getName().indexOf(pattern) != -1)
                search.add(contato);
        return search;
    }
    public void rmContact(String name){
        if(contatos.containsKey(name))
            contatos.remove(name);
        else
            throw new RuntimeException("fail: este contato nao esta na agenda");
    }
    public ArrayList<Contato> getContacts(){
        ArrayList<Contato> contacts = new ArrayList<>();
        for(Contato contato : contatos.values())
            contacts.add(contato);
        return contacts;
    }
    public Contato getContact(String name){
        if(contatos.containsKey(name))
            return contatos.get(name);
        return null;
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        for(Contato contato : contatos.values()){
            saida.append(contato.toString());
        }
        return saida.toString();
    }
}