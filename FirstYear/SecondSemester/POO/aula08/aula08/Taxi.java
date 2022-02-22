package aula08;

public class Taxi extends AutoLigeiro{
    private int nrLicenca;
    
    public Taxi(String matricula, String nrQuadro, int nrLicenca){
        super(matricula, nrQuadro);
        this.nrLicenca = nrLicenca;
    }

    public int getNrLicenca() {
        return nrLicenca;
    }

    public void setNrLicenca(int nrLicenca) {
        this.nrLicenca = nrLicenca;
    }

    public String toString(){
        return "Taxi | " + super.toString() + "| Número da Licença: " + nrLicenca;
    }

    public boolean equals(Taxi taxi2){
        if (super.equals(taxi2) && (nrLicenca == taxi2.getNrLicenca())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + nrLicenca;
    }

}
