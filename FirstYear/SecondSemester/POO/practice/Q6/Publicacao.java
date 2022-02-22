package Q6;

import aula06.Data;

public class Publicacao {
    private String titulo;
    private Data data;

    public Publicacao(String titulo, Data data){
        this.titulo = titulo;
        this.data = data;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getTitulo() {
        return titulo;
    }

    public void setData(Data data) {
        this.data = data;
    }
    public Data getData() {
        return data;
    }

    @Override
    public String toString() {
        return titulo + " | " + data;
    }


    public boolean equals(Publicacao pub) {
        if(titulo.equals(pub.getTitulo()) && data.equals(pub.getData())){
            return true;
        }
        return false;
    }
    
    @Override
    public int hashCode() {
        return titulo.hashCode() + data.hashCode();
    }
}
