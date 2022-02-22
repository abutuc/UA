package ementas;

public class PratoDieta extends Prato {
    private double limiteCalorias;

    public PratoDieta(String nome, double preco, double limiteCalorias) {
        super(nome, preco);
        this.limiteCalorias = limiteCalorias;
    }

    public boolean addIngrediente(Alimento alim) {
        if (totalCalorias() + alim.getCalorias() <= limiteCalorias)
            return super.addIngrediente(alim);
        return false;
    }
}
