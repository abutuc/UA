package aula08;
import java.util.ArrayList;
public class Prato{
    private String nome;
    private ArrayList<Alimento> alimentos;
    private double calorias;
    private double peso;
    private double proteinas;

    public Prato(String nome){
        this.nome = nome;
        alimentos = new ArrayList<Alimento>();
        calorias = 0;
        peso = 0;
        proteinas = 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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

    public double getProteinas() {
        return proteinas;
    }

    public void setProteinas(double proteinas) {
        this.proteinas = proteinas;
    }

    public boolean addAlimento(Alimento alim){
        peso += alim.getPeso();
        proteinas += alim.getProteinas();
        calorias += alim.getCalorias();
        alimentos.add(alim);
        return true;
    }

    public boolean removeAlimento(Alimento alim){
        peso -= alim.getPeso();
        proteinas -= alim.getProteinas();
        calorias -= alim.getCalorias();
        alimentos.remove(alim);
        return true;
    }

    public ArrayList<Alimento> getAlimentos(){
        return alimentos;
    }

    public Alimento getAlimento(int index){
        return alimentos.get(index);
    }

    public String enumAlimentos(){
        String s = "";
        for (Alimento alim: alimentos){
            s += alim.toString() + "\n";
        }
        return s;
    }

    public String toString(){
        return "Prato" + nome;
    }

    public int hashCode(){
        return nome.hashCode() + alimentos.hashCode();
    }

    public boolean equals(Prato prato2){
        if (nome.equals(prato2.getNome()) && alimentos.equals(prato2.getAlimentos())  && calorias == prato2.getCalorias() && proteinas == prato2.getProteinas() && peso == prato2.getPeso()){
            return true;
        }
        return false;
    }

    public int compareTo(Prato prato2){
        if (calorias == prato2.getCalorias()){
            return 1;
        }
        return 0;
    }
}
