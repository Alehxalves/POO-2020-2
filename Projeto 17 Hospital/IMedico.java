import java.util.Collection;

interface IMedico {
    String getId();
    void addPaciente(IPaciente paciente);
    void removerPaciente(String paciente);
    Collection<IPaciente> getPacientes();
    boolean isMyPacient(String id);
    String getEspec();
    String toString();
}
