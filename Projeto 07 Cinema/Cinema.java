import java.util.ArrayList;

public class Cinema{

    private ArrayList<Cliente> cliente;

    public Cinema(int size){

        this.cliente = new ArrayList<Cliente>();

        for(int i = 0; i < size; i++){
            cliente.add(i, new Cliente(null, null));
        }    
    }

    public void reservar(String id, String fone, int indice){
        if(indice < 0 || indice > cliente.size() - 1){
            System.out.println("Assento indisponível.");
            return;
        }
        if(cliente.get(indice).id == null){
            cliente.set(indice, new Cliente(id + ":", fone));
        }else
            System.out.println("Este assento já está ocupado.");

    }

    public boolean cancelar(int indice){
        if(indice < 0 || indice > cliente.size() - 1){
            System.out.println("Assento indisponível.");
            return false;
        }
        if(cliente.get(indice).id != null){
            System.out.println("Reserva cancelada.");
            cliente.set(indice, new Cliente(null, null));
            return true;
        }else
            System.out.println("Assento já está vago, não foi possível cancelar.");
            return false;
    }

    public String toString(){  
        String saida = "[ ";
        for(int i = 0; i < cliente.size(); i++){
            if(this.cliente.get(i).id == null){
                saida += "- ";
            }else
                saida += cliente.get(i).id + cliente.get(i).fone + " ";
        }
        saida += "]";
        return saida;
    }

}