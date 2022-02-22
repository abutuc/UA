package aula02;

import java.util.Scanner;

public class Ex6 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Introduza o tempo em segundos: ");
        int temp_total = sc.nextInt();

        int horas = temp_total / 3600;
        
        temp_total = temp_total % 3600;

        int minutos = temp_total / 60;

        temp_total = temp_total % 60;

        System.out.printf("%02d:%02d:%02d\n", horas, minutos, temp_total);

        sc.close();
    }
}
