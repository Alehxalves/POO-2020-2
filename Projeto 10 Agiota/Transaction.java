public class Transaction {
    private int id;
    private String codename;
    private String type;
    private float value;

    public Transaction(int id, String codename, float value, String type){
        setId(id);
        setCodename(codename);
        setValue(value);
        setType(type);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodename() {
        return codename;
    }

    public void setCodename(String codename) {
        this.codename = codename;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }
    
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String toString(){
    return getId() + " : " + type + " : " + getCodename() + " : " +  getValue();
    }

}
