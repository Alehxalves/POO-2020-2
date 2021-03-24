import java.util.*;

public class Hospital {
    private TreeMap<String, IPaciente> pacientes;
    private TreeMap<String, IMedico> medicos;

    Hospital(){
        pacientes = new TreeMap<>();
        medicos = new TreeMap<>();
    }
    public void addPaciente(Paciente paciente){
        if(pacientes.containsKey(paciente.getId()))
            throw new RuntimeException("fail: este paciente ja esta no hospital");
        pacientes.put(paciente.getId(), paciente);
    }
    public void addMedico(Medico medico){
        if(medicos.containsKey(medico.getId()))
            throw new RuntimeException("fail: este medico ja trabalha no hospital");
        medicos.put(medico.getId(), medico);
    }
    public void vincular(String idMedico, String idPaciente){
        if(!medicos.containsKey(idMedico))
            throw new RuntimeException("fail: medico nao encontrado");
        if(!pacientes.containsKey(idPaciente))
            throw new RuntimeException("fail: paciente nao encontrado");
        IMedico m = medicos.get(idMedico);
        IPaciente p = pacientes.get(idPaciente);
        for(IMedico medico : p.getMedicos()){
            if(medico.getEspec().equals(m.getEspec()))
                throw new RuntimeException("fail: esse paciente ja possui um medico com essa especialidade");
        }
        p.addMedico(m);
        m.addPaciente(p);
    }
    public void removerPaciente(String idPaciente){
        if(!pacientes.containsKey(idPaciente))
            throw new RuntimeException("fail: este paciente nao esta no hospital");
        for(IMedico medico : medicos.values())
            medico.removerPaciente(idPaciente);
        pacientes.remove(idPaciente);
    }
    public void removerMedico(String idMedico){
        if(!medicos.containsKey(idMedico))
            throw new RuntimeException("fail: este paciente nao esta no hospital");
        for(IPaciente paciente : pacientes.values())
            paciente.removerMedico(idMedico);
        medicos.remove(idMedico);
    }
    public IMedico getMed(String idMedico){
        if(medicos.containsKey(idMedico))
            return medicos.get(idMedico);
        return null;
    }
    public IPaciente getPac(String idPaciente){
        if(pacientes.containsKey(idPaciente))
            return pacientes.get(idPaciente);
        return null;
    }
    public String showAll(){
        StringBuilder saida = new StringBuilder();
        for(IPaciente paciente : pacientes.values())
            saida.append(paciente.toString() + "\n");
        for(IMedico medico : medicos.values())
            saida.append(medico.toString() + "\n");
        if(saida.lastIndexOf("\n") != -1)
            saida.deleteCharAt(saida.lastIndexOf("\n"));
        return saida.toString();
    }
}