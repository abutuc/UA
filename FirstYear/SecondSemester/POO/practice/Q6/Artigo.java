package Q6;

import aula06.Data;

public class Artigo extends Publicacao {
    private Revista revista;

    public Artigo(String titulo, Data data, Revista revista){
        super(titulo, data);
        this.revista = revista;
    }

    public void setRevista(Revista revista) {
        this.revista = revista;
    }
    public Revista getRevista() {
        return revista;
    }

    @Override
    public String toString() {
        return getTitulo() + " | " + revista.getNome();
    }

    public boolean equals(Artigo a){
        if (super.equals(a) && revista.equals(a.getRevista())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + revista.hashCode();
    }
}
