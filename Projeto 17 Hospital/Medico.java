import java.util.ArrayList;
import java.util.Collection;

public class Medico implements IMedico{
    private String id;
    private String especialidade; 
    private Collection<IPaciente> pacientes;

    Medico(String id, String especialidade){
        this.id = id;
        this.especialidade = especialidade;
        pacientes = new ArrayList<>();
    }
    @Override
    public String getId(){
        return this.id;
    }
    @Override
    public void addPaciente(IPaciente paciente){
        pacientes.add(paciente);
    }
    @Override
    public void removerPaciente(String idPaciente){
        for(IPaciente paciente : pacientes){
            if(paciente.getId().equals(idPaciente)){
                pacientes.remove(paciente);
                return;
            }
        }
        return;
    }
    @Override
    public boolean isMyPacient(String id){
        for(IPaciente paciente : pacientes){
            if(paciente.getId().equals(id))
                return true;
        }
        return false;
    }
    @Override
    public Collection<IPaciente> getPacientes(){
        Collection<IPaciente> p = new ArrayList<>();
        p.addAll(pacientes);
        return p;
    }
    @Override
    public String getEspec(){
        return this.especialidade;
    }
    @Override
    public String toString() {
        String saida = "";
        saida = ("Med:" + getId() + "(" + getEspec()) + ")";
        saida = String.format("%-60s", saida);
        saida += ("Pacs [ ");
        for(IPaciente paciente : pacientes){
            saida += paciente.getId() + " ";
        }
        saida += "]";
        return saida;
    }

}
