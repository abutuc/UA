package aula08;
import java.util.ArrayList;
public class Ementa {
    private String nome;
    private String local;
    private ArrayList<Prato> pratos;

    public Ementa(String nome, String local) {
        this.nome = nome;
        this.local = local;
        pratos = new ArrayList<Prato>();
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }  

    public void addPrato(Prato prato){
        pratos.add(prato);
    }

    public void addPratoS(Prato prato, String day){
        pratos.add(prato);
    }

    public void removePrato(Prato prato){
        pratos.remove(prato);
    }

    public String enumPratos(){
        String s = "";
        for (Prato prato: pratos){
            if (prato instanceof PratoVegetariano){
                s += prato.getNome() + ", composto por " + prato.getAlimentos().size() + " Ingredientes - Prato Vegetariano \n";
            }
            else if (prato instanceof PratoDieta){
                s += prato.getNome() + ", composto por " + prato.getAlimentos().size() + " Ingredientes - Dieta (" + prato.getCalorias() + " Calorias) \n";
            }
            else if (prato instanceof Prato) {
                s += prato.getNome() + ", composto por " + prato.getAlimentos().size() + " Ingredientes \n";
            }
        }
        return s;
    }

    public ArrayList<Prato> getPratos(){
        return pratos;
    }

    public String toString(){
        return nome + " | \n" + enumPratos();
    }

    public int hashCode(){
        return nome.hashCode() + pratos.hashCode();
    }

    public boolean equals(Ementa ementa2){
        if (nome.equals(ementa2.getNome()) && local.equals(ementa2.getLocal()) && pratos.equals(ementa2.getPratos())){
            return true;
        }
        return false;
    }
}
