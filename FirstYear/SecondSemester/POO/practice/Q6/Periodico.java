package Q6;

import aula06.Data;

public class Periodico extends Publicacao {
    private Jornal jornal;

    public Periodico(String titulo, Data data, Jornal journal){
        super(titulo, data);
        this.jornal = journal;
    }

    public Jornal getJornal() {
        return jornal;
    }
    public void setJornal(Jornal jornal) {
        this.jornal = jornal;
    }

    @Override
    public String toString() {
        return getTitulo() + " | " + jornal.getNome();
    }

    public boolean equals(Periodico per) {
        if(super.equals(per) && jornal.equals(per.getJornal())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return super.hashCode() + jornal.hashCode();
    }
}
