package aula08;
public class Alimento {
    private double proteinas;
    private double calorias;
    private double peso;

    public Alimento(double proteinas, double calorias, double peso) {
        this.proteinas = proteinas;
        this.calorias = calorias;
        this.peso = peso;
    }
    public double getProteinas() {
        return proteinas;
    }
    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }
    public double getCalorias() {
        return calorias;
    }
    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }

    public String toString(){
        return "Proteínas: " + proteinas + "g | Calorias: " + calorias + "J | Peso: " + peso + "kg";
    }

    public boolean equals(Alimento alim2){
        if ((proteinas == alim2.getProteinas()) && (calorias == alim2.getCalorias()) && (peso == alim2.getPeso())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return (int) proteinas + (int) calorias + (int) peso * 230974;
    }
}
