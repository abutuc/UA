package aula07;

public class QuartoHotel extends Alojamento {
    private String tipo;

    public QuartoHotel(String codigo, String nome, String local, String tipo){
        super(codigo, nome, local);
        this.tipo = tipo;
    }

    public String getTipo(){
        return tipo;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public String toString(){
        return super.toString() + " | " + tipo;
    }

    public int hashCode(){
        return super.hashCode() + tipo.hashCode();
    }

    public boolean equals(QuartoHotel quarto2){
        if((getCodigo().equals(quarto2.getCodigo())) && tipo.equals(quarto2.getTipo())){
            return true;
        }
        else{
            return false;
        }
    }
    
}
