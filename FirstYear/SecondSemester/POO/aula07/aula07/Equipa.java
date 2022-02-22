package aula07;
import java.util.ArrayList;

public class Equipa {
    private String nome;
    private String nome_responsavel;
    private int total_golos_marcados;
    private int total_golos_sofridos;
    private ArrayList<Robo> robos;


    public Equipa(String nome, String nome_responsavel){
        this.nome = nome;
        this.nome_responsavel = nome_responsavel;
        total_golos_marcados = 0;
        total_golos_sofridos = 0;
        robos = new ArrayList<Robo>();
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public String getNome(){
        return nome;
    }

    public void setNomeResponsavel(String nome_responsavel){
        this.nome_responsavel = nome_responsavel;
    }

    public String getNomeResponsavel(){
        return nome_responsavel;
    }

    public void setTotalGolosMarcados(int total_golos_marcados){
        this.total_golos_marcados = total_golos_marcados;
    }

    public int getTotalGolosMarcados(){
        return total_golos_marcados;
    }

    public void goalScored(){
        total_golos_marcados++;
    }

    public void setTotalGolosSofridos(int total_golos_sofridos){
        this.total_golos_sofridos = total_golos_sofridos;
    }

    public int getTotalGolosSofridos(){
        return total_golos_sofridos;
    }

    public void goalConceeded(){
        total_golos_sofridos++;
    }
    public void adicionarRobo(Robo robo1){
        robos.add(robo1);
    }

    public void removerRobo(Robo robo1){
        robos.remove(robo1);
    }

    public ArrayList<Robo> getRobos(){
        return robos;
    }

    public String enumEquipa(){
        String s = " | ";
        for(Robo robo: robos){
            s += robo.getId() + " | ";
        }
        return s;
    }

    public String toString(){
        return "Equipa: " + nome + " | Responsável: " + nome_responsavel + " | Membros: " + enumEquipa() + "Golos Marcados: " + total_golos_marcados + " | Golos Sofridos: " + total_golos_sofridos;
    }

    public boolean equals(Equipa equipa2){
        if((nome.equals(equipa2.getNome())) && (nome_responsavel.equals(equipa2.getNomeResponsavel())) && (robos.equals(equipa2.getRobos()))){
            return true;
        }
        else{
            return false;
        }
    }

    public int hashCode(){
        return nome.hashCode() + nome_responsavel.hashCode() + total_golos_marcados + total_golos_sofridos;
    }
}
