package ementas;

public class PratoVegetariano extends Prato {

    public PratoVegetariano(String nome, double preco) {
        super(nome, preco);
    }

    public boolean addIngrediente(Alimento a) {
        if (a instanceof Cereal || a instanceof Legume)
            return super.addIngrediente(a);
        return false;
    }
}
