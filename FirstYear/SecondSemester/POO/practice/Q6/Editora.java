package Q6;

import java.util.ArrayList;

public class Editora {
    private String nome;
    private int codigo;
    private ArrayList<LivroEditado> livros;


    public Editora(String nome, int codigo){
        this.nome = nome;
        this.codigo = codigo;
        livros = new ArrayList<LivroEditado>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }
    public int getCodigo() {
        return codigo;
    }

    public void addLivro(LivroEditado l){
        livros.add(l);
    }

    public void removeLivro(LivroEditado l){
        livros.remove(l);
    }

    public String enumLivros(){
        String s = "";
        for(LivroEditado l: livros){
            s+= l.toString() + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return "Editora | " + nome + " | " + codigo + "\n" + "Livros Editados:\n" + enumLivros();
    }

    public boolean equals(Editora e){
        if (nome.equals(e.getNome()) && codigo==e.getCodigo() && enumLivros().equals(e.enumLivros())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + codigo + enumLivros().hashCode();
    }
}
