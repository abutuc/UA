package aula07;
import java.time.Instant;

public class Jogo {
    private Equipa equipaA;
    private Equipa equipaB;
    private Bola bola;
    private int duracao_jogo;
    private long tempo_decorrido;
    private long instante_iniciado;
    private long instante_terminado;

    public Jogo(Equipa equipaA, Equipa equipaB, Bola bola){
        this.equipaA = equipaA;
        this.equipaB = equipaB;
        this.bola = bola;
        duracao_jogo = 0;
        tempo_decorrido = 0;
    }

    public void setDuracaoJogo(int duracao_jogo){
        this.duracao_jogo = duracao_jogo;
    }

    public int getDuracaoJogo(){
        return duracao_jogo;
    }

    public void setEquipaA(Equipa equipaA){
        this.equipaA = equipaA;
    }

    public Equipa getEquipaA(){
        return equipaA;
    }

    public void setEquipaB(Equipa equipaB){
        this.equipaB = equipaB;
    }

    public Equipa getEquipaB(){
        return equipaB;
    }

    public void setBola(Bola bola){
        this.bola = bola;
    }

    public Bola getBola(){
        return bola;
    }

    public double getTempoDecorrido(){
        return tempo_decorrido;
    }

    public String toString(){
        return equipaA.getNome() + " vs " + equipaB.getNome() + " | Bola: " + bola.getCor() + " | Duração: " + duracao_jogo;
    }

    public boolean equals(Jogo jogo2){
        if ((equipaA.equals(jogo2.getEquipaA())) && (equipaB.equals(jogo2.getEquipaB())) && (bola.equals(jogo2.getBola())) && (duracao_jogo == jogo2.getDuracaoJogo())){
            return true;
        }
        return false;
    }

    public int hashCode(){
        return equipaA.hashCode() + equipaB.hashCode() + bola.hashCode();
    }

    public long startGame(){
        instante_iniciado = Instant.now().toEpochMilli();
        return instante_iniciado;
    }

    public long registerTime(){
        instante_terminado = Instant.now().toEpochMilli();
        tempo_decorrido += (instante_terminado - instante_iniciado);
        instante_iniciado = Instant.now().toEpochMilli();
        return tempo_decorrido;
    }

    public long stopGame(){
        instante_terminado = Instant.now().toEpochMilli();
        tempo_decorrido += (instante_terminado - instante_iniciado);
        return tempo_decorrido;
    }
}
