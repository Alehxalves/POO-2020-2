import java.util.ArrayList;
import java.util.List;

public class Cliente{
    protected String id;
    protected List<Conta> contas;

    Cliente(String id){
        setId(id);
        contas = new ArrayList<>();
    }
    public String getId(){
        return id;
    }
    private void setId(String id){
        this.id = id;
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append("Cliente: " + getId() +"\n");
        for(Conta conta : contas){
            saida.append(conta.toString() + "\n");
        }
        saida.deleteCharAt(saida.lastIndexOf("\n"));
        return saida.toString();
    }
}
