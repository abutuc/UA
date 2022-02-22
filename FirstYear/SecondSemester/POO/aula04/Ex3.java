package aula04;
import java.util.Scanner;
public class Ex3 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Introduza uma frase: ");
        String frase = sc.nextLine();
        String acronimmo = acronym(frase);
        System.out.println("Acrónimo: " + acronimmo);
        sc.close();
    }
    public static String acronym(String s){
        String[] words = s.split(" ");
        String acronym = "";
        for (int i = 0; i < words.length; i++){
            if (words[i].length() >= 3){
                acronym += words[i].charAt(0);
            }
        }
        return acronym.toUpperCase();
    }
}
