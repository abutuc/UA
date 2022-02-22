package a103530;
import java.util.Set;
import java.util.TreeSet;

public class PasseioBicicleta extends Atividade {
    private Set<String> locais;

    public PasseioBicicleta(int identificador, String nome){
        super(identificador, nome);
        locais = new TreeSet<>();
    }

    public PasseioBicicleta(int identificador, String nome, String[] locais){
        super(identificador, nome);
        this.locais = new TreeSet<>();
        for(String l: locais){
            this.locais.add(l);
        }
    }
    @Override
    public Set<String> locais() {
        return locais;
    }

    public void addLocal(String local){
        locais.add(local);
    }

    public void removeLocal(String local){
        locais.remove(local);
    }

    public boolean equals(Gastronomia g){
        if (super.equals(g) && locais.equals(g.locais())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + locais.hashCode();
    }

}
