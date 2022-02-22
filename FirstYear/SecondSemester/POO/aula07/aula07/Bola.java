package aula07;
import aula05.Ponto;

public class Bola extends ObjetoMovel {
    private String cor;

    public Bola(Ponto coordenadas, String cor){
        super(coordenadas);
        this.cor = cor;
    }

    public void setCor(String cor){
        this.cor = cor;
    }

    public String getCor(){
        return cor;
    }

    public String toString(){
        return super.toString() + " | Cor: " + cor;
    }

    public boolean equals(Bola bola2){
        if((super.equals(bola2))&&(cor.equals(bola2.getCor()))){
            return true;
        }
        else{
            return false;
        }
    }

    public int hashCode(){
        return super.hashCode() + cor.hashCode();
    }
}
