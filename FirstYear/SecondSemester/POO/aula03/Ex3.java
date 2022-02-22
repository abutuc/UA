package aula03;

import java.util.Scanner;
public class Ex3 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        int num = -1;
        while (num <= 1){
            System.out.print("Número natural: ");
            num = sc.nextInt();
            if (num <= 1) {
                System.out.println("Valor introduzido inválido. Introduza uma número natural.");
            }
        }

        boolean primo = true;
        for (int i = num-1; i > 1; i--){
            if (num % i == 0){
                primo = false;
                break;
            }
        }
        if (primo) System.out.println("O número introduzido é primo.");
        else System.out.println("O número introduzido não é primo.");
        sc.close();
    }
}
