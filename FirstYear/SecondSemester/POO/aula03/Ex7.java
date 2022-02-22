package aula03;
import java.util.Scanner;
import  java.util.Random;
public class Ex7 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        Random random = new Random();
        int num = random.nextInt(100) + 1;
        int adivinha = -1;
        int count = 0;
        while (!(adivinha == num)){
            System.out.print("Introduza a sua adivinha: ");
            adivinha = sc.nextInt();
            if (adivinha > num){
                System.out.println("A sua tentativa foi demasiado alta.");
            }
            else if (adivinha < num){
                System.out.println("A sua tentativa foi demasiado baixa.");
            }

            count += 1;
            System.out.println("Tentativas: " + count);
            if (adivinha == num){
                System.out.println("Parabéns! Acertou no número em " + count + " tentativas.");
                break;
            }
            System.out.print("Pretende continuar? Prima Sim caso pretenda. ");
            String resposta = sc.next();
            if (!(resposta.equals("Sim"))){
                System.out.println("Obrigado por ter jogado.");
                break;
            }
        }
        sc.close();
    }
}
