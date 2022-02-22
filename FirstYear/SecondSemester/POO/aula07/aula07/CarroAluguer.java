package aula07;
public class CarroAluguer {
    private static int temp_cod = 100;
    private int codigo;
    private char classe;
    private String tipo;
    private boolean disponibilidade;

    public CarroAluguer(char classe, String tipo){
        this.classe = classe;
        this.tipo = tipo;
        this.disponibilidade = true;
        codigo = temp_cod;
        temp_cod++;
    }

    public void setClasse(char classe){
        this.classe = classe;
    }

    public void setTipo(String tipo){
        this.tipo = tipo;
    }

    public void setDisponibilidade(boolean disponibilidade){
        this.disponibilidade = disponibilidade;
    }

    public int getCodigo(){
        return codigo;
    }

    public char getClasse(){
        return classe;
    }
    
    public String getTipo(){
        return tipo;
    }

    public boolean getDisponibilidade(){
        return disponibilidade;
    }

    public String toString(){
        String disponivel;
        if(getDisponibilidade()){
            disponivel = "Disponível";
        }
        else{
            disponivel = "Indisponível";
        }
        return codigo + " | " + classe + " | " + tipo + " | " + disponivel;
    }

    public boolean equals(CarroAluguer carro2){
        if(codigo == carro2.getCodigo()){
            return true;
        }
        else{
            return false;
        }
    }

    public int hashCode(){
        return codigo + tipo.hashCode();
    }

    public void levantarCarro(){
        disponibilidade = false;
    }

    public void entregarCarro(){
        disponibilidade = true;
    }

}
