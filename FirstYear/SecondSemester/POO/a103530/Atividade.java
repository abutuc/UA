package a103530;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Atividade implements PontosDeInteresse{
    private int identificador;
    private String nome;

    public Atividade(int identificador, String nome){
        this.identificador = identificador;
        this.nome = nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setIdentificador(int identificador) {
        this.identificador = identificador;
    }
    public int getIdentificador() {
        return identificador;
    }

    public Collection<String> locais(){
        List<String> locais = new ArrayList<>();
        return locais;
    }

    @Override
    public String toString() {
        return "Atividade [num=" + identificador + ", nome=" + nome + "]";
    }

    public boolean equals(Atividade a){
        if(identificador==a.getIdentificador() && nome.equals(a.getNome())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return identificador + nome.hashCode();
    }
}
