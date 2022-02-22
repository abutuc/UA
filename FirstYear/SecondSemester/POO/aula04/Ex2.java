package aula04;
import java.util.Scanner;
public class Ex2 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza uma frase: ");
        String frase = sc.nextLine();

        // Método 1
        int f_digitis = countDigits(frase);
        System.out.printf("A frase tem %d dígitos.\n", f_digitis);
        // Método 2
        int f_spaces = countSpaces(frase);
        System.out.printf("A frase tem %d espaços.\n", f_spaces);
        // Método 3
        boolean onlyLowerCase = evaluateOnlyLowerCase(frase);
        System.out.println("A frase só contém minúsculas? " + onlyLowerCase);
        // Método 4
        String new_frase = replaceDoubleSpace(frase);
        System.out.println(new_frase);
        // Método 5
        boolean palindrome = evaluatePalindrome(frase);
        System.out.println("A frase é um palíndromo? " + palindrome);
        
        sc.close();
    }

    public static int countDigits(String s){
        int counter = 0;
        for (int i = 0; i < s.length(); i++){
            if ((Character.isDigit(s.charAt(i)))){
                counter++;
            }
        }
        return counter;
    }

    public static int countSpaces(String s){
        int counter = 0;
        for (int i = 0; i < s.length(); i++){
            if (s.charAt(i) == ' '){
                counter++;
            }
        }
        return counter;
    }
    
    public static boolean evaluateOnlyLowerCase(String s){
        boolean onlyLowerCase = true;
        for (int i=0; i < s.length(); i++){
            if (Character.isUpperCase(s.charAt(i))) {
                onlyLowerCase = false;
                break;
            }
        }
        return onlyLowerCase;
    }


    public static String replaceDoubleSpace(String s){
        String new_s = "";
        for (int i = 0; i < s.length()-1; i++){
            if ((s.charAt(i) == ' ') && (s.charAt(i+1) == ' ')){
                continue;
            }
            new_s += s.charAt(i);
        }
        new_s += s.charAt(s.length()-1);
        return new_s;
    }

    public static boolean evaluatePalindrome(String s){
        String s_reversed = "";
        for (int i = s.length()-1; i >= 0; i--){
            s_reversed += s.charAt(i);
        }
        return s.equals(s_reversed);
    }
}
