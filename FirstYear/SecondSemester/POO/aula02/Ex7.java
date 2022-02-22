package aula02;

import java.util.Scanner;
import java.lang.Math;

public class Ex7 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("X coord of p1: ");
        double x_p1 = sc.nextDouble();

        System.out.print("Y coord of p1: ");
        double y_p1 = sc.nextDouble();

        System.out.print("X coord of p2: ");
        double x_p2 = sc.nextDouble();

        System.out.print("Y coord of p2: ");
        double y_p2 = sc.nextDouble();

        double dist = Math.sqrt(Math.pow(x_p2 - x_p1, 2) + Math.pow(y_p2 - y_p1, 2));
        System.out.printf("A  distância entre as duas coordenadas fornecidas é %.2f\n", dist);

        sc.close();
    }
}
