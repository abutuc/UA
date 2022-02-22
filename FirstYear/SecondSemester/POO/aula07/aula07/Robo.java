package aula07;
import aula05.Ponto;

public class Robo extends ObjetoMovel {
    private String id;
    private String tipo_jogador;
    private int golos_marcados;

    public Robo(Ponto coordenadas, String id, String tipo_jogador){
        super(coordenadas);
        this.id = id;
        this.tipo_jogador = tipo_jogador;
        golos_marcados = 0;
    }

    public void setId(String id){
        this.id = id;
    }

    public void setTipoJogador(String tipo_jogador){
        this.tipo_jogador = tipo_jogador;
    }

    public void setGolosMarcados(int golos_marcados){
        this.golos_marcados = golos_marcados;
    }

    public String getId(){
        return id;
    }

    public String getTipoJogador(){
        return tipo_jogador;
    }

    public int getGolosMarcados(){
        return golos_marcados;
    }

    public String toString(){
        return super.toString() + " | Id: " + id + " | " + tipo_jogador + " | Golos Marcados: " + golos_marcados;
    }

    public boolean equals(Robo robo2){
        if ((super.equals(robo2))&&(id.equals(robo2.getId())) && (tipo_jogador.equals(robo2.getTipoJogador()))){
            return true;
        }
        else{
            return false;
        }
    }

    public int hashCode(){
        return id.hashCode() + tipo_jogador.hashCode() + golos_marcados;
    }

    public void marcarGolo(){
        golos_marcados++;
    }
}
