package Q6;
import aula06.Data;

public class Livro extends Publicacao{
    private Autor autor;

    public Livro(String titulo, Data data, Autor autor){
        super(titulo, data);
        this.autor = autor; 
    }

    public Autor getAutor() {
        return autor;
    }
    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return getTitulo() + " | " + autor.getNome();
    }

    public boolean equals(Livro l){
        if(super.equals(l) && autor.equals(l.getAutor())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + autor.hashCode();
    }


}
