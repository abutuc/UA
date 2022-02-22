package aula06;

public class Bolseiro extends Aluno{
    private double montante_mensal;

    public Bolseiro(String nome, int cc, Data dataNasc, Data dataInsc, double montante_mensal){
        super(nome, cc, dataNasc, dataInsc);
        this.montante_mensal = montante_mensal;
    }

    public Bolseiro(String nome, int cc, Data dataNasc, double montante_mensal){
        super(nome, cc, dataNasc);
        this.montante_mensal = montante_mensal;
    }

    public Bolseiro(String nome, int cc, Data dataNasc){
        super(nome, cc, dataNasc);
    }

    public double getBolsa(){
        return montante_mensal;
    }

    public void setBolsa(double montante_mensal){
        this.montante_mensal = montante_mensal;
    }
    
    public String toString(){
        return super.toString() + "; Bolsa: " + montante_mensal;
    }
}
