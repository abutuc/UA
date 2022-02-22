package aula04;
import java.util.Scanner;
public class Ex1 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza uma palavra, frase ou parágrafo: ");
        String frase = sc.nextLine();

        // Métodos pedidos
        String frase_min = frase.toLowerCase();
        System.out.println("Nova frase, convertida em para minúsculas: " + frase_min);
        char ult_char = frase.charAt(frase.length() - 1);
        System.out.println("Último carater da frase: " + ult_char);
        String prim_tres = frase.substring(0, 4);
        System.out.println("Os três primerios caracteres: " + prim_tres);

        // 3 Métodos adicionais
        String frase_concat = frase.concat(" Concat");
        System.out.println("Concatenação de frase com 'Concat' : " + frase_concat);
        boolean f_evalutate = frase.contains("java");
        System.out.println("Avaliação se frase contêm 'java': " + f_evalutate);
        boolean f_isempty = frase.isEmpty();
        System.out.println("Avaliação se a frase está vazia: " + f_isempty);
        
        sc.close();
    }
}
