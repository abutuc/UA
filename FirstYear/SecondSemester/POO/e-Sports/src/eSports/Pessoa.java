package eSports;

public abstract class Pessoa {
    private String nome;
    private int idade;

    protected Pessoa(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
    }

    protected Pessoa(String nome){
        this.nome = nome;
        this.idade = 0;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public String toString() {
        return nome;
    }

    public boolean equals(Pessoa p) {
        if (nome.equals(p.getNome()) && idade==p.getIdade()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + idade;
    }

}
