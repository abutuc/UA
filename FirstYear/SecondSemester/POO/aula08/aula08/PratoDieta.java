package aula08;

public class PratoDieta extends Prato{
    private double limite_calorias;

    public PratoDieta(String nome, double limite_calorias){
        super(nome);
        this.limite_calorias = limite_calorias;
    }
    
    public double getLimite_calorias() {
        return limite_calorias;
    }

    public void setLimite_calorias(double limite_calorias) {
        this.limite_calorias = limite_calorias;
    }

    public boolean addAlimento(Alimento alim){
        if (getCalorias() + alim.getCalorias() <= limite_calorias){
            setPeso(getPeso() + alim.getPeso());
            setCalorias(getCalorias() + alim.getCalorias());
            setProteinas(getProteinas() + alim.getProteinas());

            getAlimentos().add(alim);

            return true;
        } 
        return false; 
    }

    public boolean removeAlimento(Alimento alim){
        setPeso(getPeso() - alim.getPeso());
        setCalorias(getCalorias() - alim.getCalorias());
        setProteinas(getProteinas() - alim.getProteinas());

        getAlimentos().remove(alim);

        return true;
    }

    public String toString(){
        return super.toString() + " | Limite Máximo de Calorias: " + limite_calorias;
    }

    public boolean equals(PratoDieta prato2){
        if (super.equals(prato2) && limite_calorias == prato2.getLimite_calorias()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + (int) limite_calorias;
    }
}
