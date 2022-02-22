package aula07;

public class Apartamento extends Alojamento {
    private int nrQuartos;

    public Apartamento(String codigo, String nome, String local, int nrQuartos){
        super(codigo, nome, local);
        this.nrQuartos = nrQuartos;
    }

    public void setNrQuartos(int nrQuartos){
        this.nrQuartos = nrQuartos;
    }

    public int getNrQuartos(){
        return nrQuartos;
    }

    public String toString(){
        return super.toString() + " | " + nrQuartos + " quartos";
    }

    public int hashCode(){
        return super.hashCode() + nrQuartos;
    }
}
