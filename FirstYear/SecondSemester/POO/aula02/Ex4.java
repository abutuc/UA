package aula02;

import java.util.Scanner;
public class Ex4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.print("Montante investido: ");
        double montante = sc.nextDouble();
        System.out.print("Taxa de juro mensal: ");
        double taxa = sc.nextDouble();
        taxa /= 100;

        for (var i = 0; i <= 2; i++){
            montante += montante * taxa;
        }
        
        System.out.println("Valor total ao final de 3 meses: " + montante + "€");
        sc.close();
    }
}
