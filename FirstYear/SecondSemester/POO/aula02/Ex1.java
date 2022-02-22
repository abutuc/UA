package aula02;

import java.util.Scanner;
public class Ex1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double km;
        System.out.print("Enter distance in km: ");
        km = sc.nextDouble();
        double milhas;
        milhas = km / 1.609;
        System.out.printf("A distância em milhas é %.2f\n", milhas);
        sc.close();
    }
}
