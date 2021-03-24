import java.util.Collection;

interface IPaciente{
    String getId();
    void addMedico(IMedico medico);
    void removerMedico(String idMedico);
    Collection<IMedico> getMedicos();
    boolean isMyDoctor(String id);
    String getDiagnostico();
    String toString();
}
