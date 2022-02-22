

interface Ecra {
    void escreve(String s);
}

public class testes {
   public static void main(String[] args){
       Ecra xd = (String s) -> {
           if (s.length() > 2){
               System.out.println(s);
           }
           else{
               System.out.println("..");
           }
       };
       xd.escreve("Lambda print");
       xd.escreve("?");
   } 
}

