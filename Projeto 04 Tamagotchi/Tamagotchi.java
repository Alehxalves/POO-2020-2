import java.util.Scanner;
import java.util.Random;

class Pet{
    private int energy;
    private int hungry;
    private int clean;
    private int energyMax;
    private int hungryMax;
    private int cleanMax;
    private int age;
    private int diamonds;
    private boolean alive;
    private int ev;

    Random gerador = new Random();
    public Pet(int energyMax, int hungryMax, int cleanMax){
        this.energy = energyMax;
        this.energyMax = energyMax;
        this.hungry = hungryMax;
        this.hungryMax = hungryMax;
        this.clean = cleanMax;
        this.cleanMax = cleanMax;
        this.alive = true;
        this.age = 0;
        this.diamonds = 0;
        this.ev = 0;
    }
    public String toString(){
        return "Energy:" + energy + "/" + energyMax + " Saciedade:" + hungry + "/" + hungryMax + 
        " Limpeza:" + clean + "/" + cleanMax + " Idade:" + age + " Diamonds:" + diamonds;
    }

    private void setEnergy(int value){
        this.energy = energy + value;
        if(this.energy > energyMax){
            System.out.println("Seu pet está totalmente descansado");
            this.energy = energyMax;
            return;
        }
        if(energy <= 0){
            this.energy = 0;
            System.out.println("Seu pet morreu de cansaço.");
            this.isAlive();
        }
    }
    private void setHungry(int value){
        this.hungry = hungry + value;
        if(this.hungry > hungryMax){
            System.out.println("O pet está de barriga cheia");
            this.hungry = hungryMax;
            return;
        }
        if(hungry <= 0){
            this.hungry = 0;
            System.out.println("Seu pet morreu de fome.");
            this.isAlive();
        }
    }
    private void setClean(int value){
        this.clean = clean + value;
        if(clean > cleanMax){
            System.out.println("O pet ta todo limpinho.");
            this.clean = cleanMax;
            return;
        }
        if(clean <= 0){
            this.clean = 0;
            System.out.println("Seu pet morreu de sujeira.");
            this.isAlive();
        }
    }

    public boolean isAlive(){
        if(this.energy > 0 && this.hungry > 0 && this.clean > 0){
            return true;
        }
        return false;
    }
    public void play(){
        if(!this.isAlive()){
            System.out.println("Seu pet está morto!.");
            return;
        }
        setEnergy(-2);
        setHungry(-1);
        setClean(-3);
        age++;
        diamonds++;
    }
    public void eat(){
        if(!this.isAlive()){
            System.out.println("Seu pet está morto!.");
            return;
        }
        setEnergy(-1);
        setHungry(4);
        setClean(-2);
        age++;

    }
    public void shower(){
        if(!this.isAlive()){
            System.out.println("Seu pet está morto!.");
            return;
        }
        setEnergy(-3);
        setHungry(-1);
        setClean(cleanMax);
        age ++;
    }
    public void sleep(){
        if(!this.isAlive()){
            System.out.println("Seu pet está morto!.");
            return;
        }
        if(this.energy < energyMax)
            for(int i = energy; i < energyMax; i++){
                setEnergy(1);
                age++;
        }
        else
            System.out.println("Seu pet não quer dormir");
    }
    public void evoluir(){
        if(!this.isAlive()){
            System.out.println("Seu pet está morto!.");
            return;
        }
        if(diamonds >= 10 && this.ev == 0){
            this.energyMax += gerador.nextInt(10) + 5;
            this.energy = energyMax;
            this.hungryMax += gerador.nextInt(8) + 4;
            this.hungry = hungryMax;
            this.cleanMax += gerador.nextInt(10) + 2;
            this.clean = cleanMax;
            diamonds = 0;
            System.out.println("Seu pet evoluiu para...");
            
            ev = gerador.nextInt(2);
            if(ev == 0)
                System.out.println("Tiranossauro Rex");
            else if(ev == 1)
                System.out.println("Tricerátops");
            else if(ev == 2)
                System.out.println("Velociraptor");
            ev = 1;
            return;

        }
        System.out.println("Não foi possivel evoluir seu pet.");
    }
}

public class Tamagotchi{
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random gerador = new Random();

        Pet pet = new Pet(gerador.nextInt(20) + 10, gerador.nextInt(15) + 8, gerador.nextInt(18) + 10);

        while(true){
            String ui = scanner.nextLine();
            if(ui.equals("end")){
                break;
            }else if(ui.equals("show")){
                System.out.println(pet);
            }else if(ui.equals("play")){
                pet.play();
            }else if(ui.equals("eat")){
                pet.eat();
            }else if(ui.equals("shower")){
                pet.shower();
            }else if(ui.equals("sleep")){
                pet.sleep();
            }else if(ui.equals("evoluir")){
                pet.evoluir();
            }else
                System.out.println("Comando inválido.");
        }
        scanner.close();
    }
}