public class ContaCorrente extends Conta{
    protected float tarifaMensal;

    ContaCorrente(int id, String idCliente){
        super(id, idCliente);
        this.tarifaMensal = 0;
    }
    public float getTarifaMensal(){
        return 20;
    }
    @Override
    public void atualizacaoMensal(){
        setSaldo(-getTarifaMensal());
    }
    @Override
    public String getType(){
        return "CC";
    }
}
