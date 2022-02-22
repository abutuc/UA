package aula08;

public class AutoPesado extends Viatura {
    private String nrQuadro;
    private double peso;

    public AutoPesado(String matricula, String nrQuadro){
        super(matricula);
        this.nrQuadro = nrQuadro;
        peso = 0.0;
    }

    public String getNrQuadro() {
        return nrQuadro;
    }

    public void setNrQuadro(String nrQuadro) {
        this.nrQuadro = nrQuadro;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String toString(){
        return super.toString() + "| Número do Quadro: " + nrQuadro + "| Peso: " + peso; 
    }

    public boolean equals(AutoPesado pesado2){
        if (super.equals(pesado2) && nrQuadro.equals(pesado2.getNrQuadro())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + nrQuadro.hashCode();
    }
}
