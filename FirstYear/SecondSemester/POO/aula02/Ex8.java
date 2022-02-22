package aula02;

import java.util.Scanner;
import java.lang.Math; 

public class Ex8 {

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Cateto A: ");
        double catetoA = sc.nextDouble();

        System.out.print("Cateto B: ");
        double catetoB = sc.nextDouble();

        double hip = Math.sqrt(Math.pow(catetoA,2) + Math.pow(catetoB,2));

        double angAC = Math.toDegrees(Math.asin(catetoB / hip));

        System.out.printf("Hipotenusa ou C = %.2f ; Ângulo entre A e C = %.2f\n", hip, angAC);

        sc.close();
    }
}
