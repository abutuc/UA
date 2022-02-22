package aula02;

import java.util.Scanner;

public class Ex5 {
    
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("v1 = ");
        double v1 = sc.nextDouble();

        System.out.print("d1 = ");
        double d1 = sc.nextDouble();

        System.out.print("v2 = ");
        double v2 = sc.nextDouble();

        System.out.print("d2 = ");
        double d2 = sc.nextDouble();

        double tempo = (d1 / v1) + (d2 / v2);
        double vm = (d1 + d2) / tempo;

        System.out.println("Velocidade média final: " + vm);
        sc.close();
    }
}
