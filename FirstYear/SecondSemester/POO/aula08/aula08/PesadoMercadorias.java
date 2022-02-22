package aula08;

public class PesadoMercadorias extends AutoPesado {
    double carga_maxima;

    public PesadoMercadorias(String matricula, String nrQuadro, double carga_maxima){
        super(matricula, nrQuadro);
        this.carga_maxima = carga_maxima;
    }

    public double getCarga_maxima() {
        return carga_maxima;
    }

    public void setCarga_maxima(double carga_maxima) {
        this.carga_maxima = carga_maxima;
    }

    public String toString(){
        return "Pesado de Mercadorias | " + super.toString() + " | Carga Máxima: " + carga_maxima;
    }

    public boolean equals(PesadoMercadorias pesmer2){
        if (super.equals(pesmer2) && carga_maxima == pesmer2.getCarga_maxima()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode();
    }
}
