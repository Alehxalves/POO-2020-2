import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Hospital hospital = new Hospital();
        BatePapo chat = new BatePapo("hospital");
        Scanner scanner = new Scanner(System.in);
        while(true){
            String line = scanner.nextLine();
            String[] ui = line.split(" ");
            try{
                if(ui[0].equals("end")){
                    break;
                }else if(ui[0].equals("addPac")){
                    Paciente pac = new Paciente(ui[1], ui[2]);
                    hospital.addPaciente(pac);
                }else if(ui[0].equals("addMed")){
                    Medico med = new Medico(ui[1], ui[2]);
                    hospital.addMedico(med);
                }else if(ui[0].equals("vinc")){
                    hospital.vincular(ui[1], ui[2]);
                }else if(ui[0].equals("remPac")){
                    hospital.removerPaciente(ui[1]);
                }else if(ui[0].equals("remMed")){
                    hospital.removerMedico(ui[1]);
                }else if(ui[0].equals("show")){
                    System.out.println(hospital.showAll());
                }else if(ui[0].equals("msg")){
                    if(hospital.getMed(ui[1]) instanceof IMedico)
                        if(hospital.getMed(ui[1]).isMyPacient(ui[2])){
                            String msg = "";
                            for(int i = 3; i < ui.length; i++)
                                msg += ui[i] + " ";
                            chat.sendMessage(new Msg(ui[1], ui[2], msg), chat);
                        }else
                            throw new RuntimeException("fail: voce nao conhece " + ui[2]);
                    else if(hospital.getPac(ui[1]) instanceof IPaciente)
                        if(hospital.getPac(ui[1]).isMyDoctor(ui[2])){
                            String msg = "";
                            for(int i = 3; i < ui.length; i++)
                                msg += ui[i] + " ";
                            chat.sendMessage(new Msg(ui[1], ui[2], msg), chat);
                        }else
                            throw new RuntimeException("fail: voce nao conhece " + ui[2]);
                    else
                        throw new RuntimeException("fail: error" + ui[1] + "nao reconhecido no sistema");
                }else if(ui[0].equals("inbox")){
                    String saida = chat.toString(ui[1]);
                    System.out.println(saida);
                }else{
                    System.out.println("fail: comando invalido");
                } 
            }catch(RuntimeException e){
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}
