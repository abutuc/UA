package eSports;

public enum EModalidade {
    CSGO("CS:GO", 1),
    LOL("League of Legends", 2),
    ROCKETLEAGUE("Rocket League", 3);

    private String nome;
    private int num;
    private EModalidade(String nome, int num){
        this.nome = nome;
        this.num = num;
    }

    public String getNome(){
        return nome;
    }

    public int getNum(){
        return num;
    }
    public String toString(){
        return nome;
    }
}
