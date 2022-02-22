import java.util.concurrent.TimeUnit;

import aula05.Ponto;
import aula07.Bola;
import aula07.Equipa;
import aula07.Jogo;
import aula07.Robo;

public class Ex72 {
    
    public static void main(String[] args) throws InterruptedException{
        Equipa equipaA = new Equipa("Porto", "Sérgio");
        equipaA.adicionarRobo(new Robo(new Ponto(2.0, 3.0), "Marche", "GuardaRedes"));
        equipaA.adicionarRobo(new Robo(new Ponto(1.0, 6.0), "Pepe", "Defesa"));
        equipaA.adicionarRobo(new Robo(new Ponto(10.0, 3.5), "Taremi", "Avancado"));

        Equipa equipaB = new Equipa("Sporting", "Amorim");
        equipaB.adicionarRobo(new Robo(new Ponto(18.0, 3.0), "Pedro Gonçalves", "Avancado"));
        equipaB.adicionarRobo(new Robo(new Ponto(17.0, 6.0), "Coates", "Defesa"));
        equipaB.adicionarRobo(new Robo(new Ponto(26.0, 3.5), "Adan", "GuardaRedes"));

        Bola bola = new Bola(new Ponto(0, 0), "Branca");
        
        Jogo jogo = new Jogo(equipaA, equipaB, bola);
        jogo.setDuracaoJogo(1);

        System.out.println(jogo);

        jogo.startGame();
        TimeUnit.SECONDS.sleep(3);
        equipaA.getRobos().get(1).move(3, 9);
        System.out.println(equipaA.getRobos().get(1));
        equipaA.getRobos().get(2).move(20, 2);
        System.out.println(equipaA.getRobos().get(2));
        equipaA.getRobos().get(2).marcarGolo();
        System.out.println("GOLOOOOOO");
        equipaA.goalScored();
        equipaB.goalConceeded();
        System.out.println(jogo.registerTime());
        TimeUnit.SECONDS.sleep(2);
        equipaB.getRobos().get(1).move(30, 40);
        System.out.println(equipaB.getRobos().get(1));
        System.out.println(jogo.stopGame());
        System.out.println(equipaA);
        System.out.println(equipaB);
    }
}
