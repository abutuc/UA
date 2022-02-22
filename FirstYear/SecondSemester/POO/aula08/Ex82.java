import aula08.Carne;
import aula08.Cereal;
import aula08.Ementa;
import aula08.Legume;
import aula08.Peixe;
import aula08.Prato;
import aula08.PratoVegetariano;
import aula08.TipoPeixe;
import aula08.VariedadeCarne;
import aula08.Alimento;

public class Ex82 {

    public static void main(String[] args){

    Ementa ementa = new Ementa("Butuc Ementa", "Gaf.Naz");
    Ementa ementa2 = new Ementa("Butuc Bqq", "Aveiro");
    Prato prato = new Prato("Butuc Mix");
    PratoVegetariano prato2 = new PratoVegetariano("Butuc Veggie");
    Alimento alim = new Alimento(23.0, 700, 1);
    Carne carne1 = new Carne(100, 689, 1000, VariedadeCarne.VACA);
    Peixe peixe1 = new Peixe(100, 440, 12, TipoPeixe.CONGELADO);
    Legume leg1 = new Legume(23.0, 700, 2, "Brócolos");
    Legume leg2 = new Legume(20.0, 700, 2, "Curgete");
    Cereal cer1 = new Cereal(200, 10000, 10, "Cerelac");

    prato2.addAlimento(alim);
    prato2.addAlimento(carne1);
    prato2.addAlimento(peixe1);
    prato2.addAlimento(leg1);
    prato2.addAlimento(leg2);
    prato2.addAlimento(cer1);
    
    prato.addAlimento(alim);
    prato.addAlimento(carne1);
    prato.addAlimento(peixe1);
    prato.addAlimento(leg1);
    prato.addAlimento(leg2);
    prato.addAlimento(cer1);

    ementa.addPrato(prato);
    ementa.addPrato(prato2);
    ementa2.addPrato(prato);
    System.out.println(ementa);
    System.out.println(ementa.enumPratos());

    ementa.removePrato(prato);
    System.out.println(ementa.enumPratos());

    System.out.println(ementa.hashCode());
    System.out.println(ementa.equals(ementa2));
    System.out.println(ementa.equals(ementa));
    }
}
