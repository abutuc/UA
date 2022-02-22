package aula06;
public class Pessoa {
    private String nome;
    private int cc;
    private Data dataNasc;

    public Pessoa(String nome, int cc, Data dataNasc){
        this.nome = nome;
        this.cc = cc;
        this.dataNasc = dataNasc;
    }

    public String getName(){
        return nome;
    }

    public int getCC(){
        return cc;
    }

    public Data getData(){
        return dataNasc;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setCC(int cc){
        this.cc = cc;
    }

    public void setDataNasc(Data dataNasc){
        this.dataNasc = dataNasc;
    }

    public String toString(){
        return "Nome: " + nome + "; " + "CC: " + cc + "; " + "DataNasc: " + dataNasc;
    }
}