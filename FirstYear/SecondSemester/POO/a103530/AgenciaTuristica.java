package a103530;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class AgenciaTuristica {
    private String nome;
    private String endereco;
    private Set<Atividade> atividades;

    public AgenciaTuristica(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        atividades = new HashSet<>();
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEndereco() {
        return endereco;
    }
    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public void add(Atividade a){
        atividades.add(a);
    }

    public int totalItems(){
        int sum = 0;
        for(Atividade a: atividades){
            sum += a.locais().size();
        }
        return sum;
    }

    public Set<Atividade> atividades(){
        return atividades;
    }

    public Set<String> getAllItems(){
        Set<String> locais = new TreeSet<>();
        for (Atividade a: atividades){
            for (String l: a.locais()){
                locais.add(l);
            }
        }
        return locais;
    }

    @Override
    public String toString() {
        return "Agencia Turística " + nome + "\n Atividades: " + atividades;
    }

    public boolean equals(AgenciaTuristica a){
        if (nome.equals(a.getNome())&& endereco.equals(a.getEndereco()) && atividades.equals(a.atividades())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + endereco.hashCode() + atividades.hashCode();
    }
}
