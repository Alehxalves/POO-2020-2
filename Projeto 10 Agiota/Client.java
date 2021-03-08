public class Client {
    private String codename;
    private float limite;
    private float balance;

    public Client(String codename, float limite){
        setCodename(codename);
        setLimite(limite);
        setBalance(0.0f);
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public float getLimite() {
        return limite;
    }

    public void setLimite(float limite) {
        this.limite = limite;
    }

    public float getBalance() {
        return balance;
    }

    public void setBalance(float value) {
        this.balance = getBalance() + value;
    }
    
    public String toString(){
        return getCodename() + " : " + getBalance() + "/" + getLimite();
    }
}
