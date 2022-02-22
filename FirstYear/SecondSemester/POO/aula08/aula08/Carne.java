package aula08;

public class Carne extends Alimento{
    private VariedadeCarne variedade;
    public Carne(double proteinas, double calorias, double peso, VariedadeCarne variedade){
        super(proteinas, calorias, peso);
        this.variedade = variedade;
    }

    
    public VariedadeCarne getVariedade() {
        return variedade;
    }


    public void setVariedade(VariedadeCarne variedade) {
        this.variedade = variedade;
    }

    public String toString(){
        return "Carne | " + super.toString() + " | Variedade: " + variedade;
    }

    public boolean equals(Carne carne2){
        if (super.equals(carne2) && variedade.equals(carne2.getVariedade())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + variedade.hashCode();
    }
}  
