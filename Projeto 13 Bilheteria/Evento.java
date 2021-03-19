import java.util.TreeMap;

public class Evento {   
    private String id;
    TreeMap<String, Setor> repSetores;

    public Evento(String id){
        this.id = id;
        repSetores = new TreeMap<>();
    }

    public void addSetor(Setor setor){
        if(this.repSetores.containsKey(setor.getId())){
            throw new RuntimeException("fail: este setor já existe.");
        }
        repSetores.put(setor.getId(), new Setor(setor.getId(), setor.getPreco(), setor.getCapacidade()));
    }

    public String getId(){
        return this.id;
    }

    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append(id + "\n");
        for(Setor setor : repSetores.values()){
            saida.append("[ " + setor.toString() + " ]" + "\n");
        }
        return saida.toString();
    }
}
