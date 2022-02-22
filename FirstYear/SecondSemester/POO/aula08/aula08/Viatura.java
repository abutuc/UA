package aula08;
import java.util.ArrayList;
public class Viatura implements KmPercorridosInterface {
    private String matricula;
    private String marca;
    private String modelo;
    private double cilindrada;
    private ArrayList<Integer> trajetos;

    
    public Viatura(String matricula) {
        this.matricula = matricula;
        this.marca = "";
        this.modelo = "";
        this.cilindrada = 0.0;
        trajetos = new ArrayList<Integer>();
    }
    public String getMatricula() {
        return matricula;
    }
    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }
    public String getMarca() {
        return marca;
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public String getModelo() {
        return modelo;
    }
    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    public double getCilindrada() {
        return cilindrada;
    }
    public void setCilindrada(double cilindrada) {
        this.cilindrada = cilindrada;
    }
    

    public String toString() {
        return "Matricula: " + matricula + " | Cilindrada: " + cilindrada + " | Marca: " + marca + " | Modelo: " + modelo;
    }

    public boolean equals(Viatura viat2){
        if (matricula.equals(viat2.getMatricula())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return matricula.hashCode() + marca.hashCode() + modelo.hashCode();
    }

    public ArrayList<Integer> getTrajetos(){
        return trajetos;
    }
    public void trajeto(int quilometros){
        trajetos.add(quilometros);
    }

    public int ultimoTrajeto(){
        return trajetos.get(trajetos.size()-1);
    }

    public int distanciaTotal(){
        int distancia = 0;
        for (Integer trajeto: trajetos){
            distancia += trajeto;
        }
        return distancia;
    }

}
