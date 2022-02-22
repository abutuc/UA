package aula08;
public class PesadoPassageiros extends AutoPesado {
    private int max_passageiros;

    public PesadoPassageiros(String matricula, String nrQuadro, int max_passageiros){
        super(matricula, nrQuadro);
        this.max_passageiros = max_passageiros;
    }

    public int getMax_passageiros() {
        return max_passageiros;
    }

    public void setMax_passageiros(int max_passageiros) {
        this.max_passageiros = max_passageiros;
    }

    public String toString(){
        return "Pesado de Passageiros | " + super.toString() + " | Número Máximo de Passageiros: " + max_passageiros;
    }

    public boolean equals(PesadoPassageiros peseiro2){
        if (super.equals(peseiro2) && max_passageiros==peseiro2.getMax_passageiros()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + max_passageiros;
    }
}
