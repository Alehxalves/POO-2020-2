public abstract class Conta{
    protected int id;
    protected float saldo;
    protected String idCliente;
    protected String type;

    Conta(int id, String idCliente){
        this.id = id;
        this.idCliente = idCliente;
        setSaldo(0);
    }
    public void sacar(float value){
        if(getSaldo() < value)
            throw new RuntimeException("fail: saldo insuficiente");
        setSaldo(-value);
    }
    public void depositar(float value){
        if(value <= 0)
            throw new RuntimeException("fail: valor invalido");
        setSaldo(value);
    }
    public void transferir(Conta other, float value){
        if(this.getSaldo() < value)
            throw new RuntimeException("fail: saldo insuficiente");
        other.depositar(value);
        this.setSaldo(-value);
    }
    abstract void atualizacaoMensal();
    public int getId(){
        return id;
    }
    public float getSaldo(){
        return saldo;
    }
    protected void setSaldo(float value){
        this.saldo = (getSaldo() + value);
    }
    public String getIdCliente(){
        return idCliente;
    }
    public String getType(){
        return type;
    }
    public String toString(){
        StringBuilder saida = new StringBuilder();
        saida.append("ID:" + getId() + " Cliente:" + getIdCliente() + " Saldo:" + getSaldo()+ "R$" + " Conta:" + getType());
        return saida.toString();
    }
}