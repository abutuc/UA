package Q6;

public class Revista {
    private String nome;
    private int id;

    public Revista(String nome, int id){
        this.nome = nome;
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setId(int id) {
        this.id = id;
    }
    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return nome + " | " + id;
    }

    public boolean equals(Revista j){
        if(nome.equals(j.getNome()) && id==j.getId()){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return nome.hashCode() + id;
    }
}
