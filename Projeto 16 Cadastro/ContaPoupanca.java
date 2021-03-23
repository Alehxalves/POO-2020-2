public class ContaPoupanca extends Conta{
    protected float rendimento;

    ContaPoupanca(int id, String idCliente){
        super(id, idCliente);
        rendimento = 0;
    }
    public float getRendimento(){
        float value = (float)(this.getSaldo() * 0.01);
        return value;
    }
    @Override
    public void atualizacaoMensal(){
        setSaldo(getRendimento());
    }
    @Override
    public String getType(){
        return "CP";
    }
}