package PPGonçalo;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class Televisão extends Pacote{
    
    private TipoTelevisão tipo;
    private ArrayList<Canal> canais;

    public Televisão(String nome, double taxa, double preco_mensal, TipoTelevisão tipo){
        super(nome, taxa, preco_mensal);
        this.tipo = tipo;
        canais = new ArrayList<Canal>();
        }

    public TipoTelevisão getTipo() {
        return tipo;
    }

    public void setTipo(TipoTelevisão tipo) {
        this.tipo = tipo;
    }
    
    public void addCanal(Canal c){
        canais.add(c);
    }

    public void removeCanal(Canal c){
        canais.remove(c);
    }

    public ArrayList<Canal> getCanais(){
        return canais;
    }

    public String enumCanais(){
        String s = canais.stream().map(Canal::toString).collect(Collectors.joining("\n"));
        return s;
    }

    public String toString(){
        return "Televisão | " +  this.getNome() + " | " + "Pacote Especializado";
    }

    public boolean equals(Televisão tv2){
        if (super.equals(tv2) && tipo.equals(tv2.getTipo()) && enumCanais().equals(tv2.enumCanais())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return super.hashCode() + tipo.hashCode() + enumCanais().hashCode();
    }
    }
