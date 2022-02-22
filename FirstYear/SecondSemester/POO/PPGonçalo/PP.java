import PPGonçalo.Canal;
import PPGonçalo.Pacote;
import PPGonçalo.PacoteCombinado;
import PPGonçalo.Televisão;
import PPGonçalo.TipoTelevisão;

public class PP{
    public static void main(String[] args){
        Pacote p1 = new Pacote("Pacote1", 10.0, 23);
        System.out.println(p1.getNome());

        PacoteCombinado p2 = new PacoteCombinado();
        p2.addPacote(p1);
        
        Televisão tv = new Televisão("LP", 3, 4, TipoTelevisão.PREMIUM);
        Canal c1 = new Canal("SIC", true);
        Canal c2 = new Canal("TVI", false);

        tv.addCanal(c1);
        tv.addCanal(c2);

        System.out.println(tv.enumCanais());
    }
}
 