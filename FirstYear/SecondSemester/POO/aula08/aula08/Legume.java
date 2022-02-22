package aula08;

public class Legume extends Alimento implements Vegetariano{
    private String nome;

    public Legume(double proteinas, double calorias, double peso, String nome){
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
        return "Legume | " + super.toString() + " | Nome: " + nome;
    }

    public boolean equals(Legume leg1){
        if (super.equals(leg1) && nome.equals(leg1.getNome())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + nome.hashCode();
    }
}
