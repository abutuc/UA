package aula07;
public class Alojamento {
    private String codigo;
    private String nome;
    private String local;
    private double preco_noite;
    private boolean disponibilidade;
    private double avaliacao;

    public Alojamento(String codigo, String nome, String local){
        this.codigo = codigo;
        this.nome = nome;
        this.local = local;

    }

    public void setPrecoNoite(double preco_noite){
        this.preco_noite = preco_noite;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public void setAvaliação(double avaliacao){
        if(avaliacao >= 1.0 && avaliacao <= 5.0){
            this.avaliacao = avaliacao;
        }
    }

    public void setCodigo(String codigo){
        this.codigo = codigo;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setLocal(String local){
        this.local = local;
    }

    public String getCodigo(){
        return codigo;
    }

    public String getNome(){
        return nome;
    }

    public String getLocal(){
        return local;
    }

    public double getPrecoNoite(){
        return preco_noite;
    }

    public boolean getDisponibilidade(){
        return disponibilidade;
    }

    public double getAvaliacao(){
        return avaliacao;
    }

    public String toString(){
        String disponivel;
        if(getDisponibilidade()){
            disponivel = "Disponível";
        }
        else{
            disponivel = "Indisponível";
        }
        return codigo + " | " + nome + " | " + local + " | " + preco_noite + "€ | " + disponivel + " | " + avaliacao + "/5.0";
    }

    public boolean equals(Alojamento alojamento2){
        if(codigo.equals(alojamento2.getCodigo())){
            return true;
        }
        else{
            return false;
        }
    }

    public int hashCode(){
        return codigo.hashCode() + nome.hashCode() + local.hashCode();
    }

    public void checkIn(){
        disponibilidade = false;
    }

    public void checkOut(double avaliacao){
        if (avaliacao < this.avaliacao){
            this.avaliacao -= Math.round(avaliacao*0.10*100.0)/100.0;
        }
        else if (avaliacao > this.avaliacao){
            this.avaliacao += Math.round(avaliacao*0.07*100.0)/100.0 ;
        }
        
        disponibilidade = true;
    }
}
