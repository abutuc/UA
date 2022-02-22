package aula08;

public class AutoLigeiro extends Viatura{
    private String nrQuadro;
    private double capacidade_bagageira;

    public AutoLigeiro(String matricula, String nrQuadro){
        super(matricula);
        this.nrQuadro = nrQuadro;
        capacidade_bagageira = 0.0;
    }

    public String getNrQuadro() {
        return nrQuadro;
    }

    public void setNrQuadro(String nrQuadro) {
        this.nrQuadro = nrQuadro;
    }

    public double getCapacidade_bagageira() {
        return capacidade_bagageira;
    }

    public void setCapacidade_bagageira(double capacidade_bagageira) {
        this.capacidade_bagageira = capacidade_bagageira;
    }

    public String toString(){
        return "Automóvel Ligeiro | " + super.toString() + " | Número do Quadro: " + nrQuadro + " | Capacidade da Bagageira: " + capacidade_bagageira;
    }

    public boolean equals(AutoLigeiro auto2){
        if (super.equals(auto2) && nrQuadro.equals(auto2.getNrQuadro())){
            return true;
        }
        return false;
    }
    
    public int hashCode(){
        return super.hashCode() + nrQuadro.hashCode();
    }


}