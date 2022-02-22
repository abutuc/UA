package a103530;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Gastronomia extends Atividade{
    private List<Restaurante> restaurantes;

    public Gastronomia(int identificador, String nome){
        super(identificador, nome);
        restaurantes = new ArrayList<>();
    }

    public Gastronomia(int identificador, String nome, List<Restaurante> lista){
        super(identificador, nome);
        restaurantes = new ArrayList<>();
        restaurantes.addAll(lista);
    }

    public void add(Restaurante restaurante){
        restaurantes.add(restaurante);
    }
    public void remove(Restaurante restaurante){
        restaurantes.remove(restaurante);
    }

    public List<Restaurante> getLista(){
        return restaurantes;
    }

    public int totalRestaurantes(){
        return restaurantes.size();
    }

    @Override
    public Collection<String> locais(){
        Set<String> locais = new TreeSet<>();
        for (Restaurante r: restaurantes){
            locais.add(r.toString());
        }
        return locais;
    }
    
    public boolean equals(Gastronomia g){
        if (super.equals(g) && restaurantes.equals(g.getLista())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + restaurantes.hashCode();
    }
}
