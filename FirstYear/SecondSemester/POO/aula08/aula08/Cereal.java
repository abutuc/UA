package aula08;

public class Cereal extends Alimento implements Vegetariano {
    private String nome;

    public Cereal(double proteinas, double calorias, double peso, String nome){
        super(proteinas, calorias, peso);
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String toString(){
        return "Cereal | " + super.toString() + " | Nome: " + nome;
    }

    public boolean equals(Cereal cer1){
        if (super.equals(cer1) && nome.equals(cer1.getNome())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + nome.hashCode();
    }
}
