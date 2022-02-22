package a103530;

public class Restaurante {
    private String nome;
    private TipoComida tipoComida;

    public Restaurante(String nome, TipoComida tipoComida){
        this.nome = nome;
        this.tipoComida = tipoComida;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setTipoComida(TipoComida tipoComida) {
        this.tipoComida = tipoComida;
    }
    public TipoComida getTipoComida() {
        return tipoComida;
    }

    @Override
    public String toString() {
        return "Restaurante [nome=" + nome + ", tipo=" + tipoComida.getName() + "]";
    }
    

    public boolean equals(Restaurante r){
        if(nome.equals(r.getNome()) && tipoComida.equals(r.getTipoComida())){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return nome.hashCode() + tipoComida.hashCode();
    }
}
