package Q6;

import java.util.ArrayList;

public class Autor {
    private String nome;
    private int idade;
    private ArrayList<Livro> livros;


    public Autor(String nome, int idade){
        this.nome = nome;
        this.idade = idade;
        this.livros = new ArrayList<Livro>();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }
    public int getIdade() {
        return idade;
    }

    public void addLivro(Livro l){
        livros.add(l);
    }

    public void removeLivro(Livro l){
        livros.remove(l);
    }

    public String enumLivros(){
        String s = "";
        for(Livro l: livros){
            s+= l.toString() + "\n";
        }
        return s;
    }

    @Override
    public String toString() {
        return nome + " | " + idade + " anos |\n" + "Livros publicados:\n" + enumLivros();  
    }

    public boolean equals(Autor a){
        if(nome.equals(a.getNome()) && idade==a.getIdade() && enumLivros().equals(a.enumLivros())){
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return nome.hashCode() + idade + enumLivros().hashCode();
    }
}
