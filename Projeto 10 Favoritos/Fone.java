public class Fone {
    String label;
    String number;

    public Fone(String serial){
        String[] token = serial.split(":");
        this.label = token[0];
        this.number = token[1];
    }

    public Fone(String label, String number){
        this.label = label;
        this.number = number;
    }

    public boolean equals(String label){
        if(this.label.equals(label)){
            return true;
        }
        return false;
    }

    public static boolean isValid(String number){
        String str = ".()0123456789";
        for(int i = 0; i < number.length(); i++){
            if(str.indexOf(number.charAt(i)) == -1){
                return false;
            }
        }
        return true;
    }

    public String toString(){
        return  label + ":" + number;
    }
}  
