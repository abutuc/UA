import eSports.CSGORole;
import eSports.EModalidade;
import eSports.JogadorCS;

public class Testing {
    public static void main(String[] args){
        JogadorCS jog = new JogadorCS("André", EModalidade.CSGO, CSGORole.BOMBPLANTER);
        System.out.println(jog.enumStats());
    }
}
