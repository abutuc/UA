package PPGonçalo;

public class Pacote {

    private static int id_temp = 1000;
    private String nome;
    private double taxa;
    private double preco_mensal;
    private int id;


    public Pacote(String nome, double taxa, double preco_mensal) {
        this.nome = nome;
        this.taxa = taxa;
        this.preco_mensal = preco_mensal;
        id = id_temp;
        id_temp++;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getTaxa() {
        return taxa;
    }


    public void setTaxa(double taxa) {
        this.taxa = taxa;
    }


    public double getPreco_mensal() {
        return preco_mensal;
    }


    public void setPreco_mensal(double preco_mensal) {
        this.preco_mensal = preco_mensal;
    }

    
    public int getId() {
        return id;
    }
    
    public String toString(){
        return "Pacote" + " | " + id + " | " + nome + " | " + taxa + " | " + preco_mensal + " | Básico";
    }

    public boolean equals(Pacote p2){
        if(nome.equals(p2.getNome()) && taxa==p2.getTaxa() && preco_mensal==p2.getPreco_mensal() && id==p2.getId()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return nome.hashCode() + (int) taxa + (int) preco_mensal + id;
    }
    
}