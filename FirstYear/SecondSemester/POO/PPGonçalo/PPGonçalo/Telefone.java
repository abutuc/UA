package PPGonçalo;

public class Telefone extends Pacote {
    private String tarifário;

    public Telefone(String nome, double taxa, double preco_mensal, String tarifario){
        super(nome, taxa, preco_mensal);
        this.tarifário = tarifario;
    }

    public String getTarifário() {
        return tarifário;
    }

    public void setTarifário(String tarifário) {
        this.tarifário = tarifário;
    }

    public String toString(){
        return " Telefone | " + tarifário + " | Pacote Especializado";
    }

    public boolean equals(Telefone t1){
        if (super.equals(t1) && tarifário.equals(t1.getNome())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + tarifário.hashCode();
    }
}
