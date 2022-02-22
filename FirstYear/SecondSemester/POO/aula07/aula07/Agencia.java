package aula07;
import java.util.ArrayList;
public class Agencia {
    private ArrayList<Alojamento> alojamentos;
    private ArrayList<CarroAluguer> viaturas;
    String nome;
    String endereco;


    public Agencia(String nome, String endereco){
        this.nome = nome;
        this.endereco = endereco;
        alojamentos = new ArrayList<Alojamento>();
        viaturas = new ArrayList<CarroAluguer>();
    }

    public CarroAluguer registarViatura(char classe_v, String tipo_v){
        return new CarroAluguer(classe_v, tipo_v);
    }

    public void addViatura(CarroAluguer viatura){
        viaturas.add(viatura);
    }

    public void removeViatura(CarroAluguer viatura){
        viaturas.remove(viatura);
    }

    public Alojamento registarAlojamento(String codigo_aloj, String nome_aloj, String local_aloj){
        return new Alojamento(codigo_aloj, nome_aloj, local_aloj);
    }

    public Apartamento registarApartamento(String codigo_apart, String nome_apart, String local_apart, int nrQuartos){
        return new Apartamento(codigo_apart, nome_apart, local_apart, nrQuartos);
    }

    public QuartoHotel registarQuartoHotel(String codigo_q, String nome_q, String local_q, String tipo_q){
        return new QuartoHotel(codigo_q, nome_q, local_q, tipo_q);
    }

    public void addAlojamento(Alojamento aloj){
        alojamentos.add(aloj);
    }

    public void removeAlojamento(Alojamento aloj){
        alojamentos.remove(aloj);
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setEndereco(String endereco){
        this.endereco = endereco;
    }
    public ArrayList<Alojamento> getAlojamento(){
        return alojamentos;
    }

    public ArrayList<CarroAluguer> getCarroAluguer(){
        return viaturas;
    }

    public String getNome(){
        return nome;
    }

    public String getEndereco(){
        return endereco;
    }

    public String toString(){
        return "Agência " + nome + ", " + endereco + ".";
    }

    public String enumAlojamentos(){
        String s = "";  
        int indice = 1;
        for (Alojamento aloj: alojamentos){
            s += indice + " - " + aloj.toString() + ";\n";
            indice++;
        }
        return s;
    }

    public String enumAlojamentosDisponiveis(){
        String s = "";  
        int indice = 1;
        for (Alojamento aloj: alojamentos){
            if (aloj.getDisponibilidade()){
                s += indice + " - " + aloj.toString() + ";\n";
                indice++;
            }
        }
        return s;
    }

    public String enumAlojamentosInDisponiveis(){
        String s = "";  
        int indice = 1;
        for (Alojamento aloj: alojamentos){
            if (!aloj.getDisponibilidade()){
                s += indice + " - " + aloj.toString() + ";\n";
                indice++;
            }
        }
        return s;
    }

    public String enumCarrosAluguer(){
        String s = "";
        int indice = 1;
        for (CarroAluguer viatura: viaturas){
            s += indice + " - " + viatura.toString() + ";\n";
            indice++;
        }
        return s;
    }

    public String enumCarrosAluguerDisponiveis(){
        String s = "";
        int indice = 1;
        for (CarroAluguer viatura: viaturas){
            if(viatura.getDisponibilidade()){
            s += indice + " - " + viatura.toString() + ";\n";
            indice++;
            }
        }
        return s;
    }

    public String enumCarrosAluguerIndisponiveis(){
        String s = "";
        int indice = 1;
        for (CarroAluguer viatura: viaturas){
            if(!viatura.getDisponibilidade()){
            s += indice + " - " + viatura.toString() + ";\n";
            indice++;
            }
        }
        return s;
    }
    

    public boolean equals(Agencia agencia2){
        if ((nome.equals(agencia2.getNome())) && (endereco.equals(agencia2.getEndereco()))){
            return true;
        }
        else{
            return false;
        }
    }

    public int hashCode(){
        return nome.hashCode() + endereco.hashCode();
    }

}
