import java.util.*;

public class AgendaPlus extends Agenda implements BrookmarkIF{
    private TreeMap<String, ContatoPlus> brookmarks;

    public AgendaPlus(){
        brookmarks = new TreeMap<>();
    }
    public static void main(String[] args){
        AgendaPlus agenda = new AgendaPlus();
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try{
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addContact")){ // inserir oo numeros assim: label:number,
                    ArrayList<Fone> fones = new ArrayList<>();
                    for(int i = 2; i < ui.length; i++){
                        fones.add(new Fone(ui[i]));
                    }
                    agenda.addContact(new ContatoPlus(ui[1], fones));
                }else if(ui[0].equals("rmContact")){
                    agenda.rmContact(ui[1]);
                }else if(ui[0].equals("star")){
                    agenda.brookmark(ui[1]);
                }else if(ui[0].equals("unstar")){
                    agenda.unBrookmark(ui[1]);
                }else if(ui[0].equals("showFavs")){
                    for(ContatoPlus contato : agenda.brookmarks.values())
                        System.out.println(contato.toString());
                }else if(ui[0].equals("show")){
                    System.out.println(agenda);
                }else{
                    System.out.println("fail: comando invalido");
                }              
            }catch(IndexOutOfBoundsException e){
                System.out.println(e);
            }catch(RuntimeException e){
                System.out.println(e);
            }
        }
        scanner.close();
    }
    @Override
    public void rmContact(String name){
        super.rmContact(name);
        if(brookmarks.containsKey(name)){
            brookmarks.remove(name);
        }
    }
    @Override
    public String toString(){
        return super.toString();
    }
    @Override
    public void brookmark(String name){
        if(this.getContact(name) == null)
            throw new RuntimeException("fail: contato nao existe");
        if(this.getContact(name) instanceof ContatoPlus){
            ContatoPlus contato = (ContatoPlus)getContact(name);
            contato.setBrookmark(true);
            if(brookmarks.containsKey(name))
                return;
            brookmarks.put(name, contato);
        }
    }
    @Override
    public void unBrookmark(String name) {
        if(this.getContact(name) == null)
            throw new RuntimeException("fail: contato nao existe");
        if(brookmarks.containsKey(name)){
            ContatoPlus contato = (ContatoPlus)getContact(name);
            contato.setBrookmark(false);
            brookmarks.remove(name);
            return;
        }
        throw new RuntimeException("fail: contato nao esta na brookmark");
    }
    @Override
    public ArrayList<ContatoPlus> getBrookmarks(){
        ArrayList<ContatoPlus> contatosBrookmarks = new ArrayList<>();
        for(ContatoPlus contato : brookmarks.values())
            contatosBrookmarks.add(contato);
        return contatosBrookmarks;
    }
}
