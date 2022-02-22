package aula06;

public class Aluno extends Pessoa{
    public static int temp_nMec = 100;
    private int nMec;
    private Data dataInsc;

    public Aluno(String nome, int cc, Data dataNasc, Data dataInsc){
        super(nome, cc, dataNasc);
        nMec = temp_nMec;
        temp_nMec++;
        this.dataInsc = dataInsc;
    }

    public Aluno(String nome, int cc, Data dataNasc){
        super(nome, cc, dataNasc);
        this.nMec = temp_nMec;
        temp_nMec++;
        dataInsc = Data.today();
    }

    public int getNMec(){
        return nMec;
    }

    public Data dataInsc(){
        return dataInsc;
    }

    public void setNMec(int nMec){
        this.nMec = nMec;
    }

    public void setDataInsc(Data dataInsc){
        this.dataInsc = dataInsc;
    }

    public String toString(){
        return super.toString() + "; " + "nMec: " + nMec + "; " + "dataInsc: " + dataInsc;
    }
}
