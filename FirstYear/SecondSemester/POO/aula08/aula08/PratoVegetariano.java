package aula08;

public class PratoVegetariano extends Prato{

    public PratoVegetariano(String nome){
        super(nome);
    }

    public boolean addAlimento(Alimento alim){
        if ( alim instanceof Vegetariano){
            setPeso(getPeso() + alim.getPeso());
            setCalorias(getCalorias() + alim.getCalorias());
            setProteinas(getProteinas() + alim.getProteinas());
            getAlimentos().add(alim);
            return true;
        }
        return false;
    }

    public boolean removeAlimento(Alimento alim){
        setPeso(getPeso() - alim.getPeso());
        setCalorias(getCalorias() - alim.getCalorias());
        setProteinas(getProteinas() - alim.getProteinas());
        getAlimentos().remove(alim);
        return true;
    }
}
