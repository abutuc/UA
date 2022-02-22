package Q6;

import aula06.Data;

public class LivroEditado extends Livro {
    private Editora editora;

    public LivroEditado(String titulo, Data data, Autor autor, Editora editora){
        super(titulo, data, autor);
        this.editora = editora;
    }

    public void setEditora(Editora editora) {
        this.editora = editora;
    }
    public Editora getEditora() {
        return editora;
    }

    @Override
    public String toString() {
        return super.toString() + " | " + editora;
    }

    public boolean equals(LivroEditado l) {
        if(super.equals(l) && editora.equals(l.getEditora())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + editora.hashCode();
    }
}
