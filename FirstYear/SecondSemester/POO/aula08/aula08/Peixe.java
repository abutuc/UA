package aula08;

public class Peixe extends Alimento{
    private TipoPeixe tipo;

    public Peixe(double proteinas, double calorias, double peso, TipoPeixe tipo){
        super(proteinas, calorias, peso);
        this.tipo = tipo;
    }
  
    public TipoPeixe getTipo() {
        return tipo;
    }



    public void setTipo(TipoPeixe tipo) {
        this.tipo = tipo;
    }


    public String toString(){
        return "Peixe | " + super.toString() + " | Tipo: " + tipo;
    }

    public boolean equals(Peixe pei){
        if (super.equals(pei) && tipo==pei.getTipo()){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + tipo.hashCode();
    }

    
}
