import java.util.ArrayList;

public class Topic{

    public ArrayList<Pass> cadeiras;
    public int qtdPref;

    public Topic(int lotacao, int qtdPref){

        this.qtdPref = qtdPref;
        cadeiras = new ArrayList<Pass>();

        for(int i = 0; i < lotacao; i++){
            cadeiras.add(null);
        }
    }

    public boolean subir(Pass pass){
        if(pass.getIdade() <= 0 || pass.getIdade() > 150){
            System.out.println("?");
            return false;
        }
        // Verificar se a pessoa já está na topic
        for(Pass pessoa : cadeiras){
            if(pessoa != null && pessoa.getNome().equals(pass.getNome())){
                System.out.println(pessoa.getNome() + " já está na topic!");
                return false;
            }
        }
        // Pessoa idosa.
        if(pass.getIdade() >=65){ 
            // Cadeiras preferenciais
            for(int i = 0; i < qtdPref; i++){
                if(cadeiras.get(i) == null){
                    cadeiras.set(i, pass);
                    System.out.println(pass.getNome() + " subiu no ônibus.");
                    return true;
                }
            }
            //caso não houver cadeiras preferenciais    
            for(int i = qtdPref; i < cadeiras.size(); i++){
                if(cadeiras.get(i) == null){
                    cadeiras.set(i, pass);
                    System.out.println(pass.getNome() + " subiu no ônibus.");
                    return true;
                }
            }
            System.out.println("A topic está lotada!");
            return false;
        }else
            // Pessoa jovem/adulta.
            // Cadeiras não preferenciais.
            for(int i = qtdPref; i < cadeiras.size(); i++){
                if(cadeiras.get(i) == null){
                    cadeiras.set(i, pass);
                    System.out.println(pass.getNome() + " subiu no ônibus.");
                    return true;
                }
            }
            // Cadeiras preferenciais.
            for(int i = 0; i < qtdPref; i++){
                if(cadeiras.get(i) == null){
                    cadeiras.set(i, pass);
                    System.out.println(pass.getNome() + " subiu no ônibus.");
                    return true;
                }
            }
            System.out.println("A topic está lotada!");
            return false;
    }

    public void descer(String nome){
        for(int i = 0; i < cadeiras.size(); i++){
            if(cadeiras.get(i) != null && cadeiras.get(i).getNome().equals(nome)){
                cadeiras.set(i, null);
                System.out.println(nome + " desceu do ônibus.");
                return;
            }
        }
        System.out.println(nome + " não está na topic");

    }

    public String toString(){
        String saida = "[ ";
         // Cadeiras preferenciais.
        for(int i = 0; i < this.qtdPref; i++){
            if(cadeiras.get(i) == null){
                saida += "@ ";
                continue;
            }
            saida += cadeiras.get(i).getNome() + ":" + cadeiras.get(i).getIdade() + " ";
        }
        // Cadeiras normais.
        for(int i = this.qtdPref; i < cadeiras.size(); i++){
            if(cadeiras.get(i) == null){
                saida += "= ";
                continue;
            }
            saida += cadeiras.get(i).getNome() + ":" + cadeiras.get(i).getIdade() + " ";
        }
        saida += "]";
        return saida;
    }

}