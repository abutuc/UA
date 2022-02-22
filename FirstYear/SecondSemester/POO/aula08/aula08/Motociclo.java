package aula08;

public class Motociclo extends Viatura{
    private String tipo;

    public Motociclo(String matricula, String tipo){
        super(matricula);
        if ((tipo.equals("desportivo")) || (tipo.equals("estrada"))){
            this.tipo = tipo;
        }
        else {
            this.tipo = "Unknown";
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    
    public String toString(){
        return "Motociclo | " + super.toString() + "| Tipo: " + tipo;
    }

    public boolean equals(Motociclo mot2){
        if (super.equals(mot2) && tipo.equals(mot2.getTipo())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + tipo.hashCode();
    }
}
