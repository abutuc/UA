package aula02;

import java.util.Scanner;
public class Ex3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantidade de água em kg: ");
        double m_water = sc.nextDouble();
        System.out.print("Temperatura inicial da água (em Celsius): ");
        double temp_i = sc.nextDouble();
        System.out.print("Temperatura final da água (em Celsius): ");
        double temp_f = sc.nextDouble();

        double Q = m_water * (temp_f - temp_i) * 4184;
        System.out.println("A energia necessária para aquecer a água desde uma temperatura inicial até uma temperatura final é de " + Q + " joules.");

        sc.close();
    }
}
