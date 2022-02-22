package aula06;
public class Poligono {
   private String cor;

   public Poligono(String cor){
       this.cor = cor;
   }

   public String getCor(){
       return cor;
   }

   public void setCor(String cor){
       this.cor = cor;
   }

   public String toString(){
       return "Polígono com cor " + cor;
   }
}
