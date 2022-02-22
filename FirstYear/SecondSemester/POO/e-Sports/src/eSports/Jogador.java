package eSports;

public class Jogador extends Pessoa {
    private EModalidade modalidade;
    private String equipa;
    private int momentum;

    public Jogador(String nome,EModalidade modalidade, String equipa){
        super(nome);
        this.modalidade = modalidade;
        this.equipa = equipa;
        this.momentum = 50;
    }

    public Jogador(String nome, EModalidade modalidade){
        super(nome);
        this.modalidade = modalidade;
        this.equipa = "Unknown";
        this.momentum = 50;
    }
    public EModalidade getModalidade() {
        return modalidade;
    }
    public void setModalidade(EModalidade modalidade) {
        this.modalidade = modalidade;
    }

    

    public String getEquipa() {
        return equipa;
    }
    public void setEquipa(String equipa) {
        this.equipa = equipa;
    }

    public int getMomentum() {
        return momentum;
    }
    public void setMomentum(int momentum) {
        this.momentum = momentum;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + modalidade + " | " + equipa;
    }

    public boolean equals(Jogador j) {
        if (super.equals(j) && modalidade.equals(j.getModalidade()) && equipa.equals(j.getEquipa()) && momentum==j.getMomentum()){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + modalidade.hashCode() + equipa.hashCode() + momentum;
    }
}
