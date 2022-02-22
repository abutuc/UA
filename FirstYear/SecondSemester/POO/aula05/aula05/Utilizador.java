package aula05;

public class Utilizador {
   private String nome;
   private int nMec;
   private String curso;
   private int[] livros;
   
   public Utilizador(String nome, int nMec, String curso){
       this.nome = nome;
       this.nMec = nMec;
       this.curso = curso;
       livros = new int[3];
   }

   public String getNome(){
       return nome;
   }

   public int getNmec(){
       return nMec;
   }

   public int[] getLivros(){
       return livros;
   }

   public String getCurso(){
       return curso;
   }

   public void setNome(String nome){
       this.nome = nome;
   }

   public void setnMec(int nMec){
       this.nMec = nMec;
   }

   public void setCurso(String curso){
       this.curso = curso;
   }

   public String toString(){
       return "Aluno: " + nMec + "; " + nome + "; " + curso;
   }

   public void requisitarLivro(int livro_id){
       for (int i = 0; i < livros.length; i++){
           if (livros[i] == 0){
               livros[i] = livro_id;
               break;
           }
       }
   }

   public void devolverLivro(int livro_id){
    for (int i = 0; i < livros.length; i++){
            if (livros[i] == livro_id){
                livros[i] = 0;
            }
        }
   }
}
