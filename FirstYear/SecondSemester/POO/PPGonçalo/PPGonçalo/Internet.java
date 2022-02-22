package PPGonçalo;

public class Internet extends Pacote {
    
    private String largura_banda;
    private int limite_trafego;
    
    public Internet(String nome, double taxa, double preco_mensal, String largura_banda, int limite_trafego){
        super(nome, taxa, preco_mensal);
        this.largura_banda = largura_banda;
        this.limite_trafego = limite_trafego;
    }

    public String getLargura_banda() {
        return largura_banda;
    }

    public void setLargura_banda(String largura_banda) {
        this.largura_banda = largura_banda;
    }

    public int getLimite_trafego() {
        return limite_trafego;
    }

    public void setLimite_trafego(int limite_trafego) {
        this.limite_trafego = limite_trafego;
    }

    
    public String toString(){
        return "Internet | " + " LarguraBanda: " + largura_banda + " | " + "LimiteTrafego: " + limite_trafego + "| Pacote Especializado"; 
    }

    public boolean equals(Internet i2){
        if (super.equals(i2) && largura_banda.equals(i2.getLargura_banda()) && limite_trafego==i2.getLimite_trafego()){
            return true;
        } 
        return false;
    }

    public int hashCode(){
        return super.hashCode() + largura_banda.hashCode() + limite_trafego;
    }
}

