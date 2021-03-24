import java.util.ArrayList;
import java.util.Collection;

public class Paciente implements IPaciente{
    private String id;
    private String diagnostico;
    private Collection<IMedico> medicos;

    Paciente(String id, String diagnostico){
        this.id = id;
        this.diagnostico = diagnostico;
        medicos = new ArrayList<>();
    }
    @Override
    public String getId(){
        return this.id;
    }
    @Override
    public void addMedico(IMedico medico){
        medicos.add(medico);
    }   
    @Override
    public void removerMedico(String idMedico){
        for(IMedico medico : medicos){
            if(medico.getId().equals(idMedico)){
                medicos.remove(medico);
                return;
            }
        }
        return;
    } 
    @Override
    public boolean isMyDoctor(String id) {
        for(IMedico medico : medicos){
            if(medico.getId().equals(id))
                return true;
        }
        return false;
    }    
    @Override
    public Collection<IMedico> getMedicos(){
        return medicos;
    }
    @Override
    public String getDiagnostico(){
        return this.diagnostico;
    }
    @Override
    public String toString() {
        String saida = "";
        saida = "Pac:" + getId() + "(" + getDiagnostico() + ")";
        saida = String.format("%-60s", saida);
        saida += ("Meds [ ");
        for(IMedico medico : medicos){
            saida += medico.getId() + " ";
        }
        saida += "]";
        return saida;
    }
}
