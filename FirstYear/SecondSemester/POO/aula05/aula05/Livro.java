package aula05;
public class Livro {
    public static int temp_id = 100;
    private int id;
    private String titulo;
    private String tipoEmprestimo;
    private boolean requisitado;

    public Livro(String titulo, String tipoEmprestimo){
        this.titulo = titulo;
        this.tipoEmprestimo = tipoEmprestimo;
        this.id = temp_id;
        requisitado = false;
        temp_id++;
    }

    public Livro(String titulo){
        this.titulo = titulo;
        this.tipoEmprestimo = "NORMAL";
        this.id = temp_id;
        temp_id++;
    }

    public int getId(){
        return id;
    }

    public String getTitulo(){
        return titulo;
    }

    public String getTipoEmprestimo(){
        return tipoEmprestimo;
    }

    public boolean getRequisitado(){
        return requisitado;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setTitulo(String titulo){
        this.titulo = titulo;
    }

    public void setTipoEmprestimo(String tipo){
        tipoEmprestimo = tipo;
    }

    public String toString(){
        return "Livro "+ id + "; " + titulo + "; " + tipoEmprestimo;
    }

    public void emprestarLivro(){
        requisitado = true;
    }

    public void devolverLivro(){
        requisitado = false;
    }
}
